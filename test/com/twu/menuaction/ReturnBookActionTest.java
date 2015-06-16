package com.twu.menuaction;

import com.twu.Library;
import com.twu.book.AvailableBook;
import com.twu.book.CheckedOutBook;
import com.twu.view.ReturnBookView;
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

    private Library library;
    private ReturnBookAction returnBookAction;

    @Before
    public void setUp() throws Exception {
        library = mock(Library.class);
        when(library.searchBook("Title")).thenReturn(checkedOutBook);
        when(library.returnBook(checkedOutBook)).thenReturn(availableBook);
        when(availableBook.getAppropriateCheckoutMessage()).thenReturn("Success!");
        when(returnBookView.getBookTitle()).thenReturn("Title");
        returnBookAction = new ReturnBookAction(returnBookView, library);
    }

    @Test
    public void shouldTakeInput() throws Exception {
        returnBookAction.perform();

        Mockito.verify(returnBookView).getBookTitle();
    }

    @Test
    public void shouldReturnBookAfterGettingSelection() throws Exception {
        returnBookAction.perform();

        Mockito.verify(library).returnBook(checkedOutBook);
    }

    @Test
    public void shouldGetAppropriateMessageFromBook() throws Exception {
        returnBookAction.perform();

        verify(availableBook).getAppropriateCheckoutMessage();
    }

    @Test
    public void shouldPrintMessageAfterCheckout() throws Exception {
        returnBookAction.perform();

        verify(returnBookView).printMessage("Success!");
    }
}