import java.util.*;

public class MixedFractionTester
{
  
  static Scanner sc;
  
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
  
  public static void drReduce() // All the driver methods are set up the same way, the opening prompts, and it sends stuff to the methods and returns stuff back; I'm not commenting them
  {
    
    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    System.out.println();
    spacing("Welcome to the Reduction Demo!");
    System.out.println();
    spacing("Enter the mixed fraction's whole number: ", 1);
    
    int whole = sc.nextInt();
    
    spacing("Enter the mixed fraction's numerator: ", 2);
    
    int numerator = sc.nextInt();
    
    spacing("Enter the fraction's denominator: ", 2);
    
    int denominator = sc.nextInt();
    
    mixedFraction demo = new mixedFraction(whole, numerator, denominator);
    
    System.out.println();
    spacing("The mixed fraction you entered is: " + demo.toString());
    System.out.println();
    
    demo.reduce();
    
    spacing("After reduction: " + demo.toString());
    System.out.println();
    
    sc.nextLine();
    pause();
    
  }
  
  public static void drAddition()
  {
    
    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    System.out.println();
    spacing("Welcome to the Addition Demo!");
    System.out.println();
    spacing("Enter the first fraction's whole number: ", 2);
    
    int whole1 = sc.nextInt();
    
    spacing("Enter the first fraction's numerator: ", 2);
    
    int numerator1 = sc.nextInt();
    
    spacing("Enter the first fraction's denominator: ", 2);
    
    int denominator1 = sc.nextInt();
    
    mixedFraction demo1 = new mixedFraction(whole1, numerator1, denominator1);
    
    System.out.println();
    spacing("Enter the second fraction's whole number: ", 2);
    
    int whole2 = sc.nextInt();
    
    spacing("Enter the second fraction's numerator: ", 2);
    
    int numerator2 = sc.nextInt();
    
    spacing("Enter the second fraction's denominator: ", 2);
    
    int denominator2 = sc.nextInt();
    
    mixedFraction demo2 = new mixedFraction(whole2, numerator2, denominator2);
    
    spacing(demo1.toString() + " + " + demo2.toString() + " = " + demo1.add(demo2));
    System.out.println();
    
    sc.nextLine();
    pause();
    
  }
  
  public static void drSubtraction()
  {
    
    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    System.out.println();
    System.out.println();
    spacing("Enter the first fraction's whole number: ", 2);
    
    int whole1 = sc.nextInt();
    
    spacing("Enter the first fraction's numerator: ", 2);
    
    int numerator1 = sc.nextInt();
    
    spacing("Enter the first fraction's denominator: ", 2);
    
    int denominator1 = sc.nextInt();
    
    mixedFraction demo1 = new mixedFraction(whole1, numerator1, denominator1);
    
    System.out.println();
    spacing("Enter the second fraction's whole number: ", 2);
    
    int whole2 = sc.nextInt();
    
    spacing("Enter the second fraction's numerator: ", 2);
    
    int numerator2 = sc.nextInt();
    
    spacing("Enter the second fraction's denominator: ", 2);
    
    int denominator2 = sc.nextInt();
    
    mixedFraction demo2 = new mixedFraction(whole2, numerator2, denominator2);
    
    spacing(demo1.toString() + " - " + demo2.toString() + " = " + demo1.subtract(demo2));
    System.out.println();
    
    sc.nextLine();
    pause();
    
  }
  
  public static void drMultiplication()
  {
    
    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    System.out.println();
    spacing("Welcome to the Multiplication Demo!");
    System.out.println();
    spacing("Enter the first fraction's whole number: ", 2);
    
    int whole1 = sc.nextInt();
    
    spacing("Enter the first fraction's numerator: ", 2);
    
    int numerator1 = sc.nextInt();
    
    spacing("Enter the first fraction's denominator: ", 2);
    
    int denominator1 = sc.nextInt();
    
    mixedFraction demo1 = new mixedFraction(whole1, numerator1, denominator1);
    
    System.out.println();
    spacing("Enter the second fraction's whole number: ", 2);
    
    int whole2 = sc.nextInt();
    
    spacing("Enter the second fraction's numerator: ", 2);
    
    int numerator2 = sc.nextInt();
    
    spacing("Enter the second fraction's denominator: ", 2);
    
    int denominator2 = sc.nextInt();
    
    mixedFraction demo2 = new mixedFraction(whole2, numerator2, denominator2);
    
    spacing(demo1.toString() + " * " + demo2.toString() + " = " + demo1.multiply(demo2));
    System.out.println();
    
    sc.nextLine();
    pause();
    
  }
  
