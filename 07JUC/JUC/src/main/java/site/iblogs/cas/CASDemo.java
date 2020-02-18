package site.iblogs.cas;

import java.util.concurrent.atomic.AtomicInteger;

public class CASDemo {
    public static void main(String[] args) {
        AtomicInteger num=new AtomicInteger(3);

        System.out.println(num.compareAndSet(3,5)+"=>"+num.get());
        num.getAndIncrement();
        System.out.println(num.compareAndSet(3,5)+"=>"+num.get());
    }
}
