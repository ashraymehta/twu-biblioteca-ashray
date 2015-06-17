package com.twu.menuaction;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class QuitActionTest {
    QuitAction quitAction;

    @Before
    public void setUp() throws Exception {
        quitAction = new QuitAction();
    }

    @Test
    public void shouldExitSystem() throws Exception {
        quitAction.perform();
    }

    @Test
    public void shouldBeAbleToEquateItselfWithOtherQuitActionObjects() throws Exception {
        assertTrue(quitAction.equals(new QuitAction()));
    }
}