import java.util.ArrayList;

public class NoRepeats {
  public static void main(String[] args) {
    String sentence = "And I think to myself: what a wonderful world!!!";

    System.out.println(sentence);
    // We call the method removeDuplicates with sentence as a parameter, and we
    // reassign it to 'sentence'.
    sentence = removeDuplicates(sentence);
    System.out.println(sentence);
  }

  public static String removeDuplicates(String string) {
    // 'characters' is initialized which will store each character of the string
    // given in the parameter.
    ArrayList<String> characters = new ArrayList<>();
    // 'noDuplicates' will contain the new array of character with no duplicates.
    ArrayList<String> noDuplicates = new ArrayList<>();

    // 'string' is looped through and each character is added to 'characters'.
    for (int i = 0; i < string.length(); i++) {
      String letter = string.charAt(i) + "";
      characters.add(letter);
    }

    // 'characters' is iterated through.
    for (int i = 0; i < characters.size(); i++) {
      // stores each value in 'characters' using the .get() method.
      String character = characters.get(i);
      // checks if the value is a space and adds it to noDuplicates.
      if (character.trim().isEmpty()) {
        noDuplicates.add(character);
      }
      // checks if the 'noDuplicates' contains each 'character' converted to
      // an upper/ lowercase, and if it does, it skips to the next iteration using
      // continue.
      else if (noDuplicates.contains(character.toLowerCase())
          || noDuplicates.contains(character.toUpperCase())) {
        continue;
      }
      // adds the character to 'noDuplicates' if none of the previous conditions are
      // met.
      else {
        noDuplicates.add(character);
      }
    }

    // the values is 'noDuplicates' are joined together using the .join() method
    string = String.join("", noDuplicates);

    return string;
  }
}

/*
 * Method will Take in a string as an argument
 * init arrayString
 * Init newString which will contain no duplicates
 * Iterate through string and append each iteration to arrayString
 * - Check if iteration is a space and if it is then append it
 * - Check if array contains this value already and do nothing with it
 * - or just append this value
 * 
 * References
 * https://stackoverflow.com/questions/20881381/check-if-arraylist-contains-any-
 * letters
 * https://www.tutorialspoint.com/check-if-a-string-is-whitespace-empty-or-null-
 * in-java
 */
