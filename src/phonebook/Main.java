package phonebook;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        try {

            List<String> directory = Files.readAllLines(Paths.get("src/phonebook/directory.txt"));
            List<String> find = Files.readAllLines(Paths.get("src/phonebook/find.txt"));

            System.out.println("Start searching...");

            long startTime = System.currentTimeMillis();
            int foundCount = linearSearch(directory, find);
            long endTime = System.currentTimeMillis();
            long timeElapsed = endTime - startTime;
            String timeFormatted = formatTime(timeElapsed);

            System.out.printf("Found %d / %d entries. Time taken: %s%n", foundCount, find.size(), timeFormatted);

        } catch (IOException e) {
            System.err.println("Error reading files: " + e.getMessage());
        }
    }

    private static int linearSearch(List<String> directory, List<String> find) {

        int foundCount = 0;

        for (String target : find) {
            for (String entry : directory) {
                if (entry.contains(target)) {
                    foundCount++;
                    break;
                }
            }
        }
        return foundCount;
    }

    private static String formatTime(long milliseconds) {

        long minutes = milliseconds / 60000;
        long seconds = (milliseconds % 60000) / 1000;
        long millis = milliseconds % 1000;

        return String.format("%d min. %d sec. %d ms.", minutes, seconds, millis);
    }
}
