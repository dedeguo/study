package top.chende.study.java.proxy.stat;

import top.chende.study.java.proxy.HelloService;

public class HelloServiceImpl implements HelloService {

    public HelloServiceImpl() {
    }

    @Override
    public void sayHello() {

        System.out.println("HelloServiceImpl say hello !!");
    }
}
