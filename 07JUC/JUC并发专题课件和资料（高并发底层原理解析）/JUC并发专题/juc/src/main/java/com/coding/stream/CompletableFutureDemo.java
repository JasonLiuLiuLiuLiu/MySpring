package com.coding.stream;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

// CompletableFuture 异步回调, 对将来的结果进行结果，ajax就是一种异步回调！
public class CompletableFutureDemo {
    public static void main(String[] args) throws Exception {
        // 多线程也可以异步回调
//
//        // 没有返回结果,任务执行完了就完毕了！ 新增~
//        CompletableFuture<Void> voidCompletableFuture = CompletableFuture.runAsync(() -> {
//            // 插入数据，修改数据
//            System.out.println(Thread.currentThread().getName() + " 没有返回值！");
//        });
//
//        System.out.println(voidCompletableFuture.get());

        // 有返回结果  ajax。 成功或者失败！
        CompletableFuture<Integer> uCompletableFuture = CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread().getName() + " 有返回值！");
            // int i = 10/0;
            return 1024;
        });

        // 有一些任务不紧急，但是可以给时间做！占用主线程！假设这个任务需要返回结果！

        System.out.println(uCompletableFuture.whenComplete((t, u) -> { // 正常编译完成！
            System.out.println("=t==" + t); // 正常结果
            System.out.println("=u==" + u); // 信息错误！
        }).exceptionally(e -> { // 异常！
            System.out.println("getMessage=>" + e.getMessage());
            return 555; // 异常返回结果
        }).get());

    }
}
