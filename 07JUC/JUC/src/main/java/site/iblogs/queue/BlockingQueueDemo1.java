package site.iblogs.queue;

import java.util.concurrent.ArrayBlockingQueue;

/*       | 方法     | 抛出异常 | 返回特殊值 | 一直阻塞 | 超时退出      |
        | -------- | -------- | ---------- | -------- | ------------- |
        | 插入 存  | add      | offer      | put ()   | offer(e,time) |
        | 移除 取  | remove   | poll       | take()   | poll(e,time)  |
        | 检查队首 | element  | peek       | -        | -             |*/
public class BlockingQueueDemo1 {
    // 抛出异常
    public static void main(String[] args) {
        ArrayBlockingQueue<String> blockingQueue=new ArrayBlockingQueue<>(3);

        System.out.println(blockingQueue.add("a"));
        System.out.println(blockingQueue.add("b"));
        System.out.println(blockingQueue.add("c"));
        //System.out.println(blockingQueue.add("d"));

        System.out.println(blockingQueue.element());
        System.out.println(blockingQueue.remove());
        System.out.println(blockingQueue.element());

        blockingQueue.remove();

        System.out.println(blockingQueue.element());

        System.out.println(blockingQueue.remove()); // c
        System.out.println(blockingQueue.remove()); // java.util.NoSuchElementException

    }
}
