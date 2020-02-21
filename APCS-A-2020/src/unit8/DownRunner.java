package unit8;
//(c) A+ Computer Science
//www.apluscompsci.com
//Name - Faith Okamoto
//Date - 2/21

// import for printing outputs
import java.lang.System.*;

public class DownRunner
{
	public static void main(String args[])
	{
		// all the sample data sets
		int[][] rays = {{-99, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 12345},
						{10, 9, 8, 7, 6, 5, 4, 3, 2, 1, -99},
						{10, 20, 30, 40, 50, -11818, 40, 30, 20, 10},
						{32767},
						{255, 255},
						{9, 10, -88, 100, -555, 1000},
						{10, 10, 10, 11, 456},
						{-111, 1, 2, 3, 9, 11, 20, 30},
						{9, 8, 7, 6, 5, 4, 3, 2, 0, -2, -989},
						{12, 15, 18, 21, 23, 1000},
						{250, 19, 17, 15, 13, 11, 10, 9, 6, 3, 2, 1, -455},
						{9, 10, -8, 10000, -5000, 1000}};
		
		// run the go method on all the int[] arrays, print out the result
		for (int[] ray : rays) System.out.println(RayDown.go(ray));
	}
}