import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class UseCase7 {
    static class Bogie {
        String name;
        int capacity;
        Bogie(String name, int capacity) {
            this.name = name;
            this.capacity = capacity;
        }
        public String toString() {
            return name + " (" + capacity + " seats)";
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Train Consist Management App ===");

        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("First Class", 18));
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("Pantry Car", 0));
        bogies.add(new Bogie("AC Chair", 64));

        System.out.println("Before Sorting: " + bogies);

        bogies.sort(Comparator.comparingInt(b -> b.capacity));
        System.out.println("Sorted (Ascending): " + bogies);

        bogies.sort(Comparator.comparingInt((Bogie b) -> b.capacity).reversed());
        System.out.println("Sorted (Descending): " + bogies);
    }
}
