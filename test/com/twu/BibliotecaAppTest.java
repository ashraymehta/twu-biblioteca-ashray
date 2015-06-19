package com.twu;


import com.twu.menuactions.ListAvailableBooksAction;
import com.twu.menuactions.QuitAction;
import com.twu.user.NullUser;
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
    private NullUser nullUser;

    @Before
    public void setUp() throws Exception {
        quitAction = new QuitAction();
        nullUser = new NullUser();
        when(initialMenuView.getSelectionAndPerformAction(null))
                .thenReturn(quitAction);
        bibliotecaApp = new BibliotecaApp(consoleOut, quitAction, initialMenuView, nullUser);
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

        verify(initialMenuView).getSelectionAndPerformAction(null);
    }

    @Test
    public void shouldQuitWhenQuitActionIsEncountered() throws Exception {
        when(initialMenuView.getSelectionAndPerformAction(null))
                .thenReturn(mock(ListAvailableBooksAction.class))
                .thenReturn(quitAction);
        bibliotecaApp = new BibliotecaApp(consoleOut, quitAction, initialMenuView, nullUser);
        bibliotecaApp.start();

        verify(initialMenuView, times(2)).getSelectionAndPerformAction(null);
    }
}