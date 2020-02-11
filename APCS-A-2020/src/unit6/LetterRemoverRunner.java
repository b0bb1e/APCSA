package unit6;
//(c) A+ Computer Science
//www.apluscompsci.com
//Name - Faith Okamoto

// import for printing outputs
import static java.lang.System.*;

public class LetterRemoverRunner
{
	public static void main(String args[])
	{
		// declare objects & variables
		LetterRemover rem = new LetterRemover();
		
		// all the sample data sets
		String[] sentences = new String[] {
				"I am Sam I am",
				"ssssssssxssssesssssesss",
				"qwertyqwertyqwerty",
				"abababababa",
				"abaababababa"};
		char[] remove = new char[] {'a', 's', 'a', 'b', 'x'};
		
		// loop for as many times as sample data sets
		for (byte i = 0; i < sentences.length; i++) {
			// get new situation
			rem.setRemover(sentences[i], remove[i]);
			
			// print out situation & after-removing-algorithm
			System.out.println(rem);
			
			// space before next loop
			System.out.println("\n");
		}
	}
}