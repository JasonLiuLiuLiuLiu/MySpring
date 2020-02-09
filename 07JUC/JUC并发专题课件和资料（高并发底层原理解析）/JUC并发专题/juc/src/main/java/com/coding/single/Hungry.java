package com.coding.single;

public class Hungry {

    private byte[] data1 = new  byte[10240];
    private byte[] data2 = new  byte[10240];
    private byte[] data3 = new  byte[10240];
    private byte[] data4 = new  byte[10240];

    // 单例模式核心思想，构造器私有！
    private Hungry(){

    }

    private final static Hungry HUNGRY = new Hungry();

    public static Hungry getInstance(){
        return HUNGRY;
    }
}
