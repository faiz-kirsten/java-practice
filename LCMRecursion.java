public class LCMRecursion {
    public static void main(String[] args) {
        int num1 = 2, num2 = 3;
        System.out.println(LCM(num1, num2, 1));
    }

    // Calculates the lowest common multiple(LCM) between two numbers
    public static int LCM(int x, int y, int multiple) {
        // If the multiple modulos of x and y is 0 - if the remainder is equal to 0, the multiple is returned
        if (multiple % x == 0 && multiple % y == 0) {
            return multiple; // Lowest common multiple
        }

        // If the multiple modulos of x and y is not 0 - if the remainder is not equal to 0, the method makes a
        // recursive call to itself, incrementing the multiple by 1.
        // This recursive call continues until the LCM is found.
        return LCM(x, y, multiple + 1);
    }
}

/* Example of how the recursive calls itself until LCM is found
* 1 mod 2 = 1 --- 2 mod 2 = 0 --- 3 mod 2 = 1 --- 4 mod 2 = 0 --- 5 mod 2 = 1 --- 6 mod 2 = 0
* 1 mod 3 = 1 --- 2 mod 3 = 1 --- 3 mod 3 = 0 --- 4 mod 3 = 1 --- 5 mod 3 = 2 --- 6 mod 3 = 0
*/
