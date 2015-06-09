package com.thoughtworks.pathashala;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuView {

    private Menu menu;
    private Scanner scanner;

    public MenuView(Menu menu) {
        this.menu = menu;
        scanner = new Scanner(System.in);
    }

    public void printMainMenu() {
        System.out.println(menu.toString());
    }

    public int getSelection() {
        try {
            return scanner.nextInt();
        } catch (InputMismatchException e) {
            return -1;
        }
    }

    public void performActionUponSelection() {
        int selection = getSelection();
        if (menu.hasActionAtPosition(selection))
            menu.performActionForInput(selection);
        else
            printInvalidSelectionMessage();
    }

    public void printInvalidSelectionMessage() {
        System.out.println("Select a valid option!");
    }
}