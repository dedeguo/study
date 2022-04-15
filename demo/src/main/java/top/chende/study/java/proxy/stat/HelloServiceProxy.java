package top.chende.study.java.proxy.stat;

import top.chende.study.java.proxy.HelloService;

public class HelloServiceProxy implements HelloService {

    private HelloService helloService;

    public HelloServiceProxy(HelloService helloService) {
        this.helloService = helloService;
    }

    @Override
    public void sayHello() {
        System.out.println("before hello Service");
        helloService.sayHello();
        System.out.println("after hello service");
    }
}
