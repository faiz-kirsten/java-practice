public class IQ {
  public static void main(String[] args) {
    // An int array is initialised containing all the grades
    int[] testResults = { 70, 122, 87, 110, 95 };
    int iqTotal = 0;

    // testResults is iterated through and each iteration is added to iqTotal
    for (int i = 0; i < testResults.length; i++) {
      iqTotal += testResults[i];
    }

    double avg = iqTotal / testResults.length;
    System.out.println("The average is: " + avg + ".");

    // the relevant statement is displayed according to the conditions in the if
    // statements
    if (avg >= 130) {
      System.out.println("Very Superior");
    } else if (avg >= 120) {
      System.out.println("Superior");
    } else if (avg >= 110) {
      System.out.println("High average");
    } else if (avg >= 90) {
      System.out.println("Average");
    } else if (avg >= 80) {
      System.out.println("Low average");
    } else if (avg >= 70) {
      System.out.println("Borderline");
    } else {
      System.out.println("Extremely low");
    }
  }
}