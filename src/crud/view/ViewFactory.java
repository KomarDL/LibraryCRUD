package crud.view;

public class ViewFactory {
    private static final ViewFactory instance = new ViewFactory();
    private LibraryView libraryView = new LibraryView();

    private ViewFactory() {
    }

    public static ViewFactory getInstance() {
        return instance;
    }

    public LibraryView getLibraryView() {
        return libraryView;
    }
}
