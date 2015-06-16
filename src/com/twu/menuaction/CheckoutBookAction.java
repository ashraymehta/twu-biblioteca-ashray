package com.twu.menuaction;

import com.twu.Library;
import com.twu.book.Book;
import com.twu.view.CheckoutBookView;

// Invokes printing of books, checkoutBook of book and print successful or unsuccessful messages
public class CheckoutBookAction implements MenuAction {

    private CheckoutBookView checkoutBookView;
    private Library library;

    public CheckoutBookAction(CheckoutBookView checkoutBookView, Library library) {
        this.checkoutBookView = checkoutBookView;
        this.library = library;
    }

    @Override
    public void perform() {
        String bookTitle = checkoutBookView.getBookTitle();
        Book matchingBook = library.searchBook(bookTitle);
        matchingBook = library.checkoutBook(matchingBook);
        checkoutBookView.printMessage(matchingBook.getAppropriateCheckoutMessage());
    }
}