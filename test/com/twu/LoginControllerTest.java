package com.twu;

import com.twu.user.AbstractUser;
import com.twu.user.NullUser;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static com.twu.Messages.ENTER_LIBRARY_NUMBER;
import static com.twu.Messages.ENTER_PASSWORD;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class LoginControllerTest {
    @Mock
    LoginView loginView;
    @Mock
    Authenticator authenticator;
    @Mock
    AbstractUser user;

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
}