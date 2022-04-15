package top.chende.study.java.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class HelloDyProxy implements InvocationHandler {

    private Object object;

    public HelloDyProxy(Object object) {
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println("before HelloDyProxy");
        Object res=method.invoke(object,args);
        System.out.println("after HelloDyProxy");
        return res;
    }
}
