package site.iblogs.lock;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/*
* Read 共享锁
* Write 排他锁 (意味着写锁锁定的时候也不能读)
* */
public class ReadWriteLockDemo {
    public static void main(String[] args) {
        ReadWrite readWrite=new ReadWrite();
        for (int i=0;i<100;i++){
            int finalI = i;
            new Thread(()->{
                readWrite.Get(finalI);
            }).start();
        }

        for (int i=0;i<2;i++){
            int finalI = i;
            new Thread(()->{
                readWrite.Write(finalI,finalI);
            }).start();
        }

    }
}

class ReadWrite{
    private final HashMap<Integer,Integer> map=new HashMap<>();

    ReentrantReadWriteLock readWriteLock=new ReentrantReadWriteLock();
    Lock read=readWriteLock.readLock();
    Lock write=readWriteLock.writeLock();

    public int Get(int get)
    {
        try {
            read.lock();
            System.out.println("In read");
            if(map.containsKey(get)){
            return    map.get(get);
            }
            System.out.println("Out read");
            return 0;
        }finally {
            read.unlock();
        }
    }

   public void Write(int key, int value){
        try {
            write.lock();
            System.out.println("In write");
            map.put(key,value);
            TimeUnit.SECONDS.sleep(10);
            System.out.println("Out write");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            write.unlock();
        }
   }
}
