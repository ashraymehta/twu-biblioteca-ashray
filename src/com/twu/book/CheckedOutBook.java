package com.twu.book;

import com.twu.Messages;

import java.util.List;

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
        return Messages.SUCCESSFUL_CHECKOUT_MESSAGE;
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
        allBooks.remove(this);
        AvailableBook availableBook = AvailableBook.create(this);
        allBooks.add(availableBook);
        return availableBook;
    }
}
