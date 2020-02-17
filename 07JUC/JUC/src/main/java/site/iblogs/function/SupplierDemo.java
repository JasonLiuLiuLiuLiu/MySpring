package site.iblogs.function;

import java.util.function.Supplier;

public class SupplierDemo {
    public static void main(String[] args) {
        Supplier<Boolean> supplier=()->{return false;};
        System.out.println(supplier.get());
    }
}
