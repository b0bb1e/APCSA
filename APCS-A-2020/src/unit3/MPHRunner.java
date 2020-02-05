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

public class MPHRunner
{
	public static void main( String[] args )
	{
		// declare objects & variables
		Scanner keyboard = new Scanner(System.in);
		MilesPerHour mph = new MilesPerHour();
		int dist;
		int hrs;
		int mins;
		
		// loop for as many times as sample data sets
		for (byte i = 0; i < 4; i++) {
			// get new situation
			// enter 45, 0, 32
			// enter 96, 1, 43
			// enter 100, 2, 25
			// enter 50, 2, 25
			System.out.print("Enter the distance :: ");
			dist = keyboard.nextInt();
			System.out.print("Enter the hours :: ");
			hrs = keyboard.nextInt();
			System.out.print("Enter the minutes :: ");
			mins = keyboard.nextInt();
	
			// put input into mph object & print
			mph.setNums(dist, hrs, mins);
			System.out.println("\n" + mph);
			
			// space before the next loop
			System.out.println("\n\n\n");
		}
		
	}
}