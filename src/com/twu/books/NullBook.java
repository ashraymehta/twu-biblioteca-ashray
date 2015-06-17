package com.twu.books;

import com.twu.Messages;
import com.twu.user.Customer;

import java.util.List;

// Represents a books when books is not found instead of null
public class NullBook extends Book {
    public NullBook() {
        super("", "", 0);
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
    public Book checkoutBook(Customer customer) {
        return this;
    }

    @Override
    public Book returnBook() {
        return this;
    }
}
