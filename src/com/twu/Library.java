package com.twu;

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
            Book toBeCheckedOut = availableBooks.remove(bookIndex);
            return checkedOutBooks.add(toBeCheckedOut);
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

    public boolean returnBook(int bookIndex) {
        Book checkoutOutBook = checkedOutBooks.remove(bookIndex);
        return availableBooks.add(checkoutOutBook);
    }
}
