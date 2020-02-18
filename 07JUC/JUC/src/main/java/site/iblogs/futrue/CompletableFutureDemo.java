package site.iblogs.futrue;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<Void> voidCompletableFuture=CompletableFuture.runAsync(()->{
            System.out.println("No return value");
        });

        System.out.println(voidCompletableFuture.get());

        CompletableFuture<Integer> integerCompletableFuture=CompletableFuture.supplyAsync(()->{
            System.out.println("Have integer return");
            return 1024;
        });

        System.out.println(integerCompletableFuture.whenComplete((i,t)->{
            System.out.println("i="+i);
            System.out.println("t="+t);
        }).exceptionally(e->{
            e.printStackTrace();
            return 555;
        }).get());
    }
}
