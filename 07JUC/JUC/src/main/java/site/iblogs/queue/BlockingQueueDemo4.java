package site.iblogs.queue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

/*       | 方法     | 抛出异常 | 返回特殊值 | 一直阻塞 | 超时退出      |
        | -------- | -------- | ---------- | -------- | ------------- |
        | 插入 存  | add      | offer      | put ()   | offer(e,time) |
        | 移除 取  | remove   | poll       | take()   | poll(e,time)  |
        | 检查队首 | element  | peek       | -        | -             |*/
public class BlockingQueueDemo4 {
    public static void main(String[] args) throws InterruptedException {

        ArrayBlockingQueue<String> blockingQueue= new ArrayBlockingQueue<>(3);

        System.out.println(blockingQueue.offer("a",2, TimeUnit.SECONDS));
        System.out.println(blockingQueue.offer("b",2, TimeUnit.SECONDS));
        System.out.println(blockingQueue.offer("c",2, TimeUnit.SECONDS));
        System.out.println(blockingQueue.offer("d",2, TimeUnit.SECONDS));

    }
}
