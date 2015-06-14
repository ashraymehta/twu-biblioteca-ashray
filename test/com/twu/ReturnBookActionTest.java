package com.twu;

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
}