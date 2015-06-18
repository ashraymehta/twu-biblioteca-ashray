package com.twu.views;

import com.twu.Messages;
import com.twu.books.Book;

import java.io.PrintStream;
import java.util.Scanner;

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

    public void printBookDetails(Book user) {
        printStream.println(user);
    }

    public void printNoBookFoundMessage() {
        printStream.println(Messages.NO_BOOK_FOUND);
    }
}
