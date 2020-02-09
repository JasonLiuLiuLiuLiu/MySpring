package com.coding.function4;

import java.util.function.Consumer;

public class Demo03 {
    public static void main(String[] args) {
        // 没有返回值，只能传递参数  消费者
//        Consumer<String> consumer = new Consumer<String> () {
//            @Override
//            public void accept(String o) {
//                System.out.println(o);
//            }
//        };

        Consumer<String> consumer =s->{System.out.println(s);};
        consumer.accept("123");

        // 供给型接口  只有返回值，没有参数  生产者


    }
}
