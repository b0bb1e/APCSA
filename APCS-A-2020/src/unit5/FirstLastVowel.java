package unit5;
//(c) A+ Computer Science
//www.apluscompsci.com
//Name - Faith Okamoto
//Date - 2/10

public class FirstLastVowel
{
	// method to check if the first OR last character in a string is a vowel
	public static String go(String a)
	{
		// store lower-case versions of the first and last characters in ASCII decimal form
		int first = a.toLowerCase().charAt(0);
		int last = a.toLowerCase().charAt(a.length() - 1);
		
		// check all the lower-case ASCII values of the vowels
		if (first == 97 || first == 101 || first == 105 || first == 111 || first == 117) return "yes";
		else if (last == 97 || last == 101 || last == 105 || last == 111 || last == 117) return "yes";
		
		// if none of that panned out, the first and last characters are not vowels
		return "no";
	}
}