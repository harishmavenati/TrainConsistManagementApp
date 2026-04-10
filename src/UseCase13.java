import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class UseCase13 {
    public static void main(String[] args) {
        System.out.println("=== Train Consist Management App ===");

        List<String> bogies = new ArrayList<>();
        for (int i = 1; i <= 1000; i++) bogies.add("Bogie" + i);

        long loopStart = System.nanoTime();
        List<String> loopResult = new ArrayList<>();
        for (String b : bogies)
            if (b.contains("1")) loopResult.add(b);
        long loopTime = System.nanoTime() - loopStart;

        long streamStart = System.nanoTime();
        List<String> streamResult = bogies.stream()
            .filter(b -> b.contains("1"))
            .collect(Collectors.toList());
        long streamTime = System.nanoTime() - streamStart;

        System.out.println("Loop   matched: " + loopResult.size() + " | Time: " + loopTime + " ns");
        System.out.println("Stream matched: " + streamResult.size() + " | Time: " + streamTime + " ns");
        System.out.println("\nFaster approach: " + (loopTime < streamTime ? "Loop" : "Stream"));
    }
}
