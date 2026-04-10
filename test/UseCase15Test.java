import org.junit.Test;
import static org.junit.Assert.*;

public class UseCase15Test {

    static class CargoSafetyException extends RuntimeException {
        public CargoSafetyException(String message) { super(message); }
    }

    static class GoodsBogie {
        String bogieId;
        String shape;
        String assignedCargo;
        boolean cargoAssigned;
        boolean finallyExecuted;

        GoodsBogie(String bogieId, String shape) {
            this.bogieId = bogieId;
            this.shape = shape;
            this.assignedCargo = null;
            this.cargoAssigned = false;
            this.finallyExecuted = false;
        }

        void assignCargo(String cargoType) {
            try {
                if (cargoType.equalsIgnoreCase("Petroleum") &&
                    shape.equalsIgnoreCase("Rectangular")) {
                    throw new CargoSafetyException(
                        "Unsafe: Petroleum cannot be assigned to Rectangular bogie."
                    );
                }
                this.assignedCargo = cargoType;
                this.cargoAssigned = true;

            } catch (CargoSafetyException e) {
                this.cargoAssigned = false;

            } finally {
                this.finallyExecuted = true;
            }
        }
    }

    // Test 1: Safe assignment - Cylindrical + Petroleum
    @Test
    public void testCargo_SafeAssignment() {
        GoodsBogie bogie = new GoodsBogie("GB001", "Cylindrical");
        bogie.assignCargo("Petroleum");
        assertTrue("Cargo should be assigned", bogie.cargoAssigned);
        assertEquals("Petroleum", bogie.assignedCargo);
    }

    // Test 2: Unsafe assignment - Rectangular + Petroleum
    @Test
    public void testCargo_UnsafeAssignmentHandled() {
        GoodsBogie bogie = new GoodsBogie("GB002", "Rectangular");
        try {
            bogie.assignCargo("Petroleum");
        } catch (Exception e) {
            fail("Exception should have been handled internally, not propagated.");
        }
        assertFalse("Cargo should NOT be assigned", bogie.cargoAssigned);
    }

    // Test 3: Cargo not assigned after failure
    @Test
    public void testCargo_CargoNotAssignedAfterFailure() {
        GoodsBogie bogie = new GoodsBogie("GB002", "Rectangular");
        bogie.assignCargo("Petroleum");
        assertFalse(bogie.cargoAssigned);
        assertNull("Assigned cargo should remain null", bogie.assignedCargo);
    }

    // Test 4: Program continues after exception
    @Test
    public void testCargo_ProgramContinuesAfterException() {
        GoodsBogie b1 = new GoodsBogie("GB001", "Rectangular");
        GoodsBogie b2 = new GoodsBogie("GB002", "Cylindrical");
        GoodsBogie b3 = new GoodsBogie("GB003", "Rectangular");

        b1.assignCargo("Petroleum");
        b2.assignCargo("Petroleum");
        b3.assignCargo("Coal");

        assertFalse(b1.cargoAssigned);
        assertTrue(b2.cargoAssigned);
        assertTrue(b3.cargoAssigned);
    }

    // Test 5: Finally block always executes
    @Test
    public void testCargo_FinallyBlockExecution() {
        GoodsBogie safe = new GoodsBogie("GB001", "Cylindrical");
        safe.assignCargo("Petroleum");
        assertTrue("Finally must execute on success", safe.finallyExecuted);

        GoodsBogie unsafe = new GoodsBogie("GB002", "Rectangular");
        unsafe.assignCargo("Petroleum");
        assertTrue("Finally must execute on failure", unsafe.finallyExecuted);
    }

    // Test 6: Rectangular + Coal is safe
    @Test
    public void testCargo_RectangularCoalIsSafe() {
        GoodsBogie bogie = new GoodsBogie("GB003", "Rectangular");
        bogie.assignCargo("Coal");
        assertTrue(bogie.cargoAssigned);
        assertEquals("Coal", bogie.assignedCargo);
    }

    // Test 7: Cylindrical + Grain is safe
    @Test
    public void testCargo_CylindricalGrainIsSafe() {
        GoodsBogie bogie = new GoodsBogie("GB004", "Cylindrical");
        bogie.assignCargo("Grain");
        assertTrue(bogie.cargoAssigned);
        assertEquals("Grain", bogie.assignedCargo);
    }

    // Test 8: Multiple unsafe assignments don't crash app
    @Test
    public void testCargo_MultipleUnsafeAssignments() {
        GoodsBogie b1 = new GoodsBogie("GB001", "Rectangular");
        GoodsBogie b2 = new GoodsBogie("GB002", "Rectangular");
        GoodsBogie b3 = new GoodsBogie("GB003", "Rectangular");

        b1.assignCargo("Petroleum");
        b2.assignCargo("Petroleum");
        b3.assignCargo("Petroleum");

        assertFalse(b1.cargoAssigned);
        assertFalse(b2.cargoAssigned);
        assertFalse(b3.cargoAssigned);
        assertTrue(b1.finallyExecuted);
        assertTrue(b2.finallyExecuted);
        assertTrue(b3.finallyExecuted);
    }
}
