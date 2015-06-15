package com.twu;

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