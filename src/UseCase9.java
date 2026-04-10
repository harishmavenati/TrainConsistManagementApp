import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class UseCase9 {
    public static void main(String[] args) {
        System.out.println("=== Train Consist Management App ===");

        List<String> bogies = Arrays.asList(
            "Sleeper", "AC Chair", "First Class",
            "Rectangular Goods", "Cylindrical Goods", "Sleeper", "AC Chair"
        );

        Map<String, List<String>> grouped = bogies.stream()
            .collect(Collectors.groupingBy(b -> {
                if (b.equals("Sleeper") || b.equals("AC Chair") || b.equals("First Class"))
                    return "Passenger";
                else
                    return "Goods";
            }));

        System.out.println("Grouped Bogies:");
        for (Map.Entry<String, List<String>> entry : grouped.entrySet()) {
            System.out.println("  " + entry.getKey() + ": " + entry.getValue());
        }
    }
}
