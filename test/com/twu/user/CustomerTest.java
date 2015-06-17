package com.twu.user;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class CustomerTest {
    private Customer customer;

    @Before
    public void setUp() throws Exception {
        customer = new Customer("123-4567", "Password");
    }

    @Test
    public void shouldRepresentCustomerAsString() throws Exception {
        String actualString = customer.toString();
        String expectedString = "123-4567  ";

        assertEquals(expectedString, actualString);
    }
}