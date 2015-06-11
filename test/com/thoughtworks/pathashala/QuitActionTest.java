package com.thoughtworks.pathashala;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.ExpectedSystemExit;

public class QuitActionTest {

    @Rule
    public final ExpectedSystemExit exit = ExpectedSystemExit.none();

    @Test
    public void shouldExitSystem() throws Exception {
        QuitAction quitAction = new QuitAction();
        exit.expectSystemExitWithStatus(0);
        quitAction.perform();
    }
}