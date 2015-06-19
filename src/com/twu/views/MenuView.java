package com.twu.views;

import com.twu.Menu;
import com.twu.menuactions.MenuAction;
import com.twu.menuactions.NullAction;
import com.twu.user.AbstractUser;

import java.io.PrintStream;
import java.util.InputMismatchException;
import java.util.Scanner;

// Handles all the I/O to and from the MainMenu
public class MenuView {
    private Menu menu;
    private Scanner scanner;
    private PrintStream printStream;
    private NullAction nullAction;

    public MenuView(Menu menu, Scanner scanner, PrintStream printStream, NullAction nullAction) {
        this.menu = menu;
        this.scanner = scanner;
        this.printStream = printStream;
        this.nullAction = nullAction;
    }

    public void printMainMenu() {
        printStream.println(menu.toString());
    }

    public int getSelection() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (InputMismatchException e) {
            return -1;
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    public MenuAction getSelectionAndPerformAction(AbstractUser user) {
        int selection = getSelection();
        if (menu.hasActionAtPosition(selection))
            return menu.performCorrespondingAction(user, selection);
        else
            printInvalidSelectionMessage();
        return nullAction;
    }

    public void printInvalidSelectionMessage() {
        printStream.println("Select a valid option!");
    }
}