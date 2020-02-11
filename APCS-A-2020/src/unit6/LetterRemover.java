package unit6;
//(c) A+ Computer Science
//www.apluscompsci.com
//Name - Faith Okamoto

public class LetterRemover
{
	// situation attributes
	private String sentence;
	private char lookFor;

	// default constructor: first sample data set
	public LetterRemover()
	{
		setRemover("I am Sam I am", 'a');
	}

	// constructor: set situation attributes
	public LetterRemover(String s, char rem)
	{
		setRemover(s, rem);
	}
	
	// method to set situation attributes
	public void setRemover(String s, char rem)
	{
		sentence = s;
		lookFor = rem;
	}

	// method to remove a letter from a string
	public String removeLetters()
	{
		String cleaned = "";
		for (byte i = 0; i < sentence.length(); i++) {
			if (sentence.charAt(i) != lookFor) cleaned += sentence.charAt(i);
		}
		return cleaned;
	}

	// method to print out the attributes' values and the output
	public String toString()
	{
		return sentence + " - letter to remove " + lookFor + "\n" + removeLetters();
	}
}