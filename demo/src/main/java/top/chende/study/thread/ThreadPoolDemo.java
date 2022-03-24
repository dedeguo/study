package top.chende.study.thread;

public class ThreadPoolDemo {
    public static void main(String[] args) {
      int processorNum=  Runtime.getRuntime().availableProcessors();
      long tatalMem=  Runtime.getRuntime().freeMemory()/(1024*1024*8);
      System.out.println("processor num "+processorNum);
      System.out.println("total mem  "+tatalMem);
    }
}
