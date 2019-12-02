package crud.dao.intr;

import crud.dao.exception.DAOException;

public interface DAO<T> {
    public void SaveItems(T dataToSave, String path) throws DAOException;
    public T LoadItems(String path) throws DAOException;
}
