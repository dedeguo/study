package top.chende.event;

import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class MyApplicationListener {

    @Async
    @EventListener
    public void onAppEvent(MyEvent event){
        System.out.println("listner thread:"+Thread.currentThread().getName());
        System.out.println("接受事件"+event);
        System.out.println("HELLO:"+event.getHello());
    }
}
