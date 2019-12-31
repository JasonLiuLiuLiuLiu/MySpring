package RunnableDemo;

public class RunnableThreadDemo {
    public static void main(String[] args) {
        MyRunnableThread runnableThread=new MyRunnableThread();
        Thread td=new Thread(runnableThread,"runnable test");
        td.start();
    }
}
