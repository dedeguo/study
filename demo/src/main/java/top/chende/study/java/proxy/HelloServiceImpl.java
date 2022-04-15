package top.chende.study.java.proxy;

public class HelloServiceImpl implements Hello{
    @Override
    public String sayHello() {
        System.out.println("HelloServiceImpl hello");
        return "HelloServiceImpl hello";
    }
}
