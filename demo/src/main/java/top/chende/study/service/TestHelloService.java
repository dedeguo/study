package top.chende.study.service;

import top.chende.study.spi.Hello;

public class TestHelloService implements Hello {
    @Override
    public String sayHello(String msg) {
        return "Test --->"+msg;
    }
}
