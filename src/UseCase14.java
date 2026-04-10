import java.util.ArrayList;
import java.util.List;

public class UseCase14 {

    // Custom Checked Exception
    static class InvalidCapacityException extends Exception {
        public InvalidCapacityException(String message) {
            super(message);
        }
    }

    // Passenger Bogie class
    static class PassengerBogie {
        String bogieId;
        String bogieType;
        int capacity;

        PassengerBogie(String bogieId, String bogieType, int capacity)
                throws InvalidCapacityException {
            if (capacity <= 0) {
                throw new InvalidCapacityException(
                    "[ERROR] Invalid capacity: " + capacity +
                    " for bogie '" + bogieId + "'. Capacity must be greater than 0."
                );
            }
            this.bogieId = bogieId;
            this.bogieType = bogieType;
            this.capacity = capacity;
        }

        public String toString() {
            return "Bogie[" + bogieId + "] Type=" + bogieType +
                   " Capacity=" + capacity;
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Train Consist Management App ===");
        System.out.println("--- UC14: Handle Invalid Bogie Capacity ---\n");

        List<PassengerBogie> consist = new ArrayList<>();

        // Test data: id, type, capacity
        String[][] bogieData = {
            {"BG001", "Sleeper",     "72"},
            {"BG002", "AC Chair",    "-5"},
            {"BG003", "First Class", "18"},
            {"BG004", "Sleeper",     "0"},
            {"BG005", "AC Chair",    "64"}
        };

        for (String[] data : bogieData) {
            try {
                PassengerBogie bogie = new PassengerBogie(
                    data[0], data[1], Integer.parseInt(data[2])
                );
                consist.add(bogie);
                System.out.println("[SUCCESS] Added: " + bogie);
            } catch (InvalidCapacityException e) {
                System.out.println(e.getMessage());
            }
        }

        System.out.println("\n=== Final Train Consist ===");
        System.out.println("Total Bogies Added: " + consist.size());
        for (PassengerBogie b : consist) {
            System.out.println("  " + b);
        }
    }
}
