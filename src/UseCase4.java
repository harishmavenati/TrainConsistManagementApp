import java.util.SortedSet;
import java.util.TreeSet;

public class UseCase4 {
    public static void main(String[] args) {
        System.out.println("=== Train Consist Management App ===");

        SortedSet<String> bogieIds = new TreeSet<>();
        bogieIds.add("BG105");
        bogieIds.add("BG101");
        bogieIds.add("BG103");
        bogieIds.add("BG102");
        bogieIds.add("BG104");
        bogieIds.add("BG101"); // duplicate

        System.out.println("Sorted Unique Bogie IDs: " + bogieIds);
        System.out.println("First Bogie: " + bogieIds.first());
        System.out.println("Last Bogie : " + bogieIds.last());
    }
}
