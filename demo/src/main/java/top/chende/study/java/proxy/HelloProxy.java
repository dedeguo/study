package top.chende.study.java.proxy;

public class HelloProxy implements Hello{

    private  Hello hello=new HelloServiceImpl();
    @Override
    public String sayHello() {

        System.out.println("HelloProxy");
        return  hello.sayHello();
    }
}
