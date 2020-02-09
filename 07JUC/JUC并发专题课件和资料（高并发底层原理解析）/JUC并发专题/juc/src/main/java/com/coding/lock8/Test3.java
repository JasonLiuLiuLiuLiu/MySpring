package com.coding.lock8;

import java.util.concurrent.TimeUnit;

/**
 * 3、新增一个普通方法hello()没有同步,请问先打印邮件还是hello？
 */
public class Test3 {

    // 回家  卧室(锁)   厕所
    public static void main(String[] args) {

        Phone3 phone = new Phone3();

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
            phone.hello();
        }, "B").start();

    }
}

// 锁：竞争机制

// 手机，发短信，发邮件
class Phone3 {
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

    // 新增的方法没有被 synchronized 修饰，不是同步方法，所以不需要等待，其他线程用了一个把锁
    public void hello() {
        System.out.println("hello");
    }

}