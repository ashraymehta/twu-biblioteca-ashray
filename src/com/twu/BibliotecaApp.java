package com.twu;

import com.twu.menuactions.LogoutAction;
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
    private LogoutAction logoutAction;

    public BibliotecaApp(ConsoleOut consoleOut, MenuView customerMenuView, MenuView librarianMenuView,
                         QuitAction quitAction, LoginController loginController, LogoutAction logoutAction) {
        this.consoleOut = consoleOut;
        this.customerMenuView = customerMenuView;
        this.librarianMenuView = librarianMenuView;
        this.quitAction = quitAction;
        this.loginController = loginController;
        this.logoutAction = logoutAction;
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
        MenuView menuView = customerMenuView;
        if (user instanceof Librarian)
            menuView = librarianMenuView;
        MenuAction actionTaken;
        do {
            menuView.printMainMenu();
            actionTaken = menuView.performActionUponSelection(user);
        } while (!quitAction.equals(actionTaken) && !logoutAction.equals(actionTaken));
        return actionTaken;
    }
}