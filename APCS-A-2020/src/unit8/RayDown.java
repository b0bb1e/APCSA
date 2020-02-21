package unit8;
//(c) A+ Computer Science
//www.apluscompsci.com
//Name - Faith Okamoto
//Date - 2/21

public class RayDown
{
	// method to check if the ints in an array are in decreasing order
	public static boolean go(int[] numArray)
	{
		// loop through array starting on second int
		for (int i = 1; i < numArray.length; i++) {
			// if the int right before current int was less then/equal to (i.e. no greater than), whole thing is false
			if (numArray[i - 1] <= numArray[i]) return false;
		}
		
		// if the whole loop went through without flagging, the array is in order
		return true;
	}
}