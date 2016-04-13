// Mixed Fraction Class

class mixedFraction extends fraction
{
  
  protected int whole; // The whole number that preceeds the fraction; denominator and numerator not set up as they're inhereted
  
  public mixedFraction() // The default constructor
  {
    
    super(); // Refers to the default constructor from the fraction class
    whole = 0; // Sets up the whole number as 0; fraction is 0 and 0/1
    
  }
  
  public mixedFraction(int whole, int num, int denom)
  {
    
    super(num, denom); // Call the constructor from the fraction class using the numerator and denominator
    this.whole = whole; // Initalizes the whole number based on the parameter
    
  }
  
  public void toMixedFraction(fraction F) // Creates a mixedFraction from a fraction
  {
    
    numerator = F.numerator; 
    denominator = F.denominator;
    
  }
  
  public void toImproper() // Converts a mixedFraction object into improper form
  {
    
    if(denominator > 0 && numerator > 0)
    {
      
      numerator += (whole * denominator);
      whole = 0;
      
    }
    
    else if(denominator < 0)
    {
      
      denominator *= -1;
      whole *= -1;
      numerator *= -1;
      
      numerator += (whole * denominator);
      whole = 0;
      
    }
    
    else if(numerator < 0 && whole > 0)
    {
      
      whole *= -1;
      
    }
    
    else if(numerator < 0 && whole < 0)
    {
      
      whole *= -1;
      numerator *= -1;
      
    }
    
  }
  
  public void toMixed() // Converts a mixedFraction object in improper form into mixed fraction form
  {
    
    whole = whole + (numerator / denominator); // Whole number is just the maximum possible quotient of the numerator and denominator
    numerator = numerator % denominator; // Use modulus to get the remaining value for the numerator
    
  }
  
  public void reduce() // Just reducing the fraction portion
  {
    
    super.reduce(); // Simply reduce it using the exact same method; no changes have to be made since all we're reducing is the fraction portion
    
    if(numerator / denominator > 1) // If the fraction part is improper
    {
      
      this.toMixed(); // Convert it so it displays as a mixed fraction
      
    }
    
    else if(numerator < 0) // If the numerator part of the fraction is negative
    {
      
      whole *= -1; // throw the negative onto the whole number
      numerator *= -1; // and make the numerator positive
      
    }
    
    else if(denominator < 0) // same as above, but for the denominator
    {
      
      whole *= -1;
      denominator *= -1;
      
    }
    
  }
  
  public String toString()
  {
    
    if(whole == 0) // If there's no whole number
    {
      
      return super.toString(); // Simply return just the fraction value
      
    }
    
    else if(numerator == 0) // If the fraction is simply zero
    {
      
      return "" + whole; // Only return the whole value
      
    }
    
    else // In other cases (usual cases)
    {
    
      return whole + " and " + super.toString(); // Super accesses the method from the fraction class
      
    }
    
  }
  
  public mixedFraction add(mixedFraction M)
  {
    
    mixedFraction res = new mixedFraction(); // Set up the result variable
    fraction temp = new fraction(); // Set up a temporary fraction object so we can take advantage of the fraction methods
    
    this.toImproper(); // Convert both of the mixed fractions to improper fractions for multiplication
    M.toImproper();
    
    temp = super.add(M); // set up temp as the difference of the current object and M, using the fraction methods
    
    res.toMixedFraction(temp); // convert temp to a mixedFraction object and store it in res
    
    res.reduce(); // reduce res and turn it back into a mixedFraction 
    res.toMixed();
    
    return res;
    
  }
  
  public mixedFraction subtract(mixedFraction M)
  {
    
    mixedFraction res = new mixedFraction(); // Set up the result variable
    fraction temp = new fraction(); // Set up a temporary fraction object so we can take advantage of the fraction methods
    
    this.toImproper(); // Convert both of the mixed fractions to improper fractions for multiplication
    M.toImproper();
    
    temp = super.subtract(M); // set up temp as the difference of the current object and M, using the fraction methods
    
    res.toMixedFraction(temp); // convert temp to a mixedFraction object and store it in res
    
    res.reduce(); // reduce res and turn it back into a mixedFraction 
    res.toMixed();
    
    return res;
    
  }
  
