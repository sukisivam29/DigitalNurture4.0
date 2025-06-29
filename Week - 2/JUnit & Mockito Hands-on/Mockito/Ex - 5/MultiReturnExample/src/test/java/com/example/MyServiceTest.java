package com.example;

import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class MyServiceTest {

    @Test
    public void testMultipleReturns() {
        // Step 1: Create mock
        ExternalApi mockApi = mock(ExternalApi.class);

        // Step 2: Stub multiple return values
        when(mockApi.getStatus())
                .thenReturn("Loading")
                .thenReturn("Done");

        // Step 3: Create service and call method
        MyService service = new MyService(mockApi);
        String[] result = service.checkStatusTwice();

        // Step 4: Assert the sequence
        assertEquals("Loading", result[0]);
        assertEquals("Done", result[1]);
    }
}
