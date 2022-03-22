package top.chende.study.spi;

import java.util.Iterator;
import java.util.ServiceLoader;

public class SpiDemo {
    public static void main(String[] args) {
        ServiceLoader<Hello> s = ServiceLoader.load(Hello.class);
        Iterator<Hello> iterator = s.iterator();
        while (iterator.hasNext()) {
            Hello search =  iterator.next();
           String ss= search.sayHello("hello world");
            System.out.println(ss);
        }
    }
}
