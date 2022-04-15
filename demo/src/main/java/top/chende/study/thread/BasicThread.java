package top.chende.study.thread;

import java.util.concurrent.ConcurrentHashMap;

/**
 * 集成thread类，重写run方法
 */
public class BasicThread extends Thread{

    public void run() {

        ConcurrentHashMap c;
     String name= Thread.currentThread().getName();
        System.out.println(name);
    }
}
