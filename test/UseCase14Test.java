import org.junit.Test;
import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.List;

public class UseCase14Test {

    // Replicate classes for testing
    static class InvalidCapacityException extends Exception {
        public InvalidCapacityException(String message) { super(message); }
    }

    static class PassengerBogie {
        String bogieId;
        String bogieType;
        int capacity;

        PassengerBogie(String bogieId, String bogieType, int capacity)
                throws InvalidCapacityException {
            if (capacity <= 0) {
                throw new InvalidCapacityException(
                    "Invalid capacity: " + capacity + " for bogie " + bogieId
                );
            }
            this.bogieId = bogieId;
            this.bogieType = bogieType;
            this.capacity = capacity;
        }
    }

    // Test 1: Valid capacity - bogie created successfully
    @Test
    public void testValidCapacityCreatesBogie() throws InvalidCapacityException {
        PassengerBogie bogie = new PassengerBogie("BG001", "Sleeper", 72);
        assertEquals("BG001", bogie.bogieId);
        assertEquals(72, bogie.capacity);
    }

    // Test 2: Zero capacity throws exception
    @Test(expected = InvalidCapacityException.class)
    public void testZeroCapacityThrowsException() throws InvalidCapacityException {
        new PassengerBogie("BG002", "Sleeper", 0);
    }

    // Test 3: Negative capacity throws exception
    @Test(expected = InvalidCapacityException.class)
    public void testNegativeCapacityThrowsException() throws InvalidCapacityException {
        new PassengerBogie("BG003", "AC Chair", -5);
    }

    // Test 4: Invalid bogie NOT added to consist
    @Test
    public void testInvalidBogieNotAddedToConsist() {
        List<PassengerBogie> consist = new ArrayList<>();
        try {
            consist.add(new PassengerBogie("BG004", "Sleeper", -10));
        } catch (InvalidCapacityException e) {
            // expected
        }
        assertEquals(0, consist.size());
    }

    // Test 5: Valid bogie IS added to consist
    @Test
    public void testValidBogieAddedToConsist() throws InvalidCapacityException {
        List<PassengerBogie> consist = new ArrayList<>();
        consist.add(new PassengerBogie("BG001", "Sleeper", 72));
        assertEquals(1, consist.size());
        assertEquals(72, consist.get(0).capacity);
    }

    // Test 6: Program continues after invalid capacity
    @Test
    public void testProgramContinuesAfterException() {
        List<PassengerBogie> consist = new ArrayList<>();
        String[][] data = {
            {"BG001", "Sleeper",     "72"},
            {"BG002", "AC Chair",    "-5"},
            {"BG003", "First Class", "18"},
            {"BG004", "Sleeper",     "0"},
            {"BG005", "AC Chair",    "64"}
        };
        for (String[] d : data) {
            try {
                consist.add(new PassengerBogie(d[0], d[1], Integer.parseInt(d[2])));
            } catch (InvalidCapacityException e) {
                // continue
            }
        }
        // Only 3 valid bogies: BG001, BG003, BG005
        assertEquals(3, consist.size());
    }

    // Test 7: Exception message contains bogie ID
    @Test
    public void testExceptionMessageContainsBogieId() {
        try {
            new PassengerBogie("BG999", "Sleeper", -1);
            fail("Exception expected");
        } catch (InvalidCapacityException e) {
            assertTrue(e.getMessage().contains("BG999"));
        }
    }

    // Test 8: Minimum valid capacity (1) is accepted
    @Test
    public void testMinimumValidCapacityAccepted() throws InvalidCapacityException {
        PassengerBogie bogie = new PassengerBogie("BG010", "First Class", 1);
        assertEquals(1, bogie.capacity);
    }
}
