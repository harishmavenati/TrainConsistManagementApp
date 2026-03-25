import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) {

        System.out.println("=== Train Consist Management App ===");

        // Create a HashSet to store unique bogie IDs
        Set<String> bogieIds = new HashSet<>();

        // Add bogie IDs (duplicates will be ignored automatically)
        bogieIds.add("B001");
        bogieIds.add("B002");
        bogieIds.add("B003");
        bogieIds.add("B002"); // duplicate
        bogieIds.add("B004");
        bogieIds.add("B001"); // duplicate

        // Display unique bogie IDs
        System.out.println("Unique bogie IDs:");
        System.out.println(bogieIds);

        // Optional: Check existence of a bogie ID
        boolean exists = bogieIds.contains("B003");
        System.out.println("\nDoes B003 exist? " + exists);

        // Final state
        System.out.println("\nFinal bogie ID set:");
        System.out.println(bogieIds);

        // Program continues...
    }
}