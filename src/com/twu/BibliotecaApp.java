package com.twu;

import com.twu.menuactions.MenuAction;
import com.twu.menuactions.QuitAction;
import com.twu.user.NullUser;
import com.twu.views.MenuView;

// Invokes printing of welcome message, main menu and asks main menu to perform action upon selection
public class BibliotecaApp {
    private ConsoleOut consoleOut;
    private QuitAction quitAction;
    private MenuView initialMenuView;
    private NullUser nullUser;

    public BibliotecaApp(ConsoleOut consoleOut, QuitAction quitAction, MenuView initialMenuView, NullUser nullUser) {
        this.consoleOut = consoleOut;
        this.quitAction = quitAction;
        this.initialMenuView = initialMenuView;
        this.nullUser = nullUser;
    }

    public void start() {
        consoleOut.printWelcomeMessage();
        MenuAction lastActionTaken;
        do {
            initialMenuView.printMainMenu();
            lastActionTaken = initialMenuView.getSelectionAndPerformAction(nullUser);
        } while (!lastActionTaken.equals(quitAction));
    }
}