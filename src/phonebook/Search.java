package phonebook;

import java.util.List;

public class Search {


    static long[] linearSearch(List<String> phoneBook, List<String> contactsToFind) {

        long startTime = System.currentTimeMillis();
        long foundCount = 0L;

        for (String contactToFind : contactsToFind) {
            for (String entry : phoneBook) {
                if (entry.contains(contactToFind)) {
                    foundCount++;
                    break;
                }
            }
        }

        return new long[] {foundCount, System.currentTimeMillis() - startTime};
    }


    static long[] jumpSearch(List<String> list, List<String> targets) {

        long elementsFound = 0L;
        long startTime = System.currentTimeMillis();

        int n = list.size();
        int step = (int) Math.floor(Math.sqrt(n));

        for (String target : targets) {
            int prev = 0;

            // Finding the block where the element is present
            while (list.get(Math.min(step, n) - 1).compareTo(target) < 0) {
                prev = step;
                step += (int) Math.floor(Math.sqrt(n));
                if (prev >= n) {
                    break; // Element not found
                }
            }

            // Linear search in the found block
            while (list.get(prev).compareTo(target) < 0) {
                prev++;

                // If we reach the next block or end of list, the element is not present
                if (prev == Math.min(step, n)) {
                    break; // Element not found
                }
            }

            // If the element is found
            if (list.get(prev).equals(target)) {
                elementsFound++;

            }
        }

        return new long[] {elementsFound, System.currentTimeMillis() - startTime};
    }
}
