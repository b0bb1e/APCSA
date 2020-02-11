package unit6;
//(c) A+ Computer Science
//www.apluscompsci.com
//Name Faith Okamoto

public class CountPairs
{
	// method to count the number of letter pairs in a string
	public static int pairCounter(String str)
	{ 
		// initialize counter
		int count = 0;
		
		// compare each letter pair and increment counter if equal
		for (byte i = 0; i < str.length() - 1; i++) {
			if (str.substring(i, i + 1).equals(str.substring(i + 1, i + 2))) count++;
		}
		
		// return counter
		return count;
	}
}