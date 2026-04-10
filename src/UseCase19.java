public class UseCase19 {

    // Binary Search - returns index if found, -1 if not found
    static int binarySearch(String[] bogieIds, String key) {
        int low = 0;
        int high = bogieIds.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            int cmp = bogieIds[mid].compareTo(key);

            if (cmp == 0) {
                return mid;           // Found
            } else if (cmp < 0) {
                low = mid + 1;        // Search right half
            } else {
                high = mid - 1;       // Search left half
            }
        }
        return -1;                    // Not found
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
        System.out.println("--- UC19: Binary Search for Bogie ID ---\n");

        // Sorted bogie IDs (precondition for binary search)
        String[] bogieIds = {
            "BG001", "BG002", "BG003", "BG004",
            "BG005", "BG006", "BG007", "BG008"
        };

        System.out.println("Sorted Bogie IDs:");
        for (String id : bogieIds) System.out.print("  " + id);
        System.out.println("\n");

        // Search test cases
        String[] searchKeys = {"BG001", "BG005", "BG008", "BG010", "BG003"};

        for (String key : searchKeys) {
            int result = binarySearch(bogieIds, key);
            printResult(key, result);
        }
    }
}
