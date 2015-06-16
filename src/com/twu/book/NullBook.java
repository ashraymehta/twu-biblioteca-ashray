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
        return Messages.UNSUCCESSFUL_BOOK_CHECKOUT_MESSAGE;
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
        return this;
    }
}
