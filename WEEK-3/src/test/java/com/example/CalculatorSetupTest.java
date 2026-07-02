package com.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Exercise 1: Setting Up JUnit
 *
 * This is the first test class in the project. Its only purpose is to
 * confirm that JUnit has been added correctly (via pom.xml) and that
 * the test runner picks it up. If this test runs and passes, JUnit is
 * set up correctly.
 */
public class CalculatorSetupTest {

    @Test
    public void junitIsSetUpCorrectly() {
        Calculator calculator = new Calculator();
        assertEquals(4, calculator.add(2, 2));
    }
}
