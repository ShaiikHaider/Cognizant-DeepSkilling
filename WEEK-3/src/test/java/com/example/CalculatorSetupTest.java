package com.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class CalculatorSetupTest {

    @Test
    public void junitIsSetUpCorrectly() {
        Calculator calculator = new Calculator();
        assertEquals(4, calculator.add(2, 2));
    }
}
