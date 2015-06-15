package com.twu;

import com.twu.menuaction.MenuAction;
import com.twu.menuaction.QuitAction;

// Invokes printing of welcome message, main menu and asks main menu to perform action upon selection
public class BibliotecaApp {

    private ConsoleOut consoleOut;
    private MenuView menuView;

    public BibliotecaApp(ConsoleOut consoleOut, MenuView menuView) {
        this.consoleOut = consoleOut;
        this.menuView = menuView;
    }

    public void start() {
        consoleOut.printWelcomeMessage();
        MenuAction actionTaken = null;
        while (!(actionTaken instanceof QuitAction)) {
            menuView.printMainMenu();
            actionTaken = menuView.performActionUponSelection();
        }
    }
}