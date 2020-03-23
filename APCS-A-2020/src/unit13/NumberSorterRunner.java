package unit13;
//(c) A+ Computer Science
//www.apluscompsci.com
//Name - Faith Okamoto

public class NumberSorterRunner {
	public static void main(String args[]) {
		// all the sample data sets
		int[] cases = {567891, 901912468, 864213507, 898777, 234422};
		
		// loop over the sample data sets
		for(int test : cases) {
			// get the digit array
			int[] one = NumberSorter.getSortedDigitArray(test);
			// print it out
			for(int item : one) System.out.print(item + " ");
			// space before the next loop
			System.out.println();
		}
	}
}