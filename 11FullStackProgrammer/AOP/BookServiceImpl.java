
import java.text.MessageFormat;
import java.util.Date;

interface BookService {
    void lendOut(String bookId, String userId, Date date);
}

class BookServiceImpl implements BookService {
    @Override
    public void lendOut(String bookId, String userId, Date date) {
        System.out.println(MessageFormat.format("{0}: The book {1} is lent to {2}.", date, bookId, userId));
    }
}