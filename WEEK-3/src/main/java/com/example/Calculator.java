package com.example;

/**
 * A small class with a couple of methods, used to demonstrate
 * setting up JUnit and writing basic tests (Exercise 1) and to
 * exercise the Arrange-Act-Assert pattern (Exercise 4).
 */
public class Calculator {

    public int add(int a, int b) {
        return a + b;
    }

    public int subtract(int a, int b) {
        return a - b;
    }

    public int multiply(int a, int b) {
        return a * b;
    }

    public int divide(int a, int b) {
        if (b == 0) {
            throw new IllegalArgumentException("Cannot divide by zero");
        }
        return a / b;
    }
}
