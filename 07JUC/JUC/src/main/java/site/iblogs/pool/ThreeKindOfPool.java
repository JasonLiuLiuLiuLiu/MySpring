package site.iblogs.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreeKindOfPool {

    public static void main(String[] args) {
        ExecutorService pool1= Executors.newFixedThreadPool(5);
        ExecutorService pool2=Executors.newCachedThreadPool();
        ExecutorService pool3=Executors.newSingleThreadExecutor();

        for(int i=0;i<100;i++){
            pool1.execute(()->{
                System.out.println(Thread.currentThread().getName()+"Running...");
            });
        }
    }

//    public static ExecutorService newFixedThreadPool(int nThreads) {
//        return new ThreadPoolExecutor(nThreads, nThreads,
//                0L, TimeUnit.MILLISECONDS,
//                new LinkedBlockingQueue<Runnable>());
//    }
//
//    public static ExecutorService newCachedThreadPool() {
//        return new ThreadPoolExecutor(0, Integer.MAX_VALUE,
//                60L, TimeUnit.SECONDS,
//                new SynchronousQueue<Runnable>());
//    }
//
//    public static ExecutorService newSingleThreadExecutor() {
//        return new Executors.FinalizableDelegatedExecutorService
//                (new ThreadPoolExecutor(1, 1,
//                        0L, TimeUnit.MILLISECONDS,
//                        new LinkedBlockingQueue<Runnable>()));
//    }


//    public ThreadPoolExecutor(int corePoolSize,
//                              int maximumPoolSize,
//                              long keepAliveTime,
//                              TimeUnit unit,
//                              BlockingQueue<Runnable> workQueue,
//                              ThreadFactory threadFactory,
//                              RejectedExecutionHandler handler) {
//        if (corePoolSize < 0 ||
//                maximumPoolSize <= 0 ||
//                maximumPoolSize < corePoolSize ||
//                keepAliveTime < 0)
//            throw new IllegalArgumentException();
//        if (workQueue == null || threadFactory == null || handler == null)
//            throw new NullPointerException();
//        this.acc = System.getSecurityManager() == null ?
//                null :
//                AccessController.getContext();
//        this.corePoolSize = corePoolSize;
//        this.maximumPoolSize = maximumPoolSize;
//        this.workQueue = workQueue;
//        this.keepAliveTime = unit.toNanos(keepAliveTime);
//        this.threadFactory = threadFactory;
//        this.handler = handler;
//    }

}
