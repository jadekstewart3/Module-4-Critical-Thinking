/*
 * Program: Five Value Stats
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
  public static void main(String[] args) {
    // Array to hold the five values entered by the user
    float[] values = new float[5];

    // Number of valid values entered so far
    int count = 0;

    // Endless-loop protection: track invalid entries and set a limit
    int invalidAttempts = 0;
    int maxInvalid = 5;

    // Variables for the calculated results
    float total = 0f;
    float average = 0f;
    float interest = 0f;
    double interestPercentage = .20;

    Scanner scnr = new Scanner(System.in);

    // Keep asking until five valid values are entered OR the invalid limit
    // is reached. The second condition guarantees the loop always ends.
    while (count < 5 && invalidAttempts < maxInvalid){
      System.out.println("Please enter a decimal value: ");
      String userInput = scnr.nextLine().trim();
      try{
        // Try to convert the input to a float and store it
        values[count] = Float.parseFloat(userInput);
        count++;
      } catch (NumberFormatException e){
          // Input was not a valid number: count it and let the loop prompt again
          invalidAttempts++;
          System.out.println("Invalid value.");
      }
    }
    scnr.close();

    // If the loop ended because of too many invalid entries, exit
    // instead of running calculations on incomplete data
    if (invalidAttempts == maxInvalid){
      System.out.println("Too many invalid entries. Goodbye");
      System.exit(1);
    }

    // Start max and min at the first user value
    float maximum = values[0];
    float minimum = values[0];

    // Add up all values and track the largest and smallest
    for (float value : values){
      total += value;

      if (value > maximum){
        maximum = value;
      }

      if (value < minimum){
        minimum = value;
      }
    }

    System.out.println("Total: " + total);

    // Average of the five values
    average = total / 5.0f;

    System.out.println("Average: " + average);
    System.out.println("Maximum: " + maximum);
    System.out.println("Minimum: " + minimum);

    // Interest on the total at 20%
    interest = (float) (total * interestPercentage);

    System.out.println("Interest: " + interest);
  }
}