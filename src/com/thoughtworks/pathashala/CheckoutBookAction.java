package com.thoughtworks.pathashala;

public class CheckoutBookAction implements MenuAction {

    private CheckoutView checkoutView;

    public CheckoutBookAction(CheckoutView checkoutView) {
        this.checkoutView = checkoutView;
    }

    @Override
    public void perform() {
        checkoutView.printListOfBooks();
        checkoutView.getSelection();
    }
}
