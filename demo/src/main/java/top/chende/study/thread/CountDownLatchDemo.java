package top.chende.study.thread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;


/**
 * 等待其他进程执行完毕
 */
public class CountDownLatchDemo {


    public static void main(String[] args) {
        CountDownLatch count=new CountDownLatch(2);
        makeThread(count);
        makeThread(count);
        try {
            count.await();
          //  count.await(10, TimeUnit.SECONDS);
            System.out.println("all already to go");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    private static void makeThread(CountDownLatch count) {
        Thread t2=new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                count.countDown();
                System.out.println(Thread.currentThread().getName()+" already to go");
            }
        });
        t2.start();
    }
}
