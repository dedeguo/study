package top.chende.study.java.threadpool;


import java.util.concurrent.*;

public class ThreadPoolDemo {
    public static void main(String[] args) {
        BlockingQueue<Runnable> workQueue=new LinkedBlockingQueue<>();
        ThreadPoolExecutor threadPoolExecutor=new ThreadPoolExecutor(8,16,0,TimeUnit.SECONDS,workQueue);
        threadPoolExecutor.setCorePoolSize(1);



        ExecutorService executor = Executors.newFixedThreadPool(5);

        for (int i = 0; i < 10; i++) {
            executor.submit(() -> {
                System.out.println("thread id is: " + Thread.currentThread().getId());
                try {
                    Thread.sleep(1000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        executor.shutdown();
    }
}