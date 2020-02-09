package com.coding.lock8;

import java.util.concurrent.TimeUnit;

/** 第一次听可能不会，第二次也可能不会，但是不要放弃，你可以！
 **6、两个静态同步方法，2部手机，请问先打印邮件还是短信？**
 */
public class Test6 {

    // 回家  卧室(锁)   厕所
    public static void main(String[] args) {
        // 两个对象，互不干预
        Phone6 phone = new Phone6();
        Phone6 phone2 = new Phone6();

        // 我们这里两个线程使用的是同一个对象。两个线程是一把锁！先调用的先执行！
        new Thread(() -> { // 一开始就执行了
            phone.sendEmail();
        }, "A").start();

        // 干扰
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(() -> { // 一秒后执行
            phone2.sendMS();
        }, "B").start();

    }

}

// 手机，发短信，发邮件
class Phone6 {

    // 对象    类模板可以new 多个对象！
    // Class   类模版，只有一个

    // 被 synchronized 修饰 和 static 修饰的方法，锁的对象是类的 class 对象！唯一的
    // 同一把锁

    public static synchronized void sendEmail() {
        // 善意的延迟
        try {
            TimeUnit.SECONDS.sleep(4);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("sendEmail");
    }

    public static synchronized void sendMS() {
        System.out.println("sendMS");
    }

}
