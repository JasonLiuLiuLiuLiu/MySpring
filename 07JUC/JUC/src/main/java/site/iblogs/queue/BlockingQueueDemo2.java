package site.iblogs.queue;

import java.util.concurrent.ArrayBlockingQueue;

/*       | 方法     | 抛出异常 | 返回特殊值 | 一直阻塞 | 超时退出      |
        | -------- | -------- | ---------- | -------- | ------------- |
        | 插入 存  | add      | offer      | put ()   | offer(e,time) |
        | 移除 取  | remove   | poll       | take()   | poll(e,time)  |
        | 检查队首 | element  | peek       | -        | -             |*/
public class BlockingQueueDemo2 {
    public static void main(String[] args) {
        ArrayBlockingQueue<String> blockingQueue=new ArrayBlockingQueue<String>(3);

        System.out.println(blockingQueue.offer("a"));
        System.out.println(blockingQueue.offer("b"));
        System.out.println(blockingQueue.offer("c"));
        System.out.println(blockingQueue.offer("d"));  //false

        System.out.println(blockingQueue.peek());

        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll()); //null

        System.out.println(blockingQueue.peek()); //null


    }
}
