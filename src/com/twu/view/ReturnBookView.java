package com.twu.view;

import com.twu.Books;
import com.twu.Messages;

import java.io.PrintStream;
import java.util.InputMismatchException;
import java.util.Scanner;

// Prints list of books that are checked out, gets user selection and feedback of successful or unsuccessful return
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

    public String getBookTitle() {
        return scanner.nextLine();
    }

    public void printMessage(String message) {
        printStream.println(message);
    }

    public void printListOfBooks() {
        String booksString = books.getBooksWithSerialsAsString();
        printStream.println(booksString);
    }

    public void printSuccessfulReturnMessage() {
        printStream.println(Messages.SUCCESSFUL_BOOK_RETURN_MESSAGE);
    }

    public void printUnsuccessfulReturnMessage() {
        printStream.println(Messages.UNSUCCESSFUL_BOOK_RETURN_MESSAGE);
    }
}
