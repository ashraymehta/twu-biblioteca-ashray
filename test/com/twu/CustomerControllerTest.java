package com.twu;

import com.twu.menuactions.ListAvailableBooksAction;
import com.twu.menuactions.LogoutAction;
import com.twu.menuactions.NullAction;
import com.twu.menuactions.QuitAction;
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
public class CustomerControllerTest {
    @Mock
    Librarian librarian;
    @Mock
    MenuView customerMenuView;

    private CustomerController controller;
    private QuitAction quitAction;
    private LogoutAction logoutAction;
    private NullAction nullAction;

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
        when(customerMenuView.getSelectionAndPerformAction(librarian)).thenReturn(quitAction);
        controller = new CustomerController(customerMenuView, quitAction, logoutAction, nullAction);
    }

    @Test
    public void shouldPrintMainMenu() throws Exception {
        controller.execute(librarian);

        verify(customerMenuView).printMainMenu();
    }

    @Test
    public void shouldPerformActionUponSelection() throws Exception {
        controller.execute(librarian);

        verify(customerMenuView).getSelectionAndPerformAction(librarian);
    }

    @Test
    public void shouldGetOutOfLoopUponQuitSelection() throws Exception {
        controller.execute(librarian);

        verify(customerMenuView, times(1)).getSelectionAndPerformAction(librarian);
    }

    @Test
    public void shouldGetOutOfLoopUponLogoutSelection() throws Exception {
        customerMenuView = mock(MenuView.class);
        logoutAction = new LogoutAction();
        controller = new CustomerController(customerMenuView, quitAction, logoutAction, nullAction);
        when(customerMenuView.getSelectionAndPerformAction(librarian))
                .thenReturn(mock(ListAvailableBooksAction.class))
                .thenReturn(quitAction);
        controller.execute(librarian);

        verify(customerMenuView, times(2)).getSelectionAndPerformAction(librarian);
    }

}