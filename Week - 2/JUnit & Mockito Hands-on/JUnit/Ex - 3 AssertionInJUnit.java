package JUnit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

	public class CalculatorTest {
		@Test
	    void testAddition() {
	    	int result = 2 + 3;
	        assertEquals(5, result);

	        assertEquals(5, 2 + 3);
	        
	        assertTrue(5 > 3);

	        assertFalse(5 < 3);

	        assertNull(null);

	        assertNotNull(new Object());
	    }
}