package com.coding.demo02;

/**
 * 题目：现在两个线程，操作一个初始值为0的变量
 *       一个线程 + 1， 一个线程 -1。判断什么时候+1，什么时候-1
 *       交替10 次
 *
 * 方法论：
 *
 * 多线程编程的固定套路：
 * 1、高内聚，低耦合  （前提）
 * 2、线程  操作(调用对外暴露的方法)   资源类  (要点)
 *
 * 生产者消费者模型： 判断、干活、通知
 */
public class A {

    public static void main(String[] args) {
        Data data = new Data();

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
class Data{
    private int num = 0;

    // +1
    public synchronized void increment() throws Exception{
        //判断
        while (num!=0){
            this.wait();
        }
        // 干活
        num++;
        System.out.println(Thread.currentThread().getName()+"\t"+num);
        // 通知
        this.notifyAll();
    }

    // -1
    public synchronized void decrement() throws Exception{
        // 判断
        while (num==0){
            this.wait();
        }
        // 干活
        num--;
        System.out.println(Thread.currentThread().getName()+"\t"+num);
        // 通知
        this.notifyAll();
    }

}
