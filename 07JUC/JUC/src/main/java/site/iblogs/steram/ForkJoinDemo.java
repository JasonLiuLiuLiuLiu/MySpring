package site.iblogs.steram;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;
import java.util.stream.LongStream;

// 裁员就是机会！ 你要加工资的机会来了
class ForkJoinTest {
    public static void main(String[] args) {
         test1();
         test2();
         test3();
    }

    // 正常测试
    public static void test1() {
        long start = System.currentTimeMillis();

        long sum = 0L;
        for (long i = 0L; i <= 10_0000__0000L; i++) {
            sum += i;
        }
        long end = System.currentTimeMillis();
        System.out.println("time:" + (end - start) + " sum:" + sum);
    }


    // ForkJoin测试
    public static void test2() {
        long start = System.currentTimeMillis();

        ForkJoinPool forkJoinPool = new ForkJoinPool();
        ForkJoinDemo forkJoinDemo = new ForkJoinDemo(0L, 10_0000__0000L);
        Long sum = forkJoinPool.invoke(forkJoinDemo);

        long end = System.currentTimeMillis();
        System.out.println("time:" + (end - start) + " sum:" + sum);
    }

    // Stream并行流测试
    public static void test3() {
        long start = System.currentTimeMillis();

        long sum = LongStream.rangeClosed(0, 10_0000__0000L).parallel().reduce(0, Long::sum);

        long end = System.currentTimeMillis();
        System.out.println("time:" + (end - start) + " sum:" + sum);
    }

}

class ForkJoinDemo extends RecursiveTask<Long> {

    private Long start;
    private Long end;
    private Long temp = 10000L;

    public ForkJoinDemo(Long start, Long end) {
        this.start = start;
        this.end = end;
    }


    @Override
    protected Long compute() {
        if (end - start <= temp) {
            Long sum = 0L;
            for (Long i = start; i <= end; i++) {
                sum += i;
            }
            return sum;
        } else {
            long middle=(start+end)/2;
            ForkJoinDemo leftTask=new ForkJoinDemo(start,middle);
            leftTask.fork();
            ForkJoinDemo rightTask=new ForkJoinDemo(middle+1,end);
            rightTask.fork();
            return rightTask.join()+leftTask.join();

        }
    }

}
