package unit9;
//(c) A+ Computer Science
//www.apluscompsci.com
//Name - Faith Okamoto
//Date - 2/26

// imports for using ArrayLists
import java.util.List;
import java.util.ArrayList;

public class ListSumFirst
{
	// sums all element greater than the first one
	public static int go(List<Integer> ray)
	{
		// initialize return variable
		int sum = 0;
		// save the first value
		int first = ray.get(0);
		
		// increment sum by each value if > first
		for (Integer r : ray) if (r > first) sum += r;
		// if no values were added , sum = -1
		if (sum == 0) sum--;
		
		return sum;
	}
}