package unit13;
//(c) A+ Computer Science
//www.apluscompsci.com
//Name - Faith Okamoto

public class NumberShifterRunner
{
	public static void main(String args[])
	{
		// loop for 3 data sets (like it does in the sample output)
		for (int i = 0; i < 3; i++) {
			// get a new random array
			int[] sort = NumberShifter.makeLucky7Array(20);
			// print it out, formatted properly
			System.out.print("[");
			for (int j = 0; j < sort.length - 1; j++) System.out.print(sort[j] + ", ");
			System.out.println(sort[sort.length - 1] + "]");
			
			// sort all the 7s to the front of the array
			NumberShifter.shiftEm(sort);
			// print it out, formatted properly
			System.out.print("[");
			for (int j = 0; j < sort.length - 1; j++) System.out.print(sort[j] + ", ");
			System.out.println(sort[sort.length - 1] + "]\n"); // extra \n for spacing purposes
		}
	}
}