package crud.dao.impl;

import crud.bean.Book;
import crud.bean.Client;

public final class DAOFactory {
    private static final DAOFactory instance = new DAOFactory();

    private final Items<Book> bookList = new Items<Book>("Books.xml");
    private final Items<Client> clientList = new Items<Client>("Clients.xml");

    private DAOFactory() {};

    public static DAOFactory getInstance() {
        return instance;
    }

    public Items<Book> getBookDAO () {
        return bookList;
    }

    public Items<Client> getClientDAO () {
        return clientList;
    }
}
