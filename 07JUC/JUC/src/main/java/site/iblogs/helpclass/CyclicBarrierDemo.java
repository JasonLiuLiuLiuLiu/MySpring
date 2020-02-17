package site.iblogs.helpclass;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierDemo {
    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier=new CyclicBarrier(8, new Runnable() {
            @Override
            public void run() {
                System.out.println("神龙召唤成功..");
            }
        });

        for (int i=0;i<10;i++){
            final int temp=i;
            new Thread(()->{
                System.out.println(Thread.currentThread().getName()+"Before:"+temp);
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+"After:"+temp);
            },String.valueOf(i)).start();
        }
    }
}
