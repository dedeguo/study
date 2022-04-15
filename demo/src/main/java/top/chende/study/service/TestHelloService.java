package top.chende.study.service;

import top.chende.study.spi.Hello;

import java.util.HashSet;

public class TestHelloService implements Hello {
    @Override
    public String sayHello(String msg) {
        StringBuffer s;
        return "Test --->"+msg;
    }
}
