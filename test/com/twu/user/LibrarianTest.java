package com.twu.user;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class LibrarianTest {
    private Librarian librarian;

    @Before
    public void setUp() throws Exception {
        librarian = new Librarian("123-4567", "Password");
    }

    @Test
    public void shouldRepresentCustomerAsString() throws Exception {
        String actualString = librarian.toString();
        String expectedString = "123-4567  ";

        assertEquals(expectedString, actualString);
    }
}