package com.thoughtworks.pathashala;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static junit.framework.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class MenuViewTest {

    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

    @Test
    public void shouldPrintMainMenu() throws Exception {
        System.setOut(new PrintStream(outputStream));
        Menu menuStub = mock(Menu.class);
        when(menuStub.toString()).thenReturn("1. List books");
        MenuView menuView = new MenuView(menuStub);
        menuView.printMainMenu();

        String actualOutput = outputStream.toString();
        String expectedOutput = "1. List books" + System.lineSeparator();

        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void shouldGetIntegerFromConsole() throws Exception {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream("5".getBytes());
        System.setIn(byteArrayInputStream);
        MenuView menuView = new MenuView(new Menu());

        int actualInput = menuView.getSelection();
        int expectedInput = 5;

        assertEquals(expectedInput, actualInput);
    }
}
