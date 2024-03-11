import java.util.*;

public class BubbleSort {
    public static void main(String[] args) {
        // Create an ArrayList of words
        ArrayList<String> words = new ArrayList<>(List.of("blue", "six", "hello", "game", "unorthodox", "referee", "ask", "zebra", "run", "flex"));
        System.out.println("Unsorted: " + words);

        // Call the bubbleSort method to sort the words
        ArrayList<String> sortedWords = bubbleSort(words);

        // Print the sorted words
        System.out.println("Sorted: " + sortedWords);
    }

    public static ArrayList<String> bubbleSort(ArrayList<String> words) {
        for (int i = 0; i < words.size() - 1; i++) {
            for (int j = 0; j < words.size() - 1; j++) {
                // Get the hashcode value of the first character in the current iterations word
                String current = words.get(j);
                String currentFirstChar = String.valueOf(current.charAt(0));
                int currentFirstCharHashcode = currentFirstChar.hashCode();
                // Get the hashcode value of the first character in the next iterations word
                String next = words.get(j + 1);
                String nextFirstChar = String.valueOf(next.charAt(0));
                int nextFirstCharHashcode = nextFirstChar.hashCode();
                // if the 'currentFirstCharHashcode' is larger than the 'nextFirstCharHashcode' then swap the values
                if (currentFirstCharHashcode > nextFirstCharHashcode) {
                    String temp = words.get(j);
                    words.set(j, words.get(j + 1));
                    words.set(j + 1, temp);
                }
            }
        }

        return words;
    }

    // Debugging methods
    public static void printHashcode() {
        String alphabets = "abcdefghijklmnopqrstuvwxyz";


        for (int i = 0; i < alphabets.length(); i++) {
            System.out.println(alphabets.charAt(i) + " = " + String.valueOf(alphabets.charAt(i)).hashCode());
        }
    }
}
