package com.coding.lock;

import com.sun.org.apache.bcel.internal.generic.NEW;

import java.util.concurrent.atomic.AtomicReference;

// coding自己定义的艾编程的锁！
public class MyLock {

    // 原子引用 CAS
    AtomicReference<Thread> atomicReference = new AtomicReference<>();


    // 加锁
    public void myLock(){
        Thread thread = Thread.currentThread();
        System.out.println(Thread.currentThread().getName()+"==mylock");

        // 期望是空的没有加锁， thread         // 自旋，（循环！）
        while (atomicReference.compareAndSet(null,thread)){// cas

        }

    }

    // 解锁
    public void myUnlock(){
        Thread thread = Thread.currentThread();
        atomicReference.compareAndSet(thread,null);
        System.out.println(Thread.currentThread().getName()+"==myUnlock");
    }


}
