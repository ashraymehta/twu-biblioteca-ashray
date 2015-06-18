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
        checkedOutBookDetailsAction = new CheckedOutBookDetailsAction(checkedOutBookDetailsView);
    }

    @Test
    public void shouldGetBookTitleFromUser() throws Exception {
        checkedOutBookDetailsAction.perform(user);

        verify(checkedOutBookDetailsView).getUserInput();
    }
}