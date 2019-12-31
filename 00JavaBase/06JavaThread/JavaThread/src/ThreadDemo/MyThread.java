package ThreadDemo;

public class MyThread extends Thread {

    private final ThreadContext context;

    public MyThread(ThreadContext context) {
        this.context = context;
    }

    @Override
    public void run() {
        while (ThreadContext.count > 0) {
            synchronized (context) {
                if (ThreadContext.count % 2 != 1) {
                    try {
                        context.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(1 + "----" + ThreadContext.count--);
                context.notify();
            }
        }

    }
}
