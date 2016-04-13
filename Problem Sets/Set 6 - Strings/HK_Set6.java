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

  public static String key = "HOAZXJRTUYBIVEWKLSNCDMFGPQ" + ("HOAZXJRTUYBIVEWKLSNCDMFGPQ".toLowerCase());

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

  public static boolean alphabet(char checking) // allows me to determine if a character is in the alphabet; specified to only work on uppercase characters
  {

    boolean res = false; // result is false by default

    if(65 <= checking && 90 >= checking) // character ranges are 65 (A) to 90 (Z)
    {

      res = true; // flips result flag over to true if it's valid

    }

    else if(97 <= checking && 122 >= checking) // character ranges are 97 (a) to 122 (z)
    {

      res = true; // as above

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

    String res = ""; // the result that will be returned in the end

    for(int i = 0; i < toBeShifted.length(); i++) // loops through all values in the uppercase String;
    {

      if(alphabet(toBeShifted.charAt(i)) == true) // First of all, it has to be an alphabetical character
      {

        if(toBeShifted.charAt(i) < 123 && toBeShifted.charAt(i) > 96) // first, if it's lowercase...
        {

          if((toBeShifted.charAt(i) + (shift % 26)) > 122) // if the shift places it outside of the far bound (Note: shift is always calculated as shift%26 since it loops around anyway)
          {

            res += (char)(96 + ((shift % 26) - (122 - toBeShifted.charAt(i)))); // twist it around to the front again; using 122 and not 123 to take account for the fact that A is part of the shift

          }

          else if((toBeShifted.charAt(i) + (shift % 26)) < 97) // same method, but if it's inside of the near bound;
          {

            res += (char)(123 + ((shift % 26) - (toBeShifted.charAt(i) - 97))); // again, 123 instead of 122 since Z is part of the shift

          }

          else // otherwise, just shift it directly
          {

            res += (char)(toBeShifted.charAt(i) + (shift % 26));

          }


        }

        else // so if it's lowercase
        {

          if((toBeShifted.charAt(i) + (shift % 26)) > 90) // if the shift places it outside of the far bound (Note: shift is always calculated as shift%26 since it loops around anyway)
          {

            res += (char)(64 + ((shift % 26) - (90 - toBeShifted.charAt(i)))); // twist it around to the front again; using 64 and not 65 to take account for the fact that A is part of the shift

          }

          else if((toBeShifted.charAt(i) + (shift % 26)) < 65) // same method, but if it's inside of the near bound;
          {

            res += (char)(91 + ((shift % 26) - (toBeShifted.charAt(i) - 65))); // again, 91 instead of 90 since Z is part of the shift

          }

          else // otherwise, just shift it directly
          {

            res += (char)(toBeShifted.charAt(i) + (shift % 26));

          }

        }

      }

      else // if it's not a alphabetical character, just add it directly
      {

        res += toBeShifted.charAt(i);

      }

    }

    return res;

  }

  public static String shuffle(boolean both)
  {

    String alpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz"; // the total alphabet
    String res = "";
    String tempResLower; // temporary variable
    char moving; // the current char being operated upon

    int counter = 0; // loop counter

    for(int i = 0; i < 26; i++) // loop through all 26 values (we need to replicate the length, obviously)
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

    tempResLower = res.toLowerCase(); // create a new version of the key that's lowercase
    res += tempResLower; // append the new version to the result that's returned

    return res; // returns the now generated mixup

  }

  public static String cryptoCode(String toBeShifted, String mixer)
  {

    String alpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    String res = ""; // result

    //String mixer = "HOAZXJRTUYBIVEWKLSNCDMFGPQ"; (This is the test case)

    char working; // working character
    int finder = 0; // index of alphabet / mixed alphabet



    for(int i = 0; i < toBeShifted.length(); i++) // loop through the entire string
    {

      working = toBeShifted.charAt(i); // set up the character I will be checking

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

  public static String decodeCode(String scramble, String key)
  {

    String alpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    String res = "";

    char working;
    int finder = 0;

    for(int i = 0; i < scramble.length(); i++)
    {

      working = scramble.charAt(i);

      if(alphabet(working) == true)
      {

        finder = key.indexOf(working);
        res += alpha.charAt(finder);

      }

      else
      {

        res += working;

      }

    }

    return res;

  }

  public static void drPalindrome()
  {

    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    System.out.println();
    spacing("Welcome to the Palindrome program!");
    System.out.println();
    spacing("Enter your string of text: ", 15);

    String palInput = sc.nextLine(); // prompt for input

    System.out.println();

    boolean result = palindrome(palInput); // send the input to palindrome method

    if(result == true) // displays results if true
    {

      System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
      System.out.println();
      spacing("\"" + palInput + "\" is a palindrome!");
      System.out.println();

    }

    else // displays results if false
    {

      System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
      System.out.println();
      spacing("\"" + palInput + "\" is not a palindrome.");
      System.out.println();

    }

    pause(); // wait for keystroke

  }

  public static void drShiftCode()
  {

    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    System.out.println();
    spacing("Welcome to the ShiftCode program!");
    System.out.println();
    spacing("Enter the text you would like to shift: ", 15); // prompts for text

    String sftInput1 = sc.nextLine();

    System.out.println();

    spacing("Enter your shift value: ", 2); // prompts for the shifting

    int sftInput2 = sc.nextInt();

    System.out.println();

    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    System.out.println();
    spacing("\"" + sftInput1 + "\" shifted by " + sftInput2 + " results in:"); // outputs shift results
    System.out.println();
    spacing(shiftCode(sftInput1, sftInput2));
    System.out.println();

    sc.nextLine();

    pause(); // waits for keystroke

  }

  public static void drCryptoCode()
  {

    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    System.out.println();
    spacing("Welcome to the CryptoCode program!");
    System.out.println();
    spacing("Enter the text you would like to encode: ", 15); // prompts for text input

    String cptInput = sc.nextLine();

    System.out.println();
    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    System.out.println();

    key = shuffle(false); // shuffles alphabet and stores it in variable

    spacing("The scrambled alphabet generated was: ");

    System.out.println();

    spacing(key); // tells user the code

    System.out.println();

    spacing("Using that to encode " + "\"" + cptInput + "\" results in:"); // outputs result

    System.out.println();

    spacing(cryptoCode(cptInput, key));

    System.out.println();

    pause(); // prompt for keystroke

  }

  public static void drDeCodeCode()
  {

    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    System.out.println();
    spacing("Welcome to the CryptoCode program!");
    System.out.println();
    spacing("Enter the text you would like to decode: ", 15); // prompts for text input

    String dccInput = sc.nextLine();

    System.out.println();
    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    System.out.println();

    spacing("What do you wish to use as your key?"); // asks for a key input
    System.out.println();
    spacing("1: Mr. Jay's Default Key");
    spacing("2: The Key Currently in Memory");
    spacing("3: Enter Your Own (As individual characters)");
    spacing("4: Enter Your Own (As a single String)");
    System.out.println();
    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    System.out.println();
    spacing("Choice: ", 1);

    int dccChoice = sc.nextInt(); // takes in user's choice

    System.out.println();

    sc.nextLine();

    if(dccChoice == 1) // if they want the default example key
    {

      key = "HOAZXJRTUYBIVEWKLSNCDMFGPQ" + ("HOAZXJRTUYBIVEWKLSNCDMFGPQ".toLowerCase()); // set up the key variable accordingly

    }

    // note: there is no if statement for 2, since 2 just grabs it from the memory; the only reason I have this line is to prevent 2 from triggering the else

    else if(dccChoice == 2){}

    else if(dccChoice == 3) // when the user inputs their own key manually through characters
    {

      String res = ""; // the final result that will be used
      char loadIn; // the individual characters

      for(int i = 0; i < 26; i++) // looping through the basic alphabet
      {

        spacing("What would you like the letter <" + (char)(i + 65) + "> to be? :", 1); // prompts for character

        loadIn = sc.nextLine().charAt(0);

        System.out.println();

        while(alphabet(loadIn) == false) // character is checked to make sure it's part of the alphabet
        {

          System.out.println();
          spacing("That was not a letter. Please try again."); // if it's not, program alerts user and makes them try again
          spacing("What would you like the letter <" + (char)(i + 65) + "> to be? :", 1);

          loadIn = sc.nextLine().charAt(0);

          System.out.println();

        }

        res += loadIn; // loads the valid response into the res string
        key = res.toUpperCase(); // key is the entire res portion converted to uppercase
        res = key.toLowerCase(); // res is then set to the lowercase ver (to accomodate for both uppercase and lowercase)
        key += res; // res is then concatenated to the end ofkey

      }

    }

    else if(dccChoice == 4)
    {

      spacing("Enter your key: ");
      System.out.println();
      key = sc.nextLine(); // the assumption is that if the user's using this option, they have the key properly formatted
      System.out.println();

    }

    else // anything that wasn't covered and isn't 2 is invalid
    {

      spacing("You have entered an invalid command.");
      spacing("Program will decode your string with the current key.");
      System.out.println();

    }

    spacing("Decoding your String with the following key: ");
    spacing(key);
    System.out.println();
    spacing("Using that to encode " + "\"" + dccInput + "\" results in:");
    System.out.println();
    spacing(decodeCode(dccInput, key)); // output the results
    System.out.println();

    pause();

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
      spacing("4: DecodeCode");
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

        drPalindrome();

      }

      else if(choice == 2)
      {

        drShiftCode();

      }

      else if(choice == 3)
      {

        drCryptoCode();
      }

      else if(choice == 4)
      {

        drDeCodeCode();

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
