package top.chende.service;

import org.springframework.stereotype.Service;
import top.chende.study.api.Hello;

import javax.ws.rs.core.Application;

@Service
public class HelloRestService  extends Application implements Hello {
    @Override
    public String hello(String msg) {
        System.out.println("HelloRestService hello "+msg);
        return "HelloRestService hello"+msg;
    }

    @Override
    public String demo(String msg) {
        System.out.println("HelloRestService demo "+msg);
        return "HelloRestService demo"+msg;
    }
}
