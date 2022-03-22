package top.chende.study.service;

import top.chende.study.spi.Hello;

public class V2HelloService implements Hello {
    @Override
    public String sayHello(String msg) {
        return "V2 hello ====>"+msg;
    }
}
