package com.thoughtworks.pathashala;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ConsoleIn {
    Scanner scanner = new Scanner(System.in);

    public int readInt() {
        try {
            return scanner.nextInt();
        } catch (InputMismatchException e) {
            return -1;
        }
    }
}