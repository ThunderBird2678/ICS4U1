import java.util.*;
import java.lang.*;

public class While_Test
{

  public static void main (String [] args)
  {

    Scanner sc = new Scanner (System.in);
    Random rn = new Random();

    int guess;
    int r1, r2, points = 0;

    char input;

    boolean correct = true;

    while(correct == true)
    {

      r1 = rn.nextInt(100) + 1;
      r2 = rn.nextInt(100) + 1;

      System.out.println("The range is from " + r1 + " to " + r2 + ".");
      System.out.print("Next number in range? (i/o): ");

      input = sc.nextLine().charAt(0);

      guess = rn.nextInt(100) + 1;

      System.out.println("The number generated was " + guess);
      System.out.println();

      if(input != 'i' && input != 'o')
      {

        correct = false;

      }

      if(guess == r1 || guess == r2)
      {

        correct = false;

      }

      if(guess > Math.max(r1, r2) || guess < Math.min(r1, r2))
      {

        if(input == 'i')
        {

          correct = false;

        }

        else
        {

          points++;

        }

      }

      else
      {

        if(input == 'o')
        {

          correct = false;

        }

        else
        {

          points++;

        }

      }

    }

    System.out.println("You got " + points + " points. ");

  }

}
