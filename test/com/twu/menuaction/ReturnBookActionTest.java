package com.twu.menuaction;

import com.twu.Library;
import com.twu.ReturnBookView;
import com.twu.menuaction.ReturnBookAction;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ReturnBookActionTest {
    private Library library;

    @Before
    public void setUp() throws Exception {
        library = mock(Library.class);
    }

    @Test
    public void shouldDisplayListOfBooks() throws Exception {
        ReturnBookView returnBookView = mock(ReturnBookView.class);
        ReturnBookAction returnBookAction = new ReturnBookAction(returnBookView, library);
        returnBookAction.perform();

        Mockito.verify(returnBookView).printListOfBooks();
    }

    @Test
    public void shouldTakeInput() throws Exception {
        ReturnBookView returnBookView = mock(ReturnBookView.class);
        ReturnBookAction returnBookAction = new ReturnBookAction(returnBookView, library);
        returnBookAction.perform();

        Mockito.verify(returnBookView).getSelection();
    }

    @Test
    public void shouldReturnBookAfterGettingSelection() throws Exception {
        ReturnBookView returnBookView = mock(ReturnBookView.class);
        when(returnBookView.getSelection()).thenReturn(1);
        ReturnBookAction returnBookAction = new ReturnBookAction(returnBookView, library);
        returnBookAction.perform();

        Mockito.verify(library).returnBook(0);
    }

    @Test
    public void shouldPrintSuccessMessageAfterSuccessfulReturn() throws Exception {
        ReturnBookView returnBookView = mock(ReturnBookView.class);
        when(returnBookView.getSelection()).thenReturn(1);
        when(library.returnBook(0)).thenReturn(true);
        ReturnBookAction returnBookAction = new ReturnBookAction(returnBookView, library);
        returnBookAction.perform();

        Mockito.verify(returnBookView).printSuccessfulReturnMessage();
    }

    @Test
    public void shouldPrintUnsuccessfulMessageAfterUnsuccessfulReturn() throws Exception {
        ReturnBookView returnBookView = mock(ReturnBookView.class);
        when(returnBookView.getSelection()).thenReturn(1);
        when(library.returnBook(0)).thenReturn(false);
        ReturnBookAction returnBookAction = new ReturnBookAction(returnBookView, library);
        returnBookAction.perform();

        Mockito.verify(returnBookView).printUnsuccessfulReturnMessage();
    }
}