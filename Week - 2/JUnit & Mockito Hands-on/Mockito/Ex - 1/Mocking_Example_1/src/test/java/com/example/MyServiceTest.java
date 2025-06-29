package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class MyServiceTest {

    @Test
    public void testExternalApi() {
        // 1. Create a mock object for ExternalApi
        ExternalApi mockApi = mock(ExternalApi.class);

        // 2. Stub the getData() method
        when(mockApi.getData()).thenReturn("Mock Data");

        // 3. Pass the mock to the service
        MyService service = new MyService(mockApi);

        // 4. Call the method under test
        String result = service.fetchData();

        // 5. Verify the result
        assertEquals("Mock Data", result);
    }
}
