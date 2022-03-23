package top.chende.study.thread;

import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExchangerTest {

    private static Exchanger<String> exchanger=new Exchanger<>();
    private static ExecutorService threadPool = Executors.newFixedThreadPool(2);

    public static void main(String[] args) {
        threadPool.execute(new Runnable() {
            @Override
            public void run() {
                String a="银行流水A";
                try {
                    String s=exchanger.exchange(a);
                    System.out.println("A银行数据："+a+" "+s);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        threadPool.execute(new Runnable() {
            @Override
            public void run() {
                String a="银行流水B";
                try {
                    String s=exchanger.exchange(a);
                    System.out.println("B银行数据："+a+" "+s);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        threadPool.shutdown();
    }
}
