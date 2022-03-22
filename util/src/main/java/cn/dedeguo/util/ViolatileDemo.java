package cn.dedeguo.util;

import java.util.concurrent.TimeUnit;

/**
 * volatile 可见性
 */
public class ViolatileDemo {

    public static void main(String[] args) {
        MyData myData=new MyData();
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(
                        Thread.currentThread().getName()+"\t come in");
                try {
                    TimeUnit.SECONDS.sleep(3);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                myData.addTo60();
            }
        }).start();

        while (myData.num ==0){


        }
        System.out.println("finish !!!");
    }
}
