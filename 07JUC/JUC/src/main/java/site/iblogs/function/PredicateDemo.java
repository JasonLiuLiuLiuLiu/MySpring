package site.iblogs.function;

import java.util.function.Predicate;

public class PredicateDemo {
    public static void main(String[] args) {
        Predicate<Integer> predicate=(value)->{return value<3;};
        System.out.println(predicate.test(2));
    }
}
