package com.thoughtworks.pathashala;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.HashMap;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class MenuTest {

    private HashMap<Integer, MenuAction> menuItemsMappedToMenuAction;
    private HashMap<Integer, String> menuItemsMappedToSerials;

    @Mock
    ListBooksAction listBooksAction;

    @Mock
    QuitAction quitAction;

    @Before
    public void setUp() throws Exception {
        menuItemsMappedToSerials = new HashMap<>();
        menuItemsMappedToMenuAction = new HashMap<>();
        menuItemsMappedToSerials.put(1, "List books");
        menuItemsMappedToMenuAction.put(1, listBooksAction);
        menuItemsMappedToSerials.put(2, "Quit");
        menuItemsMappedToMenuAction.put(2, quitAction);
    }

    @Test
    public void shouldHaveProperStringRepresentation() throws Exception {
        Menu menu = new Menu(menuItemsMappedToMenuAction, menuItemsMappedToSerials);

        String actualString = menu.toString();
        String expectedString = "1. List books" + System.lineSeparator() +
                "2. Quit" + System.lineSeparator();

        assertEquals(expectedString, actualString);
    }

    @Test
    public void shouldPrintListOfBooksOnOneInput() throws Exception {
        Menu menu = new Menu(menuItemsMappedToMenuAction, menuItemsMappedToSerials);
        menu.performActionForInput(1);

        Mockito.verify(listBooksAction).perform();
    }

    @Test
    public void shouldVerifyThatMenuOptionExistsOnValidInput() throws Exception {
        Menu menu = new Menu(menuItemsMappedToMenuAction, menuItemsMappedToSerials);

        boolean actualAction = menu.hasActionAtPosition(1);

        assertTrue(actualAction);
    }

    @Test
    public void shouldVerifyThatMenuOptionExistsOnInvalidInput() throws Exception {
        Menu menu = new Menu(menuItemsMappedToMenuAction, menuItemsMappedToSerials);

        boolean actualAction = menu.hasActionAtPosition(-1);

        assertFalse(actualAction);
    }
}