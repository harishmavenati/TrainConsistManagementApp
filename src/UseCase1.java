import java.util.ArrayList;
import java.util.List;

public class UseCase1 {
    public static void main(String[] args) {
        System.out.println("=== Train Consist Management App ===");
        System.out.println("Initializing train consist...");

        List<String> bogies = new ArrayList<>();

        System.out.println("Initial Bogie Count: " + bogies.size());
        System.out.println("Train consist initialized successfully.");
    }
}
