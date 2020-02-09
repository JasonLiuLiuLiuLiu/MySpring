package com.coding.demo02;

import sun.awt.SunHints;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

// lock版生产者消费者
public class B {


    public static void main(String[] args) {
        // 新版
        Data2 data = new Data2();

        new Thread(()->{
            for (int i = 1; i <= 10; i++) {
                try {
                    data.increment();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        },"A").start();

        new Thread(()->{
            for (int i = 1; i <= 10; i++) {
                try {
                    data.decrement();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        },"B").start();

        new Thread(()->{
            for (int i = 1; i <= 10; i++) {
                try {
                    data.increment();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        },"C").start();

        new Thread(()->{
            for (int i = 1; i <= 10; i++) {
                try {
                    data.decrement();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        },"D").start();

    }

}

// 资源类  属性，方法
class Data2{
    private int num = 0;
    // 定义锁
    Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    // +1
    public void increment() throws Exception{

        // 加锁
        lock.lock();

        try {
            //判断
            while (num!=0){
                condition.await(); //等待
            }
            // 干活
            num++;
            System.out.println(Thread.currentThread().getName()+"\t"+num);
            // 通知
            condition.signalAll();

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            // 解锁
            lock.unlock();
        }
    }

    // -1
    public void decrement() throws Exception{


        // 加锁
        lock.lock();
        try {
            // 判断
            while (num==0){
                condition.await(); //等待
            }
            // 干活
            num--;
            System.out.println(Thread.currentThread().getName()+"\t"+num);
            // 通知
            condition.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            // 解锁
            lock.unlock();
        }
    }

}
