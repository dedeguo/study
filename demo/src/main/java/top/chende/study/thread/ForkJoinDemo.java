package top.chende.study.thread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;

/**
 * fork join框架
 */
public class ForkJoinDemo {

    private static class Fab extends RecursiveTask<Integer> {
        int n;
        public Fab(int n) {
            this.n = n;
        }
        @Override
        protected Integer compute() {
            if (n<=1) return n;
            else {
                Fab f1=new Fab(n-1);
                f1.fork();
                Fab f2=new Fab(n-2);
                int res=f2.compute()+f1.join();
                System.out.println(Thread.currentThread().getName()+"---> f("+n+"):"+res);
                return res;
            }
        }
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ForkJoinPool pool=new ForkJoinPool();
        int n=10;
        Fab f=new Fab(n);
        Future<Integer> future=pool.submit(f);
        System.out.println(future.get());
        pool.shutdown();

    }
}
