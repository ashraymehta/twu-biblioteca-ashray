package com.twu.menuactions;

import com.twu.*;
import com.twu.user.Customer;
import com.twu.user.Librarian;
import com.twu.user.NullUser;
import com.twu.views.MenuView;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class LoginActionTest {
    @Mock
    ConsoleOut consoleOut;
    @Mock
    BookSearcher bookSearcher;
    @Mock
    Library library;
    @Mock
    MenuView customerMenuView;
    @Mock
    MenuView librarianMenuView;
    @Mock
    LoginController loginController;
    @Mock
    Customer customer;
    @Mock
    LibrarianController librarianController;
    @Mock
    CustomerController customerController;
    @Mock
    Librarian librarian;

    private LoginAction loginAction;
    private LogoutAction logoutAction;
    private Customer customerOne;
    private NullUser nullUser;
    private List<MenuAction> stopLoopActions;
    private NullAction nullAction;

    @Before
    public void setUp() throws Exception {
        logoutAction = new LogoutAction();
        nullAction = new NullAction();
        stopLoopActions = new ArrayList<>();
        stopLoopActions.add(logoutAction);
        stopLoopActions.add(new QuitAction());
        stopLoopActions.add(new NullAction());
        nullUser = new NullUser();
        customerOne = new Customer("123-4567", "Password", "Name1", "Email1", "Phone1");
        when(loginController.login()).thenReturn(customerOne);
        when(customerController.execute(customerOne)).thenReturn(logoutAction);
        loginAction = new LoginAction(loginController, librarianController, customerController, stopLoopActions, nullAction);
    }

    @Test
    public void shouldGetOutOfLoopUponQuitSelection() throws Exception {
        loginAction.perform(nullUser);

        verify(customerController, times(1)).execute(customerOne);
    }

    @Test
    public void shouldReturnNullActionOnUnsuccessfulLogin() throws Exception {
        loginController = mock(LoginController.class);
        when(loginController.login()).thenReturn(nullUser);
        when(librarianController.execute(nullUser)).thenReturn(nullAction);
        loginAction = new LoginAction(loginController, librarianController, customerController, stopLoopActions, nullAction);
        MenuAction result = loginAction.perform(librarian);

        assertEquals(nullAction, result);
    }

    @Test
    public void shouldExecuteLibrarianControllerWhenLibrarianIsTheUser() throws Exception {
        loginController = mock(LoginController.class);
        when(loginController.login()).thenReturn(librarian);
        when(librarianController.execute(librarian)).thenReturn(logoutAction);
        loginAction = new LoginAction(loginController, librarianController, customerController, stopLoopActions, nullAction);
        loginAction.perform(librarian);

        verify(librarianController, times(1)).execute(librarian);
    }

    @Test
    public void shouldGetOutOfLoopUponLogoutSelection() throws Exception {
        customerMenuView = mock(MenuView.class);
        loginAction = new LoginAction(loginController, librarianController, customerController, stopLoopActions, nullAction);
        when(librarianController.execute(customerOne)).thenReturn(logoutAction)
                .thenReturn(logoutAction)
                .thenReturn(new QuitAction());
        loginAction.perform(nullUser);

        verify(customerController, times(1)).execute(customerOne);
    }
}