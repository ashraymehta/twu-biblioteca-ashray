package com.twu.menuactions;

import com.twu.Library;
import com.twu.user.Librarian;
import com.twu.views.BooksView;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class CheckedOutBookDetailsActionTest {
    @Mock
    BooksView booksView;
    @Mock
    Library library;
    @Mock
    Librarian librarian;

    private CheckedOutBookDetailsAction checkedOutBookDetailsAction;

    @Before
    public void setUp() throws Exception {
        checkedOutBookDetailsAction = new CheckedOutBookDetailsAction(booksView, library);
    }

    @Test
    public void shouldGetCheckedOutBooksFromLibrary() throws Exception {
        checkedOutBookDetailsAction.perform(librarian);

        verify(library).getCheckedOutBooks();
    }
}