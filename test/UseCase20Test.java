import org.junit.Test;
import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.List;

public class UseCase20Test {

    // Replicate TrainConsist logic
    static class TrainConsist {
        List<String> bogieIds = new ArrayList<>();

        void addBogie(String bogieId) {
            bogieIds.add(bogieId);
        }

        int searchBogie(String key) {
            if (bogieIds.isEmpty()) {
                throw new IllegalStateException(
                    "Cannot search. Train consist is empty."
                );
            }
            for (int i = 0; i < bogieIds.size(); i++) {
                if (bogieIds.get(i).equals(key)) return i;
            }
            return -1;
        }
    }

    // Test 1: Search on empty consist throws IllegalStateException
    @Test(expected = IllegalStateException.class)
    public void testSearch_EmptyConsistThrowsException() {
        TrainConsist train = new TrainConsist();
        train.searchBogie("BG001");
    }

    // Test 2: Exception message is meaningful
    @Test
    public void testSearch_ExceptionMessageIsMeaningful() {
        TrainConsist train = new TrainConsist();
        try {
            train.searchBogie("BG001");
            fail("Expected IllegalStateException");
        } catch (IllegalStateException e) {
            assertTrue(e.getMessage().contains("empty"));
        }
    }

    // Test 3: Search works after bogies are added
    @Test
    public void testSearch_FoundAfterAddingBogies() {
        TrainConsist train = new TrainConsist();
        train.addBogie("BG001");
        train.addBogie("BG002");
        train.addBogie("BG003");
        int index = train.searchBogie("BG002");
        assertEquals(1, index);
    }

    // Test 4: Search returns -1 for non-existent bogie
    @Test
    public void testSearch_NotFoundReturnsMinusOne() {
        TrainConsist train = new TrainConsist();
        train.addBogie("BG001");
        train.addBogie("BG002");
        int index = train.searchBogie("BG999");
        assertEquals(-1, index);
    }

    // Test 5: Search finds first element
    @Test
    public void testSearch_FirstElementFound() {
        TrainConsist train = new TrainConsist();
        train.addBogie("BG001");
        train.addBogie("BG002");
        train.addBogie("BG003");
        assertEquals(0, train.searchBogie("BG001"));
    }

    // Test 6: Search finds last element
    @Test
    public void testSearch_LastElementFound() {
        TrainConsist train = new TrainConsist();
        train.addBogie("BG001");
        train.addBogie("BG002");
        train.addBogie("BG003");
        assertEquals(2, train.searchBogie("BG003"));
    }

    // Test 7: Program continues after exception
    @Test
    public void testSearch_ProgramContinuesAfterException() {
        TrainConsist train = new TrainConsist();

        // First search on empty - exception caught
        try {
            train.searchBogie("BG001");
        } catch (IllegalStateException e) {
            // expected
        }

        // Add bogies and search again - should work
        train.addBogie("BG001");
        int index = train.searchBogie("BG001");
        assertEquals(0, index);
    }

    // Test 8: Single bogie consist - found
    @Test
    public void testSearch_SingleBogieFound() {
        TrainConsist train = new TrainConsist();
        train.addBogie("BG001");
        assertEquals(0, train.searchBogie("BG001"));
    }

    // Test 9: Single bogie consist - not found
    @Test
    public void testSearch_SingleBogieNotFound() {
        TrainConsist train = new TrainConsist();
        train.addBogie("BG001");
        assertEquals(-1, train.searchBogie("BG999"));
    }

    // Test 10: No exception thrown when consist is non-empty
    @Test
    public void testSearch_NoExceptionWhenConsistNonEmpty() {
        TrainConsist train = new TrainConsist();
        train.addBogie("BG001");
        try {
            train.searchBogie("BG001");
        } catch (IllegalStateException e) {
            fail("No exception expected for non-empty consist.");
        }
    }
}
