import java.util.Arrays;

public class UseCase17 {

    public static void main(String[] args) {
        System.out.println("=== Train Consist Management App ===");
        System.out.println("--- UC17: Sort Bogie Type Names Alphabetically ---\n");

        String[] bogieTypes = {"Sleeper", "First Class", "AC Chair",
                               "Pantry Car", "Cylindrical Goods", "Rectangular Goods"};

        System.out.println("Before Sorting: " + Arrays.toString(bogieTypes));

        Arrays.sort(bogieTypes);

        System.out.println("After Sorting : " + Arrays.toString(bogieTypes));

        System.out.println("\n--- Additional Test Cases ---\n");

        // Already sorted
        String[] alreadySorted = {"AC Chair", "First Class", "Sleeper"};
        System.out.println("Already Sorted - Before: " + Arrays.toString(alreadySorted));
        Arrays.sort(alreadySorted);
        System.out.println("Already Sorted - After : " + Arrays.toString(alreadySorted));

        System.out.println();

        // Duplicates
        String[] duplicates = {"Sleeper", "AC Chair", "Sleeper", "First Class"};
        System.out.println("Duplicates - Before: " + Arrays.toString(duplicates));
        Arrays.sort(duplicates);
        System.out.println("Duplicates - After : " + Arrays.toString(duplicates));

        System.out.println();

        // Single element
        String[] single = {"Sleeper"};
        System.out.println("Single - Before: " + Arrays.toString(single));
        Arrays.sort(single);
        System.out.println("Single - After : " + Arrays.toString(single));

        System.out.println();

        // Reverse sorted
        String[] reverse = {"Sleeper", "Rectangular Goods", "First Class",
                            "Cylindrical Goods", "AC Chair"};
        System.out.println("Reverse - Before: " + Arrays.toString(reverse));
        Arrays.sort(reverse);
        System.out.println("Reverse - After : " + Arrays.toString(reverse));
    }
}
