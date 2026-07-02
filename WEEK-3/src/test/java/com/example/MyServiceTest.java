package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class MyServiceTest {

    @Mock
    private ExternalApi mockApi;

    private MyService service;

    @BeforeEach
    public void setUp() {
        service = new MyService(mockApi);
    }

 
    @Test
    public void testExternalApi() {
        // Stub the mock
        when(mockApi.getData()).thenReturn("Mock Data");

        // Call the method under test
        String result = service.fetchData();

        // Assert the result came from the stub
        assertEquals("Mock Data", result);
    }

   
    @Test
    public void testVerifyInteraction() {
        // Call the method under test
        service.fetchData();

        verify(mockApi).getData();
    }
}
