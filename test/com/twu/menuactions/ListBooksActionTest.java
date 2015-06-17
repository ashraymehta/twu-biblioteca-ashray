package com.twu.menuactions;

import com.twu.Library;
import com.twu.user.AbstractUser;
import com.twu.views.BooksView;
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
    @Mock
    private AbstractUser abstractUser;

    @Test
    public void shouldBeAbleToDisplayList() throws Exception {
        ListBooksAction listBooksAction = new ListBooksAction(booksViewStub, library);
        listBooksAction.perform(abstractUser);

        verify(booksViewStub).printListOfBooks();
    }

    @Test
    public void shouldRefreshBooksFromLibrary() throws Exception {
        ListBooksAction listBooksAction = new ListBooksAction(booksViewStub, library);
        listBooksAction.perform(abstractUser);

        verify(library).getAvailableBooks();
    }
}