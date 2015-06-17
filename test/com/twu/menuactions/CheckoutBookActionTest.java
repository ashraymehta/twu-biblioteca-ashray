package com.twu.menuactions;

import com.twu.Library;
import com.twu.books.AvailableBook;
import com.twu.books.CheckedOutBook;
import com.twu.views.CheckoutBookView;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class CheckoutBookActionTest {
    @Mock
    CheckoutBookView checkoutBookView;
    @Mock
    AvailableBook availableBook;
    @Mock
    CheckedOutBook checkedOutBook;

    private Library library;
    private CheckoutBookAction checkoutBookAction;

    @Before
    public void setUp() throws Exception {
        library = mock(Library.class);
        when(library.searchBook("Title")).thenReturn(availableBook);
        when(library.checkoutBook(availableBook)).thenReturn(checkedOutBook);
        when(checkedOutBook.getAppropriateCheckoutMessage()).thenReturn("Success!");
        when(checkoutBookView.getBookTitle()).thenReturn("Title");
        checkoutBookAction = new CheckoutBookAction(checkoutBookView, library);
    }

    @Test
    public void shouldTakeInput() throws Exception {
        checkoutBookAction.perform();

        verify(checkoutBookView).getBookTitle();
    }

    @Test
    public void shouldCheckoutBookAfterGettingSelection() throws Exception {
        checkoutBookAction.perform();

        verify(library).checkoutBook(availableBook);
    }

    @Test
    public void shouldGetAppropriateMessageFromBook() throws Exception {
        checkoutBookAction.perform();

        verify(checkedOutBook).getAppropriateCheckoutMessage();
    }

    @Test
    public void shouldPrintMessageAfterCheckout() throws Exception {
        checkoutBookAction.perform();

        verify(checkoutBookView).printMessage("Success!");
    }
}