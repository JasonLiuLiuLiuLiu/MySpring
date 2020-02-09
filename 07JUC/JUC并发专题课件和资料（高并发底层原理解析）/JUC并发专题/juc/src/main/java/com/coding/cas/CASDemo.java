package com.coding.cas;

import com.coding.demo02.A;

import java.util.concurrent.atomic.AtomicInteger;

public class CASDemo {
    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(5);

        // compareAndSet  简称 CAS 比较并交换！
        // compareAndSet(int expect, int update)  我期望原来的值是什么，如果是，就更新

        //  a
        System.out.println(atomicInteger.compareAndSet(5, 2020)+"=>"+atomicInteger.get());

        // c  偷偷的改动
        System.out.println(atomicInteger.compareAndSet(2020, 2021)+"=>"+atomicInteger.get());
        System.out.println(atomicInteger.compareAndSet(2021, 5)+"=>"+atomicInteger.get());


        //  b
        System.out.println(atomicInteger.compareAndSet(5, 1024)+"=>"+atomicInteger.get());

    }
}
