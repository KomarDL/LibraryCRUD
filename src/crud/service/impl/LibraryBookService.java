package crud.service.impl;

import crud.bean.Book;
import crud.dao.exception.DAOException;
import crud.dao.impl.DAOFactory;
import crud.dao.impl.ItemsDAO;
import crud.dao.intr.DAO;
import crud.service.exception.ServiceException;
import crud.service.intr.LibraryLogic;

import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;

public class LibraryBookService implements LibraryLogic<Book>, Iterable<Book> {

    private DAO<LinkedList<Book>> bookDAO;
    private LinkedList<Book> books;
    private final String path  = new String("Books.xml");

    LibraryBookService() {
        bookDAO = DAOFactory.getInstance().getBookDAO();
    }

    @Override
    public LinkedList<Book> GetItems() {
        return new LinkedList<Book>(books);
    }

    @Override
    public void Sort(Comparator<? super Book> comparator) {
        books.sort(comparator);
    }

    @Override
    public LinkedList<Book> Find(Comparator<Book> comparator, Book comparedItem) {
        LinkedList<Book> result = new LinkedList<Book>();
        for (Book book : books) {
            if (comparator.compare(book, comparedItem) == 0) {
                result.add(book);
            }
        }
        return result;
    }

    @Override
    public boolean UpdateItem(Book srcItem, Book newItem) {
        boolean result = books.removeFirstOccurrence(srcItem);
        if (result){
            result = books.add(newItem);
            if (!result){
                books.add(srcItem);
            }
        }
        return result;
    }

    @Override
    public boolean AddItem(Book item) {
        return books.add(item);
    }


    @Override
    public boolean DeleteItem(Book value) {
        return books.removeFirstOccurrence(value);
    }

    @Override
    public void SaveItems() throws ServiceException {
        try {
            bookDAO.SaveItems(books, path);
        } catch (DAOException e) {
            throw new ServiceException("Cannot save changes", e);
        }
    }

    @Override
    public void LoadItems() throws ServiceException {
        try {
            bookDAO.LoadItems(path);
        } catch (DAOException e) {
            throw new ServiceException("Cannot load books", e);
        }
    }

    @Override
    public Iterator<Book> iterator() {
        return books.iterator();
    }
}
