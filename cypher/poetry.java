import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Formatter;
import java.util.ArrayList;

public class poetry {
  public static void main(String[] args) {
    // Storing the encoded lines
    ArrayList<String> encodedPoem = new ArrayList<>(),
        vowelsToCapitals = new ArrayList<>(),
        decodedPoem = new ArrayList<>();

    // Reading from poetry.txt
    try {
      File poem = new File("poem.txt");
      Scanner sc = new Scanner(poem);

      // Each line is iterated through in 'poem.txt'
      while (sc.hasNextLine()) {
        String line = sc.nextLine();
        // Skip if line is empty
        if (line.trim().isEmpty()) {
          continue;
        } else {
          // each line is passed through cypher function and and is added to
          // 'encodedPoem'
          encodedPoem.add(cypher(line, 15, "encode"));
        }
      }
      sc.close();
    } catch (FileNotFoundException e) {
      System.out.println(e.getMessage());
    }

    // Writing to new file using the writeToFile function
    writeToFile("encodedPoem", encodedPoem);

    // 'encodedPoem' is iterated through
    for (int i = 0; i < encodedPoem.size(); i++) {
      // stores each iteration in encodedPoem i.e each line
      String line = encodedPoem.get(i);
      if (i > 0) {
        vowelsToCapitals.add("\n");
      }
      // Each character in 'line' is iterated through
      for (int j = 0; j < line.length(); j++) {
        String letter = line.charAt(j) + "";
        // checks whether the iteration in line is a vowel
        // if it is a vowel it converts it to uppercase and adds it to
        // 'vowelsToCapitals'
        switch (letter) {
          case "a":
          case "e":
          case "i":
          case "o":
          case "u":
          case "A":
          case "E":
          case "I":
          case "O":
          case "U":
            vowelsToCapitals.add(letter.toUpperCase());
            break;
          default:
            vowelsToCapitals.add(letter);
        }
      }
    }

    String vowelsToCapitalsStr = String.join("", vowelsToCapitals);

    // writing the 'vowelsToCapitals' to capitalsVowels.txt
    try {
      Formatter f = new Formatter("capitalVowels.txt");
      f.format("%s", vowelsToCapitalsStr);
      f.close();
    } catch (Exception e) {
      System.out.println("Error");
    }

    // Reading from capitalVowels.txt
    try {
      File capitalVowels = new File("capitalVowels.txt");
      Scanner sc = new Scanner(capitalVowels);

      // iterates through each line in 'capitalVowels.txt'
      while (sc.hasNextLine()) {
        String line = sc.nextLine(), decodedLine = cypher(line, 15, "decode"),
            reverseDecodedLine = "";

        // 'decodedLine' is iterated through starting from the last character in the
        // string
        for (int i = decodedLine.length() - 1; i >= 0; i--) {
          // stores each character
          String character = decodedLine.charAt(i) + "";
          // 'character' is added to 'reverseDecodedLine'
          reverseDecodedLine += character;
        }
        //
        decodedPoem.add(reverseDecodedLine);
      }
      sc.close();
    } catch (FileNotFoundException e) {
      System.out.println(e.getMessage());
    }

    // Write to reversePoem file
    writeToFile("reversePoem", decodedPoem);
  }

  // write to file by inputing the name of the file and the ArrayList
  public static void writeToFile(String fileName, ArrayList<String> arrayList) {
    try {
      Formatter f = new Formatter(fileName + ".txt");
      // 'arrayList' is iterated through and each iterated is added as a new line in
      // the file
      for (int i = 0; i < arrayList.size(); i++) {
        String newLine = arrayList.get(i);
        f.format("%s", newLine + "\n");
      }
      f.close();
    } catch (Exception e) {
      System.out.println("Error");
    }
  }

  public static String cypher(String string, int shift, String opt) {
    String alphabets = "abcdefghijklmnopqrstuvwxyz";
    ArrayList<String> characters = new ArrayList<>(), alphabetAL = new ArrayList<>();
    int alphabetShift = 0;

    // Iterates through 'string' and adds each letter as an iteration in
    // 'characters'.
    for (int i = 0; i < string.length(); i++) {
      String letter = string.charAt(i) + "";
      characters.add(letter);
    }

    // Iterates through 'alphabets' and adds each letter as an iteration in
    // 'alphabetAL'.
    for (int i = 0; i < alphabets.length(); i++) {
      String letter = alphabets.charAt(i) + "";
      alphabetAL.add(letter);
    }

    // Iterate through each character and assign it a new alphabet using the cypher
    // formula.
    for (int i = 0; i < characters.size(); i++) {
      // Stores the character
      String character = characters.get(i); // i.e "A"
      for (int j = 0; j < alphabetAL.size(); j++) {
        // Stores the alphabet
        String alphabet = alphabetAL.get(j); // i.e "a"
        // executes if 'opt' parameter is 'encode'
        if (opt.equals("encode")) {
          // 'alphabetShift' is calculated by adding 'j' to 'shift' and using the
          // modulus operator to return the remainder of the that calculation.
          // 26 is used to ensure that it is kept in the correct range of the alphabet
          alphabetShift = (j + shift) % 26; // i.e 12
        } else {
          // 'alphabetShift' is calculated by subtracting 'shift' from 'j' and using the
          // modulus operator to return the remainder of the that calculation.
          // 26 is used to ensure that it is kept in the correct range of the alphabet
          alphabetShift = (j - shift) % 26; // i.e 12
          // ensures that if the number is negative the alphabet shift is subtracted from
          // the length of 'alphabetAL' to get the 'alphabetShift'
          if (alphabetShift < 0) {
            alphabetShift = alphabetAL.size() + alphabetShift;
          }
        }

        // If character equals to the current alphabet iteration(Uppercase/Lowercase)
        // then replace it with the alphabet indexed from 'alphabetAL' using the value
        // of 'alphabetShift'.
        if (character.equals(alphabet.toUpperCase())) {
          characters.set(i, alphabetAL.get(alphabetShift).toUpperCase());
        } else if (character.equals(alphabet)) {
          characters.set(i, alphabetAL.get(alphabetShift));
        }
      }
    }

    string = String.join("", characters);

    return string;
  }
}

/*
 * Pseudocode
 * Read each line from poem.txt
 * Encode each line using the cypher
 * Create a new file and write each encoded line to a new file encodedPoem.txt
 * 
 * References
 * https://www.programiz.com/java-programming/examples/vowel-consonant
 * https://cryptii.com/pipes/caesar-cipher
 * https://planetcalc.com/1434/
 * https://www.geeksforgeeks.org/iterate-over-the-characters-of-a-string-in-
 * java/
 * https://www.tutorialkart.com/java/how-to-join-elements-of-arraylist-with-
 * delimiter-in-java/#gsc.tab=0
 * https://www.tutorialspoint.com/check-if-a-string-is-whitespace-empty-or-null-
 * in-java
 * https://www.programiz.com/java-programming/try-catch
 * https://howtodoinjava.com/java/collections/arraylist/replace-element-
 * o%20replace%20an%20existing%20item,update%20with%20the%
 * 20new%20item.
 */