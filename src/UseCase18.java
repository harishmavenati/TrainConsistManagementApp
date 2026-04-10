public class UseCase18 {

    // Linear Search - returns index if found, -1 if not found
    static int linearSearch(String[] bogieIds, String key) {
        for (int i = 0; i < bogieIds.length; i++) {
            if (bogieIds[i].equals(key)) {
                return i; // Early termination on match
            }
        }
        return -1; // Not found
    }

    static void printResult(String key, int index) {
        if (index != -1) {
            System.out.println("[FOUND]     Bogie ID '" + key +
                               "' found at index " + index + ".");
        } else {
            System.out.println("[NOT FOUND] Bogie ID '" + key +
                               "' does not exist in the consist.");
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Train Consist Management App ===");
        System.out.println("--- UC18: Linear Search for Bogie ID ---\n");

        // Unsorted bogie IDs
        String[] bogieIds = {
            "BG005", "BG002", "BG008", "BG001",
            "BG007", "BG003", "BG006", "BG004"
        };

        System.out.println("Bogie IDs (Unsorted):");
        for (String id : bogieIds) System.out.print("  " + id);
        System.out.println("\n");

        // Search test cases
        String[] searchKeys = {"BG001", "BG005", "BG008", "BG010", "BG003"};

        for (String key : searchKeys) {
            int result = linearSearch(bogieIds, key);
            printResult(key, result);
        }

        System.out.println("\n--- Additional Test Cases ---\n");

        // Single element - found
        String[] single = {"BG001"};
        printResult("BG001", linearSearch(single, "BG001"));

        // Single element - not found
        printResult("BG002", linearSearch(single, "BG002"));

        // Empty array
        String[] empty = {};
        printResult("BG001", linearSearch(empty, "BG001"));
    }
}
