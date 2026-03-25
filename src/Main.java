import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {

        System.out.println("=== Train Consist Management App ===");

        // Create LinkedList for train consist
        LinkedList<String> trainConsist = new LinkedList<>();

        // Add bogies
        trainConsist.add("Engine");
        trainConsist.add("Sleeper");
        trainConsist.add("AC");
        trainConsist.add("Cargo");
        trainConsist.add("Guard");

        System.out.println("Initial train consist:");
        System.out.println(trainConsist);

        // Insert Pantry Car at position 2 (index starts from 0)
        trainConsist.add(2, "Pantry Car");

        System.out.println("\nAfter inserting Pantry Car at position 2:");
        System.out.println(trainConsist);

        // Remove first and last bogies
        trainConsist.removeFirst();
        trainConsist.removeLast();

        System.out.println("\nAfter removing first and last bogies:");
        System.out.println(trainConsist);

        // Final state
        System.out.println("\nFinal ordered train consist:");
        System.out.println(trainConsist);
    }
}