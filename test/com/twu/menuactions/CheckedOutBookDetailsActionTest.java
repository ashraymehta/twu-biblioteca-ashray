package com.twu.menuactions;

import com.twu.Library;
import com.twu.user.AbstractUser;
import com.twu.views.BooksView;
import com.twu.views.CheckedOutBookDetailsView;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CheckedOutBookDetailsActionTest {
    @Mock
    BooksView booksView;
    @Mock
    Library library;
    @Mock
    AbstractUser user;
    @Mock
    CheckedOutBookDetailsView checkedOutBookDetailsView;

    private CheckedOutBookDetailsAction checkedOutBookDetailsAction;

    @Before
    public void setUp() throws Exception {
        checkedOutBookDetailsAction = new CheckedOutBookDetailsAction(checkedOutBookDetailsView, library);
        when(checkedOutBookDetailsView.getUserInput()).thenReturn("Title");
    }

    @Test
    public void shouldGetBookTitleFromUser() throws Exception {
        checkedOutBookDetailsAction.perform(user);

        verify(checkedOutBookDetailsView).getUserInput();
    }

    @Test
    public void shouldSearchForBook() {
        checkedOutBookDetailsAction.perform(user);

        verify(library).searchBook("Title");
    }
}