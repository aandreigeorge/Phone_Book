package phonebook;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Main {


    public static void main(String[] args) {

        try {

            List<String> phoneBook = Files.readAllLines(Paths.get("src/phonebook/small_directory.txt"));
            List<String> contactsToFind = Files.readAllLines(Paths.get("src/phonebook/small_find.txt"));

            performLinearSearch(phoneBook, contactsToFind);
            performBubbleSortAndJumpSearch(phoneBook, contactsToFind);
            performQuickSortAndBinarySearch(phoneBook, contactsToFind);

        } catch (IOException e) {
            System.err.println("Error reading files: " + e.getMessage());
        }
    }


    private static void performLinearSearch(List<String> phoneBook, List<String> contactsToFind) {

        System.out.println("Start searching (linear search)...");

        long linearSearchStartTime = System.currentTimeMillis();
        int linearSearchResults = Search.linearSearch(phoneBook, contactsToFind);
        long linearSearchEndTime = System.currentTimeMillis();
        long totalLinearSearchTime = linearSearchEndTime - linearSearchStartTime;
        String linearSearchTime = Utils.formatTime(totalLinearSearchTime);

        System.out.printf("Found %d / %d entries. Time taken: %s%n", linearSearchResults, contactsToFind.size(), linearSearchTime);
        System.out.println();
    }


    private static void performBubbleSortAndJumpSearch(List<String> phoneBook, List<String> contactsToFind) {

        System.out.println("Start searching (bubble sort + jump search)...");

        long sortStartTime = System.currentTimeMillis();
        List<String> sortedPhoneBook = Sort.bubbleSort(phoneBook);
        long sortEndTime = System.currentTimeMillis();
        long totalSortTime = sortEndTime - sortStartTime;
        String sortTime = Utils.formatTime(totalSortTime);

        long searchStartTime = System.currentTimeMillis();
        int jumpSearchResults = Search.jumpSearch(sortedPhoneBook, contactsToFind);
        long searchEndTime = System.currentTimeMillis();
        long totalSearchTime = searchEndTime - searchStartTime;
        String searchTime = Utils.formatTime(totalSearchTime);

        String sortAndSearchTime = Utils.formatTime(totalSortTime + totalSearchTime);

        System.out.printf("Found %d / %d entries. Time taken: %s%n", jumpSearchResults, contactsToFind.size(), sortAndSearchTime);
        System.out.println("Sorting time: " + sortTime);
        System.out.println("Searching time: " + searchTime);
        System.out.println();
    }


    private static void performQuickSortAndBinarySearch(List<String> phoneBook, List<String> contactsToFind) {

        System.out.println("Start searching (quick sort + binary search)...");
        long sortStartTime = System.currentTimeMillis();
        List<String> sortedPhoneBook = Sort.quickSort(phoneBook);
        long sortEndTime = System.currentTimeMillis();
        long totalSortTime = sortEndTime - sortStartTime;
        String sortTime = Utils.formatTime(totalSortTime);

        long searchStartTime = System.currentTimeMillis();
        int binarySearchResults = Search.binarySearch(sortedPhoneBook, contactsToFind);
        long searchEndTime = System.currentTimeMillis();
        long totalSearchTime = searchEndTime - searchStartTime;
        String searchTime = Utils.formatTime(totalSearchTime);

        String totalTime = Utils.formatTime(totalSortTime + totalSearchTime);

        System.out.printf("Found %d / %d entries. Time taken: %s%n", binarySearchResults, contactsToFind.size(), totalTime);
        System.out.println("Sorting time: " + sortTime);
        System.out.println("Searching time: " + searchTime);
        System.out.println();
    }

}
