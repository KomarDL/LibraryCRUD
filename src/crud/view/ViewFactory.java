package crud.view;

public class ViewFactory {
    private static final ViewFactory instance = new ViewFactory();
    private LibraryView viewManager = new LibraryView();

    private ViewFactory() {
    }

    public static ViewFactory getInstance() {
        return instance;
    }

    public LibraryView getViewManager() {
        return viewManager;
    }
}
