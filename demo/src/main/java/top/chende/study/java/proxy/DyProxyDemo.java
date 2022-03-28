package top.chende.study.java.proxy;

import java.lang.reflect.Proxy;

public class DyProxyDemo {

    public static void main(String[] args) {
        HelloServiceImpl helloService=new HelloServiceImpl();
        HelloDyProxy dyProxy=new HelloDyProxy(helloService);
        Hello hello=(Hello) Proxy.newProxyInstance(dyProxy.getClass().getClassLoader(), helloService.getClass().getInterfaces(),dyProxy);
        hello.sayHello();
    }
}
