package com.thoughtworks.pathashala;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ConsoleOutTest {

    private ByteArrayOutputStream outputStream;

    @Before
    public void setUp() throws Exception {
        outputStream = new ByteArrayOutputStream();
    }

    @Test
    public void shouldPrintWelcomeMessage() throws Exception {
        ConsoleOut consoleOut = new ConsoleOut(new PrintStream(outputStream));
        consoleOut.printWelcomeMessage();

        String actualOutput = outputStream.toString();

        assertThat(actualOutput, is("Welcome" + System.lineSeparator()));
    }
}