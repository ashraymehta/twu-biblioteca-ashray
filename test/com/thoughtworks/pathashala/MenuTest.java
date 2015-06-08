package com.thoughtworks.pathashala;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class MenuTest {
    @Test
    public void shouldHaveProperStringRepresentation() throws Exception {
        Menu menu = new Menu();

        String actualString = menu.toString();
        String expectedString = "1. List books" + System.lineSeparator();

        assertEquals(expectedString, actualString);
    }
}