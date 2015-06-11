package com.thoughtworks.pathashala;

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
        library.checkoutBook(selection);
    }
}
