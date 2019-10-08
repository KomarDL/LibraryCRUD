package crud.dao.intr;

import crud.dao.exception.DAOException;

public interface DAO<T> {
    public boolean AddItem(T item);
    public boolean DeleteItem(T item);
    public void SaveItems() throws DAOException;
    public void LoadItems() throws DAOException;
}
