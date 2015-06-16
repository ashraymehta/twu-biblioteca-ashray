package com.twu.book;

import com.twu.Messages;

import java.util.List;

public class AvailableBook extends Book {
    public AvailableBook(String title, String author, int yearPublished, int id) {
        super(title, author, yearPublished, id);
    }

    public static AvailableBook create(CheckedOutBook checkedOutBook) {
        return new AvailableBook(checkedOutBook.title, checkedOutBook.author,
                checkedOutBook.yearPublished, checkedOutBook.id);
    }

    public Book checkoutBook(List<Book> allBooks) {
        allBooks.remove(this);
        CheckedOutBook checkedOutBook = CheckedOutBook.create(this);
        allBooks.add(checkedOutBook);
        return checkedOutBook;
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
        return Messages.UNSUCCESSFUL_CHECKOUT_MESSAGE;
    }
}
