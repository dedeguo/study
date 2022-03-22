package top.chende.study.thread;

import java.util.Date;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CallableThreadDemo {

    public static void main(String[] args) {

        FutureTask<String> task=new FutureTask<>(new CallableTask());
        new Thread(task).start();
        System.out.println("main:"+new Date());
        try {
            String result = task.get();
            System.out.println(result);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
