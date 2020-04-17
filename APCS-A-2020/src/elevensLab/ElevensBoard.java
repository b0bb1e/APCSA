package elevensLab;

// for arrays that can change size
import java.util.ArrayList;

/**
 * The ElevensBoard class represents the board in a game of Elevens.
 */
public class ElevensBoard extends Board {
	/**
	 * The size (number of cards) on the board.
	 */
	private static final int BOARD_SIZE = 9;
	/**
	 * The ranks of the cards for this game to be sent to the deck.
	 */
	private static final String[] RANKS = { "ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "jack", "queen",
			"king" };
	/**
	 * The suits of the cards for this game to be sent to the deck.
	 */
	private static final String[] SUITS = { "spades", "hearts", "diamonds", "clubs" };
	/**
	 * The values of the cards for this game to be sent to the deck.
	 */
	private static final int[] POINT_VALUES = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 0, 0, 0 };

	/**
	 * Creates a new <code>ElevensBoard</code> instance.
	 */
	public ElevensBoard() {
		super(BOARD_SIZE, RANKS, SUITS, POINT_VALUES);
	}

	/**
	 * Determines if the selected cards form a valid group for removal. In Elevens,
	 * the legal groups are (1) a pair of non-face cards whose values add to 11, and
	 * (2) a group of three cards consisting of a jack, a queen, and a king in some
	 * order.
	 * 
	 * @param selectedCards the list of the indices of the selected cards.
	 * @return true if the selected cards form a valid group for removal; false
	 *         otherwise.
	 */
	@Override
	public boolean isLegal(ArrayList<Integer> selectedCards) {
		// if there are two cards selected, check for 11 pair
		if (selectedCards.size() == 2) return containsPairSum11(selectedCards);
		// if there are three cards selected, check for JQK
		else if (selectedCards.size() == 3) return containsJQK(selectedCards);
		// any other number is illegal
		else return false;
	}

	/**
	 * Determine if there are any legal plays left on the board. In Elevens, there
	 * is a legal play if the board contains (1) a pair of non-face cards whose
	 * values add to 11, or (2) a group of three cards consisting of a jack, a
	 * queen, and a king in some order.
	 * 
	 * @return true if there is a legal play left on the board; false otherwise.
	 */
	@Override
	public boolean anotherPlayIsPossible() {
		// get all valid indexes on the board
		ArrayList<Integer> valid = cardIndexes();
		
		// loop through all but last as the first card in a set
		for (int i = 0; i < valid.size() - 1; i++) {
			// initialize a currently-checking array
			ArrayList<Integer> check = new ArrayList<Integer>(3);
			// add the first card in
			check.add(valid.get(i));
			// add a null placeholder
			check.add(null);
			
			// if the first card is a JQK
			if (cardAt(check.get(0)).getRank().length() > 3) {
				// add another null placeholder
				check.add(null);
				
				// loop through all cards but last after this one
				for (int j = i + 1; j < valid.size() - 1; j++) {
					// if this card is also a JQK
					if (cardAt(valid.get(j)).getRank().length() > 3) {
						// use it as the second card
						check.set(1, valid.get(j));
						
						// loop through all cards after it
						for (int k = j + 1; k < valid.size(); k++) {
							// if this card is also a JQK
							if (cardAt(valid.get(k)).getRank().length() > 3) {
								// use it as the third card
								check.set(2, valid.get(k));
								// if this set is a JQK, there is a possible move
								if (containsJQK(check)) return true;
							}
						}
					}
				}
			}
			
			// or if the first card is not a JQK
			else {
				// loop through all cards after it
				for (int j = i + 1; j < valid.size(); j++) {
					// if this card is also not a JQK
					if (cardAt(valid.get(j)).getRank().length() <= 3) {
						// use it as the second card
						check.set(1, valid.get(j));
						// if this set is an 11, there is a possible move
						if (containsPairSum11(check)) return true;
					}
				}
			}
		}
		
		// if none of the cards formed sets, there are no possible moves
		return false;
	}

	/**
	 * Check for an 11-pair in the selected cards.
	 * 
	 * @param selectedCards selects a subset of this board. It is list of indexes
	 *                      into this board that are searched to find an 11-pair.
	 * @return true if the board entries in selectedCards contain an 11-pair; false
	 *         otherwise.
	 */
	private boolean containsPairSum11(ArrayList<Integer> selectedCards) {
		// if there are two cards and their points values add to 11, this is an 11-pair
		if (selectedCards.size() == 2
				&& cardAt(selectedCards.get(0)).getPointValue()
				+ cardAt(selectedCards.get(1)).getPointValue() == 11)
			return true;
		// otherise it isn't
		else return false;
	}

	/**
	 * Check for a JQK in the selected cards.
	 * 
	 * @param selectedCards selects a subset of this board. It is list of indexes
	 *                      into this board that are searched to find a JQK group.
	 * @return true if the board entries in selectedCards include a jack, a queen,
	 *         and a king; false otherwise.
	 */
	private boolean containsJQK(ArrayList<Integer> selectedCards) {
		// if there are 3 cards
		if (selectedCards.size() == 3) {
			// get the list of faces
			ArrayList<String> faces = faceCards();
			
			// loop over all of the cards
			for (Integer index : selectedCards) {
				// if this card's face is in the needed-faces
				if (faces.contains(cardAt(index).getRank()))
					// use it
					faces.remove(cardAt(index).getRank());
				// otherwise this is not a JQK
				else return false;
			}
			// if all faces were contained, then this is a JQK
			return true;
		}
		// otherwise this is not a JQK
		else return false;
	}

	/**
	 * Get all face cards' ranks
	 * @return an ArrayList with all ranks that are face cards
	 */
	private ArrayList<String> faceCards() {
		// initialize return variable
		ArrayList<String> faces = new ArrayList<String>(3);
		// add faces in
		faces.add("jack");
		faces.add("queen");
		faces.add("king");
		
		return faces;
	}
}
