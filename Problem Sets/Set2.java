/*

Problem Set 2
Kai Huang
8 February 2016

*/

import java.util.Scanner;

public class Set2
{

  static Scanner sc; // Initalize the Scanner for I/O

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

        // pizza(); // Question 1

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
