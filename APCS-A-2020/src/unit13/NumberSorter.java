package unit13;
//(c) A+ Computer Science
//www.apluscompsci.com
//Name - Faith Okamoto

public class NumberSorter
{
	/**
	 * Calculates the number of digits in a number
	 * @param number the number to find # of digits for
	 * @return the # of digits in <code>number<code>
	 */
	private static int getNumDigits(int number)
	{
		// initialize the count of digits to 0
		int count = 0;
		// dealing with the special case of number = 0
		if (number == 0) return 1;
		// while there are digits left to count
		while (number > 0) {
			// increment count and divide number by 10
			count++;
			number /= 10;
		}
		
		return count;
	}

	/**
	 * Create a sorted array of all the digits present in a number
	 * @param number the number to sort the digits of
	 * @return an array with <code>number</code>'s digits sorted from least to greatest
	 */
	public static int[] getSortedDigitArray(int number)
	{
		// initialize the array of sorted digits
		int[] sorted = new int[getNumDigits(number)];
		
		// running count of how many digits have been sorted
		int digitsSorted = 0;
		// while digits are left to sort
		while (number > 0) {
			// pull the digit out
			int digit = number % 10;
			// at first, this digit after all the digits already sorted
			int index = digitsSorted;
			// while the number before it in the array is greater (not sorted properly)
			while (index > 0 && digit < sorted[index - 1]) {
				// shift said number back
				sorted[index] = sorted[index - 1];
				// move index being checked forward
				index--;
			}
			
			// put this digit in is proper place
			sorted[index] = digit;
			// pull the next bit of the number out
			number /= 10;
			// increment the count of already-sorted digits
			digitsSorted++;
		}
		
		return sorted;
	}
}