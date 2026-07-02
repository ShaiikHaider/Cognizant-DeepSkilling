package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Mockito Exercise 1: Mocking and Stubbing
 * Mockito Exercise 2: Verifying Interactions
 *
 * MyService depends on ExternalApi. Instead of talking to a real
 * external API in our tests, we create a mock of ExternalApi and
 * control exactly what it returns (stubbing), then check how
 * MyService interacted with it (verifying).
 */
@ExtendWith(MockitoExtension.class)
public class MyServiceTest {

    @Mock
    private ExternalApi mockApi;

    private MyService service;

    @BeforeEach
    public void setUp() {
        service = new MyService(mockApi);
    }

    /**
     * Exercise 1: Mocking and Stubbing.
     * Steps:
     *  1. Create a mock object for the external API (@Mock above).
     *  2. Stub the method to return a predefined value.
     *  3. Call the method under test and assert on the result.
     */
    @Test
    public void testExternalApi() {
        // Stub the mock
        when(mockApi.getData()).thenReturn("Mock Data");

        // Call the method under test
        String result = service.fetchData();

        // Assert the result came from the stub
        assertEquals("Mock Data", result);
    }

    /**
     * Exercise 2: Verifying Interactions.
     * Steps:
     *  1. Create a mock object for the external API (@Mock above).
     *  2. Call the method under test.
     *  3. Verify that the mock's method was actually called.
     */
    @Test
    public void testVerifyInteraction() {
        // Call the method under test
        service.fetchData();

        // Verify the mock's getData() method was called exactly once
        verify(mockApi).getData();
    }
}
