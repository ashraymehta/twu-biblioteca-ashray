package com.twu;

import com.twu.menuactions.QuitAction;
import com.twu.views.MenuView;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

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

    private BibliotecaApp bibliotecaApp;

    @Before
    public void setUp() throws Exception {
        QuitAction quitAction = new QuitAction();
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

    @Test
    public void shouldPerformActionUponSelection() throws Exception {
        bibliotecaApp.start();

        verify(menuView).performActionUponSelection();
    }
}