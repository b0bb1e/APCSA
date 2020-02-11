package unit5;
//(c) A+ Computer Science
//www.apluscompsci.com

//Name - Faith Okamoto
//Date - 2/10
//Class -
//Lab  -

public class WordsCompare
{
	// attributes for words
	private String wordOne, wordTwo;
	private int compare;

	// default constructor: first sample data set
	public WordsCompare()
	{
		setWords("abe", "ape");
	}

	// constructor: set words
	public WordsCompare(String one, String two)
	{
		setWords(one, two);
	}

	// method to set word attributes
	public void setWords(String one, String two)
	{
		wordOne = one;
		wordTwo = two;
		
		// recalculate the comparison
		compare();
	}

	// method to alphabetically compare the words
	private void compare()
	{
		compare = wordOne.compareTo(wordTwo);
	}

	// method to print out the words with calculated context
	public String toString()
	{
		if(compare < 0) return wordOne + " should be placed before " + wordTwo;
		else return wordOne + " should be placed after " + wordTwo;
	}
}