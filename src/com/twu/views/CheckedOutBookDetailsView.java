package com.twu.views;

import com.twu.books.Book;

import java.io.PrintStream;
import java.util.Scanner;

// Takes user input and prints details of a book
public class CheckedOutBookDetailsView {
    private Scanner scanner;
    private PrintStream printStream;

    public CheckedOutBookDetailsView(Scanner scanner, PrintStream printStream) {
        this.scanner = scanner;
        this.printStream = printStream;
    }

    public String getUserInput() {
        return scanner.nextLine();
    }

    public void printBookDetails(Book book) {
        printStream.println(book);
    }

    public void printMessage(String message) {
        printStream.println(message);
    }
}
