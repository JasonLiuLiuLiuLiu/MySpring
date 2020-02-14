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
        if(produced)
        {
            this.wait();
        }
        System.out.println("In Producer:" + Thread.currentThread().getName());
        produced=true;
        this.notify();
    }

    public synchronized void Consumer() throws Exception {
        if(!produced)
        {
            this.wait();
        }
        System.out.println("In Consumer:" + Thread.currentThread().getName());
        produced=false;
        this.notify();
    }

}

