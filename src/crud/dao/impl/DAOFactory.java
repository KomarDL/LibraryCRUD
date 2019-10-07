package crud.dao.impl;

import crud.bean.Book;
import crud.bean.Client;

public final class DAOFactory {
    private static final DAOFactory instance = new DAOFactory();

    private final ItemsDAO<Book> bookList = new ItemsDAO<Book>("Books.xml");
    private final ItemsDAO<Client> clientList = new ItemsDAO<Client>("Clients.xml");

    private DAOFactory() {};

    public static DAOFactory getInstance() {
        return instance;
    }

    public ItemsDAO<Book> getBookDAO () {
        return bookList;
    }

    public ItemsDAO<Client> getClientDAO () {
        return clientList;
    }
}
