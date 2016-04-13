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

  public static void main (String [] args) throws IOException
  {

    sc = new Scanner(System.in);

    Array arr = new Array();

    arr.add("Smith, John");
    arr.add("Huang, Kai");
    arr.add("Ren, Kylo");

    arr.print();

    arr.remove(2);

    arr.print();

    arr.add("Cook, Tim");
    arr.add("Tachibana, Kanade");
    arr.add("Fucker, Mother");

    arr.print();

    arr.remove(3);

    arr.print();

    arr.remove(3);

    arr.print();

    arr.enter();

    arr.print();

  }

}
