package site.iblogs.jmm;

import java.util.concurrent.TimeUnit;

public class VolatileDemo1 {


    //保证可见性
    private volatile static int num = 0;

    public static void main(String[] args) throws InterruptedException {

        new Thread(() -> {
            while (num == 0) {
                System.out.println("In");
            }
        }).start();

        TimeUnit.MILLISECONDS.sleep(20);
        num = 1;
        System.out.println("Completed");

    }
}
