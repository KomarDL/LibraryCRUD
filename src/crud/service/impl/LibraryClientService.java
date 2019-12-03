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
        clients = new LinkedList<Client>();
    }

    @Override
    public HashMap<Integer, Client> GetItems() {
        HashMap<Integer, Client> result = new HashMap<Integer, Client>();
        for (Client client : clients) {
            result.put(clients.indexOf(client), client);
        }
        return result;
    }

    @Override
    public void Sort(Comparator<? super Client> comparator) {
        clients.sort(comparator);
    }

    @Override
    public HashMap<Integer, Client> Find(Comparator<Client> comparator, Client comparedItem) {
        HashMap<Integer, Client> result = new HashMap<Integer, Client>();
        for (Client client : clients) {
            if (comparator.compare(client, comparedItem) == 0) {
                result.put(clients.indexOf(client), client);
            }
        }
        return result;
    }

    @Override
    public boolean UpdateItem(Integer index, Client newItem) throws ServiceException {
        boolean result = false;
        try {
            Client tmp = clients.remove(index.intValue());
            result = clients.add(newItem);
            if (!result) {
                clients.add(tmp);
            }
        }
        catch (IndexOutOfBoundsException e) {
            throw new ServiceException("Wrong index", e);
        }
        return result;
    }

    @Override
    public boolean AddItem(Client item) {
        return clients.add(item);
    }


    @Override
    public void DeleteItem(Integer index) throws ServiceException {
        try {
            clients.remove(index.intValue());
        }
        catch (IndexOutOfBoundsException e) {
            throw new ServiceException("Wrong index", e);
        }
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
