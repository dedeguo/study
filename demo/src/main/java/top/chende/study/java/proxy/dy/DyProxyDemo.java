package top.chende.study.java.proxy.dy;


import top.chende.study.java.proxy.HelloService;
import top.chende.study.java.proxy.stat.HelloServiceImpl;


import java.lang.reflect.Proxy;

/**
 * 底层是直接操作字节码 写入字节码文件 反射相关的api
 * JDK的动态代理有一个限制，就是使用动态代理的对象必须实现一个或多个接口。
 */
public class DyProxyDemo {

    public static void main(String[] args)  {
        HelloServiceImpl helloService=new HelloServiceImpl();
        HelloInvocation handler=new HelloInvocation(helloService);
        HelloService h=(HelloService) Proxy.newProxyInstance(helloService.getClass().getClassLoader(), helloService.getClass().getInterfaces(),handler);
        h.sayHello();
        System.out.println(h.getClass().getName());
    }
}
