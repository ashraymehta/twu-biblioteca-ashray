package com.thoughtworks.pathashala;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuView {
    public void printMainMenu() {
        System.out.println("1. List books");
    }

    public int getSelection() {
        Scanner scanner = new Scanner(System.in);
        try {
            return scanner.nextInt();
        } catch (InputMismatchException e) {
            return -1;
        }
    }
}
