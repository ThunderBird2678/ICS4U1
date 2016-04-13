/*

Problem Set 7
(Recursion)
Kai Huang
26 February 2016

*/

import java.util.*;
import java.lang.Math;

public class HK_Set7
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

  public static void pause() // Allows user keystroke before returning to menu after debug
  {

    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    System.out.println();
    spacing("Press the <Enter> key to return to the menu."); // prompt for a keystroke

    sc.nextLine(); // take any keystroke

    System.out.println();

  }

  public static int gcfRecur(int n1, int n2)
  {

    if(n1 == n2) // if the two are equal, then they're done
    {

      return n1;

    }

    else if(n1 < n2) // if the second number is larger
    {

      return gcfRecur(n2, n1); // reset the process so the first is larger (allwing us to use general algorithm)

    }

    else // so long as the first is larger than the second
    {

      return gcfRecur(n2, n1 - n2); // take away the second from the first; slowly whittling down the remainder

    }

  }

  public static int gcfIter(int n1, int n2)
  {

    int t1, t2; // temp variables that allow me to reset back and forth

    do // using a dowhile() loop becausse I need to check this at least once
    {

      if(n1 < n2) // if the first is less than the second
      {

        t1 = n2; // rebind t1 and t2 so that t1 is greater than t2
        t2 = n1;

      }

      else // if all is in order
      {

        t1 = n1; // bind t1 and t2 directly corresponding to n1 and n2
        t2 = n2;

      }

      n1 = t1; // rebind n1 and n2 to the order specified in the t - processes
      n2 = t2;

      n1 -= n2; // perform the operation where I whittle down the remainder by subtracting n2 from n1

    } while(n1 != n2); // check to make sure they're not equal and run again

    return n1; // when it's all done, n1 is returned

  }

  public static int fibRecur(int n1, int n2, int librorum, int prohibitorum)
  {

    if(prohibitorum == librorum) // if the desired n is equal to the counter n
    {

      return n1; // simply return n1

    }

    else if(n1 > n2) // if n1 is greater than n2 (shouldn't happen, but it's a failsafe)
    {

      return fibRecur(n2, n1, librorum, prohibitorum); // put them in order and continue (don't increment anything)

    }

    else // if they're not equal and n2 is greater than n2
    {

      return fibRecur(n2 + n1, n2, librorum + 1, prohibitorum); // increment counter, rerun method with n2 set to the sum and n1 set to what was n2

    }

  }

  public static int fibIter(int prohibitorum)
  {

    int librorum = 2; // set up all counters right when the method is initalized (because you don't need to pass them on to further recursions of the method)
    int n1 = 1, n2 = 1;
    int t1, t2;

    do // running with a dowhile because we need to check at least once
    {

      t2 = n2 + n1; // use temp variables to allow for sorting
      t1 = n2;

      n2 = t2; // put this all in order with the increments in place
      n1 = t1;

      librorum ++; // increment counter

    } while (librorum < prohibitorum); // check to see if my counter is equal to my desired n

    return n2; // if so, return the final value

  }

  public static void drGcfRecur()
  {

    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    System.out.println();
    spacing("Welcome to the (Recursive) GCF program!");
    System.out.println();
    spacing("Enter the first number: ", 2);

    int input1 = sc.nextInt(); // prompt, recieve first parameter
    sc.nextLine(); // clear buffer

    System.out.println();

    spacing("Enter the second number: ", 2);

    int input2 = sc.nextInt(); // prompt, recieve second parameter
    sc.nextLine(); // clear buffer

    System.out.println();
    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    System.out.println();
    spacing("The GCF of " + input1 + " and " + input2 + " is: "); // shows output
    System.out.println();
    spacing("" + gcfRecur(input1, input2)); // directly print method's return
    System.out.println();

    pause(); // waits for keystroke

  }

  public static void drGcfIter()
  {

    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    System.out.println();
    spacing("Welcome to the (Iterative) GCF program!");
    System.out.println();
    spacing("Enter the first number: ", 2);

    int input1 = sc.nextInt(); // prompt, recieve first parameter
    sc.nextLine(); // clear buffer

    System.out.println();

    spacing("Enter the second number: ", 2);

    int input2 = sc.nextInt(); // prompt, recieve second parameter
    sc.nextLine(); // clear buffer

    System.out.println();
    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    System.out.println();
    spacing("The GCF of " + input1 + " and " + input2 + " is: "); // shows output
    System.out.println();
    spacing("" + gcfIter(input1, input2)); // directly print method's return
    System.out.println();

    pause(); // waits for keystroke

  }

  public static void drFibRecur()
  {

    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    System.out.println();
    spacing("Welcome to the (Recursive) Fibonacci program!");
    System.out.println();
    spacing("Enter the term you would like to reach: ", 2);

    int input = sc.nextInt(); // prompt, recieve input
    sc.nextLine(); // clear buffer

    System.out.println();
    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    System.out.println();
    spacing("The Fibonacci number at n = " + input + " is:");
    System.out.println();
    spacing("" + fibRecur(1, 1, 2, input)); // output result directly from method call
    System.out.println();

    pause(); // wait for keystroke

  }

  public static void drFibIter()
  {

    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    System.out.println();
    spacing("Welcome to the (Iterative) Fibonacci program!");
    System.out.println();
    spacing("Enter the term you would like to reach: ", 2);

    int input = sc.nextInt(); // prompt, recieve input
    sc.nextLine(); // clear buffer

    System.out.println();
    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    System.out.println();
    spacing("The Fibonacci number at n = " + input + " is:");
    System.out.println();
    spacing("" + fibIter(input)); // output result directly from method call
    System.out.println();

    pause(); // wait for keystroke

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
      spacing("Welcome to Problem Set 7 (Recursion)");
      spacing("Kai Huang ~ 09/02/2016");
      System.out.println();
      System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
      System.out.println();
      spacing("Choices");
      System.out.println();
      spacing("1: GCF (Recursive)");
      spacing("2: GCF (Iterative)");
      spacing("3: Fibonacci (Recursive)");
      spacing("4: Fibonacci (Iterative)");
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

        drGcfRecur();

      }

      else if(choice == 2)
      {

        drGcfIter();

      }

      else if(choice == 3)
      {

        drFibRecur();

      }

      else if(choice == 4)
      {

        drFibIter();

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
