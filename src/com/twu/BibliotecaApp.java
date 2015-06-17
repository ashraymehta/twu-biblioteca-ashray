package com.twu;

import com.twu.menuactions.MenuAction;
import com.twu.menuactions.QuitAction;
import com.twu.user.AbstractUser;
import com.twu.views.MenuView;

// Invokes printing of welcome message, main menu and asks main menu to perform action upon selection
public class BibliotecaApp {

    private ConsoleOut consoleOut;
    private MenuView menuView;
    private QuitAction quitAction;
    private LoginController loginController;

    public BibliotecaApp(ConsoleOut consoleOut, MenuView menuView, QuitAction quitAction, LoginController loginController) {
        this.consoleOut = consoleOut;
        this.menuView = menuView;
        this.quitAction = quitAction;
        this.loginController = loginController;
    }

    public void start() {
        consoleOut.printWelcomeMessage();
        AbstractUser user = loginController.login();
        MenuAction actionTaken = null;
        while (!quitAction.equals(actionTaken)) {
            menuView.printMainMenu();
            actionTaken = menuView.performActionUponSelection(user);
        }
    }
}