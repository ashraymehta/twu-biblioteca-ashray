package com.twu.book;

import java.util.List;

public abstract class Book {
    protected String title, author;
    protected int yearPublished;
    protected int id;

    public Book(String title, String author, int yearPublished, int id) {
        this.title = title;
        this.author = author;
        this.yearPublished = yearPublished;
        this.id = id;
    }

    public abstract void addToListIfAvailable(List<Book> availableList);

    public abstract String getAppropriateCheckoutMessage();

    public void addToListIfTitleMatches(List<Book> books, String titleToMatch) {
        if (title.toLowerCase().equals(titleToMatch.toLowerCase()))
            books.add(this);
    }

    @Override
    public String toString() {
        return String.format("%-5d", id) + String.format("%-50s", title) + String.format("%-30s", author)
                + String.format("%-10s", yearPublished);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;

        Book book = (Book) o;

        return id == book.id;
    }

    @Override
    public int hashCode() {
        return id;
    }
}
