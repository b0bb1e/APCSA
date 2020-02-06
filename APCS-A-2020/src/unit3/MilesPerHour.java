package unit3;
//(c) A+ Computer Science
//www.apluscompsci.com

//Name - Faith Okamoto
//Date - 2/4/2020
//Class -
//Lab  -

// used for rounding
import static java.lang.Math.*;

public class MilesPerHour
{
	// attributes for situation & speed
	private int distance, hours, minutes;
	private double mph;

	// default constructor: first sample data set
	public MilesPerHour()
	{
		setNums(45, 0, 32);
	}

	// constructor: set situation attributes
	public MilesPerHour(int dist, int hrs, int mins)
	{
		setNums(dist, hrs, mins);
	}

	// method to set situation attributes
	public void setNums(int dist, int hrs, int mins)
	{
		// if no time has passed, force no movement to have happened either
		if (hrs == 0 && mins == 0) distance = 0;
		else distance = dist;
		hours = hrs;
		minutes = mins;
		// recalculate the speed
		calcMPH();
	}

	// method to calculate the speed given the situation
	private void calcMPH()
	{
		if (hours == 0 && minutes == 0) mph = 0;
		else mph = distance / (hours + (double) minutes / 60);
	}


	// method to print out the attributes with context
	public String toString()
	{
		String milesWord = "miles";
		String hoursWord = "hours";
		String minutesWord = "minutes";
		if (distance == 1) milesWord = "mile";
		if (hours == 1) hoursWord = "hour";
		if (minutes == 1) minutesWord = "minute";
		return distance + " " + milesWord + " in " + hours + " " + hoursWord + " and " + minutes + " " + minutesWord + " = " + Math.round(mph) + " MPH.";
	}
}