package ThreadDemo;

public class MyThreadOther extends Thread {

    private final ThreadContext context;

    public MyThreadOther(ThreadContext context) {
        this.context = context;
    }

    @Override
    public void run() {
        while (ThreadContext.count > 0) {
            synchronized (context) {
                if (ThreadContext.count % 2 != 0) {
                    try {
                        context.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(0 + "----" + ThreadContext.count--);
                context.notify();
            }
        }

    }
}

