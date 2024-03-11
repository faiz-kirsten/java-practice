public class degreesToCelsius {

  // compilation error: cannot use void if we intend to return a value
  public static double FtoC(double fahrenheit) {
    // compilation error: changed from int to double
    // logical error: incorrect formula used to calculate Celsius
    double celsius = (fahrenheit - 32) * 5 / 9;
    double roundingOff = Math.round(celsius * 100);
    double finalAnswer = roundingOff / 100;
    return finalAnswer; // compilation error: added semi-colon
  } // compilation error: added the curly brace

  public static void main(String[] args) {

    System.out.println("Fahrenheit to Celsius converter:"); // compilation error: added semi colon

    double degreesFahrenheit = 54.3; // compilation error: changed from int to double as the value required as input
    // in the FtoC() method is a double
    double degreesCelsius = FtoC(degreesFahrenheit); // compilation error: misspelled variable name - degreesFahrenheit
    System.out.println(degreesFahrenheit + "°F = " + degreesCelsius + "°C");

  }
}

// Once you've corrected all the errors, the answer should be 12.39°C