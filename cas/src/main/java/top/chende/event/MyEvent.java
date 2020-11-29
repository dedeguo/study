package top.chende.event;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.ApplicationContextEvent;

public class MyEvent extends ApplicationEvent {

    private String hello;
    public MyEvent(Object source) {
        super(source);
        System.out.println(" 发布事件："+source);
    }

    public MyEvent(Object source,String hello) {
        super(source);
        this.hello=hello;
        System.out.println(" 发布事件："+source+hello);
    }


    public String getHello() {
        return hello;
    }

    public void setHello(String hello) {
        this.hello = hello;
    }
}
