public class UseCase16 {

    // Bubble Sort - ascending order (no Arrays.sort / Collections.sort)
    static void bubbleSort(int[] capacities) {
        int n = capacities.length;
        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (capacities[j] > capacities[j + 1]) {
                    // Swap
                    int temp = capacities[j];
                    capacities[j] = capacities[j + 1];
                    capacities[j + 1] = temp;
                    swapped = true;
                }
            }
            // Early termination if already sorted
            if (!swapped) break;
        }
    }

    static void printArray(String label, int[] arr) {
        System.out.print(label + ": [");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) System.out.print(", ");
        }
        System.out.println("]");
    }

    public static void main(String[] args) {
        System.out.println("=== Train Consist Management App ===");
        System.out.println("--- UC16: Sort Passenger Bogies by Capacity ---\n");

        int[] capacities = {72, 56, 24, 70, 60};

        printArray("Before Sorting", capacities);

        bubbleSort(capacities);

        printArray("After Sorting ", capacities);

        System.out.println("\n--- Additional Test Cases ---\n");

        // Already sorted
        int[] sorted = {24, 56, 60, 70, 72};
        printArray("Already Sorted - Before", sorted);
        bubbleSort(sorted);
        printArray("Already Sorted - After ", sorted);

        System.out.println();

        // Duplicates
        int[] duplicates = {72, 56, 56, 24};
        printArray("Duplicates - Before", duplicates);
        bubbleSort(duplicates);
        printArray("Duplicates - After ", duplicates);

        System.out.println();

        // Single element
        int[] single = {50};
        printArray("Single - Before", single);
        bubbleSort(single);
        printArray("Single - After ", single);

        System.out.println();

        // All equal
        int[] allEqual = {40, 40, 40};
        printArray("All Equal - Before", allEqual);
        bubbleSort(allEqual);
        printArray("All Equal - After ", allEqual);
    }
}
