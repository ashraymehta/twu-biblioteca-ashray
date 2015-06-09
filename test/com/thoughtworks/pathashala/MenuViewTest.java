package com.thoughtworks.pathashala;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static junit.framework.Assert.assertEquals;

public class MenuViewTest {

    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

    @Before
    public void setUp() throws Exception {
        System.setOut(new PrintStream(outputStream));
    }

    @Test
    public void shouldPrintMainMenu() throws Exception {
        MenuView menuView = new MenuView();
        menuView.printMainMenu();

        String actualOutput = outputStream.toString();
        String expectedOutput = "1. List books" + System.lineSeparator();

        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void shouldGetIntegerFromConsole() throws Exception {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream("5".getBytes());
        System.setIn(byteArrayInputStream);
        MenuView menuView = new MenuView();

        int actualInput = menuView.getSelection();
        int expectedInput = 5;

        assertEquals(expectedInput, actualInput);
    }

    @After
    public void tearDown() throws Exception {
        System.setOut(null);
    }
}
