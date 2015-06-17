package com.twu.user;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class LibrarianTest {
    private Librarian librarian;
    private Librarian firstLibrarian;
    private Librarian secondLibrarian;
    private Librarian thirdLibrarian;

    @Before
    public void setUp() throws Exception {
        librarian = new Librarian("123-4567", "Password");
        firstLibrarian = new Librarian("123-4567", "Password");
        secondLibrarian = new Librarian("123-4567", "Password");
        thirdLibrarian = new Librarian("123-4567", "Password");
    }

    @Test
    public void shouldRepresentCustomerAsString() throws Exception {
        String actualString = librarian.toString();
        String expectedString = "123-4567  ";

        assertEquals(expectedString, actualString);
    }

    @Test
    public void shouldBeEqualToItself() {

        boolean actual = firstLibrarian.equals(firstLibrarian);

        assertEquals(true, actual);
    }

    @Test
    public void shouldFollowSymmetricProperty() {

        boolean actual = (firstLibrarian.equals(secondLibrarian) == secondLibrarian.equals(firstLibrarian));

        assertEquals(true, actual);
    }

    @Test
    public void shouldFollowTransitiveProperty() {
        boolean actual = firstLibrarian.equals(secondLibrarian) &&
                secondLibrarian.equals(thirdLibrarian) &&
                firstLibrarian.equals(thirdLibrarian);

        assertEquals(true, actual);
    }

    @Test
    public void shouldHaveSameHashCodeIfLibrariansAreEqual() {
        boolean actual = firstLibrarian.equals(secondLibrarian) && (firstLibrarian.hashCode() == secondLibrarian.hashCode());

        assertEquals(true, actual);
    }
}