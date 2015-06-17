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

import java.util.HashMap;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class BibliotecaAppTest {
    @Mock
    ConsoleOut consoleOut;
    @Mock
    BookSearcher bookSearcher;
    @Mock
    Library library;
    @Mock
    MenuView menuView;

    private HashMap<Integer, MenuAction> menuItemsMappedToMenuAction;
    private HashMap<Integer, String> menuItemsMappedToSerials;
    private QuitAction quitAction;
    private BibliotecaApp bibliotecaApp;

    @Before
    public void setUp() throws Exception {
        quitAction = new QuitAction();
        menuItemsMappedToSerials = new HashMap<>();
        menuItemsMappedToMenuAction = new HashMap<>();
        menuItemsMappedToSerials.put(1, "List books");
        menuItemsMappedToMenuAction.put(1, new ListBooksAction(mock(BooksView.class), library));
        menuItemsMappedToSerials.put(2, "Checkout books");
        menuItemsMappedToMenuAction.put(2, new CheckoutBookAction(mock(CheckoutBookView.class), mock(Library.class)));
        menuItemsMappedToSerials.put(2, "Quit");
        menuItemsMappedToMenuAction.put(2, quitAction);

        bibliotecaApp = new BibliotecaApp(consoleOut, menuView, quitAction);
        when(menuView.performActionUponSelection()).thenReturn(quitAction);
    }

    @Test
    public void shouldPrintWelcomeMessage() throws Exception {
        bibliotecaApp.start();

        Mockito.verify(consoleOut).printWelcomeMessage();
    }

    @Test
    public void shouldPrintMainMenu() throws Exception {
        bibliotecaApp.start();

        verify(menuView).printMainMenu();
    }
}