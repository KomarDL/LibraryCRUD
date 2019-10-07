package crud.service.comparators.book;

import crud.bean.Book;

import java.util.Comparator;

public class BookPageAmountAscendingComparator implements Comparator<Book> {
    @Override
    public int compare(Book book, Book t1) {
        return book.getPageAmount() - t1.getPageAmount();
    }
}
