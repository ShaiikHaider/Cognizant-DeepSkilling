package com.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class CalculatorAAATest {

    private Calculator calculator;

    @BeforeEach
    public void setUp() {
        calculator = new Calculator();
        System.out.println("Setting up Calculator before a test");
    }

    @AfterEach
    public void tearDown() {
        calculator = null;
        System.out.println("Tearing down Calculator after a test");
    }

    @Test
    public void testAdd() {
        
        int a = 10;
        int b = 5;

        int result = calculator.add(a, b);


        assertEquals(15, result);
    }

    @Test
    public void testSubtract() {
        int a = 10;
        int b = 5;

        int result = calculator.subtract(a, b);

 
        assertEquals(5, result);
    }

    @Test
    public void testMultiply() {
        int a = 10;
        int b = 5;

        int result = calculator.multiply(a, b);

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
