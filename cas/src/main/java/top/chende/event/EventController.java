package top.chende.event;

import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class EventController {
    @Resource
    ApplicationContext applicationContext;


    @GetMapping("/test")
    public String test(){
        System.out.println("test thread:"+Thread.currentThread().getName());

        applicationContext.publishEvent(new MyEvent("demo","hhhhh"));
        System.out.println("EventController test");
        return null;
    }
}
