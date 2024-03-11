public class palindromeRecursion {
    public static void main(String[] args) {
        String word = "repaper";
        System.out.println(isPalindrome(word));
    }

    public static boolean isPalindrome(String input) {
        // base case
        // Returns true if the length of input is 1 or 0 as they would be equal when reversed
        if (input.length() == 0 || input.length() == 1) {
            return true;
        }

        // sub problem
        // Checks if the first character in the input is equal to the last character in the input
        if (input.charAt(0) == input.charAt(input.length() - 1)) {
            // The string parameter in `isPalindrome()` is all the characters in the input string starting from index 1
            // to index -2
            return isPalindrome(input.substring(1, input.length() - 1));
        }

        // returns false if none of the conditions are met above
        return false;
    }
}