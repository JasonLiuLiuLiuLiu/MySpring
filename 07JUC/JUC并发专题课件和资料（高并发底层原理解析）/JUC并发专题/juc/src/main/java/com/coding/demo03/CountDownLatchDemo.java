package com.coding.demo03;

import java.util.concurrent.CountDownLatch;

// 程序如果不加以生活的理解再加上代码的测试，你就算不会
public class CountDownLatchDemo {

    // 有些任务是不得不阻塞的  减法计数器
    public static void main(String[] args) throws InterruptedException {

        CountDownLatch countDownLatch = new CountDownLatch(6); // 初始值

        for (int i = 1; i <=6 ; i++) {
            new Thread(()->{
                System.out.println(Thread.currentThread().getName()+"Start");
                // 出去一个人计数器就 -1
                countDownLatch.countDown();
            },String.valueOf(i)).start();
        }

        countDownLatch.await(); // 阻塞等待计数器归零
        // 阻塞的操作 ： 计数器  num++
        System.out.println(Thread.currentThread().getName()+"===END");

    }

    // 结果诡异的吗，达不到预期的 Main end 在最后一个
    public static void test1(){
        for (int i = 1; i <=6 ; i++) {
            new Thread(()->{
                System.out.println(Thread.currentThread().getName()+"Start");
            },String.valueOf(i)).start();
        }
        System.out.println(Thread.currentThread().getName()+"End");
    }


}

