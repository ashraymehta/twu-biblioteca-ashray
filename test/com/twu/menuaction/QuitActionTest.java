package com.twu.menuaction;

import org.junit.Test;

public class QuitActionTest {
    @Test
    public void shouldExitSystem() throws Exception {
        QuitAction quitAction = new QuitAction();
        quitAction.perform();
    }
}