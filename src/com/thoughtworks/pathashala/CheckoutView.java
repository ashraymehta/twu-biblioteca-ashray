package com.thoughtworks.pathashala;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CheckoutView {

    private Scanner scanner;

    public CheckoutView(Scanner scanner) {
        this.scanner = scanner;
    }

    public int getSelection() {
        try {
            return scanner.nextInt();
        } catch (InputMismatchException e) {
            return -1;
        }
    }

}
