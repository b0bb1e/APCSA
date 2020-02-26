package unit9;
//(c) A+ Computer Science
//www.apluscompsci.com
//Name - Faith Okamoto
//Date - 2/26

// import to use lists
import java.util.List;

public class ListDown
{
	// method to check if the ints in a list are in decreasing order
	public static boolean go(List<Integer> numArray)
	{
		// loop through list starting on second int
		for (int i = 1; i < numArray.size(); i++) {
			// if the int right before current int was less then/equal to (i.e. no greater than), whole thing is false
			if (numArray.get(i - 1) <= numArray.get(i)) return false;
		}
		
		// if the whole loop went through without flagging, the list is in order
		return true;
	}	
}