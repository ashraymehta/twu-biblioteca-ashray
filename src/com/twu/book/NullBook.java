package com.twu.book;

import com.twu.Messages;

import java.util.List;

// Represents a book when book is not found instead of null
public class NullBook extends Book {
    public NullBook() {
        super(null, null, 0);
    }

    @Override
    public void addToListIfAvailable(List<Book> availableList) {

    }

    @Override
    public String getAppropriateCheckoutMessage() {
        return Messages.UNSUCCESSFUL_CHECKOUT_MESSAGE;
    }

    @Override
    public String getAppropriateReturnMessage() {
        return Messages.UNSUCCESSFUL_RETURN_MESSAGE;
    }

    @Override
    public Book checkoutBook(List<Book> allBooks) {
        return this;
    }

    @Override
    public Book returnBook(List<Book> allBooks) {
        return this;
    }
}
