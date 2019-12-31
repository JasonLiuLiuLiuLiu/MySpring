package ThreadDemo;

public class MyThreadDemo {
    public static void main(String[] args) {
        ThreadContext context=new ThreadContext();
        MyThread td=new MyThread(context);
        MyThreadOther td2=new MyThreadOther(context);
        td.start();
        td2.start();
    }
}
