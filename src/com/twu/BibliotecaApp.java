package com.twu;

import com.twu.menuaction.MenuAction;
import com.twu.menuaction.QuitAction;
import com.twu.view.MenuView;

// Invokes printing of welcome message, main menu and asks main menu to perform action upon selection
public class BibliotecaApp {

    private ConsoleOut consoleOut;
    private MenuView menuView;
    private QuitAction quitAction;

    public BibliotecaApp(ConsoleOut consoleOut, MenuView menuView, QuitAction quitAction) {
        this.consoleOut = consoleOut;
        this.menuView = menuView;
        this.quitAction = quitAction;
    }

    public void start() {
        consoleOut.printWelcomeMessage();
        MenuAction actionTaken = null;
        while (!quitAction.equals(actionTaken)) {
            menuView.printMainMenu();
            actionTaken = menuView.performActionUponSelection();
        }
    }
}