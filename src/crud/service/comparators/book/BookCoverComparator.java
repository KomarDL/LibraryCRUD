package crud.service.comparators.book;

import crud.bean.Book;

import java.util.Comparator;

public class BookCoverComparator implements Comparator<Book> {
    @Override
    public int compare(Book book, Book t1) {
        return book.getCover().compareTo(t1.getCover());
    }
}
