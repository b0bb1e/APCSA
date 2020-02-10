package unit4;

//Name - Faith Okamoto
//Date - 2/10
//Class -
//Lab  -

// imports for getting input & printing output
import static java.lang.System.*;
import java.util.Scanner;

public class DiscountRunner
{
	public static void main(String args[])
	{
		// declare objects and variables
		Scanner keyboard = new Scanner(System.in);
		double amt;
		
		// loop for as many times as sample data
		for (byte i = 0; i < 5; i++) {
			// get new number
			// enter 500
			// enter 2500
			// enter 4000
			// enter 333.333
			// enter 95874.2154
			System.out.print("Enter the original bill amount :: ");
			amt = keyboard.nextDouble();
			
			// print discounted, rounded bill
			System.out.print("Bill after discount :: ");
			System.out.println(String.format("%.2f", Discount.getDiscountedBill(amt)));
			
			// space before next loop
			System.out.println();
		}
	}
}