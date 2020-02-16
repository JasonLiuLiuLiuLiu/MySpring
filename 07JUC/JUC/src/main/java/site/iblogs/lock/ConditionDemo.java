package site.iblogs.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConditionDemo {
    public static void main(String[] args) {

        ConditionTest test=new ConditionTest();
        new Thread(() -> {
            for (int i = 0; i<10;i++) {
                test.Print1();
            }
        },"A").start();

        new Thread(() -> {
            for (int i = 0; i<10;i++) {
                test.Print2();
            }
        },"B").start();

        new Thread(() -> {
            for (int i = 0; i<10;i++) {
                test.Print3();
            }
        },"C").start();
    }
}

class ConditionTest {

    private int number = 1;
    Lock lock = new ReentrantLock();
    private Condition c1 = lock.newCondition();
    private Condition c2 = lock.newCondition();
    private Condition c3 = lock.newCondition();

    public void Print1() {
        lock.lock();
        try {
            while (number != 1) {
                c1.await();
            }
            System.out.println(number + Thread.currentThread().getName());
            number=2;
            c2.signal();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void Print2() {
        lock.lock();
        try {
            while (number != 2) {
                c2.await();
            }
            System.out.println(number + Thread.currentThread().getName());
            number=3;
            c3.signal();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void Print3() {
        lock.lock();
        try {
            while (number != 3) {
                c3.await();
            }
            System.out.println(number + Thread.currentThread().getName());
            number = 1;
            c1.signal();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

}
