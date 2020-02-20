package unit7;
//(c) A+ Computer Science
// www.apluscompsci.com
//Name -  Faith Okmaoto

public class Triples
{
	// attribute for the maximum number
	private int number;

	// default constructor: call constructor with 0 as input
	public Triples()
	{
		this(0);
	}

	// constructor: set the maximum number to input
	public Triples(int num)
	{
		setNum(num);
	}

	// method to set the maximum numbers' value
	public void setNum(int num)
	{
		number = num;
	}
	
	// method to find the GCF of three numbers (used to get rid of non-relatively prime triples)
	private int greatestCommonFactor(int a, int b, int c)
	{
		int max = 1;
		for (int i = 2; i < a / 2 - 1; i++) {
			if (a % i == 0 && b % i == 0 && c % i == 0) max = i;
		}
		return max;
	}

	// method to return all triples up to a certain number
	public String toString()
	{
		String output = "";
		for (int a = 1; a <= number; a++) {
			for (int b = a + 1; b <= number; b += 2) {
				for (int c = b + 1; c <= number; c += 2) {
					if (c % 2 == 0) c++;
					if (Math.pow(a, 2) + Math.pow(b, 2) == Math.pow(c, 2) && greatestCommonFactor(a, b, c) == 1) output +=  a + " " + b + " " + c + "\n";
				}
			}
		}
		return output;
	}
}