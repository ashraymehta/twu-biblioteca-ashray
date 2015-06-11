package com.thoughtworks.pathashala;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.ExpectedSystemExit;

public class QuitActionTest {
    @Test
    public void shouldExitSystem() throws Exception {
        QuitAction quitAction = new QuitAction();
        quitAction.perform();
    }
}