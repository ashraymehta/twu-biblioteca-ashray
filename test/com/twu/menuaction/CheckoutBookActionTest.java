package com.twu.menuaction;

import com.twu.book.Book;
import com.twu.view.CheckoutBookView;
import com.twu.Library;
import com.twu.Searcher;
import com.twu.book.AvailableBook;
import com.twu.book.CheckedOutBook;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class CheckoutBookActionTest {
    @Mock
    Searcher searcher;
    @Mock
    CheckoutBookView checkoutBookView;
    @Mock
    AvailableBook availableBook;
    @Mock
    CheckedOutBook checkedOutBook;

    private Library library;
    private CheckoutBookAction checkoutBookAction;
    private List<Book> booksToSearch;

    @Before
    public void setUp() throws Exception {
        library = mock(Library.class);
        booksToSearch = new ArrayList<>();
        checkoutBookAction = new CheckoutBookAction(checkoutBookView, library, searcher);
        when(checkoutBookView.getBookTitle()).thenReturn("Title");
        when(searcher.search(booksToSearch, "Title")).thenReturn(availableBook);
        when(library.checkoutBook(availableBook)).thenReturn(checkedOutBook);
        when(checkedOutBook.getAppropriateCheckoutMessage()).thenReturn("Success!");
    }

    @Test
    public void shouldSearchForBookTitle() throws Exception {
        checkoutBookAction.perform();

        verify(searcher).search(booksToSearch, "Title");
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