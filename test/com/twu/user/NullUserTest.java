package com.twu.user;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.Assert.assertEquals;
import static junit.framework.TestCase.assertFalse;

public class NullUserTest {
    private NullUser nullUser;

    @Before
    public void setUp() throws Exception {
        nullUser = new NullUser();
    }

    @Test
    public void shouldNotAddToListIfCredentialsDontMatch() throws Exception {
        List<AbstractUser> list = new ArrayList<AbstractUser>();
        nullUser.addToListIfCredentialsMatch("123-4567", "Password", list);

        assertFalse(list.contains(nullUser));
    }

    @Test
    public void shouldBeEqualToAnyOtherNullUser() throws Exception {
        assertEquals(nullUser, new NullUser());
    }
}