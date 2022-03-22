package top.chende.study.thread;

public class ThreadDemo {
    public static void main(String[] args) {
        PrimeRun run=new PrimeRun();
        new Thread(run).start();
        System.out.println(Thread.currentThread().getName()+" run !");
    }
}
