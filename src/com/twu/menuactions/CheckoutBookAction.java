package com.twu.menuactions;

import com.twu.Library;
import com.twu.books.Book;
import com.twu.user.AbstractUser;
import com.twu.user.Customer;
import com.twu.views.CheckoutBookView;

// Invokes printing of books, checkoutBook of books and print successful or unsuccessful messages
public class CheckoutBookAction implements MenuAction {

    private CheckoutBookView checkoutBookView;
    private Library library;

    public CheckoutBookAction(CheckoutBookView checkoutBookView, Library library) {
        this.checkoutBookView = checkoutBookView;
        this.library = library;
    }

    @Override
    public MenuAction perform(AbstractUser user) {
        String bookTitle = checkoutBookView.getBookTitle();
        Book matchingBook = library.searchBook(bookTitle);
        matchingBook = library.checkoutBook(matchingBook, (Customer) user);
        checkoutBookView.printMessage(matchingBook.getAppropriateCheckoutMessage());
        return this;
    }
}