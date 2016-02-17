/*

Problem Set 4
Kai Huang
16 February 2016

*/

import java.util.Scanner; // Import Scanner libraries

public class HK_Set4
{

  static Scanner sc; // Initalize scanner object

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

  public static void invest2() // Problem 3; Invest
  {

    double rate, earn, deposit, target; // Set up variables
    double bal = 0;

    int counter = 0;

    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    System.out.println();
    spacing("Welcome to the Invest2 program!");
    System.out.println();
    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    System.out.println();
    spacing("Enter your Monthly Deposit ($): ", 3);

    deposit = sc.nextDouble(); // Prompt for; recieve deposit

    spacing("Enter your Annual Interest Rate (%): ", 2);

    rate = (( sc.nextDouble() / 12) / 100); // Prompt for; recieve yearly interest (Immediately convert it to be decimal representation of monthly interest)

    spacing("Enter your Target Value: ", 4);

    target = sc.nextDouble(); // Prompt for; recieve target value

    // Set up output chart

    System.out.println();
    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    System.out.println();
    System.out.println("        Starting         Interest         Monthly         Ending");
    System.out.println("        Balance           Earned          Deposit         Balance ");
    System.out.println();
    System.out.println("        ---------------------------------------------------------");
    System.out.println();

    while(bal <= target) // Looping until we end up at our desired final value
    {

      counter += 1; // Increment the counter; keep track of how many months have passed

      for(int j = 0; j < ( 16 - String.format("%.2f", bal).length() ); j++) // Algorithm to ensure that spacing is right - aligned based on taking length of the double as a String and subtracting that from constant blank spaces
      {

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

    spacing("It took " + counter + " months to reach your target."); // Output number of months it took to reach the target value
    System.out.println();


  }

  public static void bankAccount()
  {

    int counter = 0; // Set up variables
    double bal, with;
    double dep = 0;

    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    System.out.println();
    spacing("Welcome to the Bank Account Program!");
    System.out.println();
    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    System.out.println();
    spacing("Enter your Starting Balance ($): ", 4);

    bal = sc.nextDouble(); // Prompt for, recieve starting balance

    System.out.println();
    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    System.out.println();

    while(bal > 0) // as long as the balance isn't below 0
    {

      counter += 1; // increment the counter to keep track of the iterations

      spacing("Month #" + counter); // output iteration number (in this case, the month)
      System.out.println();
      spacing("Deposits: ", 3);

      dep = sc.nextDouble(); // prompt for, recieve deposit

      if(dep == -1) // if the deposit happens to be -1
      {

        System.out.println();
        break; // break out of the loop immediately (so as to not execute the next portions of the code)

      }

      spacing("Withdrawls: ", 3);

      with = sc.nextDouble(); // prompt for, recieve withdrawl

      bal += dep; // add the deposit to the balance
      bal -= with; // subtract the withdrawl from the balance

      System.out.println();

    }

    if(bal > 0) // if the loop ended due to the break statement
    {

      System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
      System.out.println();
      spacing("You have $" + String.format("%.2f", bal) + " left."); // output the remaining money
      System.out.println();

    }

    else // if the loop ended because the balance fell below 0
    {

      System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
      System.out.println();
      spacing("You have run out of money!"); // casually reminds the user that they're now bankrupt
      spacing("You are $" + (String.format("%.2f", -bal)) + " in debt!"); // conveinently also makes them aware of how much money they owe the bank
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
      spacing("Welcome to Problem Set 4");
      spacing("Kai Huang ~ 16/02/2016");
      System.out.println();
      System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
      System.out.println();
      spacing("Choices");
      System.out.println();
      spacing("1: Invest2");
      spacing("2: BankAccount");
      spacing("3: HiLo");
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

        invest2(); // Question 1

      }

      else if(choice == 2)
      {

        bankAccount(); // Question 2

      }

      else if(choice == 3)
      {

        //hiLo(); // Question 3

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