package unit6;
//(c) A+ Computer Science
//www.apluscompsci.com
//Name - Faith Okamoto

// import for printing outputs
import static java.lang.System.*; 

public class PerfectRunner
{
	public static void main(String args[])
	{
		// declare objects & variables
		Perfect p = new Perfect();
		// all sample data
		int[] nums = new int[] {496, 45, 6, 14, 8128, 1245, 33, 28, 27, 33550336};
		
		// loop for as many times as sample data sets
		for (byte i = 0; i < nums.length; i++) {
			// get new number
			p.setNum(nums[i]);
			
			// print out perfection determination
			System.out.println(p);
			
			// space before next loop
			System.out.println();
		}
	}
}