package iterator;

import entity.Book;

public interface IIterator {
    boolean hasNext();
    Book next();
}
