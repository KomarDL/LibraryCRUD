package crud.service.impl;

import crud.bean.Book;
import crud.dao.impl.DAOFactory;
import crud.dao.impl.ItemsDAO;
import crud.service.intr.LibraryLogic;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Comparator;
import java.util.LinkedList;

public class LibraryBookService implements LibraryLogic<Book> {

    private ItemsDAO<Book> books;

    public LibraryBookService() {
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
    public void UpdateItem(Book srcItem, Book newItem) {
        books.DeleteItem(srcItem);
        books.AddItem(newItem);
    }

    @Override
    public void AddItem(Book item) {
        books.AddItem(item);
    }

    @Override
    public void DeleteItem(Book item) {
        books.DeleteItem(item);
    }

    @Override
    public void SaveItems() throws IOException {
        books.SaveItems();
    }

    @Override
    public void LoadItems() throws FileNotFoundException {
        books.LoadItems();
    }
}
