package crud.controller;

import crud.bean.Client;
import crud.service.exception.ServiceException;
import crud.service.impl.LibraryBookService;
import crud.service.impl.LibraryClientService;
import crud.service.impl.ServiceFactory;

import java.util.*;

public class LibraryController {
    //private Map<String, Command> repository;
    private LibraryClientService clientService;
    private LibraryBookService bookService;
    /**
     * Создается объект, инициализируется список доступных команд.
     */
    public LibraryController() {
        clientService = ServiceFactory.getInstance().getClientService();
        bookService = ServiceFactory.getInstance().getBookService();
       /* repository = new HashMap<>();
        repository.put("add_client", new AddClientCommand());
        repository.put("delete_client", new DeleteClientCommand());
        repository.put("find_client", new FindClientCommand());
        repository.put("save_client",new SaveClientCommand());
        repository.put("load_client",new LoadClientCommand());
        repository.put("show_client", new ShowClientCommand());
        repository.put("sort_client", new SortClientCommand());
        repository.put("update_client", new UpdateClientCommand());

        repository.put("add_book", new AddBookCommand());
        repository.put("delete_book", new DeleteBookCommand());
        repository.put("find_book", new FindBookCommand());
        repository.put("save_book",new SaveBookCommand());
        repository.put("load_book",new LoadBookCommand());
        repository.put("show_book", new ShowBookCommand());
        repository.put("sort_book", new SortBookCommand());
        repository.put("update_book", new UpdateBookCommand());

        repository.put("exit", new ExitCommand());
        repository.put("wrong_request", new WrongRequestCommand());
*/
    }

    /**
     * Осуществляет поиск необходимой команды.
     * @param args Аргументы командной строки.
     * @return Возвращает найденную команду. Если команда не была найдена - возвращает команду, выполняемую при
     *         неверном запросе.
     */
    public String execute(String[] args) {
       /* Command result;
        try {
            String commandName = args[0].toLowerCase();
            if (commandName.compareTo("") != 0) {
                result = repository.get(commandName);
                if (result == null) {
                    result = repository.get("wrong_request");
                }
            } else {
                result = repository.get("wrong_request");
            }
        } catch (IllegalArgumentException | NullPointerException ex) {
            result = repository.get("wrong_request");
        }
        return result.execute(args);*/
       return null;
    }

    public HashMap<Integer, Client> displayClients() {
        return clientService.GetItems();
    }

    public boolean addClient(Client client) {
        return clientService.AddItem(client);
    }

    public boolean deleteClient(Integer index) {
        boolean result = true;
        try {
            clientService.DeleteItem(index);
        } catch (ServiceException e) {
            result = false;
        }
        return  result;
    }

    public boolean updateClient(Integer index, Client client) {
        boolean result = true;
        try {
            result = clientService.UpdateItem(index, client);
        } catch (ServiceException e) {
            result = false;
        }
        return result;
    }

    public void sortClients(Comparator<? super Client> comparator) {
        clientService.Sort(comparator);
    }
}
