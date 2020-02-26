package unit9;
//(c) A+ Computer Science
//www.apluscompsci.com
//Name - Faith Okamoto
//Date - 2/26

// imports to use ArrayLists
import java.util.ArrayList;
import java.util.List;

public class ListOddToEven
{
	// method to find distance between first odd & next even indexes
	public static int go(List<Integer>ray )
	{
		// variables to save if and where an odd was found
		int odd = 0;
		boolean gotOdd = false;
		
		// go through the list
		for (byte i = 0; i < ray.size(); i++) {
			// if an odd has not yet been found and the current value is odd
			if (!gotOdd && ray.get(i) % 2 == 1) {
				// note where and that and odd was found
				gotOdd = true;
				odd = i;
			}
			
			// or if an odd has been found and the current value is even return the difference in index
			else if (gotOdd && ray.get(i) % 2 == 0) return i - odd;
		}
		
		// if the loop finished without returning, return -1
		return -1;
	}
}