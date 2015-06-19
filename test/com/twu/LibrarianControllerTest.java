package com.twu;

import com.twu.menuactions.*;
import com.twu.user.AbstractUser;
import com.twu.user.Customer;
import com.twu.user.Librarian;
import com.twu.views.MenuView;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.HashSet;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class LibrarianControllerTest {
    @Mock
    Librarian librarian;
    @Mock
    MenuView librarianMenuView;

    private LibrarianController controller;
    private QuitAction quitAction;
    private LogoutAction logoutAction;
    private MenuAction nullAction;

    @Before
    public void setUp() throws Exception {
        quitAction = new QuitAction();
        logoutAction = new LogoutAction();
        nullAction = new NullAction();
        HashSet<AbstractUser> allUsers = new HashSet<>();
        Customer customerOne = new Customer("123-4567", "Password", "Name1", "Email1", "Phone1");
        Customer customerTwo = new Customer("111-1111", "11111", "Name2", "Email2", "Phone2");
        allUsers.add(customerOne);
        allUsers.add(customerTwo);
        when(librarianMenuView.getSelectionAndPerformAction(librarian)).thenReturn(quitAction);
        controller = new LibrarianController(librarianMenuView, quitAction, logoutAction, nullAction);
    }

    @Test
    public void shouldPrintMainMenu() throws Exception {
        controller.execute(librarian);

        verify(librarianMenuView).printMainMenu();
    }

    @Test
    public void shouldPerformActionUponSelection() throws Exception {
        controller.execute(librarian);

        verify(librarianMenuView).getSelectionAndPerformAction(librarian);
    }

    @Test
    public void shouldGetOutOfLoopUponQuitSelection() throws Exception {
        controller.execute(librarian);

        verify(librarianMenuView, times(1)).getSelectionAndPerformAction(librarian);
    }

    @Test
    public void shouldGetOutOfLoopUponLogoutSelection() throws Exception {
        librarianMenuView = mock(MenuView.class);
        logoutAction = new LogoutAction();
        controller = new LibrarianController(librarianMenuView, quitAction, logoutAction, nullAction);
        when(librarianMenuView.getSelectionAndPerformAction(librarian))
                .thenReturn(mock(ListAvailableBooksAction.class))
                .thenReturn(quitAction);
        controller.execute(librarian);

        verify(librarianMenuView, times(2)).getSelectionAndPerformAction(librarian);
    }

}