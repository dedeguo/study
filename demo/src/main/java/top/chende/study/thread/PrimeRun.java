package top.chende.study.thread;

public class PrimeRun implements Runnable{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+" run !");
    }
}
