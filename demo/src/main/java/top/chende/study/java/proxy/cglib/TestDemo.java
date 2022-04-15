package top.chende.study.java.proxy.cglib;

public class TestDemo {

    public static void main(String[] args) {
        UserDao userDao=new UserDao();
        ProxyFactory factory=new ProxyFactory(userDao);
        UserDao proxyInstance = (UserDao) factory.getProxyInstance();
        proxyInstance.save();
        System.out.println(proxyInstance.getClass().getName());
    }
}
