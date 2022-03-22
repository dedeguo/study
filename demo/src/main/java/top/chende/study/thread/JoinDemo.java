package top.chende.study.thread;

/**
 * join等待当前线程执行完毕die 才执行下面的代码
 *
 */
public class JoinDemo {
    public static void main(String[] args) throws InterruptedException {
        String threadName = Thread.currentThread().getName();
        System.out.println(threadName + " start.");
        BtThread btThread=new BtThread();
        btThread.start();
        btThread.join();

        System.out.println(threadName + " end.");
    }
}

class BtThread extends Thread{
    public void run(){
        String threadName = Thread.currentThread().getName();
        System.out.println(threadName + " start.");
        try {
            for (int i = 0; i < 5; i++) {
                System.out.println(threadName + " loop at " + i);
                Thread.sleep(1000);
            }
            System.out.println(threadName + " end.");
        } catch (Exception e) {
            System.out.println("Exception from " + threadName + ".run");
        }
    }
}
