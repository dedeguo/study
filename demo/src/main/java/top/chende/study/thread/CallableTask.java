package top.chende.study.thread;

import java.util.Date;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;


/**
 * 带返回值的线程
 */
public class CallableTask implements Callable<String> {
    @Override
    public String call() throws Exception {
        Thread.sleep(5000);
       String threadName = Thread.currentThread().getName();
        return threadName+" test!!!"+new Date();
    }
}
