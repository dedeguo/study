package top.chende.spi;

import java.util.Iterator;
import java.util.ServiceLoader;

public class TestSpi {
    public static void main(String[] args) {
        ServiceLoader<SayService> services= ServiceLoader.load(SayService.class);

        Iterator<SayService> iterable=services.iterator();
        while (iterable.hasNext()){
            String s=iterable.next().say("hello");
            System.out.println(s);
        }
    }
}
