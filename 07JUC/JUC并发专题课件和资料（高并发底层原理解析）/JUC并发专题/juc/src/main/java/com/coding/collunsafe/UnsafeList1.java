package com.coding.collunsafe;

import java.util.Arrays;
import java.util.List;

public class UnsafeList1 {

    public static void main(String[] args) {
        // Arrays 工具类  asList  ArrayList
        List<String> list = Arrays.asList("a", "b", "c");

        list.forEach(System.out::println);

        for (String s : list) {
            System.out.println(s);
        }
    }

}
