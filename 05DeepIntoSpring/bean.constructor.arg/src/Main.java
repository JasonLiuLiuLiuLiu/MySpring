import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context=new  ClassPathXmlApplicationContext("constructor.xml");
        ConstructorArgTest test=(ConstructorArgTest)context.getBean("constructorArgTest");
        System.out.println(test.toString());
    }
}
