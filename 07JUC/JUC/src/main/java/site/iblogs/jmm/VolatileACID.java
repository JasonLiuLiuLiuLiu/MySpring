package site.iblogs.jmm;

public class VolatileACID {
    private volatile static int num=0;

    public static void  add(){
        num++;
    }

    public static void main(String[] args) {
        for (int i=0;i<20;i++){
            new Thread(()->{
                for(int j=0;j<1000;j++) {
                 add();
                }
            }).start();
        }

        while (Thread.activeCount()>2){
            Thread.yield();
        }

        System.out.println("Result num="+num);
    }
}
