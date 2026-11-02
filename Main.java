/*
 * Author: Jade Stewart
 * Date: October 8, 2026
 *
 * Description:
 * Uses a while-loop to read five floating-point values from the user,
 * then prints the total, average, maximum, minimum, and 20% interest
 * on the total. A limit on invalid entries prevents an endless loop.
 */

import java.util.Scanner;

public class Main {
  // Named constants for values used throughout the program
  static final int NUM_VALUES = 5;
  static final int MAX_INVALID = 5;
  static final double INTEREST_RATE = 0.20;

  public static void main(String[] args) {
    // Array to hold the five values entered by the user
    double[] values = new double[NUM_VALUES];

    // Number of valid values entered so far
    int count = 0;

    // Endless-loop protection: track invalid entries
    int invalidAttempts = 0;

    // Variables for the calculated results
    double total = 0.0;
    double average = 0.0;
    double interest = 0.0;

    Scanner scnr = new Scanner(System.in);

    // Keep asking until five valid values are entered OR the invalid limit
    // is reached. The second condition guarantees the loop always ends.
    while (count < NUM_VALUES && invalidAttempts < MAX_INVALID) {
      System.out.println("Please enter a decimal value: ");
      String userInput = scnr.nextLine().trim();
      try {
        // Try to convert the input to a double
        double value = Double.parseDouble(userInput);

        // Reject NaN and Infinity
        if (Double.isNaN(value) || Double.isInfinite(value)) {
          invalidAttempts++;
          System.out.println("Invalid value.");
        } else {
          values[count] = value;
          count++;
        }
      } catch (NumberFormatException e) {
        // Input was not a valid number: count it and let the loop prompt again
        invalidAttempts++;
        System.out.println("Invalid value.");
      }
    }
    scnr.close();

    // If the loop ended because of too many invalid entries, exit
    // instead of running calculations on incomplete data
    if (invalidAttempts == MAX_INVALID) {
      System.out.println("Too many invalid entries. Goodbye");
      System.exit(1);
    }

    // Start max and min at the first user value
    double maximum = values[0];
    double minimum = values[0];

    // Add up all values and track the largest and smallest
    for (double value : values) {
      total += value;

      if (value > maximum) {
        maximum = value;
      }

      if (value < minimum) {
        minimum = value;
      }
    }

    System.out.println("Total: " + total);

    // Average of the five values
    average = total / NUM_VALUES;

    System.out.println("Average: " + average);
    System.out.println("Maximum: " + maximum);
    System.out.println("Minimum: " + minimum);

    // Interest on the total at 20%
    interest = total * INTEREST_RATE;

    System.out.println("Interest: " + interest);
  }
}