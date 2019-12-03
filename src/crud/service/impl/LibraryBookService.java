package crud.service.impl;

import crud.bean.Book;
import crud.dao.exception.DAOException;
import crud.dao.impl.DAOFactory;
import crud.dao.impl.ItemsDAO;
import crud.dao.intr.DAO;
import crud.service.exception.ServiceException;
import crud.service.intr.LibraryLogic;

import java.util.Comparator;
import java.util.HashMap;
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
    public HashMap<Integer, Book> GetItems() {
        HashMap<Integer, Book> result = new HashMap<Integer, Book>();
        for (Book client : books) {
            result.put(books.indexOf(client), client);
        }
        return result;
    }

    @Override
    public void Sort(Comparator<? super Book> comparator) {
        books.sort(comparator);
    }

    @Override
    public HashMap<Integer, Book> Find(Comparator<Book> comparator, Book comparedItem) {
        HashMap<Integer, Book> result = new HashMap<Integer, Book>();
        for (Book client : books) {
            if (comparator.compare(client, comparedItem) == 0) {
                result.put(books.indexOf(client), client);
            }
        }
        return result;
    }

    @Override
    public boolean UpdateItem(Integer index, Book newItem) throws ServiceException {
        boolean result = false;
        try {
            Book tmp = books.remove(index.intValue());
            result = books.add(newItem);
            if (!result) {
                books.add(tmp);
            }
        }
        catch (IndexOutOfBoundsException e) {
            throw new ServiceException("Wrong index", e);
        }
        return result;
    }

    @Override
    public boolean AddItem(Book item) {
        return books.add(item);
    }


    @Override
    public void DeleteItem(Integer index) throws ServiceException {
        try {
            books.remove(index.intValue());
        }
        catch (IndexOutOfBoundsException e) {
            throw new ServiceException("Wrong index", e);
        }
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
