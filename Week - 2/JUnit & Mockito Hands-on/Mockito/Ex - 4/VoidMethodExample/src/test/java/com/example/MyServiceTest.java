package com.example;

import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class MyServiceTest {

    @Test
    public void testVoidMethodInteraction() {
        // 1. Create mock object
        ExternalApi mockApi = mock(ExternalApi.class);

        // 2. Stub the void method (optional)
        doNothing().when(mockApi).logMessage("Hello log");

        // 3. Create service and call method
        MyService service = new MyService(mockApi);
        service.processLog("Hello log");

        // 4. Verify the interaction
        verify(mockApi).logMessage("Hello log");
    }
}
