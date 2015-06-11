package com.thoughtworks.pathashala;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CheckoutBookActionTest {
    private Library library;

    @Before
    public void setUp() throws Exception {
        library = mock(Library.class);
    }

    @Test
    public void shouldBeAbleToDisplayList() throws Exception {
        CheckoutView checkoutView = mock(CheckoutView.class);
        CheckoutBookAction checkoutBookAction = new CheckoutBookAction(checkoutView, library);
        checkoutBookAction.perform();

        Mockito.verify(checkoutView).printListOfBooks();
    }

    @Test
    public void shouldBeAbleToTakeInput() throws Exception {
        CheckoutView checkoutView = mock(CheckoutView.class);
        CheckoutBookAction checkoutBookAction = new CheckoutBookAction(checkoutView, library);
        checkoutBookAction.perform();

        Mockito.verify(checkoutView).getSelection();
    }

    @Test
    public void shouldBeAbleToCheckoutBookAfterGettingSelection() throws Exception {
        CheckoutView checkoutView = mock(CheckoutView.class);
        when(checkoutView.getSelection()).thenReturn(1);
        CheckoutBookAction checkoutBookAction = new CheckoutBookAction(checkoutView, library);
        checkoutBookAction.perform();

        Mockito.verify(library).checkoutBook(1);
    }
}