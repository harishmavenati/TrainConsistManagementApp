import org.junit.Test;
import java.util.Arrays;
import static org.junit.Assert.*;

public class UseCase17Test {

    // Test 1: Basic alphabetical sorting
    @Test
    public void testSort_BasicAlphabeticalSorting() {
        String[] bogieTypes = {"Sleeper", "First Class", "AC Chair"};
        Arrays.sort(bogieTypes);
        assertArrayEquals(
            new String[]{"AC Chair", "First Class", "Sleeper"},
            bogieTypes
        );
    }

    // Test 2: Already sorted array remains unchanged
    @Test
    public void testSort_AlreadySortedArray() {
        String[] bogieTypes = {"AC Chair", "First Class", "Sleeper"};
        Arrays.sort(bogieTypes);
        assertArrayEquals(
            new String[]{"AC Chair", "First Class", "Sleeper"},
            bogieTypes
        );
    }

    // Test 3: Duplicate bogie names handled correctly
    @Test
    public void testSort_DuplicateValues() {
        String[] bogieTypes = {"Sleeper", "AC Chair", "Sleeper", "First Class"};
        Arrays.sort(bogieTypes);
        assertArrayEquals(
            new String[]{"AC Chair", "First Class", "Sleeper", "Sleeper"},
            bogieTypes
        );
    }

    // Test 4: Single element array unchanged
    @Test
    public void testSort_SingleElementArray() {
        String[] bogieTypes = {"Sleeper"};
        Arrays.sort(bogieTypes);
        assertArrayEquals(new String[]{"Sleeper"}, bogieTypes);
    }

    // Test 5: All equal values unchanged
    @Test
    public void testSort_AllEqualValues() {
        String[] bogieTypes = {"Sleeper", "Sleeper", "Sleeper"};
        Arrays.sort(bogieTypes);
        assertArrayEquals(
            new String[]{"Sleeper", "Sleeper", "Sleeper"},
            bogieTypes
        );
    }

    // Test 6: Reverse sorted array correctly sorted
    @Test
    public void testSort_ReverseSortedArray() {
        String[] bogieTypes = {"Sleeper", "Rectangular Goods",
                               "First Class", "Cylindrical Goods", "AC Chair"};
        Arrays.sort(bogieTypes);
        assertArrayEquals(
            new String[]{"AC Chair", "Cylindrical Goods", "First Class",
                         "Rectangular Goods", "Sleeper"},
            bogieTypes
        );
    }

    // Test 7: First element is alphabetically smallest after sort
    @Test
    public void testSort_FirstElementIsSmallest() {
        String[] bogieTypes = {"Sleeper", "First Class",
                               "AC Chair", "Pantry Car"};
        Arrays.sort(bogieTypes);
        assertEquals("AC Chair", bogieTypes[0]);
    }

    // Test 8: Last element is alphabetically largest after sort
    @Test
    public void testSort_LastElementIsLargest() {
        String[] bogieTypes = {"Sleeper", "First Class",
                               "AC Chair", "Pantry Car"};
        Arrays.sort(bogieTypes);
        assertEquals("Sleeper", bogieTypes[bogieTypes.length - 1]);
    }
}
