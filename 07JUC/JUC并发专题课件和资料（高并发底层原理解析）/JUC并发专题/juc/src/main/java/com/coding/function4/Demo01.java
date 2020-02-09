package com.coding.function4;

import java.util.function.Function;

public class Demo01 {
    public static void main(String[] args) {
        // new Runnable(); ()-> {}
//
//        Function<String,Integer> function = new Function<String,Integer>() {
////            @Override // 传入一个参数，返回一个结果
////            public Integer apply(String o) {
////                System.out.println("into");
////                return 1024;
////            }
//        };

        // 链式编程、流式计算、lambda表达式
        Function<String,Integer> function = s->{return s.length();};
        System.out.println(function.apply("abc"));

    }
}
