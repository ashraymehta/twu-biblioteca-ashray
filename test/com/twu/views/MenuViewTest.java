package com.twu.views;

import com.twu.Menu;
import com.twu.menuactions.MenuAction;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Scanner;

import static junit.framework.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class MenuViewTest {

    ByteArrayOutputStream outputStream;

    @Before
    public void setUp() throws Exception {
        outputStream = new ByteArrayOutputStream();
    }

    @Test
    public void shouldPrintMainMenu() throws Exception {
        InputStream inputStream = mock(InputStream.class);
        Menu menuStub = mock(Menu.class);
        when(menuStub.toString()).thenReturn("1. List books");
        MenuView menuView = new MenuView(menuStub, new Scanner(inputStream), new PrintStream(outputStream));
        menuView.printMainMenu();

        String actualOutput = outputStream.toString();
        String expectedOutput = "1. List books" + System.lineSeparator();

        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void shouldGetIntegerFromConsole() throws Exception {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream("5".getBytes());
        System.setIn(byteArrayInputStream);
        HashMap<Integer, MenuAction> menuItemsMappedToMenuAction = new HashMap<>();
        HashMap<Integer, String> menuItemsMappedToSerials = new HashMap<>();
        Scanner scanner = new Scanner(byteArrayInputStream);
        Menu menu = new Menu(menuItemsMappedToMenuAction, menuItemsMappedToSerials);
        MenuView menuView = new MenuView(menu, scanner, new PrintStream(outputStream));

        int actualInput = menuView.getSelection();
        int expectedInput = 5;

        assertEquals(expectedInput, actualInput);
    }

    @Test
    public void shouldPrintInvalidSelectionMessage() throws Exception {
        System.setOut(new PrintStream(outputStream));
        Menu menu = mock(Menu.class);
        Scanner scanner = new Scanner(System.in);
        MenuView menuView = new MenuView(menu, scanner, new PrintStream(outputStream));
        menuView.printInvalidSelectionMessage();

        String actualOutput = outputStream.toString();
        String expectedOutput = "Select a valid option!" + System.lineSeparator();

        assertEquals(expectedOutput, actualOutput);
    }
}