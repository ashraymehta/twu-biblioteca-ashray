package com.twu.menuactions;

import com.twu.Library;
import com.twu.books.AvailableBook;
import com.twu.books.CheckedOutBook;
import com.twu.user.Customer;
import com.twu.views.ReturnBookView;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class ReturnBookActionTest {
    @Mock
    AvailableBook availableBook;
    @Mock
    CheckedOutBook checkedOutBook;
    @Mock
    ReturnBookView returnBookView;
    @Mock
    Customer customer;

    private Library library;
    private ReturnBookAction returnBookAction;

    @Before
    public void setUp() throws Exception {
        library = mock(Library.class);
        when(library.searchBook("Title")).thenReturn(checkedOutBook);
        when(library.returnBook(checkedOutBook)).thenReturn(availableBook);
        when(availableBook.getAppropriateReturnMessage()).thenReturn("Success!");
        when(returnBookView.getBookTitle()).thenReturn("Title");
        returnBookAction = new ReturnBookAction(returnBookView, library);
    }

    @Test
    public void shouldTakeInput() throws Exception {
        returnBookAction.perform(customer);

        Mockito.verify(returnBookView).getBookTitle();
    }

    @Test
    public void shouldReturnBookAfterGettingSelection() throws Exception {
        returnBookAction.perform(customer);

        Mockito.verify(library).returnBook(checkedOutBook);
    }

    @Test
    public void shouldGetAppropriateMessageFromBook() throws Exception {
        returnBookAction.perform(customer);

        verify(availableBook).getAppropriateReturnMessage();
    }

    @Test
    public void shouldPrintMessageAfterCheckout() throws Exception {
        returnBookAction.perform(customer);

        verify(returnBookView).printMessage("Success!");
    }
}