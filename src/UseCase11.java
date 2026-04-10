import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class UseCase11 {
    public static void main(String[] args) {
        System.out.println("=== Train Consist Management App ===");

        List<String> trainIds = Arrays.asList("TRN001", "TRN-002", "trn003", "TRN004", "123TRN");
        List<String> cargoCodes = Arrays.asList("CRG01", "crg02", "CRG-03", "CRG04", "CRG005X");

        Pattern trainPattern = Pattern.compile("^TRN\\d{3}$");
        Pattern cargoPattern = Pattern.compile("^CRG\\d{2}$");

        System.out.println("Train ID Validation:");
        for (String id : trainIds)
            System.out.println("  " + id + " -> " + (trainPattern.matcher(id).matches() ? "VALID" : "INVALID"));

        System.out.println("\nCargo Code Validation:");
        for (String code : cargoCodes)
            System.out.println("  " + code + " -> " + (cargoPattern.matcher(code).matches() ? "VALID" : "INVALID"));
    }
}
