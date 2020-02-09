package com.coding.collunsafe;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * 善于总结：
 * 1、 故障现象： ConcurrentModificationException
 * 2、 导致原因： 多线程操作集合类不安全
 * 3、 解决方案：
 *      List<String> list = new Vector<>(); // Vector 是一个线程安全的类,效率低下  50
 *      List<String> list = Collections.synchronizedList(new ArrayList<>()); // 60
 *      List<String> list = new CopyOnWriteArrayList<>(); // JUC 100 推荐使用
 */
public class UnsafeList2 {
    public static void main(String[] args) {
        // 代码实现
        // ArrayList<Object> list = new ArrayList<>(); // 效率高，不支持并发！
        // List<String> list = new Vector<>(); // Vector 是一个线程安全的类,效率低下  50
        // List<String> list = Collections.synchronizedList(new ArrayList<>()); // 60

        // 多线程高并发程序中，一致性最为重要

        // 写入时复制；  COW 思想，计算机设计领域。优化策略
        //  思想： 多个调用者，想调用相同的资源； 指针
        // 只是去读，就不会产生锁！
        // 假如你是去写，就需要拷贝一份都自己哪里，修改完毕后，在替换指针！

        List<String> list = new CopyOnWriteArrayList<>(); // JUC 100

        // 测试多线程下是否安全List，3条线程都不安全了
        // 多线程下记住一个异常，并发修改异常 java.util.ConcurrentModificationException

        // Exception  ConcurrentModificationException
        for (int i = 1; i <= 30; i++) {
            new Thread(()->{
                // 3个结果
                list.add(UUID.randomUUID().toString().substring(0,5));
                System.out.println(list);
            },String.valueOf(i)).start();
        }

    }
}
