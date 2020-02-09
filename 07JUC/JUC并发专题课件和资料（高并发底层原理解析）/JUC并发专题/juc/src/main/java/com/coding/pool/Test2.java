package com.coding.pool;

import java.util.concurrent.*;

public class Test2 {
    public static void main(String[] args) {

        // 代码级别的
        System.out.println(Runtime.getRuntime().availableProcessors());

        ExecutorService threadPool = new ThreadPoolExecutor(
                2,
                Runtime.getRuntime().availableProcessors(), // 线程池最大大小5
                2L,
                TimeUnit.SECONDS, // 超时回收空闲的线程，假设超过了指定的时间，这个最大的线程就不被
                new LinkedBlockingDeque<>(3), // 根据业务设置队列大小，队列大小一定要设置
                Executors.defaultThreadFactory(), // 不用变
                new ThreadPoolExecutor.CallerRunsPolicy() //拒绝策略
        );

        // 拒绝策略说明：
        // 1. AbortPolicy （默认的：队列满了，就丢弃任务抛出异常！）
        // 2. CallerRunsPolicy（哪来的回哪去？ 谁叫你来的，你就去哪里处理）
        // 3. DiscardOldestPolicy (尝试将最早进入对立与的人任务删除,尝试加入队列)
        // 4. DiscardPolicy (队列满了任务也会丢弃,不抛出异常)

        try {
            // 队列  RejectedExecutionException 拒绝策略
            for (int i = 1; i <= 10; i++) {
                // 默认在处理
                threadPool.execute(()->{
                    System.out.println(Thread.currentThread().getName()+" running....");
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            threadPool.shutdown();
        }


    }

}
