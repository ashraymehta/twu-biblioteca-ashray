package com.twu.views;

import com.twu.Books;

import java.io.PrintStream;
import java.util.InputMismatchException;
import java.util.Scanner;

import static com.twu.Messages.SUCCESSFUL_BOOK_CHECKOUT_MESSAGE;
import static com.twu.Messages.UNSUCCESSFUL_BOOK_CHECKOUT_MESSAGE;

// Prints list of available books, gets user selection and feedback on successful or unsuccessful checkoutBook
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
            return Integer.parseInt(scanner.nextLine());
        } catch (InputMismatchException e) {
            return -1;
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    public String getBookTitle() {
        return scanner.nextLine();
    }

    public void printListOfBooks() {
        String booksString = books.getBooksWithSerialsAsString();
        printStream.println(booksString);
    }

    public void printMessage(String message) {
        printStream.println(message);
    }

    public void printSuccessfulCheckoutMessage() {
        printStream.println(SUCCESSFUL_BOOK_CHECKOUT_MESSAGE);
    }

    public void printUnsuccessfulCheckoutMessage() {
        printStream.println(UNSUCCESSFUL_BOOK_CHECKOUT_MESSAGE);
    }
}