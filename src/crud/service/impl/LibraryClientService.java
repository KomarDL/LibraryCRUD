package crud.service.impl;

import crud.bean.Client;
import crud.dao.exception.DAOException;
import crud.dao.impl.DAOFactory;
import crud.dao.impl.ItemsDAO;
import crud.service.exception.ServiceException;
import crud.service.intr.LibraryLogic;

import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;

public class LibraryClientService implements LibraryLogic<Client>, Iterable<Client> {

    private ItemsDAO<Client> clients;

    LibraryClientService() {
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
    public boolean UpdateItem(Client srcItem, Client newItem) {
        boolean result = clients.DeleteItem(srcItem);
        if (result){
            result = clients.AddItem(newItem);
            if (!result){
                clients.AddItem(srcItem);
            }
        }
        return result;
    }

    @Override
    public boolean AddItem(Client item) {
        return clients.AddItem(item);
    }

    @Override
    public boolean DeleteItem(Client item) {
        return clients.DeleteItem(item);
    }

    @Override
    public void SaveItems() throws ServiceException {
        try {
            clients.SaveItems();
        } catch (DAOException e) {
            throw new ServiceException("Невозможно сохранить изменения", e);
        }
    }

    @Override
    public void LoadItems() throws ServiceException {
        try {
            clients.LoadItems();
        } catch (DAOException e) {
            throw new ServiceException("Сохранённый список посетителей не найден", e);
        }
    }

    @Override
    public Iterator<Client> iterator() {
        return clients.iterator();
    }
}
