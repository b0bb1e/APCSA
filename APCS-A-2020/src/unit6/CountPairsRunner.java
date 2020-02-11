package unit6;
//(c) A+ Computer Science
//www.apluscompsci.com
//Name Faith Okamoto

// import for printing outputs
import static java.lang.System.*; 

public class CountPairsRunner
{
	public static void main(String[] args)
	{
		// all the sample data sets
		String[] words = new String[] {
			"ddogccatppig",
			"dogcatpig",
			"xxyyzz",
			"a",
			"abc",
			"aabb",
			"dogcatpigaabbcc",
			"aabbccdogcatpig",
			"dogabbcccatpig",
			"aaaa",
			"AAAAAAAAA"};
		
		// for each word in the sample data list, count and output letter pairs
		for (byte i = 0; i < words.length; i++) System.out.println(CountPairs.pairCounter(words[i]));
	}
}