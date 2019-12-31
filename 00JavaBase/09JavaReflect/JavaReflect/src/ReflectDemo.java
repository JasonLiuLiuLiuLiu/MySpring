import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectDemo {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class c = Class.forName("Student");
        Constructor constructor = c.getDeclaredConstructor(String.class);
        constructor.setAccessible(true);
        Student student=(Student) constructor.newInstance("xliu");
        Method md=c.getMethod("SetAge", int.class);
        boolean result=(boolean)md.invoke(student,24);
        System.out.println("SetAge Result:"+result);
        System.out.println(student);
    }
}
