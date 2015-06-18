package com.twu;

import com.twu.menuactions.ListAvailableBooksAction;
import com.twu.menuactions.MenuAction;
import com.twu.menuactions.QuitAction;
import com.twu.user.Customer;
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

@RunWith(MockitoJUnitRunner.class)
public class MenuTest {

    @Mock
    ListAvailableBooksAction listAvailableBooksAction;
    @Mock
    QuitAction quitAction;
    private HashMap<Integer, MenuAction> menuItemsMappedToMenuAction;
    private HashMap<Integer, String> menuItemsMappedToSerials;

    @Before
    public void setUp() throws Exception {
        menuItemsMappedToSerials = new HashMap<>();
        menuItemsMappedToMenuAction = new HashMap<>();
        menuItemsMappedToSerials.put(1, "List books");
        menuItemsMappedToMenuAction.put(1, listAvailableBooksAction);
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
        Customer customer = new Customer("123-4567", "Password", "Name", "Name@gmail.com", "1234567");
        menu.performActionForInput(customer,1);

        Mockito.verify(listAvailableBooksAction).perform(customer);
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