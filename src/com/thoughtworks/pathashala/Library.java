package com.thoughtworks.pathashala;

import java.util.ArrayList;

public class Library {

    private final ArrayList<Book> availableBooks;
    private final ArrayList<Book> checkedOutBooks;

    public Library(ArrayList<Book> availableBooks, ArrayList<Book> checkedOutBooks) {
        this.availableBooks = availableBooks;
        this.checkedOutBooks = checkedOutBooks;
    }

    public void checkoutBook(int bookIndex) {
        Book checkedOutBook = availableBooks.get(bookIndex);
        availableBooks.remove(bookIndex);
        checkedOutBooks.add(checkedOutBook);
    }

    public String getListOfAvailableBooksAsString() {
        String listOfBooksAsString = "";
        for (Book book : availableBooks)
            listOfBooksAsString += book + System.lineSeparator();
        return listOfBooksAsString;
    }
}
