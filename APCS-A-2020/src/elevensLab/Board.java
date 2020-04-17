package elevensLab;

// for arrays that can change size
import java.util.ArrayList;

/**
 * This class represents a Board that can be used in a collection
 * of solitaire games similar to Elevens.  The variants differ in
 * card removal and the board size.
 */
public abstract class Board {
	/**
	 * The cards on this board.
	 */
	private Card[] cards;

	/**
	 * The deck of cards being used to play the current game.
	 */
	private Deck deck;
	
	/**
	 * Creates a new <code>Board</code> instance.
	 * @param size the number of cards in the board
	 * @param ranks the names of the card ranks needed to create the deck
	 * @param suits the names of the card suits needed to create the deck
	 * @param pointValues the integer values of the cards needed to create
	 *                    the deck
	 */
	public Board(int size, String[] ranks, String[] suits, int[] pointValues) {
		// initialize the current-cards array
		cards = new Card[size];
		// initialize the deck
		deck = new Deck(ranks, suits, pointValues);
		// start a new game (shuffle & deal)
		do newGame();
		// keep shuffling until there is a possible move
		while (!anotherPlayIsPossible());
	}

	/**
	 * Start a new game by shuffling the deck and
	 * dealing some cards to this board.
	 */
	public void newGame() {
		deck.shuffle();
		dealMyCards();
	}

	/**
	 * Accesses the size of the board.
	 * Note that this is not the number of cards it contains,
	 * which will be smaller near the end of a winning game.
	 * @return the size of the board
	 */
	public int size() {
		return cards.length;
	}

	/**
	 * Determines if the board is empty (has no cards).
	 * @return true if this board is empty; false otherwise.
	 */
	public boolean isEmpty() {
		// loop over all cards, checking for non-null Cards
		for (Card c : cards) if (c != null) return false;
		// if all cards were null, the board is empty
		return true;
	}

	/**
	 * Deal a card to the kth position in this board.
	 * If the deck is empty, the kth card is set to null.
	 * @param k the index of the card to be dealt.
	 */
	public void deal(int k) {
		cards[k] = deck.dealCard();
	}

	/**
	 * Accesses the deck's size.
	 * @return the number of undealt cards left in the deck.
	 */
	public int deckSize() {
		return deck.size();
	}

	/**
	 * Accesses a card on the board.
	 * @return the card at position k on the board.
	 * @param k is the board position of the card to return.
	 */
	public Card cardAt(int k) {
		return cards[k];
	}

	/**
	 * Replaces selected cards on the board by dealing new cards.
	 * @param selectedCards is a list of the indices of the
	 *        cards to be replaced.
	 */
	public void replaceSelectedCards(ArrayList<Integer> selectedCards) {
		// deal a card onto each index
		for (Integer k : selectedCards) deal(k.intValue());
	}

	/**
	 * Gets the indexes of the actual (non-null) cards on the board.
	 * @return a List that contains the locations (indexes)
	 *         of the non-null entries on the board.
	 */
	public ArrayList<Integer> cardIndexes() {
		// initialize return variable
		ArrayList<Integer> selected = new ArrayList<Integer>();
		// loop over all cards
		for (int k = 0; k < cards.length; k++) 
			// if this card exits, add its index
			if (cards[k] != null) selected.add(k);
			
		return selected;
	}

	/**
	 * Generates and returns a string representation of this board.
	 * @return the string version of this board.
	 */
	public String toString() {
		// initialize return variable
		String s = "";
		// loop over all cards
		for (int k = 0; k < cards.length; k++)
			// add this card into the string
			s = s + k + ": " + cards[k] + "\n";
		
		return s;
	}

	/**
	 * Determine whether or not the game has been won,
	 * i.e. neither the board nor the deck has any more cards.
	 * @return true when the current game has been won;
	 *         false otherwise.
	 */
	public boolean gameIsWon() {
		return deck.isEmpty() && this.isEmpty();
	}

	/**
	 * Method to be completed by the concrete class that determines
	 * if the selected cards form a valid group for removal.
	 * @param selectedCards the list of the indices of the selected cards.
	 * @return true if the selected cards form a valid group for removal;
	 *         false otherwise.
	 */
	public abstract boolean isLegal(ArrayList<Integer> selectedCards);

	/**
	 * Method to be completed by the concrete class that determines
	 * if there are any legal plays left on the board.
	 * @return true if there is a legal play left on the board;
	 *         false otherwise.
	 */
	public abstract boolean anotherPlayIsPossible();

	/**
	 * Deal cards to this board to start the game.
	 */
	private void dealMyCards() {
		// loop over all indexes, dealing a card onto each
		for (int k = 0; k < cards.length; k++) deal(k);
	}
}
