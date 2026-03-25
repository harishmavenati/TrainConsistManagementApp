import java.util.LinkedHashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) {

        System.out.println("=== Train Consist Management App ===");

        // Create LinkedHashSet to store bogies
        Set<String> trainFormation = new LinkedHashSet<>();

        // Add bogies
        trainFormation.add("Engine");
        trainFormation.add("Sleeper");
        trainFormation.add("Cargo");
        trainFormation.add("Guard");

        // Attempt to add a duplicate
        trainFormation.add("Sleeper");

        // Display final formation (preserves insertion order, no duplicates)
        System.out.println("Final train formation:");
        System.out.println(trainFormation);
    }
}