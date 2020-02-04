package unit3;
//(c) A+ Computer Science 
//www.apluscompsci.com

//Name - Faith Okamoto
//Date - 2/4/2020
//Class -
//Lab  -

import static java.lang.Math.*;

public class Distance
{
	private int xOne,yOne,xTwo,yTwo;
	private double distance;

	public Distance()
	{
		setCoordinates(0, 0, 0, 0);
	}

	public Distance(int x1, int y1, int x2, int y2)
	{
		setCoordinates(x1, y1, x2, y2);
	}

	public void setCoordinates(int x1, int y1, int x2, int y2)
	{
		xOne = x1;
		yOne = y1;
		xTwo = x2;
		yTwo = y2;
		calcDistance();
	}

	public void calcDistance()
	{
		distance = Math.sqrt(0.0 + Math.pow(xOne - xTwo, 2) + Math.pow(yOne - yTwo, 2));
	}
	
	public double getDistance()
	{
		return distance;
	}

	public String toString()
	{
		return "distance == " + ((double) Math.round(distance * 1000) / 1000);
	}
}