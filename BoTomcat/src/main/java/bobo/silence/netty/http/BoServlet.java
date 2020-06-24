package bobo.silence.netty.http;

public abstract class BoServlet {
    public void service(BoRequest request,BoResponse response) throws Exception{
        if("GET".equalsIgnoreCase(request.getMethod())){
            doGet(request,response);
        }else{
            doPost(request,response);
        }
    }

    protected abstract void doPost(BoRequest request, BoResponse response) throws Exception;

    protected abstract void doGet(BoRequest request, BoResponse response) throws Exception;
}
