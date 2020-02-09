package com.coding.pool;

import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Executors.
 * ExecutorService.execute
 */
public class Test1 {
    public static void main(String[] args) {
        // 平时我们创建一些类使用工具类操作 s
        // 总数可以管理

        // 线程池  Executors原生三大方法
        ExecutorService threadpool1 = Executors.newFixedThreadPool(5); // 固定大小
        ExecutorService threadpool2 = Executors.newCachedThreadPool(); //可以弹性伸缩的线程池，遇强则强
        ExecutorService threadpool3 = Executors.newSingleThreadExecutor(); // 只有一个


        try {
            // 10个线程，会显示几个线程~
            for (int i = 1; i <= 100; i++) {
                // 线程池，执行线程
                threadpool3.execute(()->{
                    System.out.println(Thread.currentThread().getName()+" running...");
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 线程池关闭
            threadpool3.shutdown();
        }


    }
}
