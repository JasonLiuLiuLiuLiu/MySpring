package RunnableDemo;

public class MyRunnableThread implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " This method in run");
    }
}
