package com.twu.menuactions;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;

public class LogoutActionTest {
    private LogoutAction firstLogoutAction;
    private LogoutAction secondLogoutAction;
    private LogoutAction thirdLogoutAction;

    @Before
    public void setUp() throws Exception {
        firstLogoutAction = new LogoutAction();
        secondLogoutAction = new LogoutAction();
        thirdLogoutAction = new LogoutAction();
    }

    @Test
    public void shouldBeEqualToItself() {
        boolean actual = firstLogoutAction.equals(firstLogoutAction);

        assertEquals(true, actual);
    }

    @Test
    public void shouldFollowSymmetricProperty() {
        boolean actual = (firstLogoutAction.equals(secondLogoutAction) == secondLogoutAction.equals(firstLogoutAction));

        assertEquals(true, actual);
    }

    @Test
    public void shouldFollowTransitiveProperty() {
        boolean actual = firstLogoutAction.equals(secondLogoutAction) &&
                secondLogoutAction.equals(thirdLogoutAction) &&
                firstLogoutAction.equals(thirdLogoutAction);

        assertEquals(true, actual);
    }

    @Test
    public void shouldBeEqualToAnyOtherLogoutAction() throws Exception {
        boolean actual = firstLogoutAction.equals(new LogoutAction());

        assertTrue(actual);
    }
}