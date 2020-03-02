package unit10;
//(c) A+ Computer Science
//www.apluscompsci.com
//Name - Faith Okamoto

// import for getting inputs
import java.util.Scanner;

public class DoggiesRunner
{
   public static void main(String[] args)
   {
	   // initialize a new Scanner
	   Scanner keyboard = new Scanner(System.in);
	   // used in the loop
	   int age;
	   String name;
	   
	   // figure out size of pack, create proper sized Doggies
	   // ENTER 5
	   System.out.print("How many Dogs are in the pack? :: ");
	   int size = keyboard.nextInt();
	   Doggies pack = new Doggies(size);
	   
	   // for each spot in the pack
	   for(int i = 0; i < size; i++) {
		   // get age & name of dog
		   // ENTER 20, 10, 5, 30, 2
		   System.out.print("\nEnter the age :: ");
		   age = keyboard.nextInt();
		   // ENTER Sammy, Benny, Wilee, Kelley, Baby
		   System.out.print("Enter the name :: ");
		   name  = keyboard.next();
		   
		   // create new dog in proper spot
		   pack.set(i, age, name);
	   }
	   
	   // print out some information about the pack
	   System.out.println("\n\npack :: " + pack);
	   System.out.println("\nNAME OF OLDEST :: " + pack.getNameOfOldest());
	   System.out.println("NAME OF YOUNGEST :: " + pack.getNameOfYoungest());
	   
	   // clean up scanner
	   keyboard.close();
	}		
}