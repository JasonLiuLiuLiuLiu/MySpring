package site.iblogs.lock;

public class ProducerAndConsumer {
    public static void main(String[] args) {
        Test test=new Test();
        new Thread(new Runnable() {
            public void run() {
                for (int i=0;i<20;i++) {
                    try {
                        test.Producer();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }, "Producer").start();

        new Thread(new Runnable() {
            public void run() {
                for (int i=0;i<20;i++) {
                    try {
                        test.Consumer();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }, "Consumer").start();

    }


}

// 资源类  属性，方法
class Test{

    private boolean produced = false;

    public synchronized void Producer() throws Exception {
// 可能会产生虚假唤醒
//        if(produced)
//        {
//            this.wait();
//        }
        while (produced){
            this.wait();
        }
        System.out.println("In Producer:" + Thread.currentThread().getName());
        produced=true;
        this.notify();
    }

    public synchronized void Consumer() throws Exception {
// 可能会产生虚假唤醒
//        if(!produced)
//        {
//            this.wait();
//        }
        if(!produced){
            this.wait();
        }
        System.out.println("In Consumer:" + Thread.currentThread().getName());
        produced=false;
        this.notify();
    }

/*    怎么产生虚假唤醒
    把  while (product >=1) {}
    换成   if (product >=1) {}
    就会出现虚假唤醒
    为什么 if会出现虚假唤醒
    因为if只会执行一次，执行完会接着向下执行if（）外边的
    而while不会，直到条件满足才会向下执行while（）外边的*/

}

