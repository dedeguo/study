package top.chende.study.thread;

import java.util.Objects;

/***
 * ThreadLocal 每个线程保持一份数据副本
 *
 */
public class ThreadLocalDemo {

    private static ThreadLocal<String> s=new ThreadLocal<>();
    public static void main(String[] args) {
        s.set("testhhhh");
        System.out.println(Thread.currentThread().getName()+"  "+s.get());

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                String ss=ThreadLocalDemo.s.get();
                if (Objects.isNull(ss)){
                    System.out.println(Thread.currentThread().getName()+"  : ss is null");
                }
                ThreadLocalDemo.s.set("hello");
                ss=ThreadLocalDemo.s.get();
                if (!Objects.isNull(ss)){
                    System.out.println(Thread.currentThread().getName()+"  : ss is not null");
                }

            }
        }).start();
    }
}
