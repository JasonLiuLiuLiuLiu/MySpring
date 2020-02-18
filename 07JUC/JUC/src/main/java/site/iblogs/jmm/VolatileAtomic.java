package site.iblogs.jmm;

import java.util.concurrent.atomic.AtomicInteger;

public class VolatileAtomic {
    private volatile static AtomicInteger num=new AtomicInteger();

    private static void  add(){
        num.incrementAndGet();
    }

    public static void main(String[] args) {
        for (int i=0;i<20;i++){
            new Thread(()->{
                for(int j=0;j<1000;j++) {
                    add();
                }
            }).start();
        }

        while (Thread.activeCount()>2){
            Thread.yield();
        }

        System.out.println("Result num="+num);
    }
}
