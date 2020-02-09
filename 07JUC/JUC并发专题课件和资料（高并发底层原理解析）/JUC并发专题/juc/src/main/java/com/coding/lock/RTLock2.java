package com.coding.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class RTLock2 {
    public static void main(String[] args) {
        Phone2 phone2 = new Phone2();

        // T1 线程在获得外面锁的时候，也会拿到里面的锁！
        new Thread(phone2,"T1").start();

        new Thread(phone2,"T2").start();

    }
}


class Phone2 implements Runnable{

    Lock lock = new ReentrantLock();

    public void get(){
        lock.lock(); // A  // lock 锁必须匹配！
        // lock.lock(); // A  // lock 锁必须匹配！
        try {
            System.out.println(Thread.currentThread().getName()+"=>get");
            set();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock(); // A
        }
    }

    public void set(){
        lock.lock(); // B
        try {
            System.out.println(Thread.currentThread().getName()+"=>set");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock(); // B
        }
    }

    @Override
    public void run() {
        get();
    }
}