package phonebook;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Search {


    static int linearSearch(List<String> randomOrderList, List<String> targets) {

        int numberOfFoundContacts = 0;

        for (String contactToFind : targets) {
            for (String entry : randomOrderList) {
                if (entry.contains(contactToFind)) {
                    numberOfFoundContacts++;
                    break;
                }
            }
        }
        return numberOfFoundContacts;
    }

    static int jumpSearch(List<String> sortedList, List<String> targets) {

        int count = 0;
        int listSize = sortedList.size();
        /*jumpStep represents the size of the jump or the block size that the algorithm jumps ahead in each iteration.*/
        int jumpStep = (int) Math.floor(Math.sqrt(listSize));

        for (String target : targets) {
            /* prevIndex is used to keep track of the starting index of the current block or segment being examined during the jump search.
            It helps determine where the linear search should start within the current block after the jump. */
            int prevIndex = 0;

            /* Jumping blocks to find the block where the target might be */
            while (prevIndex < listSize) {
                int currentIndex = Math.min(jumpStep, listSize) - 1;
                String currentName = Utils.extractName(sortedList.get(currentIndex));

                if (currentName.compareTo(target) >= 0) {
                    break;
                }
                prevIndex = jumpStep;
                jumpStep += jumpStep;
                /* Use jumpStep += jumpStep if you want to maximize the speed of the jump search algorithm. This approach is often more efficient
                for larger lists because it rapidly increases the jump distance, reducing the number of jumps needed to locate the target. */

                /* Use jumpStep += (int) Math.floor(Math.sqrt(listSize)); if you prefer a more cautious approach that gradually increases the jump size.
                 This method is still effective but may require more iterations to find the target compared to doubling the step size.*/
            }

            /* Extract the string variable outside the if declaration */
            String prevName = prevIndex < listSize ? Utils.extractName(sortedList.get(prevIndex)) : null;
            if (prevName != null && prevName.contains(target)) {
                count++;
                continue;
            }

            /* Linear search within the block with extracted string variable */
            for (int i = prevIndex; i < Math.min(jumpStep, listSize); i++) {
                String currentName = Utils.extractName(sortedList.get(i));
                if (currentName.contains(target)) {
                    count++;
                    break;
                }
            }
        }
        return count;
    }

    static int binarySearch(List<String> sortedList, List<String> targets) {

        int foundTargets = 0;

        for (String target : targets) {
            int lowPointer = 0;
            int highPointer = sortedList.size() - 1;

            while (lowPointer <= highPointer) {
                int middlePosition = (lowPointer + highPointer) / 2;

                String currentEntry = sortedList.get(middlePosition);
                String currentName = Utils.extractName(currentEntry);

                if (currentName.contains(target)) {
                    foundTargets++;
                    break;
                }

                if (target.compareTo(currentName) < 0) {
                    highPointer = middlePosition - 1;
                } else {
                    lowPointer = middlePosition + 1;
                }
            }
        }
        return foundTargets;
    }

    static int hashSearch(Set<PhoneBookContact> list, Set<PhoneBookContact> targets) {

        Set<PhoneBookContact> intersection = new HashSet<>(list);
        intersection.retainAll(targets);
        return intersection.size();
    }


}
