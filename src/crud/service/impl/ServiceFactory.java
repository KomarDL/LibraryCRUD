package crud.service.impl;

public final class ServiceFactory {
    private static final ServiceFactory instance = new ServiceFactory();

    private final LibraryClientService clientService = new LibraryClientService();
    private final LibraryBookService bookService = new LibraryBookService();

    private ServiceFactory() {};

    public static ServiceFactory getInstance() {
        return instance;
    }

    public LibraryBookService getBookService () {
        return bookService;
    }

    public LibraryClientService getClientService () {
        return clientService;
    }
}
