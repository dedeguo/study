package top.chende.springboot;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class ListenerDemo {

    @JmsListener(destination = "order.queue")
    public void recMsg(String test){
        System.out.println("收到消息："+test);
    }
}
