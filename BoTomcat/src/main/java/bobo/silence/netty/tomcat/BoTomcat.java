package bobo.silence.netty.tomcat;

import bobo.silence.netty.http.BoRequest;
import bobo.silence.netty.http.BoResponse;
import bobo.silence.netty.http.BoServlet;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.http.HttpRequest;
import io.netty.handler.codec.http.HttpRequestDecoder;
import io.netty.handler.codec.http.HttpResponseEncoder;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class BoTomcat {
    private int port = 8080;
    private Map<String, BoServlet> servletMapping = new HashMap<String, BoServlet>();
    private Properties webxml = new Properties();

    private void init() {
        try {
            //初始化 读取配置
            String WEB_INF = this.getClass().getResource("/").getPath();
            FileInputStream fis = new FileInputStream(WEB_INF + "web.properties");
            webxml.load(fis);
            for (Object k : webxml.keySet()) {
                String key = k.toString();
                if (key.endsWith("url")) {
                    String servletName = key.replaceAll("\\.url$", "");
                    String url = webxml.getProperty(key);
                    String className = webxml.getProperty(servletName + ".className");
                    BoServlet servlet = (BoServlet) Class.forName(className).newInstance();
                    servletMapping.put(url, servlet);
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void start() {
        doStart();
    }

    public void start(int port) {
        this.port = port;
        doStart();
    }

    private void doStart() {
        init();
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup workGroup = new NioEventLoopGroup();
        ServerBootstrap server = new ServerBootstrap();
        try {
            server.group(bossGroup, workGroup)
                    .channel(NioServerSocketChannel.class)
                    //客户端连接时启动
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        protected void initChannel(SocketChannel client) throws Exception {
                            //响应编码器
                            client.pipeline().addLast(new HttpResponseEncoder());
                            //请求解码器
                            client.pipeline().addLast(new HttpRequestDecoder());
                            //自定义处理器
                            client.pipeline().addLast(new BoTomcatHandler());
                        }
                    })
                    .option(ChannelOption.SO_BACKLOG, 128)
                    .childOption(ChannelOption.SO_KEEPALIVE, true);
            ChannelFuture f = server.bind(port).sync();
            System.out.println("BoTomcat 已启动!");
            //监听关闭状态启动
            f.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            //关闭线程池
            bossGroup.shutdownGracefully();
            workGroup.shutdownGracefully();
        }
    }

    public class BoTomcatHandler extends ChannelInboundHandlerAdapter {
        @Override
        public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
            if(msg instanceof HttpRequest){
                HttpRequest req= (HttpRequest) msg;
                BoRequest request=new BoRequest(ctx,req);
                BoResponse response=new BoResponse(ctx,req);
                String url=request.getUri();
                if(servletMapping.containsKey(url)){
                    servletMapping.get(url).service(request,response);
                }else{
                    response.write("404");
                }
            }
        }

        @Override
        public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
            super.exceptionCaught(ctx, cause);
        }
    }

    public static void main(String[] args) {
        new BoTomcat().start();
    }

}
