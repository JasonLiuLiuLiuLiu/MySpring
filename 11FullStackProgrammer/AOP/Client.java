
import java.lang.reflect.Proxy;
import java.util.Date;

public class Client {
    public static void main(String[] args) throws Exception {
        BookService bookService = (BookService) Proxy.newProxyInstance(
                BookService.class.getClassLoader(),
                new Class[]{ BookService.class },
                new ServiceInvocationHandler(new BookServiceImpl())
            );
        bookService.lendOut("123", "456", new Date());
    }
}