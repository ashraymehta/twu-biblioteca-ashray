package com.thoughtworks.pathashala;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static junit.framework.Assert.assertEquals;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ConsoleOutTest {

    private ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

    @Before
    public void setUp() throws Exception {
        System.setOut(new PrintStream(outputStream));
    }

    @Test
    public void shouldPrintWelcomeMessage() throws Exception {
        ConsoleOut consoleOut = new ConsoleOut();
        consoleOut.printWelcomeMessage();

        String actualOutput = outputStream.toString();

        assertThat(actualOutput, is("Welcome" + System.lineSeparator()));
    }

    @After
    public void tearDown() throws Exception {
        System.setOut(null);
    }
}