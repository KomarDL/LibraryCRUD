package crud.dao.impl;

import crud.bean.Book;
import crud.bean.Client;
import crud.dao.intr.DAO;

import java.util.LinkedList;
import java.util.List;

public final class DAOFactory {
    private static final DAOFactory instance = new DAOFactory();

    private final DAO<LinkedList<Book>> bookList = new ItemsDAO<LinkedList<Book>>();
    private final DAO<LinkedList<Client>> clientList = new ItemsDAO<LinkedList<Client>>();

    private DAOFactory() {};

    public static DAOFactory getInstance() {
        return instance;
    }

    public DAO<LinkedList<Book>> getBookDAO () {
        return bookList;
    }

    public DAO<LinkedList<Client>> getClientDAO () {
        return clientList;
    }
}
