package unit6;
//(c) A+ Computer Science
//www.apluscompsci.com
//Name

import static java.lang.System.*;

public class Word
{
	// word attribute
	private String word;

	// default constructor: first sample datum
	public Word()
	{
		setString("Hello");
	}

	// constructor: set word attribute
	public Word(String s)
	{
		setString(s);
	}

	// method to set the word attribute
	public void setString(String s)
	{
		word = s;
	}

	// method to reverse & return a string
	public String getBackwards()
	{
		String back = "";
		for (int i = word.length() - 1; i >= 0; i--) {
			back += word.charAt(i) + "";
		}
		return back;
	}

	// method to print out important parts of the string
 	public String toString()
 	{
 		return word.charAt(0) + "\n" + word.charAt(word.length() - 1) + "\n" + getBackwards() + "\n" + word;
	}
}