package com.coding.stream;

import java.util.concurrent.RecursiveTask;

// 吃糖，集中注意力,   计算的返回值类型
// 每一次痛苦都可以成长！
public class ForkJoinDemo extends RecursiveTask<Long> {

    private Long start;
    private Long end;
    private static final Long temp = 10000L; // 临界值

    public ForkJoinDemo(Long start, Long end) {
        this.start = start;
        this.end = end;
    }

    // 计算
    @Override
    protected Long compute() {
        // 如果这个数 超过中间值，就分任务计算！
        if (end-start<=temp){ // 正常计算
            Long sum = 0L;
            for (Long i = start; i <= end; i++) {
                sum += i;
            }
            return sum;
        }else {
            // 获取中间值
            long middle = (end + start) / 2;
            ForkJoinDemo right = new ForkJoinDemo(start, middle);// 第一个任务
            right.fork();
            ForkJoinDemo left = new ForkJoinDemo(middle+1, end);// 第一个任务
            left.fork();

            // 合并结果
            return right.join() + left.join();
        }
    }
}
