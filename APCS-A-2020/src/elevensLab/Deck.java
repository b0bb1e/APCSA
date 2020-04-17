package elevensLab;
//(c) A+ Computer Science
//www.apluscompsci.com
//Name - Faith Okamoto

// for arrays that can change size
import java.util.ArrayList;
// for shuffling those arrys
import java.util.Collections;

/**
 * Represents a deck of cards
 * @author faith
 */
public class Deck {
	/**
	 * possible faces
	 */
	public static final String[] FACES = {"ACE", "TWO", "THREE", "FOUR",
			"FIVE", "SIX", "SEVEN", "EIGHT", "NINE", "TEN", "JACK", "QUEEN", "KING"};
	/**
	 * possible suits
	 */
	public static String[] SUITS = {"CLUBS", "HEARTS", "DIAMONDS", "SPADES"};
	/**
	 * the Cards in this deck
	 */
	private ArrayList<Card> cards;
	/**
	 * the index of the top card
	 */
	private int top;

	/**
	 * Initializes a standard, no-joker decl
	 */
	public Deck() {
		this(FACES, SUITS, new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13});
	}
	
	/**
	 * Initializes a deck with the given ranks, suits, and point values
	 * @param ranks the ranks to use
	 * @param suits the suits to use
	 * @param values a parallel array of point values for those ranks
	 */
	public Deck(String[] ranks, String[] suits, int[] pointValues) {
		if (ranks.length != pointValues.length)
			throw new IllegalArgumentException("Wrong number of point values for given ranks");
		// initialize cards & top to correct size
		cards = new ArrayList<Card>(pointValues.length * suits.length);
		top = pointValues.length * suits.length - 1;
		
		// loop over all suit-rank combinations
		for (String suit : suits) for (int i = 0; i < ranks.length; i++)
			// add a properly initialized card to cards
			cards.add(new Card(suit, ranks[i], pointValues[i]));
	}
	
	/**
	 * Checks if the deck is empty
	 * @return whether the deck is empty
	 */
	public boolean isEmpty() {return top == -1;}
	
	/**
	 * Calculates the size of the deck
	 * @return the size of the deck
	 */
	public int size() {return top + 1;}
	
	/**
	 * Deals a card off the top of the deck
	 * @return the dealt card
	 */
	public Card dealCard() {
		// if no cards are left, return null
		if (isEmpty()) return null;
		// move top card down
		top--;
		// deal top card
		return cards.get(top + 1);
	}
   
	/**
	 * Shuffles the cards
	 */
	public void shuffle() {
		// reset the top of the deck
		resetTop();
		// use Collection's shuffle method
		Collections.shuffle(cards);
	}
   
	/**
	 * Resets the top of the deck
	 */
	public void resetTop() {top = cards.size() - 1;}
   
	/**
	 * Creates a String representation of the deck
	 */
	public String toString() {
		// if no cards are left, return that
		if (isEmpty()) return "no cards left";
		// otherwise initialize return variable
		String ret = "";
		// loop through all cards left
		for (int i = 0; i < top; i++)
			// add this card in
			ret += cards.get(i) + "\n";
		
		return ret;
	}
}