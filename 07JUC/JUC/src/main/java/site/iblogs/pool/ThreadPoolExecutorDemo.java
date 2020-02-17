package site.iblogs.pool;

import java.util.concurrent.*;

public class ThreadPoolExecutorDemo {
    public static void main(String[] args) {
        ThreadPoolExecutor pool = new ThreadPoolExecutor(
                2,
                5,
                3L,
                TimeUnit.SECONDS,
                new LinkedBlockingDeque<>(3),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.CallerRunsPolicy());

        //拒绝策略说明:
        //1. AbortPolicy 默认的:队列满了就丢弃任务抛出异常
        //2. CallerRunsPolicy 哪里来的就回哪里去
        //3. DiscardOldestPolicy 尝试将最好进入的任务删除,并加入此任务
        //4. DiscardPolicy 队列满了任务也会丢弃,也不抛异常

        for (int i = 0; i < 20; i++) {
            pool.execute(() -> {
                System.out.println(Thread.currentThread().getName() + "Running...");
            });
        }

    }
}
