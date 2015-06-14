package com.twu;

import java.io.PrintStream;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuView {

    private Menu menu;
    private Scanner scanner;
    private PrintStream printStream;

    public MenuView(Menu menu, Scanner scanner, PrintStream printStream) {
        this.menu = menu;
        this.scanner = scanner;
        this.printStream = printStream;
    }

    public void printMainMenu() {
        printStream.println(menu.toString());
    }

    public int getSelection() {
        try {
            return scanner.nextInt();
        } catch (InputMismatchException e) {
            return -1;
        }
    }

    public MenuAction performActionUponSelection() {
        int selection = getSelection();
        if (menu.hasActionAtPosition(selection))
            return menu.performActionForInput(selection);
        else
            printInvalidSelectionMessage();
        return null;
    }

    public void printInvalidSelectionMessage() {
        printStream.println("Select a valid option!");
    }
}