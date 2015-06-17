package com.twu;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class LoginControllerTest {
    @Mock
    LoginView loginView;

    private LoginController loginController;

    @Before
    public void setUp() throws Exception {
        loginController = new LoginController(loginView);
    }

    @Test
    public void shouldGetUserInputTwiceViaLoginView() throws Exception {
        loginController.login();

        verify(loginView, times(2)).getUserInput();
    }
}