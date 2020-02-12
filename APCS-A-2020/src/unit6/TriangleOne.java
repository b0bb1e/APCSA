package unit6;
//(c) A+ Computer Science
//www.apluscompsci.com
//Name Faith Okamoto

public class TriangleOne
{
	// word Attribute
	private String word;

	// default constructor: first sample datum
	public TriangleOne()
	{
		setWord("hippo");
	}

	// constructor: set word attribute
	public TriangleOne(String s)
	{
		setWord(s);
	}

	// method to set the word attribute
	public void setWord(String s)
	{
		word = s;
	}

	// method to print out the triangle of a word
	public String toString()
	{
		// initialize the fancy triangle
		String triangle = "";
		for (int i = word.length(); i > 0; i--) {
			triangle += word.substring(0, i) + "\n";
		}
		return triangle;
	}
}