package com.thoughtworks.pathashala;

public class BibliotecaApp {
    public static void main(String[] args) {
        start();
    }

    private static void start() {
        ConsoleOut consoleOut = new ConsoleOut();
        consoleOut.printWelcomeMessage();
        MenuView menuView = new MenuView();
        Menu menu = new Menu();
        menuView.printMainMenu(menu.toString());
        menu.performActionForInput(menuView.getSelection());
    }
}