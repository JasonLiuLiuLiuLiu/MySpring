package com.coding.jmm;

import java.util.concurrent.TimeUnit;

public class Test1 {
    // volatile 读取的时候去主内存中读取在最新值！
    private volatile static int num = 0;

    public static void main(String[] args) throws InterruptedException { // Main线程

        new Thread(()->{ // 线程A 一秒后会停止！  0
            while (num==0){

            }
        }).start();

        TimeUnit.SECONDS.sleep(1);

        num = 1;
        System.out.println(num);

    }

}
