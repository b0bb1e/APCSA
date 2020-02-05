package unit3;
//(c) A+ Computer Science 
//www.apluscompsci.com

//Name - Faith Okamoto
//Date - 2/4/2020
//Class -
//Lab  -

// used for calculations
import static java.lang.Math.*;

public class Distance
{
	// attributes for location of points & distance
	private int xOne, yOne, xTwo, yTwo;
	private double distance;

	// default constructor: both points are at (0, 0)
	public Distance()
	{
		setCoordinates(0, 0, 0, 0);
	}

	// constructor: set points' coordinates
	public Distance(int x1, int y1, int x2, int y2)
	{
		setCoordinates(x1, y1, x2, y2);
	}

	// method to set coordinate points
	public void setCoordinates(int x1, int y1, int x2, int y2)
	{
		xOne = x1;
		yOne = y1;
		xTwo = x2;
		yTwo = y2;
		// recalculate the distance between points
		calcDistance();
	}

	// method to calculate the distance between two points
	public void calcDistance()
	{
		distance = Math.sqrt(0.0 + Math.pow(xOne - xTwo, 2) + Math.pow(yOne - yTwo, 2));
	}
	
	// method to print out the important attribute with context
	public String toString()
	{
		return "distance == " + ((double) Math.round(distance * 1000) / 1000);
	}
}