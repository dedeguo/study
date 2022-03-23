package top.chende.study.thread;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo2 {
    public static void main(String[] args) throws InterruptedException {
        int  n =3;
        CountDownLatch startSignal=new CountDownLatch(1);
        CountDownLatch doneSignal=new CountDownLatch(n);
        for (int i=0;i<n;i++){
            new Thread(new Worker(startSignal,doneSignal)).start();
        }
        System.out.println("准备就绪，子线程可以开始工作");
        startSignal.countDown();
        //等待子线程完成工作
        doneSignal.await();
        System.out.println("所有工作完成");
    }
}

class Worker implements Runnable{
    CountDownLatch startSignal;
    CountDownLatch doneSignal;

    public Worker(  CountDownLatch startSignal,  CountDownLatch doneSignal){
        this.doneSignal=doneSignal;
        this.startSignal=startSignal;
    }
    @Override
    public void run() {
        try {
            startSignal.await();
            doWork();
            doneSignal.countDown();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void doWork(){
        System.out.println(Thread.currentThread().getName()+" do work.");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
