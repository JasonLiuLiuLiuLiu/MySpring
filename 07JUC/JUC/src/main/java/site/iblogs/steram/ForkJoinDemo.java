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
        for (long i = 0L; i <= 10_0000__0000; i++) {
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

        long sum = LongStream.rangeClosed(0, 10_0000__0000).parallel().reduce(0, Long::sum);

        long end = System.currentTimeMillis();
        System.out.println("time:" + (end - start) + " sum:" + sum);
    }

}

class ForkJoinDemo extends RecursiveTask<Long> {

    private Long left;
    private Long right;
    private Long temp = 10000L;

    public ForkJoinDemo(Long left, Long right) {
        this.left = left;
        this.right = right;
    }


    @Override
    protected Long compute() {
        if (right - left <= temp) {
            long sum = 0L;
            for (Long i = left; i <= right; i++) {
                sum += i;
            }
            return sum;
        } else {
            Long middle=(right+left)/2;

            ForkJoinDemo leftTask=new ForkJoinDemo(left,middle);
            leftTask.fork();
            ForkJoinDemo rightTask=new ForkJoinDemo(middle+1,right);
            rightTask.fork();
            return rightTask.join()+rightTask.join();

        }
    }

}
