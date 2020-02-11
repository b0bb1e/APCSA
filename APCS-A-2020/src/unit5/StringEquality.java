package unit5;
//(c) A+ Computer Science
//www.apluscompsci.com

//Name - Faith Okamoto
//Date - 2/11
//Class -
//Lab  -

public class StringEquality
{
	// attributes for words
	private String wordOne, wordTwo;

	// default constructor: first sample data set
	public StringEquality()
	{
		setWords("hello", "goodbye");
	}

	// constructor: set words
	public StringEquality(String one, String two)
	{
		setWords(one, two);
	}

	// method to set the word attributes
	public void setWords(String one, String two)
	{
		wordOne = one;
		wordTwo = two;
	}

	// method to check if the word attributes contain the same letters
	public boolean checkEquality()
	{
		// since only letters matter, make everything lower case
		if (wordOne.toLowerCase().equals(wordTwo.toLowerCase())) return true;
		return false;
	}

	// method to print out the words with calculated context
	public String toString()
	{
		if (checkEquality()) return wordOne + " has the same letters as " + wordTwo;
		return wordOne + " does not have the same letters as " + wordTwo;
	}
}