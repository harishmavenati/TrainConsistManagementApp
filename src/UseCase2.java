import java.util.ArrayList;
import java.util.List;

public class UseCase2 {
    public static void main(String[] args) {
        System.out.println("=== Train Consist Management App ===");

        List<String> bogies = new ArrayList<>();
        bogies.add("Sleeper");
        bogies.add("AC Chair");
        bogies.add("First Class");

        System.out.println("Bogies after addition: " + bogies);

        bogies.remove("AC Chair");
        System.out.println("Bogies after removal: " + bogies);

        System.out.println("Contains Sleeper: " + bogies.contains("Sleeper"));
    }
}
