import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext bf=new ClassPathXmlApplicationContext("lookupTest.xml");
        GetBeamTest test=(GetBeamTest)bf.getBean("getBeanTest");
        test.showMe();
    }
}
