package com.thoughtworks.pathashala;

import java.util.ArrayList;

public class Library {

    private final ArrayList<Book> availableBooks;
    private final ArrayList<Book> checkedOutBooks;

    public Library(ArrayList<Book> availableBooks, ArrayList<Book> checkedOutBooks) {
        this.availableBooks = availableBooks;
        this.checkedOutBooks = checkedOutBooks;
    }

    public void checkoutBook(int book) {
        availableBooks.remove(book);
    }

    public String getListOfAvailableBooksAsString() {
        String listOfBooksAsString = "";
        for (Book book : availableBooks)
            listOfBooksAsString += book + System.lineSeparator();
        return listOfBooksAsString;
    }
}
