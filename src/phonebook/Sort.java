package phonebook;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class Sort {


    static List<String> bubbleSort(List<String> unsortedList) {

        List<String> sortedList = new ArrayList<>(unsortedList);

        boolean swapping = true;
        int iterations = sortedList.size() - 1;

        while (swapping) {

            swapping = false;

            for (int i = 0; i < iterations; i++) {

                String name1 = Utils.extractName(sortedList.get(i));
                String name2 = Utils.extractName(sortedList.get(i + 1));

                if (name1.compareTo(name2) > 0) {
                    String temp = sortedList.get(i);
                    sortedList.set(i, sortedList.get(i + 1));
                    sortedList.set(i + 1, temp);
                    swapping = true;
                }
            }
            iterations--;
        }

        return sortedList;
    }


    static List<String> quickSort(List<String> unsortedList) {

        List<String> sortedList = new ArrayList<>(unsortedList);
        quickSort(sortedList, 0, sortedList.size() - 1);
        return sortedList;
    }


    private static void quickSort(List<String> list, int lowIndex, int highIndex) {

        if (lowIndex >= highIndex) {
            return;
        }

        int pivotIndex = new Random().nextInt(highIndex - lowIndex) + lowIndex;
        String pivot = list.get(pivotIndex);
        swapElementsInList(list, pivotIndex, highIndex);

        int leftPointer = partition(list, lowIndex, highIndex, pivot);

        quickSort(list, lowIndex, leftPointer - 1);
        quickSort(list, leftPointer + 1, highIndex);
    }


    private static int partition(List<String> list, int lowIndex, int highIndex, String pivot) {

        int leftPointer = lowIndex;
        int rightPointer = highIndex;

        String pivotName = Utils.extractName(pivot);

        while (leftPointer < rightPointer) {

            String nameOnLeft = Utils.extractName(list.get(leftPointer));
            while ((nameOnLeft.compareTo(pivotName) <= 0) && (leftPointer < rightPointer)) {
                leftPointer++;
                nameOnLeft = Utils.extractName(list.get(leftPointer));
            }

            String nameOnRight = Utils.extractName(list.get(rightPointer));
            while ((nameOnRight.compareTo(pivotName) >= 0) && (leftPointer < rightPointer)) {
                rightPointer--;
                nameOnRight = Utils.extractName(list.get(rightPointer));
            }

            swapElementsInList(list, leftPointer, rightPointer);

        }
        swapElementsInList(list, leftPointer, highIndex);

        return leftPointer;
    }


    private static void swapElementsInList(List<String> list, int firstElement, int secondElement) {

        String temp = list.get(firstElement);
        list.set(firstElement, list.get(secondElement));
        list.set(secondElement, temp);
    }


}
