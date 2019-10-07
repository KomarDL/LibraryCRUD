package crud.service.comparators.book;

import crud.bean.Book;

import java.util.Comparator;

public class BookAuthorComparator implements Comparator<Book> {

    @Override
    public int compare(Book book, Book t1) {
        return book.getAuthor().compareToIgnoreCase(t1.getAuthor());
    }
}
