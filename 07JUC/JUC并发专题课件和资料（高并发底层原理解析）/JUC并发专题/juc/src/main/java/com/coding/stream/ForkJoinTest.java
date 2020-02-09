package com.coding.stream;

import java.util.concurrent.ForkJoinPool;
import java.util.stream.LongStream;

// 裁员就是机会！ 你要加工资的机会来了
public class ForkJoinTest {
    public static void main(String[] args) {
        // test1();  // 10582 ms    60
        // test2();  // 9965 ms    90
        // test3();  // 158 ms   101
    }

    // 正常测试
    public static void test1(){
        long start =  System.currentTimeMillis();

        Long sum = 0L;
        for (Long i = 0L; i <= 10_0000__0000 ; i++) {
            sum +=i;
        }
        long end =  System.currentTimeMillis();
        System.out.println("time:"+(end-start)+" sum:"+sum);
    }


    // ForkJoin测试
    public static void test2(){
        long start =  System.currentTimeMillis();

        ForkJoinPool forkJoinPool = new ForkJoinPool();
        ForkJoinDemo forkJoinDemo = new ForkJoinDemo(0L,10_0000__0000L);
        Long sum = forkJoinPool.invoke(forkJoinDemo);

        long end =  System.currentTimeMillis();
        System.out.println("time:"+(end-start)+" sum:"+sum);
    }



    // Stream并行流测试
    public static void test3(){
        long start =  System.currentTimeMillis();

        long sum = LongStream.rangeClosed(0, 10_0000__0000).parallel().reduce(0, Long::sum);

        long end =  System.currentTimeMillis();
        System.out.println("time:"+(end-start)+" sum:"+sum);
    }

}
