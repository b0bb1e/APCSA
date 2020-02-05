package unit3;
//(c) A+ Computer Science
//www.apluscompsci.com

//Name - Faith Okamoto
//Date - 2/4/2020
//Class -
//Lab  -

// used for getting inputs & printing outputs
import java.util.Scanner; 
import static java.lang.System.*;

public class DistanceRunner
{
	public static void main( String[] args )
	{
		// declare objects & variables
		Scanner keyboard = new Scanner(System.in);
		Distance dist = new Distance();
		int x1;
		int y1;
		int x2;
		int y2;
		
		// loop for as many times as sample data sets
		for (byte i = 0; i < 3; i++) {
			// get new coordinates
			// enter 1, 1, 2, 1
			// enter 1, 1, -2, 2
			// enter 1, 1, 0, 0
			System.out.print("Enter X1 :: ");
			x1 = keyboard.nextInt();
			System.out.print("Enter Y1 :: ");
			y1 = keyboard.nextInt();
			System.out.print("Enter X2 :: ");
			x2 = keyboard.nextInt();
			System.out.print("Enter Y2 :: ");
			y2 = keyboard.nextInt();
			
			// put input into distance object & print
			dist.setCoordinates(x1, y1, x2, y2);
			System.out.println(dist);
			
			// space before the next loop
			System.out.println("\n");
		}
	}
}