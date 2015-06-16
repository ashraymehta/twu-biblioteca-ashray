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
        AvailableBook availableBook = mock(AvailableBook.class);
        when(searcher.search("Title")).thenReturn(availableBook);
        when(availableBook.getAppropriateCheckoutMessage()).thenReturn("Success!");
        checkoutBookAction.perform();

        verify(searcher).search("Title");
    }

    @Test
    public void shouldDisplayListOfBooks() throws Exception {
        CheckoutBookView checkoutBookView = mock(CheckoutBookView.class);
        CheckoutBookAction checkoutBookAction = new CheckoutBookAction(checkoutBookView, library, searcher);
        when(checkoutBookView.getBookTitle()).thenReturn("Title");
        AvailableBook availableBook = mock(AvailableBook.class);
        when(searcher.search("Title")).thenReturn(availableBook);
        when(availableBook.getAppropriateCheckoutMessage()).thenReturn("Success!");
        checkoutBookAction.perform();

        verify(checkoutBookView).printListOfBooks();
    }

    @Test
    public void shouldTakeInput() throws Exception {
        CheckoutBookView checkoutBookView = mock(CheckoutBookView.class);
        CheckoutBookAction checkoutBookAction = new CheckoutBookAction(checkoutBookView, library, searcher);
        when(checkoutBookView.getBookTitle()).thenReturn("Title");
        AvailableBook availableBook = mock(AvailableBook.class);
        when(searcher.search("Title")).thenReturn(availableBook);
        when(availableBook.getAppropriateCheckoutMessage()).thenReturn("Success!");
        checkoutBookAction.perform();

        verify(checkoutBookView).getBookTitle();
    }

    @Test
    public void shouldCheckoutBookAfterGettingSelection() throws Exception {
        CheckoutBookView checkoutBookView = mock(CheckoutBookView.class);
        CheckoutBookAction checkoutBookAction = new CheckoutBookAction(checkoutBookView, library, searcher);
        when(checkoutBookView.getBookTitle()).thenReturn("Title");
        AvailableBook availableBook = mock(AvailableBook.class);
        when(searcher.search("Title")).thenReturn(availableBook);
        when(availableBook.getAppropriateCheckoutMessage()).thenReturn("Success!");
        checkoutBookAction.perform();

        verify(library).checkoutBook(availableBook);
    }

    @Test
    public void shouldGetAppropriateMessageFromBook() throws Exception {
        CheckoutBookView checkoutBookView = mock(CheckoutBookView.class);
        CheckoutBookAction checkoutBookAction = new CheckoutBookAction(checkoutBookView, library, searcher);
        when(checkoutBookView.getBookTitle()).thenReturn("Title");
        AvailableBook availableBook = mock(AvailableBook.class);
        when(searcher.search("Title")).thenReturn(availableBook);
        checkoutBookAction.perform();

        verify(availableBook).getAppropriateCheckoutMessage();
    }

    @Test
    public void shouldPrintMessageAfterCheckout() throws Exception {
        CheckoutBookView checkoutBookView = mock(CheckoutBookView.class);
        CheckoutBookAction checkoutBookAction = new CheckoutBookAction(checkoutBookView, library, searcher);
        when(checkoutBookView.getBookTitle()).thenReturn("Title");
        AvailableBook availableBook = mock(AvailableBook.class);
        when(searcher.search("Title")).thenReturn(availableBook);
        when(availableBook.getAppropriateCheckoutMessage()).thenReturn("Success!");
        checkoutBookAction.perform();

        verify(checkoutBookView).printMessage("Success!");
    }
}