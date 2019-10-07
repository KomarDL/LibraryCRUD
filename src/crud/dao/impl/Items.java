package crud.dao.impl;

import crud.dao.intr.DAO;
import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;

public class Items<T> implements DAO<T>, Iterable<T> {

    private LinkedList<T> items;
    private String fileName;

    public Items() {
        items = new LinkedList<T>();
    }

    public Items(String fileName) {
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
    public void LoadItems() throws FileNotFoundException {
        File file = new File(fileName);
        if (!file.exists()){
            throw new FileNotFoundException("No such file in directory");
        }

        try (XMLDecoder xmlDecoder = new XMLDecoder(new BufferedInputStream(new FileInputStream(fileName)))){
            items = (LinkedList<T>) xmlDecoder.readObject();
        }
    }

    @Override
    public void SaveItems() throws IOException {
        File file = new File(fileName);
        if (!file.exists()){
            file.createNewFile();
        }

        try (XMLEncoder xmlEncoder = new XMLEncoder(new BufferedOutputStream(new FileOutputStream(fileName)))){
            xmlEncoder.writeObject(items);
        }
    }

    @Override
    public void AddItem(T item) {
        items.add(item);
    }

    @Override
    public void DeleteItem(T item) {
        items.remove(item);
    }

    @Override
    public Iterator<T> iterator() {
        return items.iterator();
    }
}
