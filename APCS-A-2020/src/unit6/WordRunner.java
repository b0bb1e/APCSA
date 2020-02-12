package unit6;
//(c) A+ Computer Science
//www.apluscompsci.com
//Name Faith Okamoto

// import for printing outputs
import static java.lang.System.*;

public class WordRunner
{
	public static void main (String[] args)
	{
		// declare objects & variables
		Word reverse = new Word();
		// all the sample data
		String[] words = new String[] {"Hello", "World", "JukeBox", "TCEA", "UIL"};
		
		// loop for as many times as sample data sets
		for (byte i = 0; i < words.length; i++) {
			// get new word
			reverse.setString(words[i]);
			
			// print out the first, last, reverse, and original
			System.out.print(reverse);
			
			// space before next loop
			System.out.print("\n\n\n");
		}
	}
}