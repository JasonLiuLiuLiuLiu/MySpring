package com.coding.single;

import java.lang.reflect.Constructor;

// 枚举是一个类！  EnumSingle.class
public enum EnumSingle {

    INSTANCE;

    public EnumSingle getInstance(){
        return INSTANCE;
    }

    public static void main(String[] args) throws Exception {
        EnumSingle enumSingle2 = EnumSingle.INSTANCE;

        Constructor<EnumSingle> declaredConstructor = EnumSingle.class.getDeclaredConstructor(String.class,int.class);
        declaredConstructor.setAccessible(true);
        // 期望的异常 throw new IllegalArgumentException("Cannot reflectively create enum objects");
        // Exception in thread "main" java.lang.IllegalArgumentException: Cannot reflectively create enum objects
        // java.lang.NoSuchMethodException: com.coding.single.EnumSingle.<init>()
        declaredConstructor.newInstance();
    }

}
