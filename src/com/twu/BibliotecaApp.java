package com.twu;

import com.twu.menuactions.MenuAction;
import com.twu.menuactions.QuitAction;
import com.twu.user.AbstractUser;
import com.twu.user.Librarian;

// Invokes printing of welcome message, main menu and asks main menu to perform action upon selection
public class BibliotecaApp {

    private ConsoleOut consoleOut;
    private QuitAction quitAction;
    private LoginController loginController;
    private LibrarianController librarianController;
    private CustomerController customerController;

    public BibliotecaApp(ConsoleOut consoleOut, QuitAction quitAction, LoginController loginController,
                         LibrarianController librarianController, CustomerController customerController) {
        this.consoleOut = consoleOut;
        this.quitAction = quitAction;
        this.loginController = loginController;
        this.librarianController = librarianController;
        this.customerController = customerController;
    }

    public void start() {
        consoleOut.printWelcomeMessage();
        MenuAction lastActionTaken;
        do {
            lastActionTaken = loginAndStartLoop();
        } while (!lastActionTaken.equals(quitAction));
    }

    private MenuAction loginAndStartLoop() {
        AbstractUser user = loginController.login();
        if (user instanceof Librarian)
            return librarianController.execute(user);
        else
            return customerController.execute(user);
    }
}