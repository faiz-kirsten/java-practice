import java.util.ArrayList;
import java.util.Arrays;

public class bigo {
    public static void main(String[] args) {
        // O(n) algorithm
        String[] names = new String[10];
        Integer[][] nums = new Integer[10][10];

        for (int i = 0; i < names.length; i++) {
            names[i] = "Faiz";
        }

        // O(n2) algorithm that iterates over a 2D array of integers.
        int counter = 1;
        for (Integer[] row : nums) {
            for (Integer col : row){
                col = counter;
                System.out.print(col + " ");
                counter++;
            }
        }

        // Write an O(log n) algorithm that sequentially inserts an element into a sorted list.
        System.out.print("\n");

        ArrayList<Integer> sortedList = new ArrayList<>();

        // calling method which inserts the values into the array list in ascending order
        insert(5, sortedList);
        insert(3, sortedList);
        insert(8, sortedList);
        insert(12, sortedList);
        insert(1, sortedList);
        insert(11, sortedList);
        insert(1, sortedList);
        insert(5, sortedList);
        insert(2, sortedList);

        System.out.print(sortedList);
    }

    // method that inserts a number in an arraylist in ascending order
    public static void insert(int num, ArrayList<Integer> list) {
        // used to index the array list of integers
        int low = 0;
        int high = list.size() - 1;

        // iterates if 'low' is less than or equal to 'high'
        while (low <= high) {
            // formula for calculating the index of the middle value in the array list
            int mid = low + (high - low) / 2;

            // executes if 'num' is the same as the value in the middle of the array
            if (num == list.get(mid)) {
                low = mid + 1;
            }
            // executes if 'num' is less than the value in the middle of the array
            else if (num < list.get(mid)) {
                high = mid - 1;
            }
            // executes if neither of the above conditions are met
            else {
                low = mid + 1;
            }
        }

        // adds 'num' to the array provided at 'low' index
        list.add(low, num);
    }
}