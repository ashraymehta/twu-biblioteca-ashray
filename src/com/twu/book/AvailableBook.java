package com.twu.book;

import com.twu.Messages;

import java.util.List;

// Represents a book that is available in the library
public class AvailableBook extends Book {
    public AvailableBook(String title, String author, int yearPublished) {
        super(title, author, yearPublished);
    }

    public static AvailableBook create(CheckedOutBook checkedOutBook) {
        return new AvailableBook(checkedOutBook.title, checkedOutBook.author,
                checkedOutBook.yearPublished);
    }

    public Book checkoutBook() {
        return CheckedOutBook.create(this);
    }

    @Override
    public Book returnBook(List<Book> allBooks) {
        return this;
    }

    @Override
    public void addToListIfAvailable(List<Book> availableList) {
        availableList.add(this);
    }

    @Override
    public String getAppropriateCheckoutMessage() {
        return Messages.UNSUCCESSFUL_BOOK_CHECKOUT_MESSAGE;
    }

    @Override
    public String getAppropriateReturnMessage() {
        return Messages.SUCCESSFUL_BOOK_RETURN_MESSAGE;
    }
}
