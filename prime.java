import javax.swing.*;

public class prime {
  public static void main(String[] args) {
    int num, i = 1, factors = 1;

    // The user is prompted to enter a positive integer
    do {
      num = Integer.parseInt(JOptionPane.showInputDialog("Please enter a positive integer: "));

      // The length of the number is iterated through.
      // The modulos operator returns the remainder of each iteration against the
      // number entered.
      while (i < num) {
        // factors is incremented by 1 each time the remainder value is 0
        if (num % i == 0) {
          factors += 1;
        }
        i++;
      }

      if (factors == 1 || factors == 0) {
        System.out.println(num + " is not a prime number."); // 1 and 0 are not prime numbers
      } else if (factors == 2) {
        System.out.println(num + " is a prime number."); // If the factors value is 2 then it is a prime number
      } else {
        System.out.println(num + " is not a prime number.");
      }
    } while (num < 0);
  }
}
