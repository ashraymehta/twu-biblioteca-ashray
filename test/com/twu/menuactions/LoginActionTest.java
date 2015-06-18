package com.twu.menuactions;

import com.twu.*;
import com.twu.user.AbstractUser;
import com.twu.user.Customer;
import com.twu.user.NullUser;
import com.twu.views.MenuView;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.HashSet;

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
    LogoutAction logoutAction;
    @Mock
    LibrarianController librarianController;
    @Mock
    CustomerController customerController;

    private LoginAction loginAction;
    private QuitAction quitAction;
    private Customer customerOne;
    private NullUser nullUser;

    @Before
    public void setUp() throws Exception {
        quitAction = new QuitAction();
        nullUser = new NullUser();
        HashSet<AbstractUser> allUsers = new HashSet<>();
        customerOne = new Customer("123-4567", "Password", "Name1", "Email1", "Phone1");
        Customer customerTwo = new Customer("111-1111", "11111", "Name2", "Email2", "Phone2");
        allUsers.add(customerOne);
        allUsers.add(customerTwo);
        when(loginController.login()).thenReturn(customerOne);
        when(librarianController.execute(customerOne)).thenReturn(quitAction);
        when(customerController.execute(customerOne)).thenReturn(quitAction);
        loginAction = new LoginAction(loginController, librarianController, customerController, quitAction);
    }

    @Test
    public void shouldGetOutOfLoopUponQuitSelection() throws Exception {
        loginAction.perform(nullUser);

        verify(customerController, times(1)).execute(customerOne);
    }

    @Test
    public void shouldGetOutOfLoopUponLogoutSelection() throws Exception {
        customerMenuView = mock(MenuView.class);
        loginAction = new LoginAction(loginController, librarianController, customerController, quitAction);
        when(librarianController.execute(customerOne)).thenReturn(quitAction)
                .thenReturn(logoutAction)
                .thenReturn(new QuitAction());
        loginAction.perform(nullUser);

        verify(customerController, times(1)).execute(customerOne);
    }

}