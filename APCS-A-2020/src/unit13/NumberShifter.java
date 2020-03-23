package unit13;
//(c) A+ Computer Science
//www.apluscompsci.com
//Name - Faith Okamoto

public class NumberShifter {
	/**
	 * Makes an array of the desired length with randomized contents (1-10)
	 * @param size the length of the array
	 * @return an <code>int[]</code> array with randomized contents
	 */
	public static int[] makeLucky7Array(int size) {
		// create an array with the specified size
		int[] rand = new int[size];
		// at each index, use math.random() to generate an integer between 1 and 10 inclusive
		for (int i = 0; i < size; i++) rand[i] = (int) (Math.random() * 10) + 1;
		
		return rand;
	}
	
	/**
	 * Moves all the 7s in an array to the front, leaving the contents overall the same
	 * @param array the array to shift
	 */
	public static void shiftEm(int[] array) {
		// loop over all indexes after the first (assume it's already sorted
		for (int i = 1; i < array.length; i++) {
			// only bother with sorting if this index has a 7
			if (array[i] == 7) {
				// saves the index before the one which this element belongs in
				int beforeIndex = i - 1;
				// while the element being checked is not a 7 (current element belongs before it)
				while(beforeIndex > -1 && array[beforeIndex]!= 7) 
					// shift the index being checked forwards
					beforeIndex--;
				
				// swap the placement of the elements identified
				array[i] = array[beforeIndex + 1];
				array[beforeIndex + 1] = 7;
			}
		}
	}
}