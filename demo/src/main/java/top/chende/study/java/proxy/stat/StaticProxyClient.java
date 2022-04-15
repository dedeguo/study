package top.chende.study.java.proxy.stat;


/**
 * 静态代理
 */
public class StaticProxyClient {


    public static void main(String[] args) {
        HelloServiceImpl helloService=new HelloServiceImpl();
        HelloServiceProxy proxy=new HelloServiceProxy(helloService);
        proxy.sayHello();
    }
}
