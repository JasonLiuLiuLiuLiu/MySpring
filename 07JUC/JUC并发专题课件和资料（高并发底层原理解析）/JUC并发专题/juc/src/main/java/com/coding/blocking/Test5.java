package com.coding.blocking;

import java.util.concurrent.Executor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

// 同步队列
// 每一个 put 操作。必须等待一个take。否则无法继续添加元素！
public class Test5 {
    public static void main(String[] args) {
        // 不用写参数！
        SynchronousQueue<String> queue = new SynchronousQueue<>();


        new Thread(()->{
            try {
                System.out.println(Thread.currentThread().getName()+"put 1");
                queue.put("1");
                System.out.println(Thread.currentThread().getName()+"put 2");
                queue.put("2");
                System.out.println(Thread.currentThread().getName()+"put 3");
                queue.put("3");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"A").start();


        new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(3);
                System.out.println(Thread.currentThread().getName()+queue.take());
                TimeUnit.SECONDS.sleep(3);
                System.out.println(Thread.currentThread().getName()+queue.take());
                TimeUnit.SECONDS.sleep(3);
                System.out.println(Thread.currentThread().getName()+queue.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"B").start();


    }
}
