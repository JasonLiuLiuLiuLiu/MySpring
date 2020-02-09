package com.coding.jmm;

import java.util.concurrent.atomic.AtomicInteger;

// 遇到问题不要着急，要思考如何去做！
public class Test2 {

    private volatile static AtomicInteger num = new AtomicInteger();

    public static void  add(){
        num.getAndIncrement(); // 等价于 num++
    }

    public static void main(String[] args) {
        for (int i = 1; i <= 20; i++) {
            new Thread(()->{
                for (int j = 1; j <= 1000; j++) {
                    add();  // 20 * 1000 = 20000
                }
            },String.valueOf(i)).start();
        }

        // main线程等待上面执行完成，判断线程存活数   2
        while (Thread.activeCount()>2){ // main  gc
            Thread.yield();
        }

        System.out.println(Thread.currentThread().getName()+" "+num);

    }
}
