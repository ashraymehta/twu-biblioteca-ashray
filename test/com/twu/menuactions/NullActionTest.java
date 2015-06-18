package com.twu.menuactions;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class NullActionTest {
    private NullAction nullAction;

    @Before
    public void setUp() throws Exception {
        nullAction = new NullAction();
    }

    @Test
    public void shouldBeEqualToAnyOtherNullAction() {
        assertEquals(nullAction, new NullAction());
    }
}