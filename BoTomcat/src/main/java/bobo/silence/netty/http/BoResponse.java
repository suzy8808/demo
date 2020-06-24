package bobo.silence.netty.http;

import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.*;

import java.io.UnsupportedEncodingException;

public class BoResponse {
    private ChannelHandlerContext ctx;
    private HttpRequest request;
    private String code = "UTF-8";

    public BoResponse(ChannelHandlerContext ctx, HttpRequest request) {
        this.ctx = ctx;
        this.request = request;
    }

    public void write(String out) throws Exception {
        try {
            if (out == null || out.length() == 0) return;
            //设置HTTP及请求头信息
            FullHttpResponse response = null;
            response = new DefaultFullHttpResponse(
                    //设置版本
                    HttpVersion.HTTP_1_1,
                    //设置响应状态码
                    HttpResponseStatus.OK,
                    //设置输出格式
                    Unpooled.wrappedBuffer(out.getBytes(code)));
            response.headers().set("Content-Type", "text/html;");
            ctx.write(response);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } finally {
            ctx.flush();
            ctx.close();
        }


    }
}
