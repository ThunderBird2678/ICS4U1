/*

Problem Set 5
Kai Huang
22 February 2016

*/

import java.util.*;
import java.lang.Math;

public class HK_Set5
{

  static Scanner sc; // Initalize the scanner Object
  static Random rn; // Initalize the Random Object

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

  public static void title(String input)
  {

    System.out.println();
    spacing("--------------------------------");
    System.out.println();

    // Begin massive section to format this properly

    System.out.print("                     |");

    for(int i = 0; i < (28-input.length())/2; i++)
    {

      System.out.print(" ");

    }

    System.out.print(input);

    for(int i = 0; i < (28-input.length())/2; i++)
    {

      System.out.print(" ");

    }

    System.out.println("|");

    // End massive section to format this properly

    System.out.println();
    spacing("--------------------------------");
    System.out.println();

  }

  public static int getRandom(int r1, int r2)
  {

    int n2 = Math.max(r1, r2);
    int n1 = Math.min(r1, r2);

    int randomNum = rn.nextInt(n2 - n1) + n1 + 1;

    return randomNum;

  }

  public static char readChar(char c1, char c2)
  {

    char ch1, ch2, read;

    if(c1 > c2)
    {

      ch2 = c1;
      ch1 = c2;

    }

    else
    {

      ch2 = c2;
      ch1 = c1;

    }

    System.out.println();
    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    System.out.println();
    spacing("The range specified is from " + ch1 + " to " + ch2 + ".");
    System.out.println();
    spacing("Enter a character in the range: ", 1);

    read = sc.nextLine().charAt(0);

    System.out.println();

    while(ch1 > read || ch2 < read)
    {

      System.out.println();
      System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
      System.out.println();
      spacing("The character was not within the range " + ch1 + " to " + ch2 + ".");
      System.out.println();
      spacing("Please try again.");
      System.out.println();
      spacing("Enter a character in the range: ", 1);

      read = sc.nextLine().charAt(0);

      System.out.println();

    }

    return read;

  }

  public static char readChar(String validList)
  {

    char read;
    char vals[] = new char[validList.length()];
    String show = "";

    for(int i = 0; i < validList.length(); i ++)
    {

      vals[i] = validList.charAt(i);

    }

    for(int i = 0; i < validList.length(); i++)
    {

      show += (vals[i] + ", ");

    }

    System.out.println();
    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    System.out.println();
    spacing("Valid Characters: " + show + ".");
    System.out.println();
    spacing("Enter a valid character: ", 1);

    read = sc.nextLine().charAt(0);

    boolean res = false;

    System.out.println();

    for(int i = 0; i < vals.length; i++)
    {

      if(read == vals[i])
      {

        res = true;

      }

    }

    while(res == false)
    {

      System.out.println();
      System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
      System.out.println();
      spacing("The character was not part of the valid list");
      System.out.println();
      spacing("Please try again.");
      System.out.println();
      spacing("Enter a valid character: ", 1);

      read = sc.nextLine().charAt(0);

      for(int i = 0; i < vals.length; i++)
      {

        if(read == vals[i])
        {

          res = true;

        }

      }

      System.out.println();

    }

    return read;

  }

  public static int lcm(int n1, int n2)
  {

    int temp = n1;

    if(n1 < 1 || n2 < 1)
    {

      return 0;

    }

    else
    {

      while(n1 % n2 != 0)
      {

        n1 += temp;

      }

      return n1;
    }

  }

  public static void main (String [] args)
  {

    sc = new Scanner (System.in); // Define Scanner Object
    rn = new Random();

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
      spacing("1: The LCM Machine");
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

        spacing(" ", 1);
        int t1 = sc.nextInt();
        System.out.println();
        spacing(" ", 1);
        int t2 = sc.nextInt();
        System.out.println();
        spacing("Output: " + lcm(t1, t2));

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
