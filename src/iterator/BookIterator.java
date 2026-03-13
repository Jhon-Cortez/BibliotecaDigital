package iterator;

import entity.Book;
import java.util.List;

public class BookIterator implements IIterator {
    private List<Book> books;
    private int position;

    public BookIterator(List<Book> books) {
        this.books = books;
        this.position = 0;
    }

    @Override
    public boolean hasNext() {
        return position < books.getUser().size();
    }

    @Override
    public Book next() {
        if (hasNext()) {
            return books.getUser().get(position++);
        }
        return null;
    }
}
