package site.iblogs.cas;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicStampedReference;

public class AtomicStampedReferenceDemo {
    public static void main(String[] args) {
        AtomicStampedReference<Integer> atomicStampedReference=new AtomicStampedReference<>(100,1);
        new Thread(()->{
            //1 、 获得版本号
            int stamp = atomicStampedReference.getStamp();
            System.out.println("T1 stamp 01=>"+stamp);

            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("T1 02 Result="+atomicStampedReference.compareAndSet(100,101,
                    stamp,atomicStampedReference.getStamp()+1));
            System.out.println("T1 stamp 03=>"+atomicStampedReference.getStamp());

        },"T1").start();

        new Thread(()->{

            atomicStampedReference.compareAndSet(100,101,
                    atomicStampedReference.getStamp(),atomicStampedReference.getStamp()+1);

            System.out.println("T2 stamp 01=>"+atomicStampedReference.getStamp());

            atomicStampedReference.compareAndSet(101,100,
                    atomicStampedReference.getStamp(),atomicStampedReference.getStamp()+1);

            System.out.println("T1 stamp 02=>"+atomicStampedReference.getStamp());
        },"T2").start();
    }
}
