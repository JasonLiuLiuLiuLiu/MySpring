package com.coding.demo02;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *  多个线程启动  A -- B -- C
 *  三个线程依次打印
 *  A  5次
 *  B  10次
 *  C  15次
 *  依次循环
 *
 *  精确通知线程消费
 */
public class C {

    public static void main(String[] args) {
        Data3 data = new Data3();

        // 线程操作资源类
        new Thread(()->{
            for (int i = 1; i <= 10; i++) {
                data.print5();
            }
        },"A").start();

        new Thread(()->{
            for (int i = 1; i <= 10; i++) {
                data.print10();
            }
        },"B").start();

        new Thread(()->{
            for (int i = 1; i <= 10; i++) {
                data.print15();
            }
        },"C").start();

    }

}


// 资源类  属性，方法
class Data3{
    private int num = 1; // A1   B2   C3
    // 定义锁
    Lock lock = new ReentrantLock();
    private Condition condition1 = lock.newCondition(); //3个判断，交替执行 A--B--C--A
    private Condition condition2 = lock.newCondition(); //3个判断，交替执行 A--B--C--A
    private Condition condition3 = lock.newCondition(); //3个判断，交替执行 A--B--C--A

    // 3个方法、作业，合3为1
    // +1
    public void print5(){
        // 加锁
        lock.lock();
        try {
            //判断
            while (num!=1){
                condition1.await(); //等待
            }
            // 干活
            for (int i = 1; i <=5 ; i++) {
                System.out.println(Thread.currentThread().getName()+"\t"+i);
            }

            // 第一个线程通知第二个线程，第二个线程通知第三个....  计数器
            num=2;
            // 通知第二个线程干活,指定谁干活
            condition2.signal();

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            // 解锁
            lock.unlock();
        }
    }

    public void print10() {
        // 加锁
        lock.lock();
        try {
            //判断
            while (num!=2){
                condition2.await(); //等待
            }
            // 干活
            for (int i = 1; i <=10 ; i++) {
                System.out.println(Thread.currentThread().getName()+"\t"+i);
            }
            // 第一个线程通知第二个线程，第二个线程通知第三个....  计数器
            num=3;
            // 通知第二个线程干活,指定谁干活
            condition3.signal();

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            // 解锁
            lock.unlock();
        }
    }

    public void print15() {
        // 加锁
        lock.lock();
        try {
            //判断
            while (num!=3){
                condition3.await(); //等待
            }
            // 干活 = 业务代码
            for (int i = 1; i <=15 ; i++) {
                System.out.println(Thread.currentThread().getName()+"\t"+i);
            }

            num=1;
            condition1.signal();

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            // 解锁
            lock.unlock();
        }
    }


}