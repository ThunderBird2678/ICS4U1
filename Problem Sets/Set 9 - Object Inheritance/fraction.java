// Fraction Class 1.0

class fraction
{
  
  protected int numerator, denominator; // Gives access to subclass
  
  // Default constructor defined to set all fields to 0
  // Better coding practice to code your own
  
  public fraction()
  {
    
    numerator = 0; 
    denominator = 1; // Makes more sense than 0/0, since that's undefined
    
  }
  
  // An overloaded constructor is used to create a duplicate an object
  // It copies data instead of referencing two different things to the same memory address
  
  public fraction (fraction F)
  {
    
    numerator = F.numerator;
    denominator = F.denominator;
    
  }
  
  // Alternate constructor based upon values that are recieved
  // Constructors can be overloaded to suit any parameters
  
  public fraction (int num, int denom)
  {
    
    numerator = num;
    denominator = denom;
    
  }
  
  public void spacing( String printed ) // Custom method written in order to center - align output)
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
  
  public String toString() // Returns the string output of the fraction
  {
    
    if(denominator == 1) // If the denominator is 1, then division is unnecessary
    {
      
      return "" + numerator; // Result is simply the numerator
      
    }
    
    else if(denominator == 0) // If the denominator is 0, it's undefined
    {
      
      return "Undefined"; // As such, return that it's undefined
      
    }
    
    else if(numerator == 0) // If numerator is 0
    {
      
      return "0"; // Value is thus 0 regardless of denominator, so return 0
      
    }
    
    
    else // When none of the above is valid
    {
    
      return numerator + "/" + denominator; // Return the string as a fraction 
      
    }
    
  }
  
  public void reduce() // Reduces the fraction to simplest form
  {
    
    int tempNumerator = numerator; // Since we'll be manipulating the numerator first but still need the original to calculate our new denominator
    
    if(numerator != 0 && denominator != 0)
    {
      
      while(gcf(Math.abs(numerator), Math.abs(denominator)) != 1) // Using the recursive gcf() method from the recursion problem set with numerator and denominator
      {
        
        numerator /= gcf(Math.abs(numerator), Math.abs(denominator)); // numerator is divided by the gcf
        denominator /= gcf(Math.abs(tempNumerator), Math.abs(denominator)); // denominator is also divided by the gcf
        
      }
      
      if(numerator < 0 && denominator < 0) // Checking to see if both are negative
      {
        
        numerator *= -1; // multiply both by -1 to turn it positive
        denominator *= -1;
        
      }
      
      else if(denominator < 0) // if the denominator is negative
      {
        
        numerator *= -1; // multiply both by -1 so that the negative is flipped into the numerator, as per standard convention
        denominator *= -1;
        
      }
      
    }
    
  }
  
  private int gcf(int n1, int n2) // recursive gcf method from recursion problem set
  {

    if(n1 == n2) // if the two are equal, then they're done
    {

      return n1;

    }

    else if(n1 < n2) // if the second number is larger
    {

      return gcf(n2, n1); // reset the process so the first is larger (allwing us to use general algorithm)

    }

    else // so long as the first is larger than the second
    {

      return gcf(n2, n1 - n2); // take away the second from the first; slowly whittling down the remainder

    }

  }
  
  private int lcm(int n1, int n2) // simple lcm method based off euclid's gcf method
  {
    
    return n1 * (n2 / gcf(Math.abs(n1), Math.abs(n2))); 
  
  }
  
  public fraction add(fraction F) // Addition method
  {
    
    fraction res = new fraction(); // set up the result as a new fraction object
    
    res.denominator = lcm(denominator, F.denominator); // denominator is the lcm of the two fractions
    
    int numerator1 = numerator * (lcm(denominator, F.denominator) / denominator); // the first fraction's numerator has to be adjusted based on what the lcm is
    int numerator2 = F.numerator * (lcm(denominator, F.denominator) / F.denominator); // adjustment is also made to the second fraction's numerator
    
    res.numerator = numerator1 + numerator2; // numerator of result is just the sum of the two
    
    res.reduce(); // reduce the result using the already created reduce() method
    
    return res; // and return the fraction object
    
  }
  
