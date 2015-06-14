package com.twu;

import java.io.PrintStream;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ReturnBookView {
    private Books books;
    private Scanner scanner;
    private PrintStream printStream;

    public ReturnBookView(Books books, Scanner scanner, PrintStream printStream) {
        this.books = books;
        this.scanner = scanner;
        this.printStream = printStream;
    }

    public int getSelection() {
        try {
            return scanner.nextInt();
        } catch (InputMismatchException ex) {
            return -1;
        }
    }

    public void printListOfBooks() {
        String booksString = books.getBooksWithSerialsAsString();
        printStream.println(booksString);
    }

    public void printSuccessfulReturnMessage() {
        printStream.println("Thank you for returning the book.");
    }
}
