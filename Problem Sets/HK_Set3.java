/*

Problem Set 3
Kai Huang
9 February 2016

*/

import java.util.Scanner;

public class HK_Set3
{

  static Scanner sc; // Initalize the scanner Object

  public static void spacing( String printed )
  {

    if(printed.length() > 72)
    {

      System.out.println(printed);


    }

    else
    {

      for(int i = 0; i < (72 - printed.length())/2; i++)
      {

        System.out.print(" ");

      }

      System.out.println(printed);

    }

  }

  public static void spacing( String printed, int length )
  {

    if((printed.length() + length) > 72)
    {

      System.out.println(printed);


    }

    else
    {

      for(int i = 0; i < (72 - printed.length() - length)/2; i++)
      {

        System.out.print(" ");

      }

      System.out.print(printed);

    }

  }

  public static void product() // Problem 1; Product
  {

    int numInputs, temp; // Set up variables
    int res = 1;

    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    System.out.println();
    spacing("Welcome to the Product program!");
    System.out.println();
    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    System.out.println();
    spacing("How many numbers to process? : ", 1);

    numInputs = sc.nextInt(); // Prompt for, recieve amount of numbers

    if(numInputs < 1) // If number if inputs is invalid, return error message
    {

      System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
      System.out.println();
      spacing("ERROR: cannot process " + numInputs + " numbers.");
      System.out.println();


    }

    else{

      boolean valid = false; // if this is false, then tell the user that he didn't enter anything valid

      int [] inputs = new int [numInputs]; // Use an array to store the inputs

      for(int i = 0; i < inputs.length; i++) // Fill array by default with 1, so multiplication has no effect on empty values
      {

        inputs [i] = 1;

      }

      System.out.println();
      System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
      System.out.println();
      spacing("Enter " + numInputs + " positive integers"); // Prompt for some number of positive integers
      System.out.println();

      for(int i = 0; i < inputs.length; i++) // Iterate through array, asking for each value
      {

        temp = 1; // Just to be safe, reinitalize this variable after each run

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println();
        spacing("#" + (i + 1) + ": ", 1);

        temp = sc.nextInt(); // Prompt for the number
        System.out.println();

        if(temp < 1) // If the number is either 0 or negative, then it's not counted
        {

          System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
          System.out.println();
          spacing( temp + " was not counted.");
          System.out.println();

        }

        else // Otherwise, the number is counted
        {

          System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
          System.out.println();
          spacing( temp + " was counted.");
          System.out.println();

          inputs[i] = temp; // Number is added to the array for further processing
          valid = true;

        }

      }

      for(int i = 0; i < inputs.length; i++) // Iterate through the array, multiply values into final result
      {

        res *= inputs[i];

      }

      if(valid == false)
      {

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println();
        spacing("ERROR: You did not enter any valid numbers."); // Tell the user that they did not enter any valid numbers
        System.out.println();

      }

      else{

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println();
        spacing("The product of the positives is " + res); // Output result
        System.out.println();

      }

    }

  }

  public static void factorial() // Problem 2; Factorial
  {

    int input; // Set up variables
    int res = 1;

    String finalresult  = ""; // Using a String for the final result for better display

    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    System.out.println();
    spacing("Welcome to the Factorial program!");
    System.out.println();
    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    System.out.println();
    spacing("Enter a non - negative integer: ", 2);

    input = sc.nextInt(); // Prompt for; recieve a non - negative integer

    System.out.println();

    if(input < 0) // Checks if the integer is negative; gives error message
    {

      System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
      System.out.println();
      spacing("ERROR: You entered a negative value");
      System.out.println();

    }

    else if(input == 0) // Checks if integer is 0; gives the special case answer
    {

      System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
      System.out.println();
      spacing("The Factorial of 0 is 1.");
      System.out.println();

    }

    else if(input > 12) // Checks if the integer is over 12, as 12! is too large for an int; gives error message
    {

      System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
      System.out.println();
      spacing("ERROR: You entered a number that is too large.");
      System.out.println();

    }

    else // Otherwise, the input is valid
    {

      System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
      System.out.println();

      for(int i = input; i > 1; i--) // Iterate through the number, counting downwards (Ends before 1 is output, since 1 needs to be output in a special way)
      {

        finalresult += (i + " * "); // Add each one in sequence with the multiplication symbol behind it to finalresult

        res *= i; // Multiplies into the final result

      }

      finalresult += ("1 = " + res); // Adds number 1, ** without the multiplication symbol behind it ** and the result to finalresult

      spacing(finalresult);

      System.out.println();

    }

  }

