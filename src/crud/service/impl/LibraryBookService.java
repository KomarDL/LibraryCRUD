package crud.service.impl;

import crud.bean.Book;
import crud.dao.exception.DAOException;
import crud.dao.impl.DAOFactory;
import crud.dao.impl.ItemsDAO;
import crud.service.exception.ServiceException;
import crud.service.intr.LibraryLogic;

import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;

public class LibraryBookService implements LibraryLogic<Book>, Iterable<Book> {

    private ItemsDAO<Book> books;

    LibraryBookService() {
        books = DAOFactory.getInstance().getBookDAO();
    }

    @Override
    public void Sort(Comparator<? super Book> comparator) {
        books.Sort(comparator);
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
        boolean result = books.DeleteItem(srcItem);
        if (result){
            result = books.AddItem(newItem);
            if (!result){
                books.AddItem(srcItem);
            }
        }
        return result;
    }

    @Override
    public boolean AddItem(Book item) {
        return books.AddItem(item);
    }

    @Override
    public boolean DeleteItem(Book item) {
        return books.DeleteItem(item);
    }

    @Override
    public void SaveItems() throws ServiceException {
        try {
            books.SaveItems();
        } catch (DAOException e) {
            throw new ServiceException("Невозможно сохранить изменения", e);
        }
    }

    @Override
    public void LoadItems() throws ServiceException {
        try {
            books.LoadItems();
        } catch (DAOException e) {
            throw new ServiceException("Сохранённый список книг не найден", e);
        }
    }

    @Override
    public Iterator<Book> iterator() {
        return books.iterator();
    }
}