  public static void drDivision()
  {
    
    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    System.out.println();
    spacing("Welcome to the Division Demo!");
    System.out.println();
    spacing("Enter the first fraction's whole number: ", 2);
    
    int whole1 = sc.nextInt();
    
    spacing("Enter the first fraction's numerator: ", 2);
    
    int numerator1 = sc.nextInt();
    
    spacing("Enter the first fraction's denominator: ", 2);
    
    int denominator1 = sc.nextInt();
    
    mixedFraction demo1 = new mixedFraction(whole1, numerator1, denominator1);
    
    System.out.println();
    spacing("Enter the second fraction's whole number: ", 2);
    
    int whole2 = sc.nextInt();
    
    spacing("Enter the second fraction's numerator: ", 2);
    
    int numerator2 = sc.nextInt();
    
    spacing("Enter the second fraction's denominator: ", 2);
    
    int denominator2 = sc.nextInt();
    
    mixedFraction demo2 = new mixedFraction(whole2, numerator2, denominator2);
    
    spacing(demo1.toString() + " / " + demo2.toString() + " = " + demo1.divide(demo2));
    System.out.println();
    
    sc.nextLine();
    pause();
    
  }
  
  public static void drEquals()
  {
    
    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    System.out.println();
    spacing("Welcome to the Equals Demo!");
    System.out.println();
    spacing("Enter the first fraction's whole number: ", 2);
    
    int whole1 = sc.nextInt();
    
    spacing("Enter the first fraction's numerator: ", 2);
    
    int numerator1 = sc.nextInt();
    
    spacing("Enter the first fraction's denominator: ", 2);
    
    int denominator1 = sc.nextInt();
    
    mixedFraction demo1 = new mixedFraction(whole1, numerator1, denominator1);
    
    System.out.println();
    spacing("Enter the second fraction's whole number: ", 2);
    
    int whole2 = sc.nextInt();
    
    spacing("Enter the second fraction's numerator: ", 2);
    
    int numerator2 = sc.nextInt();
    
    spacing("Enter the second fraction's denominator: ", 2);
    
    int denominator2 = sc.nextInt();
    
    mixedFraction demo2 = new mixedFraction(whole2, numerator2, denominator2);
    
    System.out.println();
    
    if(demo1.equals(demo2) == true)
    {
      
      spacing("The two fractions are equivalent");
      
    }
    
    else
    {
      
      spacing("The two fractions are not equivalent");
      
    }
    
    sc.nextLine();
    pause();
    
  }
  
  public static void drCompareTo()
  {
    
    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    System.out.println();
    spacing("Welcome to the CompareTo Demo!");
    System.out.println();
    spacing("Enter the first fraction's whole number: ", 2);
    
    int whole1 = sc.nextInt();
    
    spacing("Enter the first fraction's numerator: ", 2);
    
    int numerator1 = sc.nextInt();
    
    spacing("Enter the first fraction's denominator: ", 2);
    
    int denominator1 = sc.nextInt();
    
    mixedFraction demo1 = new mixedFraction(whole1, numerator1, denominator1);
    
    System.out.println();
    spacing("Enter the second fraction's whole number: ", 2);
    
    int whole2 = sc.nextInt();
    
    spacing("Enter the second fraction's numerator: ", 2);
    
    int numerator2 = sc.nextInt();
    
    spacing("Enter the second fraction's denominator: ", 2);
    
    int denominator2 = sc.nextInt();
    
    mixedFraction demo2 = new mixedFraction(whole2, numerator2, denominator2);
    
    System.out.println();
    
    if(demo1.compareTo(demo2) == 0)
    {
      
      spacing("The two fractions are equivalent");
      
    }
    
    else if(demo1.compareTo(demo2) == 1)
    {
      
      spacing(demo1.toString() + " is greater than " + demo2.toString());
      
    }
    
    else
    {
      
      spacing(demo1.toString() + " is less than " + demo2.toString());
      
    }
    
    sc.nextLine();
    pause();
    
  }
  
