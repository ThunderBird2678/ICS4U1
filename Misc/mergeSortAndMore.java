// Merge Sort Algorithm

// This would've been damn much easier in Python, I swear

import java.util.*;

public class mergeSortAndMore
{
  
  static Scanner sc; // Initalize the scanner object
  static Random rn = new Random();
  
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
  
  public static int[] merge_Sort(int [] toSort)
  {
    
    spacing("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    System.out.println();
    
    if(toSort.length == 1) // Base case: if array only has length one, it's inherently sorted and is returned as such
    {
      
      spacing("We've hit the base case: " + toSort[0]);
      System.out.println();
      
      return toSort;
      
    }
    
    else // this is where the fun begins
    {
      
      /*
       * 
       * Setting up the variables
       * 
       */
      
      int [] left; // The left half of the array
      int [] right; // The right half of the array
      int [] res = new int[toSort.length]; // The resulting array that we will be returning
      
      int midPoint = (toSort.length / 2); //. Calculate the central index of the array, as mergeSort replies on recursively splitting up the array into halves
      
      spacing("The midpoint is at: " + midPoint);
      
      /*
       * 
       * Initalizing the two seperate subArray halves
       * 
       */
      
      left = new int[midPoint]; // Creating the left subArray; since midPoint is calculated as half the length of the original anyway, we can use it to initalize this one
      
      if(toSort.length % 2 != 0) // If the array starts off with an odd number of elements and as such the halfpoint isn't precisely there
      {
        
        right = new int [midPoint + 1]; // Since Java will round the midPoint down, we need to make this array one element larger
        
      }
      
      else // If the array has an even number of elements, though
      {
        
        right = new int[midPoint]; // Set up the right array the same way the left one was set up
        
      }
      
      /*
       * 
       * Populating the new subArray halves
       * 
       */
      
      System.out.println();
      spacing("The left array is as follows: ");
      
      String lArray = "";
      
      for(int i = 0; i < midPoint; i++) // Iterating through the first half of the array
      {
        
        left[i] = toSort[i]; // Setting up the left[] array as a direct duplicate of the original 
        lArray += toSort[i] + " ";
        
      }
      
      spacing(lArray);
      System.out.println();
      spacing("The right array is as follows: ");
      
      String rArray = "";
      
      int rCounter = 0; // In order to iterate through the right array starting from index 0
      
      for(int i = midPoint; i < toSort.length; i++)
      {
        
        right[rCounter] = toSort[i]; // Setting up the right[] array as a direct duplicate of the original's second half
        rCounter ++; // Incrementing the index for the right array seperately
        rArray += toSort[i] + " ";
        
      }
      
      spacing(rArray);
      System.out.println();
      
      /*
       * 
       * Recursive calls and the returning of the final result
       * 
       */
      
      left = merge_Sort(left); // Recursively call the merge_Sort method again, this time with the array being only half the size
      right = merge_Sort(right);
      
      res = merge(left, right); // Set the result array to be that of the merged left and right arrays; merge() method determines the actual sorting when merging back together
      
      return res;
      
    }
    
  }
  
  public static int [] merge(int [] arrayOne, int [] arrayTwo)
  {
    
    spacing("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    System.out.println();
    
    /*
     * 
     * Setting up the variables
     * 
     */
    
    int resLength = arrayOne.length + arrayTwo.length; // Takes the length of the two arrays we're merging and adds them
    int [] res = new int[resLength]; // Result array is initalized
    
    int indexOne = 0; // Counter variables for iterating through the arrays we're given
    int indexTwo = 0;
    int resIndex = 0;
    
    /*
     * 
     * Sorting algorithm in its own sense
     * 
     */
    
    while(indexOne < arrayOne.length || indexTwo < arrayTwo.length) // Continue running through the arrays until all of the values have been merged into the result array
    {
      
      if(indexOne < arrayOne.length && indexTwo < arrayTwo.length) // Seems redundant, but we're running through cases here, and this code only applies if they BOTH still have values
      {
        
        spacing("Now comparing " + arrayOne[indexOne] + " from arrayOne and " + arrayTwo[indexTwo] + " from arrayTwo");
        System.out.println();
        
        if(arrayOne[indexOne] <= arrayTwo[indexTwo]) // Comparing the two values, seeing which one we have to dump into the result first
        {
          
          spacing("Chucking " + arrayOne[indexOne] + " into the result array as it's smaller than " + arrayTwo[indexTwo]);
          System.out.println();
          
          res[resIndex] = arrayOne[indexOne]; // dump the smaller of the two (in this case, arrayOne[indexOne] into the result array
          
          resIndex ++; // increment both of the counters associated with the operation
          indexOne ++;
          
        }
        
        else // Identical to the above, except this time, we're working with if the value in arrayTwo is smaller
        {
          
          spacing("Chucking " + arrayTwo[indexTwo] + " into the result array as it's smaller than " + arrayOne[indexOne]);
          System.out.println();
          
          res[resIndex] = arrayTwo[indexTwo];
          
          resIndex ++;
          indexTwo ++;
          
        }
        
      }
      
      else if(indexOne < arrayOne.length) // For this to trigger, one of the arrays must be empty; in this case, the second is empty and so I can just keep adding from the first
      {
        
        spacing("Chucking the value " + arrayOne[indexOne] + " from arrayOne into the result array, as arrayTwo is empty");
        System.out.println();
        
        res[resIndex] = arrayOne[indexOne];
        
        resIndex ++;
        indexOne ++;
        
      }
      
      else // In the only other case, the right array must still have elements while the left is empty
      {
        
        spacing("Chucking the value " + arrayTwo[indexTwo] + " from arrayTwo into the result array, as arrayOne is empty");
        System.out.println();
        
        res[resIndex] = arrayTwo[indexTwo];
        
        resIndex ++;
        indexTwo ++;
        
      }
      
    }
    
    /*
     * 
     * Returning the merged lists
     * 
     */
    
    return res;
    
  }
  
  public static int search (int [] toSearch, int toFind, int lIndex, int rIndex)
  {
    
    int mid = toSearch.length / 2;
    
    int res = (lIndex + mid) + 1;
    
    spacing("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    System.out.println();
    spacing("The current middle term is term #" + res + " of the original array.");
    spacing("Which is term #" + (mid + 1) + " of the current level.");
    System.out.println();
    
    if(toSearch[mid] == toFind)
    {
      
      spacing("Base case: It equals what we're looking for: " + toFind);
      System.out.println();
      
      return res;
      
    }
    
    else
    {
      
      int [] nextStep = (toSearch.length % 2 == 0)? new int[mid] : new int[mid+1];
      
      if(toSearch[mid] > toFind) // if the middle element is already larger than what we want to find
      {
        
        spacing("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println();
        spacing("The middle term is larger than what we're looking for.");
        spacing("We must look to the left.");
        
        String nextStepOutput = "";
        
        for(int i = 0; i < nextStep.length; i++)
        {
          
          nextStep[i] = toSearch[i];
          nextStepOutput += (nextStep[i] + " ");
          
        }
        
        System.out.println();
        spacing("The subarray we will be searching next is:");
        spacing(nextStepOutput);
        System.out.println();
        spacing("The right bound is term #" + (nextStep.length));
        spacing("The left bound is" + (lIndex+1));
        System.out.println();
        
        return search(nextStep, toFind, lIndex, nextStep.length - 1);
        
      }
      
      else
      {
        
        spacing("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println();
        spacing("The middle term is smaller than what we're looking for.");
        spacing("We must look to the right.");
        
        String nextStepOutput = "";
        
        for(int i = 0; i < nextStep.length; i++)
        {
          
          nextStep[i] = toSearch[mid + i];
          nextStepOutput += (nextStep[i] + " ");
          
        }
        
        System.out.println();
        spacing("The subarray we will be searching next is:");
        spacing(nextStepOutput);
        System.out.println();
        spacing("The right bound is term #" + (rIndex + 1));
        spacing("The left bound is term #" + (lIndex + mid + 1));
        System.out.println();
        
        return search(nextStep, toFind, (lIndex + mid), rIndex);
        
      }
      
    }
    
  }
  
  public static int[] randomArray(int numTerms)
  {
    
    int [] res = new int [numTerms];
    
    for(int i = 0; i < numTerms; i++)
    {
      
      res [i] = rn.nextInt(99) + 1;
      
    }
    
    return res;
    
  }
  
  public static void main (String [] args)
  {
    
    sc = new Scanner (System.in); // Define the scanner object
    
    spacing("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"); // Just introducing the program
    System.out.println();
    spacing("An exercise in recursion: MergeSort");
    System.out.println();
    spacing("How many terms would you like to sort? : ", 2);
    
    int numTerms = sc.nextInt(); // prompt for number of terms
    int [] toSort = new int [numTerms]; // generate an array with aforementioned number of terms
    
    System.out.println();
    
    toSort = randomArray(numTerms);
    
    /*
    
    for(int i = 0; i < numTerms; i++) // loop through array, have user input the lists
    {
      spacing("Enter term number " + (i + 1) + ": ", 2);
      
      toSort[i] = sc.nextInt();
      
      System.out.println();
      
    }
    
    */
    
    spacing("The original array prior to any sorting is as follows:"); // outputs original array based off a list
    
    String original = "";
    
    for(int i = 0; i < numTerms; i++)
    {
      
      original += toSort[i] + " ";
      
    }
    
    spacing(original);
    System.out.println();
    
    int [] res = merge_Sort(toSort); // sets up the sorted array based off the method
    
    spacing("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    System.out.println();
    spacing("The array after the sorting is as follows:"); // displays result
    
    String result = "";
    
    for(int i = 0; i < numTerms; i++)
    {
      
      result += res[i] + " ";
      
    }
    
    spacing(result);
    System.out.println();
    spacing("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    System.out.println();
    spacing("What number do you wish to search for?", 2);
    
    int search = sc.nextInt();
    
    int searchRes = search(res, search, 0, res.length - 1);
    
    System.out.println();
    spacing(search + " was term #" + searchRes);
  
  }
  
}
