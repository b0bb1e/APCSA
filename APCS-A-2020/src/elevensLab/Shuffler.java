package elevensLab;

import java.util.Arrays;

/**
 * This class provides a convenient way to test shuffling methods.
 */
public class Shuffler {

	/**
	 * The number of consecutive shuffle steps to be performed in each call
	 * to each sorting procedure.
	 */
	private static final int SHUFFLE_COUNT = 8;

	/**
	 * The number of values to shuffle.
	 */
	private static final int VALUE_COUNT = 11;

	/**
	 * Tests shuffling methods.
	 * @param args is not used.
	 */
	public static void main(String[] args) {
		// announce type of shuffle
		System.out.println("Results of " + SHUFFLE_COUNT + " consecutive perfect shuffles:");
		// set up a new array of values
		int[] values1 = new int[VALUE_COUNT];
		for (int i = 0; i < values1.length; i++) values1[i] = i;
		
		// for as many times as SHUFFLE_COUNT
		for (int j = 1; j <= SHUFFLE_COUNT; j++) {
			// shuffle
			perfectShuffle(values1);
			
			// print out the shuffled array
			System.out.print("\n  " + j + ":");
			for (int k = 0; k < values1.length; k++) System.out.print(" " + values1[k]);
		}
		
		// same procedure as above, but different type of shuffle
		System.out.println("\n\nResults of " + SHUFFLE_COUNT + " consecutive efficient selection shuffles:");
		int[] values2 = new int[VALUE_COUNT];
		for (int i = 0; i < values2.length; i++) values2[i] = i;
		
		for (int j = 1; j <= SHUFFLE_COUNT; j++) {
			selectionShuffle(values2);
			
			System.out.print("\n  " + j + ":");
			for (int k = 0; k < values2.length; k++) System.out.print(" " + values2[k]);
		}
	}


	/**
	 * Apply a "perfect shuffle" to the argument.
	 * The perfect shuffle algorithm splits the deck in half, then interleaves
	 * the cards in one half with the cards in the other.
	 * @param values is an array of integers simulating cards to be shuffled.
	 */
	public static void perfectShuffle(int[] values) {
		// used to store shuffled values
		int[] shuffled = new int[values.length];
		// save current index in values being pulled from
		int spot = 0;
		
		// for the first half of shuffled, add even indexes to shuffled
		for (int i = 0, n = shuffled.length / 2 + 1; i < n; i++) {
			shuffled[i] = values[spot];
			spot += 2;
		}
		
		// for the second half of shuffled, add odd indexes to shuffled
		spot = 1;
		for (int i = shuffled.length / 2 + 1, n = shuffled.length; i < n; i++) {
			shuffled[i] = values[spot];
			spot += 2;
		}
		
		// copy shuffled into original array
		values = Arrays.copyOf(shuffled, values.length);
	}

	/**
	 * Apply an "efficient selection shuffle" to the argument.
	 * The selection shuffle algorithm conceptually maintains two sequences
	 * of cards: the selected cards (initially empty) and the not-yet-selected
	 * cards (initially the entire deck). It repeatedly does the following until
	 * all cards have been selected: randomly remove a card from those not yet
	 * selected and add it to the selected cards.
	 * An efficient version of this algorithm makes use of arrays to avoid
	 * searching for an as-yet-unselected card.
	 * @param values is an array of integers simulating cards to be shuffled.
	 */
	public static void selectionShuffle(int[] values) {
		// helper values in the loop
		int temp, spot;
		
		// loop through the whole array
		for (int i = values.length - 1; i >= 0; i--) {
			// generate a random number from 0 to i
			spot = (int) (Math.random() * (i + 1));
			// swap i & spot
			
			temp = values[spot];
			values[spot] = values[i];
			values[i] = temp;
		}
	}
}
