package com.twu.book;

import java.util.List;

public abstract class Book {
    protected String title, author;
    protected int yearPublished;

    public Book(String title, String author, int yearPublished) {
        this.title = title;
        this.author = author;
        this.yearPublished = yearPublished;
    }

    public abstract Book checkoutBook(List<Book> allBooks);
    public abstract Book returnBook(List<Book> allBooks);
    public abstract String getAppropriateCheckoutMessage();
    public abstract String getAppropriateReturnMessage();
    public abstract void addToListIfAvailable(List<Book> availableList);

    public void addToListIfTitleMatches(List<Book> books, String titleToMatch) {
        if (title.toLowerCase().equals(titleToMatch.toLowerCase()))
            books.add(this);
    }

    @Override
    public String toString() {
        return String.format("%-50s", title) + String.format("%-30s", author)
                + String.format("%-10s", yearPublished);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;

        Book book = (Book) o;

        if (yearPublished != book.yearPublished) return false;
        if (!title.equals(book.title)) return false;
        return author.equals(book.author);

    }

    @Override
    public int hashCode() {
        int result = title.hashCode();
        result = 31 * result + author.hashCode();
        result = 31 * result + yearPublished;
        return result;
    }
}