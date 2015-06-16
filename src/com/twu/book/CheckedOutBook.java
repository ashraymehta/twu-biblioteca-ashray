package com.twu.book;

import com.twu.Messages;

import java.util.List;

public class CheckedOutBook extends Book {
    public CheckedOutBook(String title, String author, int yearPublished, int id) {
        super(title, author, yearPublished, id);
    }

    public static CheckedOutBook create(AvailableBook availableBook) {
        return new CheckedOutBook(availableBook.title, availableBook.author,
                availableBook.yearPublished, availableBook.id);
    }

    @Override
    public void addToListIfAvailable(List<Book> availableList) {

    }

    @Override
    public String getAppropriateCheckoutMessage() {
        return Messages.SUCCESSFUL_CHECKOUT_MESSAGE;
    }

    @Override
    public void addToListIfTitleMatches(List<Book> books, String titleToMatch) {

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
