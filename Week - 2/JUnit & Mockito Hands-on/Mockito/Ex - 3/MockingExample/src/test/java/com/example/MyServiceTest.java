package com.example;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;
import static org.mockito.ArgumentMatchers.*;

public class MyServiceTest {

    @Test
    public void testVerifyArgumentMatching() {
        // Step 1: Mock the dependency
        ExternalApi mockApi = mock(ExternalApi.class);

        // Step 2: Inject into service
        MyService service = new MyService(mockApi);

        // Step 3: Call method with a specific argument
        service.pushData("Hello");

        // Step 4: Verify that the method was called with "Hello"
        verify(mockApi).sendData(eq("Hello"));

        // (Optional): More flexible matching
        // verify(mockApi).sendData(anyString());
    }
}
