package com.twu;

import com.twu.book.Book;

import java.util.ArrayList;

// Holds the available and the checked out books; provides APIs to checkout and return a book
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

    public boolean returnBook(int bookIndex) {
        try {
            Book checkoutOutBook = checkedOutBooks.remove(bookIndex);
            return availableBooks.add(checkoutOutBook);
        } catch (IndexOutOfBoundsException ex) {
            return false;
        }
    }
}
