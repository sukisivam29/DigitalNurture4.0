package com.example;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class MyServiceTest {

    @Test
    public void testVoidMethodThrowsException() {
        // Step 1: Create mock object
        ExternalApi mockApi = mock(ExternalApi.class);

        // Step 2: Stub the void method to throw exception
        doThrow(new RuntimeException("Failed to delete")).when(mockApi).deleteRecord();

        // Step 3: Verify the exception and interaction
        MyService service = new MyService(mockApi);

        RuntimeException thrown = assertThrows(RuntimeException.class, service::deleteData);
        assertEquals("Failed to delete", thrown.getMessage());

        // Optional: Verify method was called
        verify(mockApi).deleteRecord();
    }
}
