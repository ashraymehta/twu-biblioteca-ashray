package com.twu.book;

import com.twu.Messages;

import java.util.List;

public class NullBook extends Book {
    public NullBook() {
        super(null, null, 0, 0);
    }

    @Override
    public void addToListIfAvailable(List<Book> availableList) {

    }

    @Override
    public String getAppropriateCheckoutMessage() {
        return Messages.UNSUCCESSFUL_CHECKOUT_MESSAGE;
    }

    @Override
    public Book checkout(List<Book> allBooks) {
        return this;
    }
}
