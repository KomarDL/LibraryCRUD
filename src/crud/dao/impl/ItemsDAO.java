package crud.dao.impl;

import crud.dao.exception.DAOException;
import crud.dao.intr.DAO;
import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;

public class ItemsDAO<T> implements DAO<T> {

    ItemsDAO() {
    }

    @Override
    public T LoadItems(String path) throws DAOException {
        try (XMLDecoder in = new XMLDecoder(new BufferedInputStream(new FileInputStream(path)));){
            T data = (T)in.readObject();
            return data;
        } catch (FileNotFoundException e) {
            throw new DAOException("Cannot find data", e);
        }
    }

    @Override
    public void SaveItems (T dataToSave, String path) throws DAOException {
        File file = new File(path);
        try {
            file.createNewFile();
            XMLEncoder out = new XMLEncoder(new BufferedOutputStream(new FileOutputStream(path)));
            out.writeObject(dataToSave);
            out.flush();
            out.close();
        } catch (IOException e) {
            throw new DAOException("Cannot save data", e);
        }
    }
}
