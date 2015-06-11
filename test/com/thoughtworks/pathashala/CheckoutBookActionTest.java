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
        CheckoutBookView checkoutBookView = mock(CheckoutBookView.class);
        CheckoutBookAction checkoutBookAction = new CheckoutBookAction(checkoutBookView, library);
        checkoutBookAction.perform();

        Mockito.verify(checkoutBookView).printListOfBooks();
    }

    @Test
    public void shouldBeAbleToTakeInput() throws Exception {
        CheckoutBookView checkoutBookView = mock(CheckoutBookView.class);
        CheckoutBookAction checkoutBookAction = new CheckoutBookAction(checkoutBookView, library);
        checkoutBookAction.perform();

        Mockito.verify(checkoutBookView).getSelection();
    }

    @Test
    public void shouldBeAbleToCheckoutBookAfterGettingSelection() throws Exception {
        CheckoutBookView checkoutBookView = mock(CheckoutBookView.class);
        when(checkoutBookView.getSelection()).thenReturn(1);
        CheckoutBookAction checkoutBookAction = new CheckoutBookAction(checkoutBookView, library);
        checkoutBookAction.perform();

        Mockito.verify(library).checkoutBook(1);
    }
}