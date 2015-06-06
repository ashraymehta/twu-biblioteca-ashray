package com.thoughtworks.pathashala;

import org.junit.After;
import org.junit.Test;

import java.io.ByteArrayInputStream;

import static junit.framework.Assert.assertEquals;

// Handles input from Console
public class ConsoleInTest {

    @Test
    public void testIntegerInputFromConsole() throws Exception {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream("5".getBytes());
        System.setIn(byteArrayInputStream);

        ConsoleIn consoleIn = new ConsoleIn();
        int actualInput = consoleIn.readInt();
        int expectedInput = 5;

        assertEquals(expectedInput, actualInput);
    }

    @Test
    public void testIntegerInputFromConsoleWithInvalidInput() throws Exception {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream("Five".getBytes());
        System.setIn(byteArrayInputStream);

        ConsoleIn consoleIn = new ConsoleIn();
        int actualInput = consoleIn.readInt();
        int expectedInput = -1;

        assertEquals(expectedInput, actualInput);
    }

    @After
    public void tearDown() throws Exception {
        System.setIn(null);
    }
}