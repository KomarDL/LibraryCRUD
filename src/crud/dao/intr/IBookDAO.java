package crud.dao.intr;

import crud.bean.Book;

import java.util.LinkedList;

public interface IBookDAO {
    public void AddBook(Book book);
    public void DeleteBook(Book book);
    public void SaveBooks();
    public void LoadBooks();
}
