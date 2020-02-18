package site.iblogs.single;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public enum SingleEnum {
    INSTANCE;

    public SingleEnum getInstance(){
        return INSTANCE;
    }

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Constructor<SingleEnum> constructor= SingleEnum.class.getDeclaredConstructor(String.class,int.class);
        constructor.setAccessible(true);
        SingleEnum instance=constructor.newInstance("string",1);
    }
}
