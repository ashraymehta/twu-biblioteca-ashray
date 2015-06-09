package com.thoughtworks.pathashala;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuView {

    private Scanner scanner;

    public MenuView() {
        scanner = new Scanner(System.in);
    }

    public void printMainMenu(String mainMenuAsString) {
        System.out.println(mainMenuAsString);
    }

    public int getSelection() {
        try {
            return scanner.nextInt();
        } catch (InputMismatchException e) {
            return -1;
        }
    }
}
