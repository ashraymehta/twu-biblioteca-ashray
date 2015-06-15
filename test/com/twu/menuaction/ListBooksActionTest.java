package com.twu.menuaction;

import com.twu.BooksView;
import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.mock;

public class ListBooksActionTest {
    @Test
    public void shouldBeAbleToDisplayList() throws Exception {
        BooksView booksViewStub = mock(BooksView.class);
        ListBooksAction listBooksAction = new ListBooksAction(booksViewStub);
        listBooksAction.perform();

        Mockito.verify(booksViewStub).printListOfBooks();
    }
}