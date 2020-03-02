package unit10;
//(c) A+ Computer Science
//www.apluscompsci.com
//Name - Faith Okamoto

public class TriangleWord
{
	// prints out a word in a fancy triangle
	public static void printTriangle(String word)
	{
		// run for each character in the word
		for (int i = 1; i <= word.length(); i++) {
			// run for as many times as how far this has got
			for (int j = 0; j < i; j++)
				// print out the beginning substring of the word
				System.out.print(word.substring(0, i));
			// newline for next line
			System.out.println();
		}
	}
}