package com.coding.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.Predicate;

public class RTLock {

    public static void main(String[] args) {
        Phone phone = new Phone();

        new Thread(()->{
            phone.sendSMS();
        },"T1").start();

        new Thread(()->{
            phone.sendMail();
        },"T2").start();
    }

}

class Phone {

    public synchronized void sendSMS(){ // 外面的锁
        System.out.println(Thread.currentThread().getName()+" sendSMS");
        sendMail();  // 这个方法本来也是被锁的，但是由于获得了外面的锁，所以这个锁也获得了！
    }
    public synchronized void sendMail(){
        System.out.println(Thread.currentThread().getName()+" sendMail");
    }
}