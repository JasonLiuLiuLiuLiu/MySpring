package com.coding.function4;

import java.util.function.Supplier;

public class Demo04 {
    public static void main(String[] args) {
//        Supplier<String> supplier =  new Supplier<String>() {
//            @Override
//            public String get() {
//                return "aaa";
//            }
//        };

        Supplier<String> supplier = ()->{return "aaa";};
        System.out.println(supplier.get());
    }
}
