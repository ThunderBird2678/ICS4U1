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

  String [] arr;

  public static void spacing()
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

  public Array()
  {

    arr = new String[0];

  }

  public Array(String path) throws IOException
  {

    try
    {

      FileReader in = new FileReader(path);
      BufferedReader br = new BufferedReader(in);

      int lineCounter = 0;

      while(br.readLine() != null)
      {

        lineCounter ++;

      }

      arr = new String [lineCounter];

      for(int i = 0; i < lineCounter; i++)
      {

        arr[i] = br.readLine();

      }

    }

    catch(Exception damnIt)
    {

      spacing("Your file was not found.");

    }

  }

  public void enter()
  {

    Scanner sc = new Scanner(System.in);

    boolean done = false;

    while(done == false)
    {
      
      spacing("Please enter a name in the format:");
      spacing("LastName, FirstName");
      spacing("Enter q to quit");
      spacing();
      spacing("Name: ", 10);

      String temp = sc.nextLine();

      if(temp.equals("q") || temp.equals("Q"))
      {

        done = true;

      }

      else
      {

        this.add(temp);

      }

    }

  }

  public void print()
  {

    spacing("Names:");
    spacing();

    for(int i = 0; i < arr.length; i++)
    {

      spacing(arr[i]);

    }

    spacing();

  }

  public Array search (char letter)
  {

    char letterUpper = Character.toUpperCase(letter);

    Array res = new Array();

    for(int i = 0; i < arr.length; i++)
    {

      char testerUpper = Character.toUpperCase(arr[i].charAt(0));

      if(testerUpper == letterUpper)
      {

        res.add(arr[i]);

      }

    }

    return res;

  }

  public Array search (String surname)
  {

    Array res = new Array();

    for(int i = 0; i < arr.length; i++)
    {

      if(arr[i].toUpperCase().equals(surname.toUpperCase()))
      {

        res.add(arr[i]);

      }

    }

    return res;

  }

  public void add(String name)
  {

    String [] temp = new String [arr.length + 1];

    for(int i = 0; i < arr.length; i++)
    {

      temp[i] = arr[i];

    }

    arr = new String [temp.length];

    for(int i = 0; i < arr.length; i++)
    {

      arr[i] = temp[i];

    }

    arr[arr.length - 1] = name;

  }

  public void remove(int index)
  {

    if(index < 0 || index > arr.length)
    {

      spacing();
      spacing("Your index is not valid");
      spacing();

    }

    else
    {

      String [] temp = new String [arr.length - 1];
      int tempCounter = 0;

      for(int i = 0; i < index - 1; i++)
      {

        temp [i] = arr [i];
        tempCounter = i;

      }

      tempCounter ++;

      for(int i = index; i < arr.length; i++)
      {

        temp [tempCounter] = arr [i];
        tempCounter ++;

      }

      arr = new String [temp.length];

      for(int i = 0; i < arr.length; i++)
      {

        arr[i] = temp[i];

      }

    }

  }

  public void sort()
  {

    String temp;

    for (int i = 0 ; i < arr.length - 1 ; i++) // sort first length-1 values
    {

      int lowPos = i; // assume first value is lowest


      for (int j = i + 1 ; j < arr.length ; j++) // check rest of list
      {

        int nameChar = 0;

        if(!arr[j].equals(arr[lowPos]))
        {

          while(arr[j].charAt(nameChar) == arr [lowPos].charAt(nameChar))
          {

            nameChar ++;

          }

        }


        if (arr[j].charAt(nameChar) < arr[lowPos].charAt(nameChar)) // if you find a lower value
        {

          lowPos = j; // keep track of lowest’s position

        }

      }

      temp = arr [i]; // swap low value with value in its proper position

      arr [i] = arr [lowPos];
      arr [lowPos] = temp;

    }

  }

}
