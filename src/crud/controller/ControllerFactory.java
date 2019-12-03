package crud.controller;

public class ControllerFactory {
    private static final ControllerFactory instance = new ControllerFactory();
    private LibraryController libraryController = new LibraryController();

    private ControllerFactory() {
    }

    public static ControllerFactory getInstance() {
        return instance;
    }

    public LibraryController getLibraryController() {
        return libraryController;
    }
}
