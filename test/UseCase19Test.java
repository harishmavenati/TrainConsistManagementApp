import org.junit.Test;
import static org.junit.Assert.*;

public class UseCase19Test {

    // Sorted bogie ID array used across tests
    String[] bogieIds = {
        "BG001", "BG002", "BG003", "BG004",
        "BG005", "BG006", "BG007", "BG008"
    };

    // Replicate binary search logic
    int binarySearch(String[] arr, String key) {
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            int cmp = arr[mid].compareTo(key);
            if (cmp == 0)       return mid;
            else if (cmp < 0)   low = mid + 1;
            else                high = mid - 1;
        }
        return -1;
    }

    // Test 1: Search key found - first element
    @Test
    public void testSearch_FirstElementFound() {
        assertEquals(0, binarySearch(bogieIds, "BG001"));
    }

    // Test 2: Search key found - last element
    @Test
    public void testSearch_LastElementFound() {
        assertEquals(7, binarySearch(bogieIds, "BG008"));
    }

    // Test 3: Search key found - middle element
    @Test
    public void testSearch_MiddleElementFound() {
        int result = binarySearch(bogieIds, "BG004");
        assertNotEquals(-1, result);
        assertEquals("BG004", bogieIds[result]);
    }

    // Test 4: Search key not found
    @Test
    public void testSearch_KeyNotFound() {
        assertEquals(-1, binarySearch(bogieIds, "BG010"));
    }

    // Test 5: Search key not found - before range
    @Test
    public void testSearch_KeyBeforeRange() {
        assertEquals(-1, binarySearch(bogieIds, "BG000"));
    }

    // Test 6: Search key not found - after range
    @Test
    public void testSearch_KeyAfterRange() {
        assertEquals(-1, binarySearch(bogieIds, "BG099"));
    }

    // Test 7: Single element array - found
    @Test
    public void testSearch_SingleElementFound() {
        String[] single = {"BG001"};
        assertEquals(0, binarySearch(single, "BG001"));
    }

    // Test 8: Single element array - not found
    @Test
    public void testSearch_SingleElementNotFound() {
        String[] single = {"BG001"};
        assertEquals(-1, binarySearch(single, "BG002"));
    }

    // Test 9: Empty array returns -1
    @Test
    public void testSearch_EmptyArray() {
        String[] empty = {};
        assertEquals(-1, binarySearch(empty, "BG001"));
    }

    // Test 10: Correct index returned - BG003
    @Test
    public void testSearch_CorrectIndexReturned() {
        int index = binarySearch(bogieIds, "BG003");
        assertEquals(2, index);
        assertEquals("BG003", bogieIds[index]);
    }
}
