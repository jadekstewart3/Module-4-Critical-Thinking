import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    float[] values = new float[5];
    int count = 0; 
    int invalidAttempts = 0;
    int maxInvalid = 10 ;
    Scanner scnr = new Scanner(System.in);

    while (count < 5 && invalidAttempts < maxInvalid){
      System.out.println("Please enter a decimal value: ");
      String userInput = scnr.nextLine().trim();
      try{
        values[count] = Float.parseFloat(userInput);
        count++;
      } catch (NumberFormatException e){
          invalidAttempts++;
          System.out.println("Invalid value, please enter a decimal: ");
      }
    }
    scnr.close();
    if (invalidAttempts == maxInvalid){
      System.out.println("Too many invalid entries. Goodbye");
      System.exit(1);
    }
  }
}