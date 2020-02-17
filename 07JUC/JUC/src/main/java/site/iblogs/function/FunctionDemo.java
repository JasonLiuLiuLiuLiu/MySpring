package site.iblogs.function;

import java.util.function.Function;

public class FunctionDemo {
    public static void main(String[] args) {
        Function<Integer,String> function= String::valueOf;
        System.out.println(function.apply(2));
    }
}
