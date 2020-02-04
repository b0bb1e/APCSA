package unit3;
//(c) A+ Computer Science
//www.apluscompsci.com

//Name - Faith Okamoto
//Date - 2/4/2020
//Class -
//Lab  -

import static java.lang.Math.*;

public class MilesPerHour
{
	private int distance, hours, minutes;
	private double mph;

	public MilesPerHour()
	{
		setNums(0, 0, 0);
	}

	public MilesPerHour(int dist, int hrs, int mins)
	{
		setNums(dist, hrs, mins);
	}

	public void setNums(int dist, int hrs, int mins)
	{
		distance = dist;
		hours = hrs;
		minutes = mins;
		calcMPH();
	}

	public void calcMPH()
	{
		mph = distance / (hours + (double) minutes / 60);
	}


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