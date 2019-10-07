package crud.dao.intr;

import crud.bean.Client;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedList;

public interface DAO<T> {
    public void AddItem(T item);
    public void DeleteItem(T item);
    public void SaveItems() throws IOException;
    public void LoadItems() throws FileNotFoundException;
}
