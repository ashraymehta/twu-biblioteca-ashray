package com.twu.views;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import java.io.ByteArrayInputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static junit.framework.Assert.assertEquals;

public class CheckedOutBookDetailsViewTest {
    @Mock
    PrintStream printStream;

    private Scanner scanner;
    private CheckedOutBookDetailsView checkedOutBookDetailsView;

    @Before
    public void setUp() throws Exception {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream("Title".getBytes());
        scanner = new Scanner(byteArrayInputStream);
        checkedOutBookDetailsView = new CheckedOutBookDetailsView(scanner, printStream);
    }

    @Test
    public void shouldBeAbleToTakeUserInput() throws Exception {
        String actualInput = checkedOutBookDetailsView.getUserInput();
        String expectedInput = "Title";

        assertEquals(expectedInput, actualInput);
    }
}