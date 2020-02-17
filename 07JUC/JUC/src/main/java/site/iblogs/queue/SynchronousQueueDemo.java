package site.iblogs.queue;

import java.util.concurrent.SynchronousQueue;

//  一个put, 必须有一个take, 否则无法继续添加元素
public class SynchronousQueueDemo {
    public static void main(String[] args) {
        SynchronousQueue<String> queue=new SynchronousQueue<>();

         new Thread(()->{
             try {
                 queue.put("a");
                 System.out.println(1);
                 queue.put("b");
                 System.out.println(2);
                 queue.put("c");
                 System.out.println(3);
                 queue.put("d");
                 System.out.println(4);
             } catch (InterruptedException e) {
                 e.printStackTrace();
             }
         }).start();

         new Thread(()->{
             try {
                 System.out.println(queue.take());
                 System.out.println(queue.take());
                 System.out.println(queue.take());
                 System.out.println(queue.take());
                 System.out.println(queue.take());
             } catch (InterruptedException e) {
                 e.printStackTrace();
             }
         }).start();
    }

}
