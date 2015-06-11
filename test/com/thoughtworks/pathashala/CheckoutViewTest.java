package com.thoughtworks.pathashala;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.Scanner;

import static junit.framework.Assert.assertEquals;

public class CheckoutViewTest {

    ByteArrayOutputStream outputStream;

    @Before
    public void setUp() throws Exception {
        outputStream = new ByteArrayOutputStream();
    }

    @Test
    public void shouldGetIntegerFromConsole() throws Exception {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream("5".getBytes());
        Scanner scanner = new Scanner(byteArrayInputStream);
        CheckoutView checkoutView = new CheckoutView(scanner);

        int actualInput = checkoutView.getSelection();
        int expectedInput = 5;

        assertEquals(expectedInput, actualInput);
    }
}