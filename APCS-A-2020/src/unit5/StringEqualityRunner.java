package unit5;
//(c) A+ Computer Science
//www.apluscompsci.com

//Name - Faith Okamoto
//Date - 2/11
//Class -
//Lab  - 

// import for printing outputs
import static java.lang.System.*;

public class StringEqualityRunner
{
	public static void main(String args[])
	{
		// declare objects and variables
		StringEquality eq = new StringEquality();
		// all the sample data sets
		String[][] words = new String[][] {
			{"hello", "goodbye"},
			{"one", "two"},
			{"three", "four"},
			{"TCEA", "UIL"},
			{"State", "Champions"},
			{"ABC", "ABC"},
			{"ABC", "CBA"},
			{"Same", "Same"}};
			
		// loop for as many times as sample data sets
		for (byte i = 0; i < words.length; i++) {
			// set the new words from the array of sample words
			eq.setWords(words[i][0], words[i][1]);
			
			// print out the comparison
			System.out.println(eq);
			
			// space before next loop
			System.out.println();
		}
	}
}