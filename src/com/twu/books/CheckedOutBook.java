package com.twu.books;

import com.twu.Messages;

import java.util.List;

// Represents a books that is currently not in the library
public class CheckedOutBook extends Book {
    public CheckedOutBook(String title, String author, int yearPublished) {
        super(title, author, yearPublished);
    }

    public static CheckedOutBook create(AvailableBook availableBook) {
        return new CheckedOutBook(availableBook.title, availableBook.author,
                availableBook.yearPublished);
    }

    @Override
    public void addToListIfAvailable(List<Book> availableList) {

    }

    @Override
    public String getAppropriateCheckoutMessage() {
        return Messages.SUCCESSFUL_BOOK_CHECKOUT_MESSAGE;
    }

    @Override
    public String getAppropriateReturnMessage() {
        return Messages.UNSUCCESSFUL_BOOK_RETURN_MESSAGE;
    }

    @Override
    public Book checkoutBook() {
        return this;
    }

    @Override
    public Book returnBook() {
        return AvailableBook.create(this);
    }
}
