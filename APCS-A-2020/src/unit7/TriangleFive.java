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

	// method to make the char triangle
	public String toString()
	{
		// initialize triangle variable
		String triangle = "";
		
		char let = 65;
		
		// make as many rows as "amount"
		for (int row = 0; row < amount; row++) {
			// count down from total number of rows to row number
			// MATH EXPLANATION: beginning blocks are larger, and smaller blocks are not reached in later rows
			for (int block = amount; block > row; block--) {
				// count down from block number to 0
				// MATH EXPLANATION: block# is number of chars required
				for (int chars = block; chars > 0; chars--) {
					// add proper char in
					// MATH EXPLANATION: total amount of blocks - current block (beginning larger) gives the shift from the given char
					let = (char) (letter + amount - block);
					// loop around from Z-A, so mod from Z
					if (let > 90) let = (char) ((let % 90) + 64);
					triangle += let + "";
				}
				
				// space after each block
				triangle += " ";
			}
			
			// newline after each line
			triangle += "\n";
		}
		
		// return the triangle
		return triangle;
	}
}