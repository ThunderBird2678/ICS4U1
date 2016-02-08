/*

Problem Set 2
Kai Huang
8 February 2016

*/

import java.util.Scanner;

public class Set2
{

  static Scanner sc; // Initalize the Scanner for I/O

  public static void pizza()
  {

    int numPizzas; // Set up variables
    char size;
    String input;

    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    System.out.println();
    System.out.println("         Welcome to the Pizza program!");
    System.out.println();
    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    System.out.println();
    System.out.print("             Number of Pizzas: ");

    numPizzas = sc.nextInt(); // Prompt for; recieve number of Pizzas

    sc.nextLine(); // Empty Scanner buffer

    System.out.print("                Size (S,M,L): ");

    size = sc.nextLine().charAt(0); // Prompt for; recieve size of pizzas

    System.out.println();

    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    System.out.println();

    switch(size)
    {

      case 'S': case 's': // Ordering small pizzas

        System.out.print("            " + numPizzas + " @ $6.99 = $");
        System.out.format("%.2f%n", (6.99 * numPizzas)); // Calculates, returns cost (formatted to two decimal places)
        System.out.println();
        break; // Breaks out of case

      case 'M': case 'm': // Ordering medium pizzas

        System.out.print("            " + numPizzas + " @ $8.99 = $");
        System.out.format("%.2f%n", (8.99 * numPizzas)); // Calculates, returns cost (formatted to two decimal places)
        System.out.println();
        break; // Breaks out of case

      default: // Ordering large pizzas (or anything, really, since an invalid size is meant to result in a large pizza)

        System.out.print("            " + numPizzas + " @ $10.99 = $");
        System.out.format("%.2f%n", (10.99 * numPizzas)); // Calculates, returns cost (formatted to two decimal places)
        System.out.println();
        break; // Breaks out of case

    }

  }

  public static void equation()
  {

    sc = new Scanner (System.in);

    int a, b;

    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    System.out.println();
    System.out.println("         Welcome to the Equation program!");
    System.out.println();
    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    System.out.println();
    System.out.print("                         A: ");

    a = sc.nextInt(); // Prompt for, recieve A

    System.out.print("                         B: ");

    b = sc.nextInt(); // Prompt for; recieve B

    System.out.println();

  }

  public static void main (String [] args)
  {

    sc = new Scanner (System.in);

    int choice; // Set up choice variable

    do // Looping through this
    {

      System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
      System.out.println();
      System.out.println("           Welcome to Problem Set 2");
      System.out.println("            Kai Huang ~ 08/02/2016");
      System.out.println();
      System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
      System.out.println();
      System.out.println("                   Choices");
      System.out.println();
      System.out.println("                  1: Pizza");
      System.out.println("                 2: Equation");
      System.out.println("                 3: Paycheque");
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

        pizza(); // Question 1

      }

      else if(choice == 2)
      {

        // equation(); // Question 2

      }

      else if(choice == 3)
      {

        // paycheque(); // Question 3

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
