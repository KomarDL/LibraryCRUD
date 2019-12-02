package crud.view;

import java.util.Scanner;

public class LibraryView {

    public void start() {
        Scanner in = new Scanner(System.in);
        CommandProvider provider = new CommandProvider();
        boolean isContinue;
        do {
            String commandString = in.nextLine();
            String[] args = commandString.split(" ");
            Command command = provider.getCommand(args);
            isContinue = command.execute(args);
        } while (isContinue);
    }
}
