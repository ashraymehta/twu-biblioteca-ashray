package com.twu.menuaction;

import com.twu.CheckoutBookView;
import com.twu.Library;

// Invokes printing of books, checkout of book and print successful or unsuccessful messages
public class CheckoutBookAction implements MenuAction {

    private CheckoutBookView checkoutBookView;
    private Library library;

    public CheckoutBookAction(CheckoutBookView checkoutBookView, Library library) {
        this.checkoutBookView = checkoutBookView;
        this.library = library;
    }

    @Override
    public void perform() {
        checkoutBookView.printListOfBooks();
        int selection = checkoutBookView.getSelection() - 1;
        boolean isSuccessful = library.checkoutBook(selection);
        if (isSuccessful)
            checkoutBookView.printSuccessfulCheckoutMessage();
        else
            checkoutBookView.printUnsuccessfulCheckoutMessage();
    }
}
