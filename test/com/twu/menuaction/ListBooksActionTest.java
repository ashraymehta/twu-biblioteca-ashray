package com.twu.menuaction;

import com.twu.view.BooksView;
import com.twu.Library;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class ListBooksActionTest {
    @Mock
    Library library;
    @Mock
    BooksView booksViewStub;

    @Test
    public void shouldBeAbleToDisplayList() throws Exception {
        ListBooksAction listBooksAction = new ListBooksAction(booksViewStub, library);
        listBooksAction.perform();

        verify(booksViewStub).printListOfBooks();
    }

    @Test
    public void shouldRefreshBooksFromLibrary() throws Exception {
        ListBooksAction listBooksAction = new ListBooksAction(booksViewStub, library);
        listBooksAction.perform();

        verify(library).getAvailableBooks();
    }
}