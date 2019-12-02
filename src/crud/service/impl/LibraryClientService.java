package crud.service.impl;

import crud.bean.Client;
import crud.dao.exception.DAOException;
import crud.dao.impl.DAOFactory;
import crud.dao.impl.ItemsDAO;
import crud.dao.intr.DAO;
import crud.service.exception.ServiceException;
import crud.service.intr.LibraryLogic;

import java.util.*;

public class LibraryClientService implements LibraryLogic<Client>, Iterable<Client> {

    private DAO<LinkedList<Client>> clientDAO;
    private LinkedList<Client> clients;
    private final String path  = new String("Clients.xml");

    LibraryClientService() {
        clientDAO = DAOFactory.getInstance().getClientDAO();
    }

    @Override
    public LinkedList<Client> GetItems() {
        return new LinkedList<Client>(clients);
    }

    @Override
    public void Sort(Comparator<? super Client> comparator) {
        clients.sort(comparator);
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
        boolean result = clients.removeFirstOccurrence(srcItem);
        if (result){
            result = clients.add(newItem);
            if (!result){
                clients.add(srcItem);
            }
        }
        return result;
    }

    @Override
    public boolean AddItem(Client item) {
        return clients.add(item);
    }


    @Override
    public boolean DeleteItem(Client value) {
        return clients.removeFirstOccurrence(value);
    }

    @Override
    public void SaveItems() throws ServiceException {
        try {
            clientDAO.SaveItems(clients, path);
        } catch (DAOException e) {
            throw new ServiceException("Cannot save changes", e);
        }
    }

    @Override
    public void LoadItems() throws ServiceException {
        try {
            clientDAO.LoadItems(path);
        } catch (DAOException e) {
            throw new ServiceException("Cannot load clients", e);
        }
    }

    @Override
    public Iterator<Client> iterator() {
        return clients.iterator();
    }
}
