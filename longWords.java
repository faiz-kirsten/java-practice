import java.util.ArrayList;
import javax.swing.*;
import java.math.*;

public class longWords {

  public static void main(String[] args) {
    String end = "0", newWord;
    int counter4Letters = 0;
    double wordsLength = 0;
    ArrayList<String> words = new ArrayList<>();

    // The user is required to enter any word of any length which is added to the
    // end of 'words' using the .add() method.
    // Entering 0 will terminate the program because whether 'words' contains 'end'
    // will be true.
    while (words.contains(end) == false) {
      newWord = JOptionPane.showInputDialog("Please enter a word (enter 0 to exit): ");
      if (newWord.length() >= 1) {
        words.add(newWord);
      }
    }

    // The length of each iteration/value in 'words' is added onto 'wordslength'
    for (int i = 0; i < words.size() - 1; i++) {
      wordsLength += words.get(i).length();
      // If the word is longer than 4 letters 'count4Letters' will increment by 1
      if (words.get(i).length() > 4) {
        counter4Letters += 1;
      }
    }

    double averageLengthOfWords = (wordsLength / (words.size() - 1));

    System.out.println("The array of words: " + words);
    System.out.println("Words longer than 4 letters: " + counter4Letters);
    System.out.println("Average length of all words given: " + averageLengthOfWords);

  }
}
/*
 * Pseudo code
 * Get any amount of words from the user but once they enter a 0 then I should
 * terminate the users input
 * Store all these words entered by the user in an array
 * init a counter for words longer than 4 letters
 * init all word length counter
 * I should then determine the length of each word in the array and increment
 * the counter of words by 1 if the word is longer than 4 letters
 * Then I should calculate the average length of all the words given by the user
 * - increment this counter by the length of each word
 * - divide it by the amount of entries in the array
 * 
 * References
 * https://www.geeksforgeeks.org/arraylist-get-method-java-examples/
 */