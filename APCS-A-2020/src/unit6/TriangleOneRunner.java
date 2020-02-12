package unit6;
//(c) A+ Computer Science
//www.apluscompsci.com
//Name Faith Okamoto

// import for printing outputs
import static java.lang.System.*;

public class TriangleOneRunner
{
	public static void main (String[] args)
	{
		// declare objects & variables
		TriangleOne tri = new TriangleOne();
		// all the sample data
		String[] words = new String[] {"hippo", "abcd", "it", "a", "chicken"};
		
		// loop for as many times as sample data
		for (byte i = 0; i < words.length; i++) {
			// get new word
			tri.setWord(words[i]);
			
			// print out this words' triangle
			System.out.print(tri);
			
			// space before next loop
			System.out.print("\n\n");
		}
	}
}