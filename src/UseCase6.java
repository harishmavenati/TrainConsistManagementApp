import java.util.HashMap;
import java.util.Map;

public class UseCase6 {
    public static void main(String[] args) {
        System.out.println("=== Train Consist Management App ===");

        Map<String, Integer> bogieCapacity = new HashMap<>();
        bogieCapacity.put("Sleeper", 72);
        bogieCapacity.put("AC Chair", 64);
        bogieCapacity.put("First Class", 18);
        bogieCapacity.put("Pantry Car", 0);

        System.out.println("Bogie Capacity Map:");
        for (Map.Entry<String, Integer> entry : bogieCapacity.entrySet()) {
            System.out.println("  " + entry.getKey() + " -> " + entry.getValue() + " seats");
        }

        System.out.println("\nCapacity of Sleeper: " + bogieCapacity.get("Sleeper"));
        bogieCapacity.put("Sleeper", 80);
        System.out.println("Updated Sleeper Capacity: " + bogieCapacity.get("Sleeper"));
    }
}
