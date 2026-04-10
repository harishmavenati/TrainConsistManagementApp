import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class UseCase8 {
    public static void main(String[] args) {
        System.out.println("=== Train Consist Management App ===");

        List<String> bogies = Arrays.asList(
            "Sleeper", "AC Chair", "First Class",
            "Rectangular Goods", "Cylindrical Goods", "Pantry Car"
        );

        List<String> passengerBogies = bogies.stream()
            .filter(b -> b.equals("Sleeper") || b.equals("AC Chair") || b.equals("First Class"))
            .collect(Collectors.toList());

        System.out.println("All Bogies      : " + bogies);
        System.out.println("Passenger Bogies: " + passengerBogies);
        System.out.println("Total Passenger Bogies: " + passengerBogies.size());
    }
}
