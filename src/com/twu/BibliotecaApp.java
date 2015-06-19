package com.twu;

import com.twu.menuactions.MenuAction;
import com.twu.menuactions.QuitAction;
import com.twu.views.MenuView;

// Invokes printing of welcome message, main menu and asks main menu to perform action upon selection
public class BibliotecaApp {
    private ConsoleOut consoleOut;
    private QuitAction quitAction;
    private MenuView initialMenuView;

    public BibliotecaApp(ConsoleOut consoleOut, QuitAction quitAction, MenuView initialMenuView) {
        this.consoleOut = consoleOut;
        this.quitAction = quitAction;
        this.initialMenuView = initialMenuView;
    }

    public void start() {
        consoleOut.printWelcomeMessage();
        MenuAction lastActionTaken;
        do {
            initialMenuView.printMainMenu();
            lastActionTaken = initialMenuView.performActionUponSelection(null);
        } while (!lastActionTaken.equals(quitAction));
    }
}