package unit8;
//(c) A+ Computer Science
//www.apluscompsci.com
//Name - Faith Okamoto
//Date - 2/21

public class RaySumLast
{
	public static int go(int[] ray)
	{
		// initialize return variable
		int sum = 0;
		// get last value in the array
		int last = ray[ray.length - 1];
		
		// used to check if any values were added to sum at all
		boolean added = false;
		
		// for each
		for (int i : ray) {
			// if value is big enough, note that a value was added to sum and add it
			if (i > last) {
				added = true;
				sum += i;
			}
		}
		
		// if no values were added (if statement never executed), sum = -1
		if (!added) sum = -1;
		
		// return the sum
		return sum;
	}
}