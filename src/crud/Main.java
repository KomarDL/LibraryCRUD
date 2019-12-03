package crud;

import crud.bean.Client;
import crud.view.ViewFactory;

import java.util.*;

public class Main {
    public static void main(String args[]) {
        ViewFactory.getInstance().getLibraryView().start();
    }
}
