package crud;

import crud.people.client.Client;

import java.util.Collections;
import java.util.Date;
import java.util.LinkedList;

public class Main {
    public static void main(String args[]) {
        LinkedList<Client> clientList = new LinkedList<Client>();
        
        clientList.add(new Client("гг", "гг", "апа", new Date(), new Date()));
        clientList.add(new Client("дд", "дд", "апа", new Date(), new Date()));
        clientList.add(new Client("ддпакопао", "ддпакопао", "апа", new Date(), new Date()));
        clientList.add(new Client("аааяаопао", "", "апа", new Date(), new Date()));
        clientList.add(new Client("а", "а", "апа", new Date(), new Date()));
        clientList.add(new Client("вася", "вася", "апа", new Date(), new Date()));
        clientList.add(new Client("вася", "Aася", "апа", new Date(), new Date()));
        clientList.add(new Client("вася", "Vася", "апа", new Date(), new Date()));

        for (Client client: clientList) {
            System.out.println(client.getSurname());
        }
        System.out.println();

        Collections.sort(clientList);

        for (Client client: clientList) {
            System.out.println(client.getSurname() + " " + client.getName());
        }
    }
}
