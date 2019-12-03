package crud.service.intr;

import crud.service.exception.ServiceException;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface LibraryLogic<T> {
    public Map<Integer, T> GetItems();
    public void Sort (Comparator<? super T> comparator);
    public Map<Integer, T> Find(Comparator<T> comparator, T comparedItem);
    public boolean UpdateItem(Integer index, T newItem) throws ServiceException;
    public boolean AddItem(T item);
    public void DeleteItem(Integer index) throws ServiceException;
    public void SaveItems() throws ServiceException;
    public void LoadItems() throws ServiceException;
}
