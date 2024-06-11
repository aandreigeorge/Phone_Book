package phonebook;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        try {

            List<String> phoneBook = Files.readAllLines(Paths.get("src/phonebook/directory.txt"));
            List<String> contactsToFind = Files.readAllLines(Paths.get("src/phonebook/find.txt"));

            System.out.println("Start searching (linear search)...");

            long[] linearSearchResults = Search.linearSearch(phoneBook, contactsToFind);
            long numberOfContactsFound = linearSearchResults[0];
            long timeOfLinearSearch = linearSearchResults[1];

            String timeTaken = TimeFormatter.formatTime(linearSearchResults[1]);
            System.out.printf("Found %d / %d entries. Time taken: %s%n", numberOfContactsFound, contactsToFind.size(), timeTaken);
            System.out.println();

            long bubbleSortTimeLimit = timeOfLinearSearch * 10;
            List<String> sortedPhoneBook = Sort.bubbleSort(phoneBook, contactsToFind, bubbleSortTimeLimit);

        } catch (IOException e) {
            System.err.println("Error reading files: " + e.getMessage());
        }
    }

}
