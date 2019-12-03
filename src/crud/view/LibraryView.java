package crud.view;

import crud.bean.Client;
import crud.controller.ControllerFactory;
import crud.controller.LibraryController;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

public class LibraryView {

    private LibraryController controller;
    private Scanner in;

    public LibraryView() {
        controller = ControllerFactory.getInstance().getLibraryController();
        in = new Scanner(System.in);
    }

    public void start() {
        outputAction();
        Integer input = 0;
        do {
            try {
                System.out.print("Enter command number: ");
                input = in.nextInt();
            }
            catch (InputMismatchException e) {
                System.out.println("Wrong command number\n");
                continue;
            }
            switch (input) {
                case 0:
                    outputAction();
                    break;
                case 1:
                    displayClients();
                    break;
                case 2:
                    Client client = getClient();
                    if (client != null) {
                        if (controller.addClient(client)){
                            System.out.println("Added");
                        }
                        else {
                            System.out.println("Not added");
                        }
                    }
                    else {
                        System.out.println("Wrong input");
                    }
                    break;
                case 3:
                    if (deleteClient()) {
                        System.out.println("Deleted");
                    }
                    else {
                        System.out.println("Not deleted");
                    }
                    break;
                case 4:
                    if (updateClient()) {
                        System.out.println("Updated");
                    }
                    else {
                        System.out.println("not updated");
                    }
                    break;
               /* case 5:
                    outputAction();
                    break;
                case 6:
                    outputAction();
                    break;
                case 7:
                    outputAction();
                    break;
                case 8:
                    outputAction();
                    break;
                case 9:
                    outputAction();
                    break;
                case 10:
                    outputAction();
                    break;
                case 11:
                    outputAction();
                    break;*/
                default:
                    System.out.println("Wrong command number\n");
            }
        } while (input != 17);
    }

    private void displayClients() {
        HashMap<Integer, Client> items = controller.displayClients();
        Object[] keys = items.keySet().toArray();
        if (keys.length != 0) {
            for (Object key : keys) {
                displayClient((Integer)key, items.get(key));
            }
        }
        else {
            System.out.println("No clients");
        }

    }

    private Client getClient() {
        Client result = new Client();
        try {
            System.out.print("Enter name");
            result.setName(in.nextLine());
            System.out.print("Enter surname");
            result.setSurname(in.nextLine());
            System.out.print("Enter patronymic");
            result.setPatronymic(in.nextLine());
            System.out.print("Enter birthday in dd/mm/yyyy format");
            result.setBirthday(new SimpleDateFormat("dd/MM/yyyy").parse(in.nextLine()));
            result.setRegistrationDate(new Date(System.currentTimeMillis()));
        }
        catch (Exception e) {
            return null;
        }
        return result;
    }

    private void displayClient(Integer number, Client client) {
        System.out.print(number + ") ");
        System.out.printf("\t %s %s %s\n",client.getName(), client.getSurname(), client.getPatronymic());
        System.out.printf("\t Birthday: %td/%tm/%ty ", client.getBirthday(), client.getBirthday(), client.getBirthday());
        System.out.printf("Registration data %td/%tm/%ty\n\n", client.getRegistrationDate(), client.getRegistrationDate(), client.getRegistrationDate());
    }

    private boolean deleteClient() {
        boolean result = true;
        try {
            System.out.print("Enter index of item to delete");
            controller.deleteClient(in.nextInt());
        }
        catch (Exception e) {
            result = false;
        }
        return  result;
    }

    private boolean updateClient() {
        Client client = getClient();
        boolean result = true;
        if (client != null) {
            try {
                System.out.print("Enter index of item to delete");
                result = controller.updateClient(in.nextInt(), client);
            }
            catch (Exception e) {
                result = false;
            }
        }
        else {
            result = false;
        }
        return result;
    }

    private boolean sortClients() {
        System.out.println("Sort by:");
        System.out.println("1 - Registration date ascending");
        System.out.println("2 - Registration date descending");
        System.out.println("3 - Birthday");
        System.out.println("4 - Name");
        System.out.println("5 - Surname");
        System.out.println("6 - Patronymic");
        boolean result = true;
        try {
            System.out.print("Enter command number");
            int input = in.nextInt();
            //controller.sortClients();
        }
        catch (InputMismatchException e) {
            result = false;
        }
        return result;
    }

    private void outputAction(){
        System.out.println("0 - display menu");
        System.out.println("1 - display clients");
        System.out.println("2 - add client");
        System.out.println("3 - delete client");
        System.out.println("4 - update client");
        System.out.println("5 - sort clients");
        System.out.println("6 - find clients");
        System.out.println("7 - save clients");
        System.out.println("8 - load clients");

        System.out.println("9 - display books");
        System.out.println("10 - add book");
        System.out.println("11 - delete book");
        System.out.println("12 - update book");
        System.out.println("13 - sort books");
        System.out.println("14 - find books");
        System.out.println("15 - save books");
        System.out.println("16 - load books");
    }
}
