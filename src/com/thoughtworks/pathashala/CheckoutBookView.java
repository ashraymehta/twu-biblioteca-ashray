package com.thoughtworks.pathashala;

import java.io.PrintStream;
import java.util.InputMismatchException;
import java.util.Scanner;

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
}