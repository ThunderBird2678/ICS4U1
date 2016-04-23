/*

Kai Huang
ICS4U1
Problem Set 10: Arrays
13 April 2016

*/

import java.io.*;
import java.util.*;

public class Array
{

  String [] arr; // The array variable that will be manipulated throughout this object

  public static void spacing() // new addition to spacing method that allows me to use it to simply output blank lines; same purpose as System.out.println() but looks cleaner
  {

    System.out.println();

  }

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

  public Array() // default constructor
  {

    arr = new String[0]; // set up the array with zero elements

  }

  public Array(String path) throws IOException // constructor that reads from a file
  {

    try // it tries to read from a file
    {

      FileReader in = new FileReader(path); // set up a file reader
      BufferedReader br = new BufferedReader(in); // set up a buffer just to be safe

      int lineCounter = 0; // counter variable to see how many lines we have to read

      while(br.readLine() != null) // iterate through the list once with a while loop
      {

        lineCounter ++; // as long as there's a line, increment the counter var

      }

      arr = new String [lineCounter]; // now initalize array as a new string array with the amount of lines

      for(int i = 0; i < lineCounter; i++) // iterate through it again, this time with a for loop to write the lines to array locations
      {

        arr[i] = br.readLine(); // reads lines one by one

      }

    }

    catch(FileNotFoundException damnIt) // catches the program if the file is not there
    {

      spacing("Your file was not found."); // tells the user what happened

    }

  }

  public void enter() // enter method that allows user to enter names
  {

    Scanner sc = new Scanner(System.in); // set up a scanner

    boolean done = false; // a boolean flag triggered by "q"

    while(done == false) // so long as the flag is not triggered
    {

      spacing("Please enter a name in the format:"); // prompts, recieves input
      spacing("LastName, FirstName");
      spacing("Enter q to quit");
      spacing();
      spacing("Name: ", 10);

      String temp = sc.nextLine();

      if(temp.equals("q") || temp.equals("Q")) // if the temp variables is "q"
      {

        done = true; // throw the flag and be done with it

      }

      else // otherwise we assume it's a name
      {

        this.add(temp); // and we call upon the add method to perform the actual operation

      }

      spacing();

    }

  }

  public void print() // print method
  {

    spacing("Names:"); // basic header to introduce the data
    spacing();

    for(int i = 0; i < arr.length; i++) // iterating through all values in the array
    {

      spacing(arr[i]); // output each value on a seperate line; center - aligned

    }

    spacing();

  }

  public Array search (char letter) // search method for character
  {

    char letterUpper = Character.toUpperCase(letter); // convert character to uppercase to prevent any dumb case - sensing

    Array res = new Array(); // set up the new array that will be returned

    for(int i = 0; i < arr.length; i++) // iterate through all of the old array
    {

      char testerUpper = Character.toUpperCase(arr[i].charAt(0)); // generate the tested character from the first character (converted to uppercase) in the array element

      if(testerUpper == letterUpper) // if they match
      {

        res.add(arr[i]); // use the add method to toss the current element of the current array into the result array

      }

    }

    return res; // return the result

  }

  public Array search (String surname) // almost as above, but with a string being input
  {

    Array res = new Array(); // create a new array for the result

    String searchTest; // set up a new string for the tested variable

    for(int i = 0; i < arr.length; i++) // iterate through the array
    {

      searchTest = arr[i].toUpperCase(); // first convert the array element to uppercase
      int indexOfSplit = searchTest.indexOf(","); // find the index where the comma is that splits the last and first Names
      String searching = searchTest.substring(0,indexOfSplit); // create a substring from the beginning of the string all the way to the index

      if(searching.equals(surname.toUpperCase())) // as long as it matches up
      {

        res.add(arr[i]); // throw it into the result array

      }

    }

    return res; // return the result array

  }

  public void add(String name) // add method
  {

    String [] temp = new String [arr.length + 1]; // set up a new temporary array with a size of one more than the current

    for(int i = 0; i < arr.length; i++) // iterate through all of the current array's values
    {

      temp[i] = arr[i]; // and throw them directly over to the new array

    }

    arr = new String [temp.length]; // reset the current array to be completely blank and the same size as the temp array that we just stored everything in

    for(int i = 0; i < arr.length; i++) // iterate through the entire blank array
    {

      arr[i] = temp[i]; // and copy stuff back from the temporary array so now it has one more space

    }

    arr[arr.length - 1] = name; // with that empty space, we can toss in the new value

  }

  public void remove(int index) // remove method
  {

    if(index < 0 || index > arr.length) // if the index is out of bounds, tell the user that
    {

      spacing();
      spacing("Your index is not valid");
      spacing();

    }

    else // as long as we don't have ridiculous inputs
    {

      String [] temp = new String [arr.length - 1]; // set up a temporary array with a size of one less than the current's
      int tempCounter = 0; // set up a seperate counter for the temp array as it will be running at a shifted index

      for(int i = 0; i < index - 1; i++) // loop through the current array all the way up to the one to remove
      {

        temp [i] = arr [i]; // at thiss point, we just copy directly over
        tempCounter = i; // tempcounter increments normally

      }

      tempCounter ++; // tempcounter now gets incremented by one extra one

      for(int i = index; i < arr.length; i++) // run through what's left of the current array
      {

        temp [tempCounter] = arr [i]; // countinue assigning values, skipping over the desired one
        tempCounter ++;

      }

      arr = new String [temp.length]; // reset the current array

      for(int i = 0; i < arr.length; i++) // copy all the values from the temp array back to the current one
      {

        arr[i] = temp[i];

      }

    }

  }

  public void sort() // sorting method
  {

    String temp; // set up a temporary string that we can use

    for (int i = 0 ; i < arr.length - 1 ; i++) // sort first length - 1 values
    {

      int lowPos = i; // assume first value is lowest


      for (int j = i + 1 ; j < arr.length ; j++) // check rest of list
      {

        int nameChar = 0; // a variable to iterate through the characters in the name

        if(!arr[j].equals(arr[lowPos])) // if the two being compared have the same first letter
        {

          while(arr[j].charAt(nameChar) == arr [lowPos].charAt(nameChar)) // keep comparing until we encounter different characters
          {

            nameChar ++; // every time this fails, we increment to look at the next character

          }

        }


        if (arr[j].charAt(nameChar) < arr[lowPos].charAt(nameChar)) // if you find a lower value
        {

          lowPos = j; // keep track of lowest’s position

        }

      }

      temp = arr [i]; // store the value in the temporary position

      arr [i] = arr [lowPos]; // swap the two elements
      arr [lowPos] = temp; // and put the new lowest position variable back in from the tempo

    }

  }

}
