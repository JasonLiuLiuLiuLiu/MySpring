package com.coding.function4;

import java.util.function.Predicate;

public class Demo02 {
    public static void main(String[] args) {
//        Predicate<String> predicate = new Predicate<String>(){
//            @Override
//            public boolean test(String o) {
//                if (o.equals("abc")){
//                    return true;
//                }
//                return false;
//            }
//
//        };

        Predicate<String> predicate = s->{return s.isEmpty();};
        System.out.println(predicate.test("abced"));
    }
}
