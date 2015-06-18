package com.twu;

import com.twu.menuactions.MenuAction;
import com.twu.menuactions.QuitAction;
import com.twu.user.AbstractUser;
import com.twu.views.MenuView;

// Invokes printing of welcome message, main menu and asks main menu to perform action upon selection
public class BibliotecaApp {
    private ConsoleOut consoleOut;
    private QuitAction quitAction;
    private LoginController loginController;
    private LibrarianController librarianController;
    private CustomerController customerController;
    private MenuView initialMenuView;

    public BibliotecaApp(ConsoleOut consoleOut, QuitAction quitAction, LoginController loginController,
                         LibrarianController librarianController, CustomerController customerController, MenuView initialMenuView) {
        this.consoleOut = consoleOut;
        this.quitAction = quitAction;
        this.loginController = loginController;
        this.librarianController = librarianController;
        this.customerController = customerController;
        this.initialMenuView = initialMenuView;
    }

    public void start() {
        consoleOut.printWelcomeMessage();
        MenuAction lastActionTaken;
        do {
            AbstractUser abstractUser = null;
            initialMenuView.printMainMenu();
            lastActionTaken = initialMenuView.performActionUponSelection(abstractUser);
        } while (!lastActionTaken.equals(quitAction));
    }
}