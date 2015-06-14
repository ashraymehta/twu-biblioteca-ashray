package com.twu;

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
    public void shouldDisplayListOfBooks() throws Exception {
        CheckoutBookView checkoutBookView = mock(CheckoutBookView.class);
        CheckoutBookAction checkoutBookAction = new CheckoutBookAction(checkoutBookView, library);
        checkoutBookAction.perform();

        Mockito.verify(checkoutBookView).printListOfBooks();
    }

    @Test
    public void shouldTakeInput() throws Exception {
        CheckoutBookView checkoutBookView = mock(CheckoutBookView.class);
        CheckoutBookAction checkoutBookAction = new CheckoutBookAction(checkoutBookView, library);
        checkoutBookAction.perform();

        Mockito.verify(checkoutBookView).getSelection();
    }

    @Test
    public void shouldCheckoutBookAfterGettingSelection() throws Exception {
        CheckoutBookView checkoutBookView = mock(CheckoutBookView.class);
        when(checkoutBookView.getSelection()).thenReturn(1);
        CheckoutBookAction checkoutBookAction = new CheckoutBookAction(checkoutBookView, library);
        checkoutBookAction.perform();

        Mockito.verify(library).checkoutBook(0);
    }

    @Test
    public void shouldPrintSuccessMessageAfterSuccessfulCheckout() throws Exception {
        CheckoutBookView checkoutBookView = mock(CheckoutBookView.class);
        when(checkoutBookView.getSelection()).thenReturn(1);
        when(library.checkoutBook(0)).thenReturn(true);
        CheckoutBookAction checkoutBookAction = new CheckoutBookAction(checkoutBookView, library);
        checkoutBookAction.perform();

        Mockito.verify(checkoutBookView).printSuccessfulCheckoutMessage();
    }

    @Test
    public void shouldPrintUnsuccessfulMessageAfterUnsuccessfulCheckout() throws Exception {
        CheckoutBookView checkoutBookView = mock(CheckoutBookView.class);
        when(checkoutBookView.getSelection()).thenReturn(1);
        when(library.checkoutBook(0)).thenReturn(false);
        CheckoutBookAction checkoutBookAction = new CheckoutBookAction(checkoutBookView, library);
        checkoutBookAction.perform();

        Mockito.verify(checkoutBookView).printUnsuccessfulCheckoutMessage();
    }
}