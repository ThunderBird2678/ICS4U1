/*

Problem Set 1
Kai Huang
8 February 2016

*/

import java.util.Scanner; // Import the Scanner that will be used for I/O operations

public class HK_Set1
{

  static Scanner sc; // Initialize the Scanner

  public static void interest() // Problem 1: Interest
  {

    int principal; // Set up variables
    double interestRate;

    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    System.out.println();
    System.out.println("        Welcome to the Interest program!");
    System.out.println();
    System.out.print("                Principal ($): ");

    principal = sc.nextInt(); // Prompt for; recieve principal amount

    System.out.print("              Interest Rate (%): ");

    interestRate = sc.nextDouble(); // Prompt for; recieve interest rate

    System.out.println();
    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

    double year1, year2; // Set up variables

    year1 = principal * (interestRate / 100); // Generate results

    year2 = (principal + year1) * (interestRate / 100);

    System.out.println();
    System.out.format("           Year 1 Interest: $%.2f%n", year1); // Output results with formatting
    System.out.format("           Year 2 Interest: $%.2f%n", year2);

    // System.out.println("           Year 2 Interest:" + year2); (Debug statement without formatting)

    System.out.println();

    sc.nextLine(); // Waits for keystroke before returning to menu
    sc.nextLine(); // Catches newline from previous

  }

  public static void arithmetic() // Problem 2: Arithmetic
  {

    int operand1, operand2; // Set up variables

    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    System.out.println();
    System.out.println("      Welcome to the Arithmetic program!");
    System.out.println();
    System.out.print("                 Operand 1:");

    operand1 = sc.nextInt(); // Prompt for; recieve operand 1

    System.out.print("                 Operand 2:");

    operand2 = sc.nextInt(); // Prompt for; recieve operand 2

    System.out.println();
    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    System.out.println();
    System.out.println("                 " + operand1 + " + " + operand2 + " = " + (operand1 + operand2)); // Simple calculations are simply output
    System.out.println("                 " + operand1 + " - " + operand2 + " = " + (operand1 - operand2));
    System.out.println("                 " + operand1 + " * " + operand2 + " = " + (operand1 * operand2));

    double divAnswer = (double)operand1 / (double)operand2; // Utilizing floating point accuracy for division

    System.out.print("                 " + operand1 + " / " + operand2 + " = "); // Output results
    System.out.format("%.2f%n", divAnswer); // Output formatted quotient, rounded off to two decimal places
    System.out.println();

    sc.nextLine(); // Waits for keystroke before returning to menu
    sc.nextLine(); // Catches newline from previous

  }

  public static void receipt() // Question 3; Receipt
  {

    double price; // Set up variables
    int quantity;

    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    System.out.println();
    System.out.println("      Welcome to the Receipt program!");
    System.out.println();
    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    System.out.println();
    System.out.println("           Enter Item Information:");
    System.out.println();
    System.out.print("              Price ($): ");

    price = sc.nextDouble(); // Prompt for; recieve price


    System.out.print("               Quantity: ");

    quantity = sc.nextInt(); // Prompt for; recieve quantity

    System.out.println();
    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    System.out.println();
    System.out.println("          Here is your receipt.");
    System.out.println();
    System.out.print("            " + quantity);
    System.out.format(" x $%.2f", price); // outputs price, displaying 2 decimal places
    System.out.format(" = $%.2f%n", (quantity * price)); // outputs final costs, 2 decimal places
    System.out.println();

    sc.nextLine(); // Waits for keystroke before returning to menu
    sc.nextLine(); // Catches newline from previous

  }

  public static void main (String [] args) // Main Method; Start Here
  {

    sc = new Scanner (System.in); // Define Scanner Object

    int choice; // Set up choice variable

    do // Looping through this
    {

      System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
      System.out.println();
      System.out.println("           Welcome to Problem Set 1");
      System.out.println("            Kai Huang ~ 08/02/2016");
      System.out.println();
      System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
      System.out.println();
      System.out.println("                   Choices");
      System.out.println();
      System.out.println("                 1: Interest");
      System.out.println("                2: Arithmetic");
      System.out.println("                 3: Receipt");
      System.out.println();
      System.out.println("                   0: Exit");
      System.out.println();
      System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
      System.out.println();
      System.out.print("                 Choice: ");

      choice = sc.nextInt(); // Read user's choice

      System.out.println();

      if(choice == 1)
      {

        interest(); // Question 1

      }

      else if(choice == 2)
      {

        arithmetic(); // Question 2

      }

      else if(choice == 3)
      {

        receipt(); // Question 3

      }

      else if(choice != 0) // Failsafe; warns user if they've entered a command out of bounds
      {

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println();
        System.out.println("          Please enter a valid command.");
        System.out.println();

      }


    } while (choice != 0); // Terminates if choice is 0

    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    System.out.println();
    System.out.println("             Farewell, good sir."); // Termination message
    System.out.println();
    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

  }

}
