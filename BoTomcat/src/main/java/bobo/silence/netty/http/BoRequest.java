package bobo.silence.netty.http;

import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.HttpRequest;
import io.netty.handler.codec.http.QueryStringDecoder;

import java.util.List;
import java.util.Map;

public class BoRequest {
    private ChannelHandlerContext ctx;
    private HttpRequest request;
    public BoRequest(ChannelHandlerContext ctx,HttpRequest request){
        this.ctx=ctx;
        this.request=request;
    }
    public String getUri(){
        return request.uri();
    }
    public String getMethod(){
        return request.method().name();
    }
    public Map<String, List<String>> getParameters(){
        QueryStringDecoder decoder=new QueryStringDecoder(request.uri());
        return decoder.parameters();
    }
    public String getParameter(String name){
        Map<String,List<String>> params=getParameters();
        List<String> param=params.get(name);
        if(param==null)return null;
        else return param.get(0);
    }
}
