package com.thoughtworks.pathashala;

import java.util.ArrayList;

public class Library {

    private final ArrayList<Book> availableBooks;
    private final ArrayList<Book> checkedOutBooks;

    public Library(ArrayList<Book> availableBooks, ArrayList<Book> checkedOutBooks) {
        this.availableBooks = availableBooks;
        this.checkedOutBooks = checkedOutBooks;
    }

    public boolean checkoutBook(int bookIndex) {
        try {
            Book checkedOutBook = availableBooks.remove(bookIndex);
            return checkedOutBooks.add(checkedOutBook);
        } catch (IndexOutOfBoundsException ex) {
            return false;
        }
    }

    public String getListOfAvailableBooksAsString() {
        String listOfBooksAsString = "";
        for (Book book : availableBooks)
            listOfBooksAsString += book + System.lineSeparator();
        return listOfBooksAsString;
    }
}
