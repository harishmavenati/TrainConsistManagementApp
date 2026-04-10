import java.util.ArrayList;
import java.util.List;

public class UseCase20 {

    static class TrainConsist {
        List<String> bogieIds = new ArrayList<>();

        void addBogie(String bogieId) {
            bogieIds.add(bogieId);
            System.out.println("[ADDED] Bogie '" + bogieId + "' added to consist.");
        }

        // Fail-fast: throws IllegalStateException if consist is empty
        int searchBogie(String key) {
            if (bogieIds.isEmpty()) {
                throw new IllegalStateException(
                    "[ERROR] Cannot search. Train consist is empty. " +
                    "Add bogies before performing a search."
                );
            }

            for (int i = 0; i < bogieIds.size(); i++) {
                if (bogieIds.get(i).equals(key)) {
                    return i;
                }
            }
            return -1;
        }

        void printConsist() {
            if (bogieIds.isEmpty()) {
                System.out.println("[INFO] Consist is empty.");
            } else {
                System.out.println("Current Consist: " + bogieIds);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Train Consist Management App ===");
        System.out.println("--- UC20: Exception Handling During Search ---\n");

        TrainConsist train = new TrainConsist();

        // Case 1: Search on empty consist
        System.out.println("-- Case 1: Search on Empty Consist --");
        try {
            train.searchBogie("BG001");
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        }

        System.out.println();

        // Case 2: Add bogies then search
        System.out.println("-- Case 2: Search After Adding Bogies --");
        train.addBogie("BG001");
        train.addBogie("BG002");
        train.addBogie("BG003");
        train.printConsist();

        try {
            int index = train.searchBogie("BG002");
            if (index != -1) {
                System.out.println("[FOUND] 'BG002' found at index " + index + ".");
            } else {
                System.out.println("[NOT FOUND] 'BG002' not in consist.");
            }
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        }

        System.out.println();

        // Case 3: Search for non-existent bogie
        System.out.println("-- Case 3: Search for Non-Existent Bogie --");
        try {
            int index = train.searchBogie("BG999");
            if (index != -1) {
                System.out.println("[FOUND] 'BG999' found at index " + index + ".");
            } else {
                System.out.println("[NOT FOUND] 'BG999' not in consist.");
            }
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        }
    }
}
