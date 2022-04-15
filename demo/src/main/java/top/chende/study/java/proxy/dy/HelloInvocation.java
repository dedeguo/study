package top.chende.study.java.proxy.dy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class HelloInvocation implements InvocationHandler {

    private Object target;// 维护一个目标对象

    public HelloInvocation(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before dy proxy");
        method.invoke(target,args);
        System.out.println("after dy proxy");
        return null;
    }
}
