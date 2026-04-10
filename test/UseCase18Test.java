import org.junit.Test;
import static org.junit.Assert.*;

public class UseCase18Test {

    // Unsorted bogie ID array used across tests
    String[] bogieIds = {
        "BG005", "BG002", "BG008", "BG001",
        "BG007", "BG003", "BG006", "BG004"
    };

    // Replicate linear search logic
    int linearSearch(String[] arr, String key) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals(key)) return i;
        }
        return -1;
    }

    // Test 1: Search key found - first element
    @Test
    public void testSearch_FirstElementFound() {
        assertEquals(0, linearSearch(bogieIds, "BG005"));
    }

    // Test 2: Search key found - last element
    @Test
    public void testSearch_LastElementFound() {
        assertEquals(7, linearSearch(bogieIds, "BG004"));
    }

    // Test 3: Search key found - middle element
    @Test
    public void testSearch_MiddleElementFound() {
        int index = linearSearch(bogieIds, "BG008");
        assertNotEquals(-1, index);
        assertEquals("BG008", bogieIds[index]);
    }

    // Test 4: Search key not found
    @Test
    public void testSearch_KeyNotFound() {
        assertEquals(-1, linearSearch(bogieIds, "BG010"));
    }

    // Test 5: Single element array - found
    @Test
    public void testSearch_SingleElementFound() {
        String[] single = {"BG001"};
        assertEquals(0, linearSearch(single, "BG001"));
    }

    // Test 6: Single element array - not found
    @Test
    public void testSearch_SingleElementNotFound() {
        String[] single = {"BG001"};
        assertEquals(-1, linearSearch(single, "BG002"));
    }

    // Test 7: Empty array returns -1
    @Test
    public void testSearch_EmptyArray() {
        String[] empty = {};
        assertEquals(-1, linearSearch(empty, "BG001"));
    }

    // Test 8: Correct index returned - BG001
    @Test
    public void testSearch_CorrectIndexReturned() {
        int index = linearSearch(bogieIds, "BG001");
        assertEquals(3, index);
        assertEquals("BG001", bogieIds[index]);
    }

    // Test 9: Works on unsorted data
    @Test
    public void testSearch_WorksOnUnsortedData() {
        String[] unsorted = {"BG007", "BG003", "BG001", "BG005"};
        assertEquals(2, linearSearch(unsorted, "BG001"));
    }

    // Test 10: Returns index of first occurrence for duplicates
    @Test
    public void testSearch_ReturnsFirstOccurrence() {
        String[] withDuplicates = {"BG001", "BG002", "BG001", "BG003"};
        assertEquals(0, linearSearch(withDuplicates, "BG001"));
    }
}
