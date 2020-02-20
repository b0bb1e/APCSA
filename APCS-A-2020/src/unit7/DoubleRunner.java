package unit7;
//(c) A+ Computer Science
// www.apluscompsci.com
//Name -  Faith Okamoto

// import for printing outputs
import static java.lang.System.*;

public class DoubleRunner
{
	public static void main(String[] args)
	{
		// declare objects & variables
		BiggestDouble run = new BiggestDouble();
		// all the sample data sets
		double[][] doubles = new double[][] {
			{4.5, 6.7, 7.8, 9.0},
			{14.51, 6.17, 71.8, 1.0},
			{884.5, 16.7, 7.8, 9.0},
			{4.5, -456.7, 677.8, 9.0},
			{4.5, 16.7, -7.8, -9.0}
		};
			
		// loop for as many times as sample data sets
		for (byte i = 0; i < doubles.length; i++) {
			// get new sample data
			run.setDoubles(doubles[i][0], doubles[i][1], doubles[i][2], doubles[i][3]);
			
			// print out the doubles with which-is-biggest context
			System.out.println(run);
			
			// space before next loop
			System.out.println();
		}
	}
}