  public static void invest() // Problem 3; Invest
  {

    int term; // Set up variables
    double rate, earn, deposit;
    double bal = 0;

    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    System.out.println();
    spacing("Welcome to the Invest program!");
    System.out.println();
    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    System.out.println();
    spacing("Enter your Monthly Deposit ($): ", 6);

    deposit = sc.nextDouble(); // Prompt for; recieve deposit

    spacing("Enter your Annual Interest Rate (%): ", 2);

    rate = (( sc.nextDouble() / 12) / 100); // Prompt for; recieve yearly interest (Immediately convert it to be decimal representation of monthly interest)

    spacing("Enter your Term (Months): ", 2);

    term = sc.nextInt(); // Prompt for; recieve Term

    // Set up output chart

    System.out.println();
    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    System.out.println();
    System.out.println("        Starting         Interest         Monthly         Ending");
    System.out.println("        Balance           Earned          Deposit         Balance ");
    System.out.println();
    System.out.println("        ---------------------------------------------------------");
    System.out.println();

    for(int i = 0; i < term; i++) // Looping through the months of the investment term
    {

      for(int j = 0; j < ( 16 - String.format("%.2f", bal).length() ); j++) // Algorithm to ensure that spacing is right - aligned based on taking length of the double as a String and subtracting that from constant blank spaces
      {

        // The following are debug statements; please ignore them

        //System.out.println(String.format("%.2f", bal));
        //System.out.println(String.format("%.2f", bal));

        //System.out.println("I'm in yer loop");
        //System.out.println("J is: " + j);
        //System.out.println("There should be " + (String.format("%.2f", bal).length() + 4) + " spaces.");

        System.out.print(" "); // For spacing purposes


      }

      System.out.format("%.2f", bal); // Output balance (1)

      earn = (rate * bal); // Calculate earnings

      for(int j = 0; j < ( 16 - String.format("%.2f", earn).length() ); j++) // Same algorithm as above
      {

        System.out.print(" ");


      }

      System.out.format("$%.2f", earn); // Output earnings

      for(int j = 0; j < ( 15 - String.format("%.2f", deposit).length() ); j++) // Same algorithm as above
      {

        System.out.print(" ");


      }

      System.out.format("$%.2f", deposit); // Output deposit

      bal += (deposit + earn); // Calculate final balance

      for(int j = 0; j < ( 15 - String.format("%.2f", bal).length() ); j++) // Same algorithm as above
      {

        System.out.print(" ");


      }

      System.out.format("$%.2f%n", bal); // Output balance (2)
      System.out.println();

    }


  }

  public static void main (String [] args)
  {

    sc = new Scanner (System.in); // Define Scanner Object

    int choice; // Set up choice variable

    do // Looping through this
    {

      System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
      System.out.println();
      spacing("Welcome to Problem Set 3");
      spacing("Kai Huang ~ 09/02/2016");
      System.out.println();
      System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
      System.out.println();
      spacing("Choices");
      System.out.println();
      spacing("1: Product");
      spacing("2: Factorial");
      spacing("3: Invest");
      System.out.println();
      spacing("0: Exit");
      System.out.println();
      System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
      System.out.println();
      spacing("Choice: ", 1);

      choice = sc.nextInt(); // Read user's choice

      System.out.println();

      if(choice == 1)
      {

        product(); // Question 1

      }

      else if(choice == 2)
      {

        factorial(); // Question 2

      }

      else if(choice == 3)
      {

        invest(); // Question 3

      }

      else if(choice != 0) // Failsafe; warns user if they've entered a command out of bounds
      {

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println();
        spacing("Please enter a valid command.");
        System.out.println();

      }


    } while (choice != 0); // Terminates if choice is 0

    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    System.out.println();
    spacing("Farewell, good sir."); // Termination message
    System.out.println();
    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

  }


}
