package com.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Exercise 3: Assertions in JUnit
 *
 * Demonstrates the most common JUnit assertions.
 */
public class AssertionsTest {

    @Test
    public void testAssertions() {
        // Assert equals
        assertEquals(5, 2 + 3);

        // Assert true
        assertTrue(5 > 3);

        // Assert false
        assertFalse(5 < 3);

        // Assert null
        assertNull(null);

        // Assert not null
        assertNotNull(new Object());

        // A few extras that are useful in practice
        assertNotEquals(4, 2 + 3);
        assertArrayEquals(new int[] {1, 2, 3}, new int[] {1, 2, 3});
        assertThrows(IllegalArgumentException.class, () -> {
            throw new IllegalArgumentException("bad argument");
        });
    }
}
