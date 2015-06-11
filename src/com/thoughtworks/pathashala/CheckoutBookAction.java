package com.thoughtworks.pathashala;

public class CheckoutBookAction implements MenuAction {

    private CheckoutView checkoutView;
    private Library library;

    public CheckoutBookAction(CheckoutView checkoutView, Library library) {
        this.checkoutView = checkoutView;
        this.library = library;
    }

    @Override
    public void perform() {
        checkoutView.printListOfBooks();
        int selection = checkoutView.getSelection() - 1;
        library.checkoutBook(selection);
    }
}
