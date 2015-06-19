package com.twu;


import com.twu.menuactions.ListAvailableBooksAction;
import com.twu.menuactions.QuitAction;
import com.twu.views.MenuView;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class BibliotecaAppTest {
    @Mock
    ConsoleOut consoleOut;
    @Mock
    MenuView initialMenuView;

    private QuitAction quitAction;
    private BibliotecaApp bibliotecaApp;

    @Before
    public void setUp() throws Exception {
        quitAction = new QuitAction();
        when(initialMenuView.performActionUponSelection(null))
                .thenReturn(quitAction);
        bibliotecaApp = new BibliotecaApp(consoleOut, quitAction, initialMenuView);
    }

    @Test
    public void shouldPrintWelcomeMessage() throws Exception {
        bibliotecaApp.start();

        verify(consoleOut).printWelcomeMessage();
    }

    @Test
    public void shouldPrintMainMenu() throws Exception {
        bibliotecaApp.start();

        verify(initialMenuView).printMainMenu();
    }

    @Test
    public void shouldPerformActionUponSelection() throws Exception {
        bibliotecaApp.start();

        verify(initialMenuView).performActionUponSelection(null);
    }

    @Test
    public void shouldQuitWhenQuitActionIsEncountered() throws Exception {
        when(initialMenuView.performActionUponSelection(null))
                .thenReturn(mock(ListAvailableBooksAction.class))
                .thenReturn(quitAction);
        bibliotecaApp = new BibliotecaApp(consoleOut, quitAction, initialMenuView);
        bibliotecaApp.start();

        verify(initialMenuView, times(2)).performActionUponSelection(null);
    }
}