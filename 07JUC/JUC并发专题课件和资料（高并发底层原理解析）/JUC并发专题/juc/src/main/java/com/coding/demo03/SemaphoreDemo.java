package com.coding.demo03;

import sun.misc.Unsafe;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

// 抢车位
public class SemaphoreDemo {
    public static void main(String[] args) {
        // 模拟6个车，只有3个车位
        Semaphore semaphore = new Semaphore(3); // 3个位置

        for (int i = 1; i <= 6; i++) {
            new Thread(()->{
                // 得到车位
                try {
                    semaphore.acquire(); // 得到
                    System.out.println(Thread.currentThread().getName()+"抢到了车位");
                    TimeUnit.SECONDS.sleep(3);
                    System.out.println(Thread.currentThread().getName()+"离开了车位");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    semaphore.release(); // 释放位置
                }

            },String.valueOf(i)).start();
        }

    }
}
