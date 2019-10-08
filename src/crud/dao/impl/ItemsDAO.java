package crud.dao.impl;

import crud.dao.exception.DAOException;
import crud.dao.intr.DAO;
import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;

public class ItemsDAO<T> implements DAO<T>, Iterable<T> {

    private LinkedList<T> items;
    private String fileName;

    private ItemsDAO() {
        items = new LinkedList<T>();
    }

    ItemsDAO(String fileName) {
        this();
        this.fileName = fileName;
    }

   /* public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }*/
	
	public void Sort(Comparator<? super T> comparator) {
		items.sort(comparator);
	}

    @Override
    public void LoadItems() throws DAOException {
        try (XMLDecoder xmlDecoder = new XMLDecoder(new BufferedInputStream(new FileInputStream(fileName)))){
            items = (LinkedList<T>) xmlDecoder.readObject();
        } catch (FileNotFoundException e) {
            throw new DAOException("Данные не найдены", e);
        }
    }

    @Override
    public void SaveItems() throws DAOException {
        File file = new File(fileName);
        try {
            file.createNewFile();
        } catch (IOException e) {
            throw new DAOException("Невозможно сохранить данные", e);
        }

        try (XMLEncoder xmlEncoder = new XMLEncoder(new BufferedOutputStream(new FileOutputStream(fileName)))){
            xmlEncoder.writeObject(items);
        } catch (FileNotFoundException | SecurityException e) {
            throw new DAOException("Невозможно сохранить данные", e);
        }
    }

    @Override
    public boolean AddItem(T item) {
        return items.add(item);
    }

    @Override
    public boolean DeleteItem(T item) {
        return items.remove(item);
    }

    @Override
    public Iterator<T> iterator() {
        return items.iterator();
    }
}