  public static void drRead()
  {
    
    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    System.out.println();
    spacing("Welcome to the Read Demo!");
    System.out.println();
    spacing("Enter the fraction: ", 5);
    
    String frac = sc.nextLine();
    
    System.out.println();
    
    mixedFraction demo = new mixedFraction();
    demo.read(frac);
    
    spacing("The fraction you entered was " + demo.toString());
    spacing("Whole number: " + demo.whole);
    spacing("Numerator: " + demo.numerator);
    spacing("Denominator: " + demo.denominator);
    
    System.out.println();
    
    demo.reduce();
    
    spacing("This simplifies to: " + demo.toString());
    spacing("Whole number: " + demo.whole);
    spacing("Numerator: " + demo.numerator);
    spacing("Denominator: " + demo.denominator);
    
    pause();
    
  }
  
  public static void drToString()
  {
    
    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    System.out.println();
    spacing("Welcome to the String Demo!");
    System.out.println();
    spacing("Enter the fraction's whole number: ", 2);
    
    int whole = sc.nextInt();
    
    spacing("Enter the fraction's numerator: ", 2);
    
    int numerator = sc.nextInt();
    
    spacing("Enter the fraction's denominator: ", 2);
    
    int denominator = sc.nextInt();
    
    mixedFraction demo = new mixedFraction(whole, numerator, denominator);
    
    System.out.println();
    
    spacing(demo.toString() + " as a string is " + demo.toString());
    
    sc.nextLine();
    pause();
    
  }
  
  public static void drToDecimal()
  {
    
    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    System.out.println();
    spacing("Welcome to the ToDecimal Demo!");
    System.out.println();
    spacing("Enter the fraction's whole number: ", 2);
    
    int whole = sc.nextInt();
    
    spacing("Enter the fraction's numerator: ", 2);
    
    int numerator = sc.nextInt();
    
    spacing("Enter the fraction's denominator: ", 2);
    
    int denominator = sc.nextInt();
    
    mixedFraction demo = new mixedFraction(whole, numerator, denominator);
    
    System.out.println();
    
    spacing(demo.toString() + " in decimal form is " + demo.toDecimal());
    
    sc.nextLine();
    pause();
    
  }
  
  public static void main (String [] args)
  {
    
    sc = new Scanner (System.in);
    
    int choice;
    
    do // Looping through this
    {

      System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
      System.out.println();
      spacing("Welcome to the Fraction Class Assignment");
      spacing("Kai Huang ~ 27/03/2016");
      System.out.println();
      System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
      System.out.println();
      spacing("Interactive Demos");
      System.out.println();
      spacing("1: Reduction Method");
      spacing("2: Addition Method");
      spacing("3: Subtraction Method");
      spacing("4: Multiplication Method");
      spacing("5: Division Method");
      spacing("6: Equals Method");
      spacing("7. CompareTo Method");
      spacing("8. ToDecimal Method");
      spacing("9. Read Method");
      spacing("10. ToString Method");
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

        drReduce();

      }

      else if(choice == 2)
      {

        drAddition();

      }

      else if(choice == 3)
      {

        drSubtraction();
      }

      else if(choice == 4)
      {

        drMultiplication();

      }
      
      else if(choice == 5)
      {
        
        drDivision();
        
      }
      
      else if(choice == 6)
      {
        
        drEquals();
        
      }
      
      else if(choice == 7)
      {
        
        drCompareTo();
        
      }
      
      else if(choice == 8)
      {
        
        drToDecimal();
        
      }
      
      else if(choice == 9)
      {
        
        drRead();
        
      }
      
      else if(choice == 10)
      {
        
        drToString();
        
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
