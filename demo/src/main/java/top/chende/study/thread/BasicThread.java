package top.chende.study.thread;

/**
 * 集成thread类，重写run方法
 */
public class BasicThread extends Thread{

    public void run() {
     String name= Thread.currentThread().getName();
        System.out.println(name);
    }
}
