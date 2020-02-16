package site.iblogs.helpclass;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class CountDownLatchDemo {

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch=new CountDownLatch(4);
        for (int i=0;i<6;i++){
            new Thread(()->{
                try {
                    Down(countDownLatch);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();

        }

        countDownLatch.await();
        System.out.println(Thread.currentThread().getName()+"End");
    }

    private static synchronized void Down(CountDownLatch countDownLatch) throws InterruptedException {
        TimeUnit.SECONDS.sleep(3);
        System.out.println("Running..");
        countDownLatch.countDown();
    }

}
