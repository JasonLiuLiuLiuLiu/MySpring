package com.coding.demo03;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

// CyclicBarrier 栅栏 加法计数器
public class CyclicBarrierDemo {
    public static void main(String[] args) {
        // 集齐7个龙珠召唤神龙 ++ 1

        //  public CyclicBarrier(int parties, Runnable barrierAction)
        // 等待cyclicBarrier计数器满，就执行后面的Runnable，不满就阻塞
        CyclicBarrier cyclicBarrier = new CyclicBarrier(8, new Runnable() {
            @Override
            public void run() {
                System.out.println("神龙召唤成功！");
            }
        });

        for (int i = 1; i <= 7; i++) {
            final int temp = i;
            new Thread(()->{
                System.out.println(Thread.currentThread().getName()+"收集了第"+temp+"颗龙珠");

                try {
                    cyclicBarrier.await(); // 等待 阻塞
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }

            }, String.valueOf(i)).start();

        }


    }
}
