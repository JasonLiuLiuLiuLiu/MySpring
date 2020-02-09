package com.coding.lock8;

import java.util.concurrent.TimeUnit;

/**
 * **2、邮件方法暂停4秒钟，请问先打印邮件还是短信？**
 */
public class Test2 {
    public static void main(String[] args) {

        Phone2 phone = new Phone2();

        // 我们这里两个线程使用的是同一个对象。两个线程是一把锁！先调用的先执行！
        new Thread(() -> {
            phone.sendEmail();
        }, "A").start();

        // 干扰
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(() -> {
            phone.sendMS();
        }, "B").start();

    }
}


// 手机，发短信，发邮件
class Phone2 {
    // 被 synchronized 修饰的方法、锁的对象是方法的调用者、
    public synchronized void sendEmail() {
        try {
            TimeUnit.SECONDS.sleep(4);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("sendEmail");
    }

    public synchronized void sendMS() {
        System.out.println("sendMS");
    }
}