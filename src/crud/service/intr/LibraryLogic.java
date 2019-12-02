package crud.service.intr;

import crud.service.exception.ServiceException;

import java.util.Comparator;
import java.util.List;

public interface LibraryLogic<T> {
    public List<T> GetItems();
    public void Sort (Comparator<? super T> comparator);
    public List<T> Find(Comparator<T> comparator, T comparedItem);
    public boolean UpdateItem(T srcItem, T newItem);
    public boolean AddItem(T item);
    public boolean DeleteItem(T value);
    public void SaveItems() throws ServiceException;
    public void LoadItems() throws ServiceException;
}
