package JUnit;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

public class calculateTest {

	    @BeforeEach
	    void setUp() {
	        new Calculator();
	        System.out.println("Setup complete.");
	    }

	    @AfterEach
	    void tearDown() {
	        System.out.println("Teardown complete.");
	    }

	    @Test
	    void testAddition() {
	        // Arrange
	        int a = 2;
	        int b = 3;

	        // Act
	        int result = Calculator.add(a, b);

	        // Assert
	        assertEquals(5, result);
	    }

	    @Test
	    void testAssertions() {
	        // Arrange & Act are trivial in these cases

	        // Assert
	        assertEquals(5, 2 + 3);
	        assertTrue(5 > 3);
	        assertFalse(5 < 3);
	        assertNull(null);
	        assertNotNull(new Object());
	    }
}

