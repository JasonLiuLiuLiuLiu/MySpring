package com.coding.single;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class LazyMan {

    private static boolean flag = false;

    private LazyMan(){
        synchronized (LazyMan.class){
            if (flag==false){
                flag = true;
            }else {
                throw new RuntimeException("不要试图使用反射破坏单例模式");
            }
        }
    }

    private volatile static LazyMan lazyMan;

    public static  LazyMan getInstance(){
        if (lazyMan==null){
            synchronized (LazyMan.class){
                if (lazyMan==null){
                    lazyMan = new LazyMan(); // 可能存在指令重排！
                    /*
                    A：  1    3    2
                    B：  lazyMan = null ；
                    1. 分配对象的内存空间
                    2. 执行构造方法初始化对象
                    3. 设置实例对象指向刚分配的内存的地址， instance = 0xfffff;
                     */
                }
            }
        }
        return lazyMan;
    }

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {

        //LazyMan instance1 = LazyMan.getInstance();
        Constructor<LazyMan> declaredConstructors = LazyMan.class.getDeclaredConstructor(null);
        declaredConstructors.setAccessible(true); // 无视 private 关键字

        Field flag = LazyMan.class.getDeclaredField("flag");
        flag.setAccessible(true);

        LazyMan instance1 = declaredConstructors.newInstance();

        flag.set(instance1,false);


        LazyMan instance2 = declaredConstructors.newInstance();

        System.out.println(instance1);
        System.out.println(instance2);

    }

}
