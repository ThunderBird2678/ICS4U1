import java.util.Scanner;

public class Set1
{
  
  static Scanner sc;
  
  public static void clearScreen()
  {
    
    System.out.flush();
    
  }  
  
  public static void interest()
  {
    
    sc = new Scanner (System.in);
    
    int principal;
    double interestRate;
    
    clearScreen();
    
    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    System.out.println();
    System.out.println("        Welcome to the Interest program!");
    System.out.println();
    System.out.print("                Principal ($): ");
    
    principal = sc.nextInt();
    
    System.out.print("              Interest Rate (%) :");
    
    interestRate = sc.nextDouble();
    
    System.out.println();
    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    
    double year1, year2;
    
    year1 = principal * (interestRate / 100);
    
    year2 = (principal + year1) * (interestRate / 100);
    
    System.out.println();
    System.out.format("           Year 1 Interest: $%.2f%n", year1);
    System.out.format("           Year 2 Interest: $%.2f%n", year2);
    
    // System.out.println("           Year 2 Interest:" + year2); (Debug statement without formatting)
    
    System.out.println();
    
  }
  
  public static void arithmetic()
  {
    
    sc = new Scanner (System.in);
    
    int operand1, operand2;
    
    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    System.out.println();
    System.out.println("      Welcome to the Arithmetic program!");
    System.out.println();
    System.out.print("                 Operand 1:");
    
    operand1 = sc.nextInt();
    
    System.out.print("                 Operand 2:");
    
    operand2 = sc.nextInt();
    
    System.out.println();
    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    System.out.println();
    System.out.println("                 " + operand1 + " + " + operand2 + " = " + (operand1 + operand2));
    System.out.println("                 " + operand1 + " - " + operand2 + " = " + (operand1 - operand2));
    System.out.println("                 " + operand1 + " * " + operand2 + " = " + (operand1 * operand2));
    
    double divAnswer = (double)operand1 / (double)operand2;
    
    System.out.println("                 " + operand1 + " / " + operand2 + " = " + divAnswer);
    System.out.println();
    
  }
  
  public static void receipt()
  {
    
    sc = new Scanner (System.in);
    
    double price;
    int quantity;
    
    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    System.out.println();
    System.out.println("      Welcome to the Receipt program!");
    System.out.println();
    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    System.out.println();
    System.out.println("           Enter Item Information:");
    System.out.println();
    System.out.print("                Price: "); 
    
    price = sc.nextDouble();
    
    
    System.out.print("               Quantity: "); 
    
    quantity = sc.nextInt();
    
    System.out.println();
    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    System.out.println();
    System.out.println("          Here is your receipt.");
    System.out.println();
    System.out.print("            " + quantity);
    System.out.format(" x $%.2f", price);
    System.out.format(" = $%.2f%n", (quantity * price));
    System.out.println();
    
    
    
  }
  
  public static void main (String [] args){
    
    sc = new Scanner (System.in);
    
    int choice;
    
    do
    {
      
      clearScreen();
      
      System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
      System.out.println();
      System.out.println("           Welcome to Problem Set 1");
      System.out.println("            Kai Huang ~ 08/02/2016");
      System.out.println();
      System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
      System.out.println();
      System.out.println("                   Choices");
      System.out.println();
      System.out.println("                 1: Interest");
      System.out.println("                2: Arithmetic");
      System.out.println("                 3: Receipt");
      System.out.println();
      System.out.println("                   0: Exit");
      System.out.println();
      System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
      System.out.println();
      System.out.print("                 Choice: ");
      
      choice = sc.nextInt();
      
      if(choice == 1)
      {
        
        interest();
        
      }
      
      else if(choice == 2)
      {
       
        arithmetic();
        
      }
      
      else if(choice == 3)
      {
        
        receipt();
        
      }
      
      else if(choice != 0)
      {
        
        clearScreen();
        
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println();
        System.out.println("          Please enter a valid command.");
        System.out.println();
        
      }
      
      
    } while (choice != 0);
    
    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    System.out.println();
    System.out.println("             Farewell, good sir.");
    System.out.println();
    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    
  }
  
}