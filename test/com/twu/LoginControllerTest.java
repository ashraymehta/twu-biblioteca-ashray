package com.twu;

import com.twu.user.AbstractUser;
import com.twu.user.Customer;
import com.twu.user.Librarian;
import com.twu.user.NullUser;
import com.twu.views.LoginView;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static com.twu.Messages.ENTER_LIBRARY_NUMBER;
import static com.twu.Messages.ENTER_PASSWORD;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class LoginControllerTest {
    @Mock
    LoginView loginView;
    @Mock
    Authenticator authenticator;
    @Mock
    Customer user;

    private LoginController loginController;
    private String libraryNumber;
    private String password;
    private NullUser nullUser;

    @Before
    public void setUp() throws Exception {
        nullUser = new NullUser();
        loginController = new LoginController(loginView, authenticator, nullUser);
        libraryNumber = "LibraryNumber";
        password = "Password";
        when(loginView.getUserInput())
                .thenReturn(libraryNumber)
                .thenReturn(password);
        when(authenticator.login(libraryNumber, password))
                .thenReturn(user);
        when(user.getLoginStatusMessage())
                .thenReturn(Messages.SUCCESSFUL_LOGIN);
    }

    @Test
    public void shouldGetUserInputTwiceViaLoginView() throws Exception {
        loginController.login();

        verify(loginView, times(2)).getUserInput();
    }

    @Test
    public void shouldPromptForLibraryNumberInput() throws Exception {
        loginController.login();

        verify(loginView).printMessage(ENTER_LIBRARY_NUMBER);
    }

    @Test
    public void shouldPromptForPasswordInput() throws Exception {
        loginController.login();

        verify(loginView).printMessage(ENTER_PASSWORD);
    }

    @Test
    public void shouldTryToLoginAuthenticator() throws Exception {
        loginController.login();

        verify(authenticator).login(libraryNumber, password);
    }

    @Test
    public void shouldGetStatusMessageOfUser() throws Exception {
        loginController.login();

        verify(user).getLoginStatusMessage();
    }

    @Test
    public void shouldPrintLoginStatusOfUser() throws Exception {
        loginController.login();

        verify(loginView).printMessage(Messages.SUCCESSFUL_LOGIN);
    }

    @Test
    public void shouldLoopUntilLoginIsSuccessful() throws Exception {
        authenticator = mock(Authenticator.class);
        when(loginView.getUserInput())
                .thenReturn(libraryNumber)
                .thenReturn(password)
                .thenReturn(libraryNumber)
                .thenReturn(password);
        when(authenticator.login(libraryNumber, password))
                .thenReturn(nullUser)
                .thenReturn(user);
        loginController = new LoginController(loginView, authenticator, nullUser);
        loginController.login();

        verify(authenticator, times(2)).login(libraryNumber, password);
    }

    @Test
    public void shouldReturnTheLoggedInUser() throws Exception {
        AbstractUser user = loginController.login();

        assertTrue(user instanceof Customer || user instanceof Librarian);
    }
}