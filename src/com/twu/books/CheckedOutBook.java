package com.twu.books;

import com.twu.Messages;
import com.twu.user.AbstractUser;
import com.twu.user.Customer;

import java.util.List;

// Represents a books that is currently not in the library
public class CheckedOutBook extends Book {
    private AbstractUser checkedOutTo;

    public CheckedOutBook(String title, String author, int yearPublished, AbstractUser checkedOutTo) {
        super(title, author, yearPublished);
        this.checkedOutTo = checkedOutTo;
    }

    public static CheckedOutBook create(AvailableBook availableBook, AbstractUser customer) {
        return new CheckedOutBook(availableBook.title, availableBook.author,
                availableBook.yearPublished, customer);
    }

    @Override
    public void addToListIfAvailable(List<Book> availableList) {

    }

    @Override
    public void addToListIfCheckedOut(List<Book> checkedOutList) {
        checkedOutList.add(this);
    }

    @Override
    public String getAppropriateCheckoutMessage() {
        return Messages.SUCCESSFUL_BOOK_CHECKOUT_MESSAGE;
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
        return AvailableBook.create(this);
    }

    @Override
    public String toString() {
        return super.toString() + String.format("%-80s", checkedOutTo);
    }
}
