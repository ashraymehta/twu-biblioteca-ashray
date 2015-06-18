package com.twu;

import com.twu.menuactions.LogoutAction;
import com.twu.menuactions.QuitAction;
import com.twu.user.AbstractUser;
import com.twu.user.Customer;
import com.twu.views.MenuView;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.HashSet;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class BibliotecaAppTest {
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

    private BibliotecaApp bibliotecaApp;
    private QuitAction quitAction;

    @Before
    public void setUp() throws Exception {
        quitAction = new QuitAction();
        HashSet<AbstractUser> allUsers = new HashSet<>();
        Customer customerOne = new Customer("123-4567", "Password");
        Customer customerTwo = new Customer("111-1111", "11111");
        allUsers.add(customerOne);
        allUsers.add(customerTwo);
        when(loginController.login()).thenReturn(customer);
        when(customerMenuView.performActionUponSelection(customer)).thenReturn(quitAction);
        bibliotecaApp = new BibliotecaApp(consoleOut, customerMenuView, librarianMenuView, quitAction, loginController, logoutAction);
    }

    @Test
    public void shouldPrintWelcomeMessage() throws Exception {
        bibliotecaApp.start();

        Mockito.verify(consoleOut).printWelcomeMessage();
    }

    @Test
    public void shouldPrintMainMenu() throws Exception {
        bibliotecaApp.start();

        verify(customerMenuView).printMainMenu();
    }

    @Test
    public void shouldPerformActionUponSelection() throws Exception {
        bibliotecaApp.start();

        verify(customerMenuView).performActionUponSelection(customer);
    }

    @Test
    public void shouldGetOutOfLoopUponQuitSelection() throws Exception {
        bibliotecaApp.start();

        verify(customerMenuView, times(1)).performActionUponSelection(customer);
    }

    @Test
    public void shouldGetOutOfLoopUponLogoutSelection() throws Exception {
        customerMenuView = mock(MenuView.class);
        LogoutAction logoutAction = new LogoutAction();
        bibliotecaApp = new BibliotecaApp(consoleOut, customerMenuView, librarianMenuView,
                quitAction, loginController, logoutAction);
        when(customerMenuView.performActionUponSelection(customer))
                .thenReturn(logoutAction)
                .thenReturn(new QuitAction());
        bibliotecaApp.start();

        verify(customerMenuView, times(2)).performActionUponSelection(customer);
    }
}