package com.twu.menuaction;

import com.twu.CheckoutBookView;
import com.twu.Library;
import com.twu.Searcher;
import com.twu.book.AvailableBook;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.*;
@RunWith(MockitoJUnitRunner.class)
public class CheckoutBookActionTest {
    @Mock
    Searcher searcher;

    private Library library;

    @Before
    public void setUp() throws Exception {
        library = mock(Library.class);
    }

    @Test
    public void shouldSearchForBookTitle() throws Exception {
        CheckoutBookView checkoutBookView = mock(CheckoutBookView.class);
        CheckoutBookAction checkoutBookAction = new CheckoutBookAction(checkoutBookView, library, searcher);
        when(checkoutBookView.getBookTitle()).thenReturn("Title");
        checkoutBookAction.perform();

        verify(searcher).search("Title");
    }

    @Test
    public void shouldDisplayListOfBooks() throws Exception {
        CheckoutBookView checkoutBookView = mock(CheckoutBookView.class);
        CheckoutBookAction checkoutBookAction = new CheckoutBookAction(checkoutBookView, library, searcher);
        checkoutBookAction.perform();

        verify(checkoutBookView).printListOfBooks();
    }

    @Test
    public void shouldTakeInput() throws Exception {
        CheckoutBookView checkoutBookView = mock(CheckoutBookView.class);
        CheckoutBookAction checkoutBookAction = new CheckoutBookAction(checkoutBookView, library, searcher);
        checkoutBookAction.perform();

        verify(checkoutBookView).getBookTitle();
    }

    @Test
    public void shouldCheckoutBookAfterGettingSelection() throws Exception {
        CheckoutBookView checkoutBookView = mock(CheckoutBookView.class);
        CheckoutBookAction checkoutBookAction = new CheckoutBookAction(checkoutBookView, library, searcher);
        when(checkoutBookView.getBookTitle()).thenReturn("Title");
        AvailableBook availableBook = new AvailableBook("Title", "Author", 1000, 12);
        when(searcher.search("Title")).thenReturn(availableBook);
        checkoutBookAction.perform();

        verify(library).checkoutBook(availableBook);
    }

    @Test
    public void shouldPrintSuccessMessageAfterSuccessfulCheckout() throws Exception {
        CheckoutBookView checkoutBookView = mock(CheckoutBookView.class);
        CheckoutBookAction checkoutBookAction = new CheckoutBookAction(checkoutBookView, library, searcher);
        when(checkoutBookView.getBookTitle()).thenReturn("Title");
        AvailableBook availableBook = new AvailableBook("Title", "Author", 1000, 12);
        when(searcher.search("Title")).thenReturn(availableBook);
        checkoutBookAction.perform();

        verify(checkoutBookView).printSuccessfulCheckoutMessage();
    }

    @Test
    public void shouldPrintUnsuccessfulMessageAfterUnsuccessfulCheckout() throws Exception {
        CheckoutBookView checkoutBookView = mock(CheckoutBookView.class);
        CheckoutBookAction checkoutBookAction = new CheckoutBookAction(checkoutBookView, library, searcher);
        when(checkoutBookView.getBookTitle()).thenReturn("Title");
        when(searcher.search("Title")).thenReturn(null);
        checkoutBookAction.perform();

        verify(checkoutBookView).printUnsuccessfulCheckoutMessage();
    }
}