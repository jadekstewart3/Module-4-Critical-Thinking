import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    float[] values = new float[5];
    int count = 0; 
    int invalidAttempts = 0;
    int maxInvalid = 5;
    float total = 0f;
    float average = 0f;
    float interest = 0f;
    double interestPercentage = .20;


    
    Scanner scnr = new Scanner(System.in);

    while (count < 5 && invalidAttempts < maxInvalid){
      System.out.println("Please enter a decimal value: ");
      String userInput = scnr.nextLine().trim();
      try{
        values[count] = Float.parseFloat(userInput);
        count++;
      } catch (NumberFormatException e){
          invalidAttempts++;
          System.out.println("Invalid value.");
      }
    }
    scnr.close();

    if (invalidAttempts == maxInvalid){
      System.out.println("Too many invalid entries. Goodbye");
      System.exit(1);
    }

    float maximum = values[0];
    float minimum = values[0];

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

    average = total / 5.0f;

    System.out.println("Average: " + average);
    System.out.println("Maximum: " + maximum);
    System.out.println("Minimum: " + minimum);
  
    interest = (float) (total * interestPercentage);

    System.out.println("Interest: " + interest);
  }
}