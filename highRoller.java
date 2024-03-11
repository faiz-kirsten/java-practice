import java.util.Random;
import javax.swing.*;

public class highRoller {
  public static void main(String[] args) {
    // A maximum and minimum number is declared to determine the range of numbers
    // that will be generated randomly
    int minNum = 1, maxNum = 7, cpuScore = 0, userScore = 0, userTurn, cpuTurn, opt;
    // Stores the object of the random class
    Random rand = new Random();

    for (int i = 1; i < 4; i++) {
      // The user enters 1 to roll the dice
      opt = Integer.parseInt(JOptionPane.showInputDialog("Enter 1 to roll the dice"));
      // The nextInt method of Random takes in the max and min as arguments
      // The min number is subtracted from the maxNum and added again to ensure that
      // if the random number is 1 it will still return a number within the range
      // instead of returning 0. The same applies for when 6 is the generated number.;
      userTurn = rand.nextInt(maxNum - minNum) + minNum;
      cpuTurn = rand.nextInt(maxNum - minNum) + minNum;

      // A point is added to the winners score counter based on whether the user or
      // cpu's turn(number) is higher than the other
      System.out.println("Round " + i);
      if (userTurn > cpuTurn) {
        userScore += 1;
        System.out.println("You won this round");
      } else if (cpuTurn > userTurn) {
        cpuScore += 1;
        System.out.println("The cpu won this round");
      } else {
        System.out.println("This round was a draw");
      }

      // The score after each round is printed out
      System.out.println("User: " + userTurn + "\nCPU: " + cpuTurn);

      // Since this is best of 3 rounds, whoever gets 2 points while the other has
      // none will win
      if (cpuScore == 2 && userScore == 0 || userScore == 2 && cpuScore == 0) {
        break;
      }

    }

    System.out.println("Final Score\n" + "User: " + userScore + "\nCpu: " + cpuScore);

    // Depentant on who has the highest score the relevant statement will display
    if (cpuScore > userScore) {
      System.out.println("The cpu has won. Better luck next time!");
    } else if (userScore > cpuScore) {
      System.out.println("You won. Congratulations!");
    } else {
      System.out.println("It's a draw.");
    }

  }
}

/*
 * Pseudo code
 * Declare a score counter variable for user and cpu
 * Generate a random number from 1-6 for user
 * Generate a random number from 1-6 for cpu
 * Check whether cpu or users number is higher and add a 1 to the respective
 * counter
 * There should only be 3 rounds
 * If the user or cpu has 2 and the other has 0 end the game and output who won
 * or lost.
 * 
 * References
 * https://www.w3schools.com/java/java_operators.asp
 * https://linuxhint.com/generate-random-number-within-specified-range-in-java/
 */