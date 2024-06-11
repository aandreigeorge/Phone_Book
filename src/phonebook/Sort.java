package phonebook;

import java.util.ArrayList;
import java.util.List;

class Sort {

    static List<String> bubbleSort(List<String> phoneBook, List<String> contactsToFind, long timeLimit) {

        System.out.println("Start searching (bubble sort + jump search)...");

        List<String> sortedPhoneBook = new ArrayList<>(phoneBook);
        long startTime = System.currentTimeMillis();

        for (int j = 0; j < sortedPhoneBook.size() - 1; j++) {
            for (int i = 0; i < sortedPhoneBook.size() - 1 - j; i++) {
                if (sortedPhoneBook.get(i).compareTo(sortedPhoneBook.get(i + 1)) > 0) {
                    String temp = sortedPhoneBook.get(i);
                    sortedPhoneBook.set(i, sortedPhoneBook.get(i + 1));
                    sortedPhoneBook.set(i + 1, temp);
                }
            }
        }

        long sortingTime = System.currentTimeMillis() - startTime;

        long[] jumpSearchResults = Search.jumpSearch(sortedPhoneBook, contactsToFind);
        long numberOfContactsFound = jumpSearchResults[0];
        long searchingTime = jumpSearchResults[1];

        String totalTime = TimeFormatter.formatTime(sortingTime + searchingTime);

        System.out.printf("Found %d / %d entries. Time taken: %s%n", numberOfContactsFound, contactsToFind.size(), totalTime);

        if(sortingTime < timeLimit) {
            System.out.println("Sorting time: " + TimeFormatter.formatTime(sortingTime));
            System.out.println("Searching time: " + TimeFormatter.formatTime(searchingTime));

        } else {
            System.out.println("Sorting time: " + TimeFormatter.formatTime(sortingTime) + " - STOPPED, moved to linear search");
            System.out.println("Searching time: " + TimeFormatter.formatTime(searchingTime));
        }

        return sortedPhoneBook;
    }
}
