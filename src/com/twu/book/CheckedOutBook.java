package com.twu.book;

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
    public void addToListIfTitleMatches(List<Book> books, String titleToMatch) {

    }
}
