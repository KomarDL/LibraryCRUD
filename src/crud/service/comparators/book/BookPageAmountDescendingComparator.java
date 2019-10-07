package crud.service.comparators.book;

import crud.bean.Book;

import java.util.Comparator;

public class BookPageAmountDescendingComparator implements Comparator<Book> {

    @Override
    public int compare(Book book, Book t1) {
        return t1.getPageAmount() - book.getPageAmount();
    }
}
