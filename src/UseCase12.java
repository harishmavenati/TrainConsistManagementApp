import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class UseCase12 {
    static class GoodsBogie {
        String id;
        String cargoType;
        boolean isSealed;
        boolean hasFireExtinguisher;

        GoodsBogie(String id, String cargoType, boolean isSealed, boolean hasFireExtinguisher) {
            this.id = id;
            this.cargoType = cargoType;
            this.isSealed = isSealed;
            this.hasFireExtinguisher = hasFireExtinguisher;
        }

        boolean isCompliant() {
            return isSealed && hasFireExtinguisher;
        }

        public String toString() {
            return id + " [" + cargoType + "] Sealed=" + isSealed +
                   " FireExt=" + hasFireExtinguisher +
                   " -> " + (isCompliant() ? "COMPLIANT" : "NON-COMPLIANT");
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Train Consist Management App ===");

        List<GoodsBogie> bogies = Arrays.asList(
            new GoodsBogie("GB001", "Coal", true, true),
            new GoodsBogie("GB002", "Chemicals", false, true),
            new GoodsBogie("GB003", "Grain", true, false),
            new GoodsBogie("GB004", "Steel", true, true)
        );

        System.out.println("Safety Compliance Report:");
        bogies.forEach(b -> System.out.println("  " + b));

        List<GoodsBogie> nonCompliant = bogies.stream()
            .filter(b -> !b.isCompliant())
            .collect(Collectors.toList());

        System.out.println("\nNon-Compliant Bogies: " + nonCompliant.size());
        nonCompliant.forEach(b -> System.out.println("  [ALERT] " + b.id + " requires attention."));
    }
}
