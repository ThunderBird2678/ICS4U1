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

  public static void pause() // Allows user keystroke before returning to menu after debug
  {

    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    System.out.println();
    spacing("Press any key to return to the menu."); // prompt for a keystroke

    sc.nextLine(); // take any keystroke

    System.out.println();

  }

  public static void title(String input) // title() method
  {

    System.out.println();
    spacing("--------------------------------"); // Display the top border
    System.out.println();

    int spaces = (28 - input.length())/2; // The amount of spaces from the side of the top border to the edges of the screen

    // Begin massive section to format this properly

    System.out.print("                     |"); // Displays the left border (spacing is center aligned to the top border)

    for(int i = 0; i < spaces; i++) // 28 being the space from the left side of the screen to the beginning of the border
    {

      System.out.print(" "); // Print out the spacing

    }

    System.out.print(input); // Output the actual input that's read

    for(int i = 0; i < spaces; i++) // Finish outputting spacing to lead up to the right border
    {

      System.out.print(" "); // Prinpt out more spacing~

    }

    System.out.println("|"); // Output the right border

    // End massive section to format this properly

    System.out.println();
    spacing("--------------------------------"); // Display the bottom border.
    System.out.println();

  }

  public static int getRandom(int r1, int r2) // getRandom() method
  {

    // these two are here to ensure that the lower bound and upper bound are set respectively

    int n2 = Math.max(r1, r2); // n2 is the higher bound; maximum of r1, r2
    int n1 = Math.min(r1, r2); // vice versa of above

    // the range that we want it is from n1 to n2, so we take the difference between them (so generating the number first from 0), and then adding n1 to it to put it within the range.

    int randomNum = rn.nextInt(n2 - n1) + n1 + 1;

    return randomNum; // Method returns the random number generated

  }

  public static char readChar(char c1, char c2) // readChar() method
  {

    char ch1, ch2, read; // set up variables, ch1 and ch2 might seem redundant, but are necessary to set the upper and lower bounds
    String tempRead;

    // Section to find out the max / min values of c1 / c2 to set bounds accordingly
    // Side note: Using Math.max() on characters will cause a compilation error; the JDK warns of precision loss

    if(c1 > c2) // if c1 is the greatest value
    {

      ch2 = c1; // ch2 (higher bound) is set to c1
      ch1 = c2; // the other one is set accordingly

    }

    else // the vice versa statement of above
    {

      ch2 = c2;
      ch1 = c1;

    }

    tempRead = sc.nextLine(); // take in the input as a string first


    boolean valid = false;

    do
    {

      read = (char)(-1);

      if(tempRead.length() > 1) // to ensure that we're looking at a character here
      {

        System.out.println();
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println();
        spacing("One character only, if you please..."); // Tells the user to input a char, not a damn string
        System.out.println();
        spacing("Please try again.");
        System.out.println();
        spacing("Enter a character: ", 1); // prompts for re - read

        tempRead = sc.nextLine();

      }

      else
      {

        read = tempRead.charAt(0); // Sets the read variale to the proper character

        if(ch1 > read || ch2 < read) // keep asking if read is either smaller than the min or larger than the max; it's out of the range
        {

          System.out.println();
          System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
          System.out.println();
          spacing("The character was not within the range " + ch1 + " to " + ch2 + "."); // Tells user range again and describes error
          System.out.println();
          spacing("Please try again.");
          System.out.println();
          spacing("Enter a character: ", 1);

          tempRead = sc.nextLine(); // recieves another input

        }

        else // if none of those if conditions are triggered, the input must be valid
        {

          valid = true;

        }

      }

    } while(valid == false); // triggers at least once, as a failsafe measure

    return read; // If the loop no longer triggers, the read value is valid and is returned

  }

  public static char readChar(String validList) // overloaded readChar() method
  {

    char read; // set up variables
    char vals[] = new char[validList.length()]; // vals is a character array based off the string recieved; there's probably an internal method to do this, but w/e
    String show = "", tempRead;

    for(int i = 0; i < validList.length() - 1; i ++) // looping through the list the first time
    {

      vals[i] = validList.charAt(i); // take the characters from the string and point the array references accordingly
      show += (vals[i] + ","); // Add the characters (apart from the past one) along with a comma to a string that can be output

    }

    vals[vals.length - 1] = validList.charAt(vals.length - 1); // add final character to the array
    show += vals[(vals.length) - 1]; // add final character (without comma)

    boolean res = false; // temporary boolean variable to control loop

    tempRead = sc.nextLine();

    do // No matter what, needs to read input and scan through array at least once
    {

      read = (char)(-1); // set read to something that's invalid

      if(tempRead.length() > 1) // ensure we're reading a character, not a string
      {

        System.out.println();
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println();
        spacing("One character only, if you please..."); // Tells the user what they did wrong
        System.out.println();
        spacing("List: " + show); // Reminds the user of what is valid
        System.out.println();
        spacing("Please try again.");
        System.out.println();
        spacing("Enter a character: ", 1);

        tempRead = sc.nextLine(); // prompts for another input

      }

      else
      {

        read = tempRead.charAt(0); // take the first index of the tempRead variable to be read as the character

        for(int i = 0; i < vals.length; i++) // iterate through the array, check if the character is ever equivalent
        {

          if(read == vals[i]) // if it's equivalent, flip the boolean back
          {

            res = true;

          }

        }

        if(res == false) // only display these error messages if res is still false.
        {

          System.out.println();
          System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
          System.out.println();
          spacing("The character was not part of the valid list."); // Tells the user that their input wasn't valid
          System.out.println();
          spacing("List: " + show); // Reminds the user of what is valid
          System.out.println();
          spacing("Please try again.");
          System.out.println();
          spacing("Enter a valid character: ", 1); // Prompts for the input again

          tempRead = sc.nextLine();

        }

      }

    } while(res == false); // so long as the condition is not met

    System.out.println();

    return read; // return the read character

  }

  public static int lcm(int n1, int n2) // lcm() method
  {

    int temp = n1; // temporary variable used to store initial value of n1 (since n1 will be modified later)

    if(n1 == 0 || n2 == 0) // Just checking if either of the values are zero
    {

      return 0;

    }

    else // As long as they're not zero, continue on
    {

      while(n1 % n2 != 0) // as long as n1 hasn't reached the point where it can divide out n2 perfectly
      {

        n1 += temp; // increment n1 by its initial value; essentially moving up the multiplication table

      }

      return n1; // Return n1 once the modulus has succeeded
    }

  }

  public static void theLcmMachine() // theLcmMachine() method
  {

    int numPairs; // set up variables
    int pairs[];

    title("The LCM Machine"); // use title() method to display the title

    System.out.println();
    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    System.out.println();
    spacing("How many pairs of numbers would you like to process?"); // Prompts for some number pairs
    System.out.println();
    spacing("Pairs (1 - 9): ", 1);

    numPairs = readChar((char)(1+48), (char)(9+48));

    System.out.println();
    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    System.out.println();

    int genOne[] = new int[numPairs-48]; // array to store the first number generated for the lists
    int genTwo[] = new int[numPairs-48]; // array to store the second...

    for(int i = 0; i < numPairs-48; i++) // loop through the lists
    {

      genOne[i] = getRandom(1,100); // use the getRandom() method to generated random numbers from 1 to 100
      genTwo[i] = getRandom(1,100);

    }

    // Output begins here

    System.out.println("              Number 1          Number 2               lCM");  // Begin by outputting this chart; 14 spaces on either side to center it in 72 spaces
    System.out.println();
    System.out.println("              --------------------------------------------");
    System.out.println();

    for(int i = 0; i < numPairs-48; i++) // Looping through both arrays
    {

      for(int j = 0; j < 22 - (String.valueOf(genOne[i])).length(); j++) // Right - alignment output of num1 requires spacing
      {

        System.out.print(" "); // print blank spaces

      }

      System.out.print(genOne[i]); // output the first number of the pair

      for(int j = 0; j < 18 - (String.valueOf(genTwo[i])).length(); j++) // as above
      {

        System.out.print(" ");

      }

      System.out.print(genTwo[i]);

      for(int j = 0; j < 18 - (String.valueOf(lcm(genOne[i], genTwo[i]))).length(); j++) // This time makes use of the lcm() method from earlier to solve for the lcm
      {

        System.out.print(" ");

      }

      System.out.print(lcm(genOne[i], genTwo[i])); // prints out the lcm of the two generated values
      System.out.println();

    }

    System.out.println();
    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    System.out.println();
    spacing("Would you like to run the program again?"); // Asks for a rerun
    System.out.println();
    spacing("Enter Yes or No (Y/y/N/n): ", 1); // prompts for Y/y/N/n

    char repeat = readChar("YyNn");

    System.out.println();

    if(repeat == 'Y' || repeat == 'y') // if the character returned is either uppercase or lowercase y; meaning yes
    {

      System.out.println();

      theLcmMachine(); // (Recursively) calls itself to loop once more

    }

    // returns void and exits immediately afterwards

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
      spacing("Welcome to Problem Set 5");
      spacing("Kai Huang ~ 09/02/2016");
      System.out.println();
      System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
      System.out.println();
      spacing("Choices");
      System.out.println();
      spacing("1: The LCM Machine");
      System.out.println();
      spacing("** Note: These next options are for testing only. **");
      System.out.println();
      spacing("2: title()");
      spacing("3: getRandom()");
      spacing("4: readChar(char, char)");
      spacing("5: readChar(String)");
      spacing("6: lcm()");
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

        sc.nextLine(); // clear buffer
        theLcmMachine(); // call the program method

      }

      else if(choice == 2) // testing title();
      {

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println();
        spacing("Enter one parameter of type <String>: ", 15); // Prompts for parameter

        sc.nextLine(); // clears buffer

        String temp = sc.nextLine(); // Reads parameter

        System.out.println();
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        title(temp); // parameter sent to title method and displays demo

        pause(); // asks for keystroke

      }

      else if(choice == 3)
      {

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println();
        spacing("Enter the first parameter of type <int>: ", 2); // prompts for first parameter

        sc.nextLine(); // clears buffer

        int temp1 = sc.nextInt();

        System.out.println();
        spacing("Enter the second parameter of type <int>: ", 2); // prompts for second parameter

        int temp2 = sc.nextInt();

        System.out.println();
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println();

        spacing("The RNG grants you: " + String.valueOf(getRandom(temp1, temp2))); // outputs RNG result

        System.out.println();

        sc.nextLine(); // clears buffer

        pause(); // asks for keystroke

      }

      else if(choice == 4)
      {

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println();
        spacing("Enter the first parameter of type <char>: ", 1); // prompts for first parameter

        sc.nextLine(); // clears buffer

        char temp1 = sc.nextLine().charAt(0);

        System.out.println();
        spacing("Enter the second parameter of type <char>: ", 1); // prompts for second parameter

        char temp2 = sc.nextLine().charAt(0);

        System.out.println();
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println();
        spacing("Enter a character in between the prior characters: ", 1); // prompts for character input as per readChar()

        char res = readChar(temp1, temp2); // executes readChar

        System.out.println();
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println();

        spacing("The <char> you entered was: " + res); // outputs the result of readChar()

        System.out.println();

        pause(); // asks for keystroke

      }

      else if(choice == 5)
      {

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println();
        spacing("Enter a parameter of type <String> : ", 6); // prompts for parameter

        sc.nextLine(); // clears buffer

        String temp = sc.nextLine();

        System.out.println();
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println();
        spacing("Enter a character that was present in the prior <String>: ", 1); // prompts for character input as per readChar()

        char res = readChar(temp); // executes readChar()

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println();

        spacing("The <char> you entered was: " + res); // outputs result from readChar()

        System.out.println();

        pause(); // asks for keystroke

      }

      else if(choice == 6)
      {

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println();
        spacing("Enter the first parameter of type <int>: ", 2); // prompts for first parameter

        sc.nextLine(); // clears buffer

        int temp1 = sc.nextInt();

        System.out.println();
        spacing("Enter the second parameter of type <int>: ", 2); // prompts for second parameter

        int temp2 = sc.nextInt();

        System.out.println();
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println();

        spacing("The LCM is: " + String.valueOf(lcm(temp1, temp2))); // outputs result of lcm()

        System.out.println();

        sc.nextLine(); // clears buffer

        pause(); // asks for keystroke

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
