import org.junit.Test;
import static org.junit.Assert.*;

public class UseCase16Test {

    // Replicate bubble sort logic
    void bubbleSort(int[] capacities) {
        int n = capacities.length;
        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (capacities[j] > capacities[j + 1]) {
                    int temp = capacities[j];
                    capacities[j] = capacities[j + 1];
                    capacities[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
    }

    // Test 1: Basic sorting
    @Test
    public void testSort_BasicSorting() {
        int[] capacities = {72, 56, 24, 70, 60};
        bubbleSort(capacities);
        assertArrayEquals(new int[]{24, 56, 60, 70, 72}, capacities);
    }

    // Test 2: Already sorted array
    @Test
    public void testSort_AlreadySortedArray() {
        int[] capacities = {24, 56, 60, 70, 72};
        bubbleSort(capacities);
        assertArrayEquals(new int[]{24, 56, 60, 70, 72}, capacities);
    }

    // Test 3: Duplicate values
    @Test
    public void testSort_DuplicateValues() {
        int[] capacities = {72, 56, 56, 24};
        bubbleSort(capacities);
        assertArrayEquals(new int[]{24, 56, 56, 72}, capacities);
    }

    // Test 4: Single element array
    @Test
    public void testSort_SingleElementArray() {
        int[] capacities = {50};
        bubbleSort(capacities);
        assertArrayEquals(new int[]{50}, capacities);
    }

    // Test 5: All equal values
    @Test
    public void testSort_AllEqualValues() {
        int[] capacities = {40, 40, 40};
        bubbleSort(capacities);
        assertArrayEquals(new int[]{40, 40, 40}, capacities);
    }

    // Test 6: Reverse sorted array
    @Test
    public void testSort_ReverseSortedArray() {
        int[] capacities = {72, 60, 48, 36, 18};
        bubbleSort(capacities);
        assertArrayEquals(new int[]{18, 36, 48, 60, 72}, capacities);
    }

    // Test 7: Two elements unsorted
    @Test
    public void testSort_TwoElementsUnsorted() {
        int[] capacities = {80, 20};
        bubbleSort(capacities);
        assertArrayEquals(new int[]{20, 80}, capacities);
    }

    // Test 8: First element is smallest
    @Test
    public void testSort_FirstElementSmallest() {
        int[] capacities = {18, 72, 56, 64};
        bubbleSort(capacities);
        assertEquals(18, capacities[0]);
        assertEquals(72, capacities[capacities.length - 1]);
    }
}
