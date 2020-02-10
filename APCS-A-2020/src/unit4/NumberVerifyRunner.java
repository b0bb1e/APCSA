package unit4;

//Name - Faith Okamoto
//Date - 2/10
//Class -
//Lab  -

// used for getting inputs & printing outputs
import static java.lang.System.*;
import java.util.Scanner;

public class NumberVerifyRunner
{
	public static void main ( String[] args )
	{
		// declare objects & variables
		Scanner keyboard = new Scanner(System.in);
		int num;
		
		// loop for as many times as sample data
		for (byte i = 0; i < 5; i++) {
			// get new number
			// enter 111
			// enter 2000
			// enter -99
			// enter 1111
			// enter -850
			System.out.print("Enter a whole number :: ");
			num = keyboard.nextInt();
			
			// print oddness and evenness
			System.out.println(num + " is odd :: " + NumberVerify.isOdd(num));
			System.out.println(num + " is even :: " + NumberVerify.isEven(num));
			
			// space before next loop
			System.out.println();
		}
	}
}