package crud.service.impl;

import crud.bean.Client;
import crud.dao.impl.DAOFactory;
import crud.dao.impl.ItemsDAO;
import crud.service.intr.LibraryLogic;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Comparator;
import java.util.LinkedList;

public class LibraryClientService implements LibraryLogic<Client> {

    private ItemsDAO<Client> clients;

    public LibraryClientService() {
        clients = DAOFactory.getInstance().getClientDAO();
    }

    @Override
    public void Sort(Comparator<? super Client> comparator) {
        clients.Sort(comparator);
    }

    @Override
    public LinkedList<Client> Find(Comparator<Client> comparator, Client comparedItem) {
        LinkedList<Client> result = new LinkedList<Client>();
        for (Client client : clients) {
            if (comparator.compare(client, comparedItem) == 0) {
                result.add(client);
            }
        }
        return result;
    }

    @Override
    public void UpdateItem(Client srcItem, Client newItem) {
        clients.DeleteItem(srcItem);
        clients.AddItem(newItem);
    }

    @Override
    public void AddItem(Client item) {
        clients.AddItem(item);
    }

    @Override
    public void DeleteItem(Client item) {
        clients.DeleteItem(item);
    }

    @Override
    public void SaveItems() throws IOException {
        clients.SaveItems();
    }

    @Override
    public void LoadItems() throws FileNotFoundException {
        clients.LoadItems();
    }
}
