package site.iblogs.jmm;

public class VolatileMemoryBarrier {

    private boolean flag=false;
    private int a=0;

    private void  m1(){
        a=5;
        flag=true;   //如果重排 flag=true a=5 结果会不一样
    }

    private void  m2()
    {
        while(flag){
            a=a+3;
            System.out.println("result"+a);
        }

    }
}
