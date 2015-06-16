package com.twu;

import com.twu.menuaction.CheckoutBookAction;
import com.twu.menuaction.ListBooksAction;
import com.twu.menuaction.MenuAction;
import com.twu.menuaction.QuitAction;
import com.twu.view.BooksView;
import com.twu.view.CheckoutBookView;
import com.twu.view.MenuView;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Scanner;

import static junit.framework.Assert.assertEquals;
import static org.mockito.Mockito.mock;

@RunWith(MockitoJUnitRunner.class)
public class BibliotecaAppTest {
    @Mock
    ConsoleOut consoleOut;
    @Mock
    Searcher searcher;
    @Mock
    Library library;

    private HashMap<Integer, MenuAction> menuItemsMappedToMenuAction;
    private HashMap<Integer, String> menuItemsMappedToSerials;

    @Before
    public void setUp() throws Exception {
        menuItemsMappedToSerials = new HashMap<>();
        menuItemsMappedToMenuAction = new HashMap<>();
        menuItemsMappedToSerials.put(1, "List books");
        menuItemsMappedToMenuAction.put(1, new ListBooksAction(mock(BooksView.class), library));
        menuItemsMappedToSerials.put(2, "Checkout books");
        menuItemsMappedToMenuAction.put(2, new CheckoutBookAction(mock(CheckoutBookView.class), mock(Library.class), searcher));
        menuItemsMappedToSerials.put(2, "Quit");
        menuItemsMappedToMenuAction.put(2, new QuitAction());
    }

    @Test
    public void shouldPrintWelcomeMessage() throws Exception {
        String command = "2";
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(command.getBytes());
        Scanner scanner = new Scanner(byteArrayInputStream);
        Menu menu = new Menu(menuItemsMappedToMenuAction, menuItemsMappedToSerials);
        MenuView menuView = new MenuView(menu, scanner, mock(PrintStream.class));
        BibliotecaApp bibliotecaApp = new BibliotecaApp(consoleOut, menuView);
        bibliotecaApp.start();

        Mockito.verify(consoleOut).printWelcomeMessage();
    }

    @Test
    public void shouldPrintMainMenu() throws Exception {
        String command = "2";
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(command.getBytes());
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        Scanner scanner = new Scanner(byteArrayInputStream);
        Menu menu = new Menu(menuItemsMappedToMenuAction, menuItemsMappedToSerials);
        MenuView menuView = new MenuView(menu, scanner, new PrintStream(outputStream));
        BibliotecaApp bibliotecaApp = new BibliotecaApp(consoleOut, menuView);
        bibliotecaApp.start();

        String actualOutput = outputStream.toString();
        String expectedOutput = "1. List books" + System.lineSeparator() +
                "2. Quit" + System.lineSeparator() + System.lineSeparator();

        assertEquals(expectedOutput, actualOutput);
    }
}