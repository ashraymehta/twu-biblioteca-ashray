package com.twu.books;

import com.twu.user.Customer;

import java.util.List;

// Represents a Book with comparison checks for the object as well as some properties
public abstract class Book {
    protected String title, author;
    protected int yearPublished;

    public Book(String title, String author, int yearPublished) {
        this.title = title;
        this.author = author;
        this.yearPublished = yearPublished;
    }

    public abstract Book checkoutBook(Customer customer);

    public abstract Book returnBook();

    public abstract String getAppropriateCheckoutMessage();

    public abstract String getAppropriateReturnMessage();

    public abstract void addToListIfAvailable(List<Book> availableList);

    public abstract void addToListIfCheckedOut(List<Book> checkedOutList);

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