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

  public static Scanner sc; // Set up Scanner Object
  public static Array arr = new Array(); // Set up Array Object

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

  public static void drEnter() // Driver Method for enter() Array Object Method
  {

    arr.enter(); // no parameters or instructions needed, simply call Method

    pause(); // wait for keystroke

  }

  public static void drPrint() // driver method for Array.print()
  {

    arr.print(); // no parameters / instructions needed, simply call method

    pause(); // wait for keystroke

  }

  public static void drSearch() // driver method for Array.search()
  {

    spacing("What would you like to search for?");
    spacing("Enter the full last name or its first letter."); // prompt for, recieve input
    System.out.println();
    spacing("Search: ", 5);

    String searchFor = sc.nextLine(); // sets it up as a string by default

    System.out.println();

    Array res = new Array(); // Initalize a new array object for the solution

    if(searchFor.length() == 1) // If the user entered simply a character
    {

      char searchChar = searchFor.charAt(0); // convert the input into a character to be sent to array.search(char)
      res = arr.search(searchChar);

      System.out.println();
      spacing("The array of all matches is as follows:"); // display result
      res.print(); // use the array.print() method with the result array we created

    }

    else if(searchFor.length() < 1) // if the user did not enter anything
    {

      System.out.println();
      spacing("Your input was invalid. "); // tell them that their input does not work
      System.out.println();

    }

    else // in any other case, the user entered the full last name
    {

      res = arr.search(searchFor); // run Array.search(String)
      spacing("The array of all matches is as follows:");
      res.print(); // display results

    }

    System.out.println();

    pause(); // wait for keystroke

  }

  public static void drAdd() // driver for Array.add()
  {

    spacing("Please enter a name in the format LastName, FirstName"); // Tell them the format and prompt for input
    spacing("Name: ", 9);

    String toAdd = sc.nextLine(); // read the input

    System.out.println();
    arr.add(toAdd); // and add it to the array
    spacing("The name has been added."); // tell user operation has been performed
    System.out.println();

    pause(); // wait for keystroke

  }

  public static void drRemove() // driver method for Array.rermove()
  {

    spacing("Please enter the number of the name you wish to remove."); // tell them the format and prompt for input
    spacing("Number: ", 1);

    int toRemove = sc.nextInt(); // read the input

    System.out.println();
    arr.remove(toRemove); // and based off that, remove the corresponding element from the Array
    spacing("The name has been removed."); // tell user operation has been performed
    System.out.println();

    pause(); // wait for keystroke

  }

  public static void drSort() // driver method for sort()
  {

    spacing("Sorting the list..."); // telling user what's going on
    arr.sort();
    spacing("The list has been sorted."); // essentially returning a success flag
    System.out.println();

    pause(); // wait for keystroke

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

      if(choice == 1) // A whole bunch of choices
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

        drAdd();

      }

      else if(choice == 5)
      {

        drRemove();

      }

      else if(choice == 6)
      {

        drSort();

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
