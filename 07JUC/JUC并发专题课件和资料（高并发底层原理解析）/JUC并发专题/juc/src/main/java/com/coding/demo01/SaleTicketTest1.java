package com.coding.demo01;

import java.util.TimerTask;

/**
 * 卖票   自己会写     3个售票员卖出30张票
 * 企业中禁止这样写，Coding：企业级开发！
 *
 * 多线程编程的固定套路：
 *     1、高内聚，低耦合  （前提）
 *     2、线程  操作(调用对外暴露的方法)   资源类  (要点)
 */
public class SaleTicketTest1 {
    public static void main(String[] args) {

        // 资源类
        SaleTicket saleTicket = new SaleTicket();

        new Thread(new Runnable() {
            public void run() {
                for (int i = 1; i < 40; i++) {
                    saleTicket.saleTicket();
                }
            }
        }, "A").start();

        new Thread(new Runnable() {
            public void run() {
                for (int i = 1; i < 40; i++) {
                    saleTicket.saleTicket();
                }
            }
        }, "B").start();

        new Thread(new Runnable() {
            public void run() {
                for (int i = 1; i < 40; i++) {
                    saleTicket.saleTicket();
                }
            }
        }, "C").start();

    }
}

// 属性，和方法  高内聚
class SaleTicket{ //资源类
    private int number = 30;

    // 卖票方法
    public synchronized void saleTicket(){
        if (number>0) {
            System.out.println(Thread.currentThread().getName() + "卖出第" + (number--) + "还剩下：" + number + "张票");
        }
    }

}