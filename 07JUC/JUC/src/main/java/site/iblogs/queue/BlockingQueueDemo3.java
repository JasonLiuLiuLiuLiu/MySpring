package site.iblogs.queue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

/*       | 方法     | 抛出异常 | 返回特殊值 | 一直阻塞 | 超时退出      |
        | -------- | -------- | ---------- | -------- | ------------- |
        | 插入 存  | add      | offer      | put ()   | offer(e,time) |
        | 移除 取  | remove   | poll       | take()   | poll(e,time)  |
        | 检查队首 | element  | peek       | -        | -             |*/
public class BlockingQueueDemo3 {
    public static void main(String[] args) throws InterruptedException {
        ArrayBlockingQueue<String> blockingQueue= new ArrayBlockingQueue<>(3);
        new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(5);
                System.out.println(blockingQueue.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        blockingQueue.put("a");
        System.out.println(1);
        blockingQueue.put("b");
        System.out.println(2);
        blockingQueue.put("c");
        System.out.println(3);
        blockingQueue.put("d");
        System.out.println(4);

    }
}
