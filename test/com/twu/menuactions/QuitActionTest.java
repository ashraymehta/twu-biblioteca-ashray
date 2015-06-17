package com.twu.menuactions;

import com.twu.user.AbstractUser;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;

@RunWith(MockitoJUnitRunner.class)
public class QuitActionTest {
    private QuitAction quitAction;

    @Before
    public void setUp() throws Exception {
        quitAction = new QuitAction();
    }

    @Test
    public void shouldExitSystem() throws Exception {
        quitAction.perform(mock(AbstractUser.class));
    }

    @Test
    public void shouldBeAbleToEquateItselfWithOtherQuitActionObjects() throws Exception {
        assertTrue(quitAction.equals(new QuitAction()));
    }
}