  public fraction subtract(fraction F) // Subtraction method; Identical to the above addition method
  {
    
    fraction res = new fraction();
    
    res.denominator = lcm(denominator, F.denominator);
    
    int numerator1 = numerator * (lcm(denominator, F.denominator) / denominator);
    int numerator2 = F.numerator * (lcm(denominator, F.denominator) / F.denominator);
    
    res.numerator = numerator1 - numerator2; // This time, it's the difference, not the sum
    
    res.reduce();
    
    return res;
    
  }
  
  public fraction multiply(fraction F) // Multiplication Method
  {
    
    fraction res = new fraction(); // Set up result fraction object
    
    res.numerator = numerator * F.numerator; // directly multiply the two numerators
    res.denominator = denominator * F.denominator; // directly multiply the two denominators
    
    res.reduce(); // reduce it and output
    
    return res; // return the result
    
  }
  
  public fraction divide(fraction F) // Division method, largely identical to the one above
  {
    
    fraction res = new fraction();
    
    res.numerator = numerator * F.denominator; // In this case, we multiply by the reciprocal, so just invert the second fraction
    res.denominator = denominator * F.numerator;
    
    res.reduce();
    
    return res;
    
  }
  
  public boolean equals(fraction F) // checks if the fractions are equal; returns boolean
  {
    
    boolean res = false; // result that will be returned; false until set otherwise
    fraction temp = new fraction (numerator, denominator); // a new fraction object is created with the same properties as the current one, so we can manipulate it freely
    
    temp.reduce(); // reduce both of the fractions
    F.reduce();
    
    if(temp.numerator == F.numerator && temp.denominator == F.denominator) // compare the numerator and denominator of both and check that they're identical
    {
      
      res = true; // flip the result boolean over to true
      
    }
    
    return res; // return the result
    
  }
  
  public int compareTo(fraction F) // compareTo method returns 0 if the two are equal, 1 if the first is larger, -1 if the second is larger
  {
    fraction temp = new fraction (numerator, denominator); // as above, set up a new fraction object with the same properties as the current for manipulation
    
    System.out.println(temp.toDecimal());
    System.out.println(F.toDecimal());
    
    if(temp.toDecimal() == F.toDecimal()) // check if their decimal forms are equivalent
    {
      
      return 0; // equals; 0
      
    }
    
    else if(temp.toDecimal() > F.toDecimal()) // checks if first is larger
    {
      
      return 1; // first larger; 1
      
    }
    
    else // checks if second is larger
    {
      
      return -1; // second larger; -1
      
    }
    
  }
  
  public double toDecimal() // toDecimal method takes the fraction and returns a decimal value
  {
    
    double res = (double) numerator / (double) denominator; // have to cast the integers to doubles beforehand 
    return res; // returns the simple division output
    
  }
  
  public void read(String input) // reads a fraction's numerator and denominator from a string
  {
    
    try
    {
      
      int indexOfSlash = input.indexOf('/'); // finds the index where the '/' is in the string so we know where to split around
      String strNum = input.substring(0, indexOfSlash); // the numerator comes before the index
      String strDenom = input.substring(indexOfSlash + 1, input.length()); // and the denominator afterwards
      
      try // see if this works out
      {
        
        numerator = Integer.parseInt(strNum); // parse the two strings as integers and see if it works out
        denominator = Integer.parseInt(strDenom);
        
      }
      
      catch(NumberFormatException wewLad) // if it doesn't work out
      {
        
        System.out.println();
        spacing("Your input " + input + " is not a valid fraction."); // tell the user that what they entered isn't valid
        spacing("Returning the default fraction 0/1");
        System.out.println();
        
        numerator = 0; // Sets the fraction as the default one
        denominator = 1;
      
      }
      
    }
    
    catch(Exception wowLad)
    {
      
      System.out.println();
      spacing("Your input " + input + " is not a valid fraction."); // tell the user that what they entered isn't valid
      spacing("Returning the default fraction 0/1");
      System.out.println();
        
      numerator = 0; // Sets the fraction as the default one
      denominator = 1;
      
    }
    
  }
  
}