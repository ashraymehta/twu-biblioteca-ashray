package com.twu;

import java.io.PrintStream;
import java.util.InputMismatchException;
import java.util.Scanner;

import static com.twu.Messages.*;
import static com.twu.Messages.SUCCESSFUL_CHECKOUT_MESSAGE;

public class CheckoutBookView {

    private final Books books;
    private final Scanner scanner;
    private final PrintStream printStream;

    public CheckoutBookView(Books books, Scanner scanner, PrintStream printStream) {
        this.books = books;
        this.scanner = scanner;
        this.printStream = printStream;
    }

    public int getSelection() {
        try {
            return scanner.nextInt();
        } catch (InputMismatchException e) {
            return -1;
        }
    }

    public void printListOfBooks() {
        String booksString = books.getBooksWithSerialsAsString();
        printStream.println(booksString);
    }

    public void printSuccessfulCheckoutMessage() {
        printStream.println(SUCCESSFUL_CHECKOUT_MESSAGE);
    }

    public void printUnsuccessfulCheckoutMessage() {
        printStream.println(UNSUCCESSFUL_CHECKOUT_MESSAGE);
    }
}