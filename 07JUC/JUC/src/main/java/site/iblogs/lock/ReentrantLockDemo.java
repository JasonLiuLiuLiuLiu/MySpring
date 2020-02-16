package site.iblogs.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockDemo {
    public static void main(String[] args) {

        SaleTicket1 saleTicket= new SaleTicket1();

        new Thread(()->{
            for (int i=0;i<30;i++){
                try {
                    TimeUnit.MILLISECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                saleTicket.sale();
            }
        },"A").start();

        new Thread(()->{
            for (int i=0;i<30;i++){
                try {
                    TimeUnit.MILLISECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                saleTicket.sale();
            }
        },"B").start();

        new Thread(()->{
            for (int i=0;i<30;i++){
                try {
                    TimeUnit.MILLISECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                saleTicket.sale();
            }
        },"C").start();
    }
}

class SaleTicket1{

    private int number=30;

    private Lock lock= new ReentrantLock();

    public void sale(){
        if (lock.tryLock()) {
            try {
                if (number > 1)
                    System.out.println(number-- + Thread.currentThread().getName());
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            } finally {
                lock.unlock();
            }
        }
    }
}
