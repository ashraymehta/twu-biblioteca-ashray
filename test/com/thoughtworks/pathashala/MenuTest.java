package com.thoughtworks.pathashala;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static junit.framework.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class MenuTest {
    @Test
    public void shouldHaveProperStringRepresentation() throws Exception {
        Menu menu = new Menu();

        String actualString = menu.toString();
        String expectedString = "1. List books" + System.lineSeparator();

        assertEquals(expectedString, actualString);
    }

    @Test
    public void shouldPrintListOfBooksOnOneInput() throws Exception {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(byteArrayOutputStream));
        Menu menu = new Menu();
        MenuView menuViewStub = mock(MenuView.class);
        when(menuViewStub.getSelection()).thenReturn(1);
        menu.performActionForInput(menuViewStub.getSelection());

        String actualOutput = byteArrayOutputStream.toString();
        String expectedOutput = "Harry Potter and the Philosopher's Stone          " +
                "JK Rowling                    1997      " + System.lineSeparator() +
                "Harry Potter and the Chamber of Secrets           " +
                "JK Rowling                    1998      " + System.lineSeparator() + System.lineSeparator();

        assertEquals(expectedOutput, actualOutput);
    }
}