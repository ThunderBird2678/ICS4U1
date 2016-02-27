/*

Problem Set 6
(Strings)
Kai Huang
26 February 2016

*/

import java.util.*;
import java.lang.Math;

public class HK_Set6
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
    spacing("Press any key to return to the menu."); // prompt for a keystroke

    sc.nextLine(); // take any keystroke

    System.out.println();

  }

  public static boolean alphabet(char checking) // allows me to determine if a character is in the alphabet; specified to only work on uppercase characters
  {

    boolean res = false; // result is false by default

    if(65 <= checking && 90 >= checking) // character ranges are 65 (A) to 90 (Z)
    {

      res = true; // flips result flag over to true if it's valid

    }

    return res; // returns the true/false

  }

  public static boolean palindrome(String inputForCheck)
  {

    int points = 0; // set up variables
    String checking; // new string that contains everything in uppercase
    String mod = ""; // new string that we'll be checking for palindrome on
    boolean res = false; // the result to be returned

    checking = inputForCheck.toUpperCase(); // sets it all in uppercase just to make sure

    for(int i = 0; i < checking.length(); i++) // iterates through the completely uppercase string, removes all non - alphabet charracters
    {

      if(alphabet(checking.charAt(i)) == true) // using my previously written alphabet method
      {

        mod += checking.charAt(i); // add the value if valid to the string that will be checked

      }

    }

    for(int i = 0; i < mod.length(); i++) // iterating through string that only contains the bare alphabetical characters
    {

      if(mod.charAt(i) == mod.charAt(mod.length() - (i+1))) // comparing the beginning character to the end and move inwards
      {

        points += 1; // add a point if it's valid; points must be equal to length for it to be palindrome

      }

    }

    if(points == mod.length()) // check that the matches are the same number as the string's length
    {

      res = true; // flips flag over to true

    }

    return res; // returns the result

  }

  public static String shiftCode(String toBeShifted, int shift)
  {

    String upper = toBeShifted.toUpperCase(); // convert it all to uppercase first
    String res = ""; // the result that will be returned in the end

    for(int i = 0; i < upper.length(); i++) // loops through all values in the uppercase String; 3 options
    {

      if(alphabet(upper.charAt(i)) == true) // First of all, it has to be an alphabetical character
      {

        if((upper.charAt(i) + shift) > 90) // if the shift places it outside of the far bound
        {

          res += (char)(64 + (shift - (90 - upper.charAt(i)))); // twist it around to the front again; using 64 and not 65 to take account for the fact that A is part of the shift

        }

        else if((upper.charAt(i) + shift) < 65) // same method, but if it's inside of the near bound;
        {

          res += (char)(91 + (shift - (upper.charAt(i) - 65))); // again, 91 instead of 90 since Z is part of the shift

        }

        else // otherwise, just shift it directly
        {

          res += (char)(upper.charAt(i) + shift);

        }

      }

      else // if it's not a alphabetical character, just add it directly
      {

        res += upper.charAt(i);

      }

    }

    return res;

  }

  public static String shuffle()
  {

    String alpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"; // the total alphabet
    String res = "";
    char moving; // the current char being operated upon

    int counter = 0; // loop counter

    for(int i = 0; i < alpha.length(); i++) // loop through all 26 values (we need to replicate the length, obviously)
    {

      counter = 0; // reset the counter every time

      moving = alpha.charAt(rn.nextInt(26));

      while(counter < res.length()) // as long as we don't go out of bounds
      {

        while(moving == res.charAt(counter)) // constantly regenrate until no duplication
        {

          moving = alpha.charAt(rn.nextInt(26)); // regenerate

          counter = 0; // and then set counter to 0, to run the whole process again

        }

        counter++; // increments the counter every time

      }

      res += moving; // add on the character that was finalized

    }

    return res; // returns the now generated mixup

  }

  public static String cryptoCode(String toBeShifted)
  {

    String upper = toBeShifted.toUpperCase(); // convert it all to uppercase for ease of use
    String alpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    String mixer = shuffle(); // Uses my above shuffle method to generate a random shuffle of the alphabet
    String res = ""; // result

    //String mixer = "HOAZXJRTUYBIVEWKLSNCDMFGPQ"; (This is the test case)

    char working; // working character
    int finder = 0; // index of alphabet / mixed alphabet



    for(int i = 0; i < upper.length(); i++) // loop through the entire string (uppercase version obviously)
    {

      working = upper.charAt(i); // set up the character I will be checking

      if(alphabet(working) == true) // as long as it is an alphabetical character
      {

        finder = alpha.indexOf(working); // find what order it's in from the alphabet
        res += mixer.charAt(finder); // call out that index from the scrambled alphabet and add it to my result string

      }

      else
      {

        res += working; // if it's not alphabetical, then just add the character directly

      }

    }

    return res; // return the result

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
      spacing("Welcome to Problem Set 6");
      spacing("Kai Huang ~ 09/02/2016");
      System.out.println();
      System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
      System.out.println();
      spacing("Choices");
      System.out.println();
      spacing("1: Palindrome");
      spacing("2: ShiftCode");
      spacing("3: CryptoCode");
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

        String input = sc.nextLine();
        spacing(cryptoCode(input));

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
