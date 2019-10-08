package crud.service.intr;

import crud.service.exception.ServiceException;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;

public interface LibraryLogic<T> {
    public void Sort (Comparator<? super T> comparator);
    public LinkedList<T> Find(Comparator<T> comparator, T comparedItem);
    public void UpdateItem(T srcItem, T newItem);
    public void AddItem(T item);
    public void DeleteItem(T item);
    public void SaveItems() throws ServiceException;
    public void LoadItems() throws ServiceException;
}
