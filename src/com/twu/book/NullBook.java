package com.twu.book;

import com.twu.Messages;

import java.util.List;

public class NullBook extends Book {
    public NullBook(String title, String author, int yearPublished, int id) {
        super(title, author, yearPublished, id);
    }

    @Override
    public void addToListIfAvailable(List<Book> availableList) {

    }

    @Override
    public String getAppropriateCheckoutMessage() {
        return Messages.UNSUCCESSFUL_CHECKOUT_MESSAGE;
    }
}
