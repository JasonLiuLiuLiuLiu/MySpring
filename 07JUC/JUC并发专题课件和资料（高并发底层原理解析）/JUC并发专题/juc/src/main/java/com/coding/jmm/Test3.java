package com.coding.jmm;

// 两个线程交替执行的！
public class Test3 {

    int a = 0;
    boolean flag = false;

    public void m1(){  // A
        flag = true;   // 语句2
        a = 1;         // 语句1

    }

    public void m2(){  // B
        if (flag){
            a = a + 5;  // 语句3
            System.out.println("m2=>"+a);
        }
    }

}
