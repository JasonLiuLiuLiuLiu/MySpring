package com.coding.blocking;

import java.util.concurrent.ArrayBlockingQueue;

// 通常！
public class Test2 {

    public static void main(String[] args) {

        // 队列的大小
        ArrayBlockingQueue blockingQueue = new ArrayBlockingQueue<>(3); // 阻塞队列

        System.out.println(blockingQueue.offer("a"));
        System.out.println(blockingQueue.offer("b"));
        System.out.println(blockingQueue.offer("c"));
        // 等待（一直等待，超时就不等你）
        // System.out.println(blockingQueue.offer("d")); // false 我们通常不希望代码报错！这时候就使用offer

        System.out.println(blockingQueue.peek()); // 查看队首

        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll()); // null

        // System.out.println(blockingQueue.peek()); // 查看队首 null

    }



}
