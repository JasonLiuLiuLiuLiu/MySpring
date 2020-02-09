package com.coding.blocking;

import java.util.ArrayList;
import java.util.concurrent.ArrayBlockingQueue;

public class Test1 {
    public static void main(String[] args) {
        // 队列的大小
        ArrayBlockingQueue blockingQueue = new ArrayBlockingQueue<>(3); // 阻塞队列

        // add返回布尔值
        System.out.println(blockingQueue.add("a"));
        System.out.println(blockingQueue.add("b"));
        System.out.println(blockingQueue.add("c"));
        // System.out.println(blockingQueue.add("d")); // java.lang.IllegalStateException: Queue full

        System.out.println(blockingQueue.element());

        System.out.println(blockingQueue.remove()); // a

        System.out.println(blockingQueue.element());

        blockingQueue.remove();

        System.out.println(blockingQueue.element());

        System.out.println(blockingQueue.remove()); // b
        System.out.println(blockingQueue.remove()); // c
        System.out.println(blockingQueue.remove()); // java.util.NoSuchElementException


    }
}
