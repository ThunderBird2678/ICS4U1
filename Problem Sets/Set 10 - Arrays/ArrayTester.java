/*

Kai Huang
ICS4U1
Problem Set 10: Arrays
13 April 2016

*/

import java.io.*;
import java.util.Scanner;

public class ArrayTester
{

  public static Scanner sc;
  public static Array arr = new Array();

  public static void spacing( String printed ) // Custom method written in order to center - align output)
  {

    if(printed.length() > 72) // 72 is the length of my dividers, so I'm using that as my maximum value
    {

      System.out.println(printed); // print it directly if it's any larger


    }

    else // provided that it fits
    {

      for(int i = 0; i < (72 - printed.length())/2; i++) // the amount of spaces is simply 72 - length of my output, then divided by 2 to center it with equal spaces on either side
      {

        System.out.print(" "); // outputs the spaces

      }

      System.out.println(printed); // outputs my text; center - aligned

    }

  }

  public static void spacing( String printed, int length ) // overloaded version that is used when I want in-line user input; int length is simply how long I believe the input will be (usually easily estimated)
  {

    if((printed.length() + length) > 72) // as above
    {

      System.out.println(printed);


    }

    else
    {

      for(int i = 0; i < (72 - printed.length() - length)/2; i++) // key thing here is that it also subtracts out a bit more to accomodate for user input
      {

        System.out.print(" ");

      }

      System.out.print(printed); // using .print() instead of .println() here because I want the input in-line

    }

  }

  public static void pause() // Allows user keystroke before returning to menu after debug
  {

    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    System.out.println();
    spacing("Press the <Enter> key to return to the menu."); // prompt for a keystroke

    sc.nextLine(); // take any keystroke

    System.out.println();

  }

  public static void drEnter()
  {

    arr.enter();

    System.out.println();
    pause();

  }

  public static void drPrint()
  {

    arr.print();
    pause();

  }

  public static void drSearch()
  {

    spacing("What would you like to search for?");
    spacing("Enter the full last name or its first letter.");
    System.out.println();
    spacing("Search: ", 5);

    String searchFor = sc.nextLine();
    Array res = new Array();

    if(searchFor.length() == 1)
    {

      char searchChar = searchFor.charAt(0);
      res = arr.search(searchChar);

      System.out.println();
      spacing("The array of all matches is as follows:");
      res.print();

    }

    else if(searchFor.length() < 1)
    {

      System.out.println();
      spacing("Your input was invalid. ");
      System.out.println();

    }

    else
    {

      res = arr.search(searchFor);
      spacing("The array of all matches is as follows:");
      res.print();

    }

    System.out.println();
    pause();

  }

  public static void main (String [] args) throws IOException
  {

    sc = new Scanner(System.in);

    int choice = 0;

    do // Looping through this
    {

      System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
      System.out.println();
      spacing("Welcome to Problem Set 10 (Arrays)");
      spacing("Kai Huang ~ 09/02/2016");
      System.out.println();
      System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
      System.out.println();
      spacing("Choices");
      System.out.println();
      spacing("1: enter()");
      spacing("2: print()");
      spacing("3: search()");
      spacing("4: add()");
      spacing("5: remove()");
      spacing("6: sort()");
      System.out.println();
      spacing("0: Exit");
      System.out.println();
      System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
      System.out.println();
      spacing("Choice: ", 1);

      choice = sc.nextInt(); // Read user's choice

      System.out.println();

      sc.nextLine();

      if(choice == 1)
      {

        drEnter();

      }

      else if(choice == 2)
      {

        drPrint();

      }

      else if(choice == 3)
      {

        drSearch();

      }

      else if(choice == 4)
      {

        // drAdd();

      }

      else if(choice == 5)
      {

        // drRemove();

      }

      else if(choice == 6)
      {

        // drSort();

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
