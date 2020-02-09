package com.coding.lock;

import java.util.concurrent.TimeUnit;

public class SpinLockDemo {

    public static void main(String[] args) {
        MyLock myLock = new MyLock();

        new Thread(()->{
            myLock.myLock();

            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            myLock.myUnlock();

        },"T1").start();


        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(()->{
            myLock.myLock();

            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            myLock.myUnlock();

        },"T2").start();



    }

}
