package crud.service.comparators.client;

import crud.bean.Client;

import java.util.Comparator;

public class ClientRegistrationDateAscendingComparator implements Comparator<Client> {
    @Override
    public int compare(Client client, Client t1) {
        return client.getRegistrationDate().compareTo(t1.getRegistrationDate());
    }
}
