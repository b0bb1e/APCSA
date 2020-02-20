package unit7;
//(c) A+ Computer Science
//www.apluscompsci.com
//Name - Faith Okamoto

public class TriangleFive
{
	// situation attributes
	private char letter;
	private int amount;

	// default constructor: constructor with first sample data set
	public TriangleFive()
	{
		this('C', 4);
	}

	// constructor: initialize attributes to passed-in values
	public TriangleFive(char c, int amt)
	{
		setLetAmt(c, amt);
	}

	// method to set the situation attributes
	public void setLetAmt(char c, int amt)
	{
		letter = c;
		amount = amt;
	}

	public String toString()
	{
		String output = "";
		for (int row = amount; row > 0; row--) {
			for (int block = row; block > 0; block--) {
				for (int chars = block; chars > 0; chars--) {
					output += (char) (letter + amount - block) + "";
				}
				output += " ";
			}
			output += "\n";
		}
		return output;
	}
}