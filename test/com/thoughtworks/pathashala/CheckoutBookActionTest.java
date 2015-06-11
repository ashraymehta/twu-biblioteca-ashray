package com.thoughtworks.pathashala;

import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.mock;

public class CheckoutBookActionTest {
    @Test
    public void shouldBeAbleToDisplayList() throws Exception {
        CheckoutView checkoutView = mock(CheckoutView.class);
        CheckoutBookAction checkoutBookAction = new CheckoutBookAction(checkoutView);
        checkoutBookAction.perform();

        Mockito.verify(checkoutView).printListOfBooks();
    }

    @Test
    public void shouldBeAbleToTakeInput() throws Exception {
        CheckoutView checkoutView = mock(CheckoutView.class);
        CheckoutBookAction checkoutBookAction = new CheckoutBookAction(checkoutView);
        checkoutBookAction.perform();

        Mockito.verify(checkoutView).getSelection();
    }
}