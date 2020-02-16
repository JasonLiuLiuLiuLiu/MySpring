package site.iblogs.callable;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

public class CallableDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<Integer> task=new FutureTask<>(new MyCallable());
        new Thread(task).start();
        new Thread(task).start();  // 结果缓存
        System.out.println("before");
        System.out.println(task.get());
    }

}

class MyCallable implements Callable<Integer>{

    @Override
    public Integer call() throws Exception {
        TimeUnit.MILLISECONDS.sleep(2);
        System.out.println("Running...");
        return 1024;
    }
}
