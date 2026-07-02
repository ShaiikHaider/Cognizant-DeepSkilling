package com.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Exercise 4: Arrange-Act-Assert (AAA) Pattern, Test Fixtures,
 * Setup and Teardown Methods in JUnit
 *
 * Note: JUnit 5 renamed the JUnit 4 annotations @Before / @After to
 * @BeforeEach / @AfterEach. They serve the same purpose:
 *  - @BeforeEach runs before every test method (setup / test fixture)
 *  - @AfterEach runs after every test method (teardown)
 */
public class CalculatorAAATest {

    private Calculator calculator;

    @BeforeEach
    public void setUp() {
        // Runs before each test - creates a fresh fixture so tests
        // don't affect each other.
        calculator = new Calculator();
        System.out.println("Setting up Calculator before a test");
    }

    @AfterEach
    public void tearDown() {
        // Runs after each test - clean up the fixture.
        calculator = null;
        System.out.println("Tearing down Calculator after a test");
    }

    @Test
    public void testAdd() {
        // Arrange
        int a = 10;
        int b = 5;

        // Act
        int result = calculator.add(a, b);

        // Assert
        assertEquals(15, result);
    }

    @Test
    public void testSubtract() {
        // Arrange
        int a = 10;
        int b = 5;

        // Act
        int result = calculator.subtract(a, b);

        // Assert
        assertEquals(5, result);
    }

    @Test
    public void testMultiply() {
        // Arrange
        int a = 10;
        int b = 5;

        // Act
        int result = calculator.multiply(a, b);

        // Assert
        assertEquals(50, result);
    }

    @Test
    public void testDivideByZeroThrowsException() {
        // Arrange
        int a = 10;
        int b = 0;

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> calculator.divide(a, b));
    }
}
