import java.util.Arrays;
import java.util.Scanner;

public class multipleElements {
  public static void main(String[] args) {
    // initialising the array
    int[][] array = new int[3][4];

    // Using the scanner method from util object to get the users input
    Scanner input = new java.util.Scanner(System.in);
    System.out.print("Please enter " + array[0].length + " positive integers(seperate each entry with a space):\n");

    // The users input is iterated through and each iteration is inserted as a value
    // in the first row of the array.
    for (int i = 0; i < array[0].length; i++) {
      array[0][i] = input.nextInt();
    }

    // Inserting the mutiples into 2nd and 3rd row
    // The for loop begins iterating at the first row to ensure that those values
    // can be accessed.
    for (int i = 0; i < array.length; i++) {
      for (int j = 0; j < array[i].length; j++) {
        // In this nested for loop we assign new values to the 2nd and 3rd rows of the
        // array. These values are determined by multiplying the first rows values by 2
        // and 3
        array[1][j] = array[0][j] * 2;
        array[2][j] = array[0][j] * 3;
      }
    }

    // Using the deepToString method from the Arrays object to output the array as a
    // string.
    System.out.println("The array of multiples: " + Arrays.deepToString(array));
  }
}

/*
 * Examples
 * [1 ; 2 ; 3 ; 4 ]
 * [2 ; 4 ; 6 ; 8 ]
 * [3 ; 6 ; 9 ; 12 ]
 * 
 * 5 12 8 11
 * 10 24 16 22
 * 15 36 24 33
 * 
 * 32 21 7 9
 * 64 42 14 18
 * 96 63 21 27
 *
 * References
 * https://stackabuse.com/java-how-to-print-an-array-in-one-line/
 * https://www.geeksforgeeks.org/how-to-read-and-print-an-integer-value-in-java/
 * https://www.geeksforgeeks.org/how-to-iterate-a-multidimensional-array/
 */