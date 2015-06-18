package com.twu;

import com.twu.menuactions.MenuAction;
import com.twu.menuactions.QuitAction;
import com.twu.user.AbstractUser;
import com.twu.user.Librarian;
import com.twu.views.MenuView;

// Invokes printing of welcome message, main menu and asks main menu to perform action upon selection
public class BibliotecaApp {

    private ConsoleOut consoleOut;
    private MenuView customerMenuView;
    private MenuView librarianMenuView;
    private QuitAction quitAction;
    private LoginController loginController;

    public BibliotecaApp(ConsoleOut consoleOut, MenuView customerMenuView, MenuView librarianMenuView,
                         QuitAction quitAction, LoginController loginController) {
        this.consoleOut = consoleOut;
        this.customerMenuView = customerMenuView;
        this.librarianMenuView = librarianMenuView;
        this.quitAction = quitAction;
        this.loginController = loginController;
    }

    public void start() {
        consoleOut.printWelcomeMessage();
        AbstractUser user = loginController.login();
        MenuView menuView = customerMenuView;
        if (user instanceof Librarian)
            menuView = librarianMenuView;
        MenuAction actionTaken = null;
        do {
            menuView.printMainMenu();
            actionTaken = menuView.performActionUponSelection(user);
        } while (!quitAction.equals(actionTaken));
    }
}