package unit7;
//(c) A+ Computer Science
// www.apluscompsci.com
//Name -  Faith Okamoto

public class BiggestDouble
{
	// the doubles that are compared to each other
	private double one, two, three, four;

	// default constructor: first sample data set
	public BiggestDouble()
	{
		setDoubles(0, 0, 0, 0);
	}

	// constructor: set doubles to passed-in values
	public BiggestDouble(double a, double b, double c, double d)
	{
		setDoubles(a, b, c, d);
	}

	// method to set the values of the doubles
	public void setDoubles(double a, double b, double c, double d)
	{
		one = a;
		two = b;
		three = c;
		four = d;
	}

	// method to return whichever double is the biggest
	public double getBiggest()
	{
		if (one >= two && one >= three && one >= four) return one;
		else if (two >= one && two >= three && two >= four) return two;
		else if (three >= one && three >= two && three >= four) return three;
		else return four;
	}

	// method to print out the doubles, indicating the biggest one
	public String toString()
	{
	   return one + " " + two + " " + three + " " + four + "\nbiggest = " + getBiggest();
	}
}