  public mixedFraction multiply(mixedFraction M)
  {
    
    mixedFraction res = new mixedFraction(); // Set up the result variable
    fraction temp = new fraction(); // Set up a temporary fraction object so we can take advantage of the fraction methods
    
    this.toImproper(); // Convert both of the mixed fractions to improper fractions for multiplication
    M.toImproper();
    
    temp = super.multiply(M); // set up temp as the multiple of the current object and M, using the fraction methods
    
    res.toMixedFraction(temp); // convert temp to a mixedFraction object and store it in res
    
    res.reduce(); // reduce res and turn it back into a mixedFraction 
    res.toMixed();
    
    return res; 
    
  }
  
  public mixedFraction divide(mixedFraction M)
  {
    
    mixedFraction res = new mixedFraction(); // Set up the result variable
    fraction temp = new fraction(); // Set up a temporary fraction object so we can take advantage of the fraction methods
    
    this.toImproper(); // Convert both of the mixed fractions to improper fractions for multiplication
    M.toImproper();
    
    temp = super.divide(M); // set up temp as the quotient of the current object and M, using the fraction methods
    
    res.toMixedFraction(temp); // convert temp to a mixedFraction object and store it in res
    
    res.reduce(); // reduce res and turn it back into a mixedFraction
    res.toMixed();
    
    return res; 
    
  }
  
  public boolean equals(mixedFraction M)
  {
    
    this.toImproper(); // Convert both of the mixed fractions to improper fractions
    M.toImproper();
    
    this.reduce(); // Reduce both of the mixed fractions
    M.reduce();
    
    boolean res = super.equals(M); // Use the fraction class' equals method with the mixed fractions
    
    return res; // return the result
    
  }
  
  public int compareTo(mixedFraction M)
  {
    
    this.toImproper(); // Convert both of the mixed fractions to improper fractions
    M.toImproper();
    
    this.reduce(); // Reduce both of the mixed fractions
    M.reduce();
    
    int res = super.compareTo(M); // Use the fraction class' equals method with the mixed fractions
    
    return res; // return the result
    
  }
  
  public double toDecimal()
  {
    
    this.toImproper(); // Convert the mixed fraction to improper fraction
    
    System.out.println("this: " + this);
    
    // No need to reduce them in this case since they'll be converted to a decimal value anyway
    
    double res = super.toDecimal(); // call on the toDecimal method from the fraction class
    
    return res; // return the result
    
  }
  
  public void read(String input)
  {
    
    try
    {
      
      //int indexOfSplit = input.indexOf('+'); // Finds the index where the plus sign is located
      int indexOfSplit = input.indexOf(" "); // Or alternatively, where the space is located
      
      String wholeNum = input.substring(0, indexOfSplit); // The whole number is the part before the plus sign
      String fracPart = input.substring(indexOfSplit + 1, input.length()); // The actual fraction part is the part after it
      
      try
      {
        
        whole = Integer.parseInt(wholeNum);
        super.read(fracPart);
        
      }
      
      catch(NumberFormatException wowLad)
      {
        
        System.out.println();
        spacing("Your input " + input + " is not a valid fraction."); // tell the user that what they entered isn't valid
        spacing("Returning the default fraction 0 and 0/1");
        System.out.println();
        
        whole = 0;
        numerator = 0; // Sets the fraction as the default one
        denominator = 1;
        
      }
      
    }
    
    catch(Exception wawLad)
    {
      
      System.out.println();
      spacing("Your input " + input + " is not a valid fraction."); // tell the user that what they entered isn't valid
      spacing("Returning the default fraction 0 and 0/1");
      System.out.println();
      
      whole = 0;
      numerator = 0; // Sets the fraction as the default one
      denominator = 1;
      
    }
    
  }
  
}