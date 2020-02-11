package unit5;
//(c) A+ Computer Science
//www.apluscompsci.com

//Name - Faith Okamoto
//Date - 2/11
//Class -
//Lab  -

// import for printing outputs
import static java.lang.System.*;

public class WordsCompareRunner
{
	public static void main( String args[] )
	{
		// declare objects and variables
		WordsCompare dictionary = new WordsCompare();
		// all the sample data sets
		String[][] words = new String[][] {
			{"abe", "ape"},
			{"giraffe", "gorilla"},
			{"one", "two"},
			{"fun", "funny"},
			{"123", "19"},
			{"193", "1910"},
			{"goofy", "godfather"},
			{"funnel", "fun"}};
		
		// loop for as many times as sample data sets
		for (byte i = 0; i < words.length; i++) {
			// set the new words from the array of sample words
			dictionary.setWords(words[i][0], words[i][1]);
			
			// print out the alphabetization
			System.out.println(dictionary);
			
			// space before next loop
			System.out.println();
		}

	}
}