public class UseCase15 {

    static class CargoSafetyException extends RuntimeException {
        public CargoSafetyException(String message) {
            super(message);
        }
    }

    static class GoodsBogie {
        String bogieId;
        String shape;
        String assignedCargo;
        boolean cargoAssigned;

        GoodsBogie(String bogieId, String shape) {
            this.bogieId = bogieId;
            this.shape = shape;
            this.assignedCargo = null;
            this.cargoAssigned = false;
        }

        void assignCargo(String cargoType) {
            try {
                System.out.println("[ATTEMPT] Assigning '" + cargoType +
                                   "' to " + shape + " bogie [" + bogieId + "]...");

                if (cargoType.equalsIgnoreCase("Petroleum") &&
                    shape.equalsIgnoreCase("Rectangular")) {
                    throw new CargoSafetyException(
                        "[ERROR] Unsafe assignment: Petroleum cannot be assigned " +
                        "to a Rectangular bogie [" + bogieId + "]. Risk of leakage!"
                    );
                }

                this.assignedCargo = cargoType;
                this.cargoAssigned = true;
                System.out.println("[SUCCESS] Cargo '" + cargoType +
                                   "' assigned to bogie [" + bogieId + "].");

            } catch (CargoSafetyException e) {
                System.out.println(e.getMessage());
                this.cargoAssigned = false;

            } finally {
                System.out.println("[LOG] Cargo validation completed for bogie [" +
                                   bogieId + "].\n");
            }
        }

        public String toString() {
            return "Bogie[" + bogieId + "] Shape=" + shape +
                   " Cargo=" + (cargoAssigned ? assignedCargo : "None");
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Train Consist Management App ===");
        System.out.println("--- UC15: Safe Cargo Assignment ---\n");

        GoodsBogie b1 = new GoodsBogie("GB001", "Cylindrical");
        b1.assignCargo("Petroleum");

        GoodsBogie b2 = new GoodsBogie("GB002", "Rectangular");
        b2.assignCargo("Petroleum");

        GoodsBogie b3 = new GoodsBogie("GB003", "Rectangular");
        b3.assignCargo("Coal");

        GoodsBogie b4 = new GoodsBogie("GB004", "Cylindrical");
        b4.assignCargo("Grain");

        System.out.println("=== Final Bogie Status ===");
        System.out.println(b1);
        System.out.println(b2);
        System.out.println(b3);
        System.out.println(b4);
    }
}
