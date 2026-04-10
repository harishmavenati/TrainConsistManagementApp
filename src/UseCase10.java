import java.util.Arrays;
import java.util.List;

public class UseCase10 {
    static class Bogie {
        String name;
        int capacity;
        Bogie(String name, int capacity) {
            this.name = name;
            this.capacity = capacity;
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Train Consist Management App ===");

        List<Bogie> bogies = Arrays.asList(
            new Bogie("Sleeper", 72),
            new Bogie("AC Chair", 64),
            new Bogie("First Class", 18),
            new Bogie("Pantry Car", 0)
        );

        int totalSeats = bogies.stream()
            .mapToInt(b -> b.capacity)
            .reduce(0, Integer::sum);

        System.out.println("Bogie Seat Counts:");
        bogies.forEach(b -> System.out.println("  " + b.name + ": " + b.capacity));
        System.out.println("\nTotal Seats in Train: " + totalSeats);
    }
}
