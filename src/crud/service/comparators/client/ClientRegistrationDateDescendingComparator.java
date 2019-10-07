package crud.service.comparators.client;

import crud.bean.Client;

import java.util.Comparator;

public class ClientRegistrationDateDescendingComparator implements Comparator<Client> {
    @Override
    public int compare(Client client, Client t1) {
        return t1.getRegistrationDate().compareTo(client.getRegistrationDate());
    }
}
