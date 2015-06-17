package com.twu;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.io.ByteArrayInputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static junit.framework.Assert.assertEquals;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class LoginViewTest {
    @Mock
    PrintStream printStream;

    private LoginView loginView;

    @Before
    public void setUp() throws Exception {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream("Library Number".getBytes());
        Scanner scanner = new Scanner(byteArrayInputStream);
        loginView = new LoginView(printStream, scanner);
    }

    @Test
    public void shouldGetUserInput() throws Exception {
        String actualInput = loginView.getUserInput();
        String expectedInput = "Library Number";

        assertEquals(expectedInput, actualInput);
    }

    @Test
    public void shouldPrintTheMessageProvided() throws Exception {
        String message = "Message!";
        loginView.printMessage(message);

        verify(printStream).println(message);
    }
}