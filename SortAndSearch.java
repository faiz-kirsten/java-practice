// The ideal algorithm for this list would be to search through the list using linear search as the list is not ordered
// Sorting the list using the sort method will result in more overhead on the system

import java.util.Arrays;

public class SortAndSearch {
    public static void main(String[] args) {
        int[] integers1 = {27, -3, 4, 5, 35, 2, 1, -40, 7, 18, 9, -1, 16, 100};
        int num = 9;
        System.out.println("Index of " + num + " is " + linearSearch(num, integers1));

        // Implementation of insertion sort
        System.out.println("Before applying insertion sort: " + Arrays.toString(integers1));
        System.out.println("After applying insertion sort: " + Arrays.toString(insertionSort(integers1)));

        System.out.println("Index of " + num + " is " + binarySearch(num, integers1));
        // Binary search is commonly used in scenarios where you have a sorted dataset and need to quickly find a specific value.
        // It's used, for instance, in algorithms that run search engines, dictionary searches, and phone book lookups. Binary search
        // is particularly useful in software applications for finding, sorting, and retrieving data from huge collections, such as databases
        // or arrays. Binary search is an essential technique for simplifying search operations across a variety of domains since it effectively
        // eliminates half of the remaining search space with each comparison, cutting down on the time required to find a certain element or determine without it.
    }

    public static int linearSearch(int num, int[] list) {
        // if index is still -1 at the end of this method, the item is not
        // in this array.
        int index = -1;
        // loop through each element in the array. if we find our search
        // term, exit the loop.
        int counter = 0;
        for (int i : list) {
            if (i == num) {
                index = counter;
                break;
            }
            counter++;
        }
        return index;
    }

    // 1. Start at index 1 in array
    // 2. Store value at index 1 in temp variable
    // 3. Check all values to the right
    // 4. if it is larger than the value at index 1, then shift that element to the right
    // 5. if not, insert it in that specific index
    private static int[] insertionSort(int[] integers1) {
        // iterate through the array starting from the second position and store the value in 'temp'
        for (int i = 1; i < integers1.length; i++) {
            int temp = integers1[i];
            // iterate from the position before the current value of i and decrement by 1
            for (int j = i - 1; j >= 0; j--) {
                // if the value at index j is bigger than the value at index i, shift the value to the value and insert
                // temp into the position of j
                if (integers1[j] > temp) {
                    integers1[j + 1] = integers1[j];
                    integers1[j] = temp;
                }
            }
        }

        return integers1;
    }

    private static int binarySearch(int item, int[] list) {
        // if index = -1 when the method is finished, we did not find the
        // search term in the array
        int index = -1;
        // set the starting and ending indexes of the array; these will
        // change as we narrow our search
        int low = 0;
        int high = list.length-1;
        int mid;
        // Continue to search for the search term until we find it or
        // until our ''low'' and ''high'' markers cross
        while (high >= low) {
            mid = (high + low) / 2; // calculate the midpoint of the current array
            if (item < list[mid]) { // value is in lower half, if at all
                high = mid - 1;
            } else if (item > list[mid]) {
                // value is in upper half, if at all
                low = mid + 1;

            } else {
                // found it! break out of the loop
                index = mid;
                break;
            }
        }
        return index;
    }
}