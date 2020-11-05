package top.chende.study.api;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

@Path("v2") // 服务路径
public interface Hello {


    @GET
    @Path("hello")
    public String hello(String msg);

    @POST
    @Path("demo")
    public String demo(String msg);

}
