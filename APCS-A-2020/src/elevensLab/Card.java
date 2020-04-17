package elevensLab;
//(c) A+ Computer Science
//www.apluscompsci.com
//Name - Faith Okamoto

/**
 * Represents a card used for playing card games
 * @author faith
 */
public class Card {
	/**
	 * the suit/rank of the card
	 */
	private String suit, rank;
	/**
	 * the face = rank as a number, pointValue = value in the game
	 */
	private int face, pointValue;
	/*
	 * a value to set int instance variables to to indicate no value
	 */
	public final static int NOT_SPECIFIED = Integer.MIN_VALUE;

	// a bunch of constructors that all call the main, 4-arg constuctor
	
	/**
	 * Initializes the suit and rank of the card
	 * @param suit the suit of the card
	 * @param rank the rank (like "ace") of the card
	 */
	public Card(String suit, String rank) {
		this(suit, rank, NOT_SPECIFIED, NOT_SPECIFIED);
	}
	
	/**
	 * Initializes the suit and face value of the card
	 * @param suit the suit of the card
	 * @param face the face value (like 1) of the card
	 */
	public Card(String suit, int face) {
		this(suit, null, face, NOT_SPECIFIED);
	}
	
	/**
	 * Initializes the suit, face, and point value of the card
	 * @param suit the suit of the card
	 * @param face the face value (like 1) of the card
	 * @param pointValue the point value of the card
	 */
	public Card(String suit, int face, int pointValue) {
		this(suit, null, face, pointValue);
	}
	
	/**
	 * Initializes the suit, rank, and point value of the card
	 * @param suit the suit of the card
	 * @param rank the rank (like "ace") of the card
	 * @param pointValue the point value of the card
	 */
	public Card(String suit, String rank, int pointValue) {
		this(suit, rank, NOT_SPECIFIED, pointValue);
	}
	
	/**
	 * Initializes all instance variables
	 * @param suit the suit of the card
	 * @param rank the rank (like "ace") of the card
	 * @param face the face value (like 1) of the card
	 * @param pointValue the point value of the card
	 */
	public Card(String suit, String rank, int face, int pointValue) {
		if (suit == null)
			throw new IllegalArgumentException("Suit cannot be null");
		if (rank == null && face < 1)
			throw new IllegalArgumentException("Face must be positive");
		this.rank = rank;
		this.suit = suit;
		this.face = face;
		this.pointValue = pointValue;
	}

	// setters
	
	public void setSuit(String suit) {
		if (suit == null)
			throw new IllegalArgumentException("Suit can't be null");
		else this.suit = suit;
	}
	
	public void setRank(String rank) {
		if (face == NOT_SPECIFIED && rank == null)
			throw new IllegalArgumentException("Rank can't be null");
		else this.rank = rank;
	}
	
	public void setFace(int face) {
		if (rank == null && face == NOT_SPECIFIED)
			throw new IllegalArgumentException("Face must exist");
		else if (face < 1)
			throw new IllegalArgumentException("Face must be positive");
		else this.face = face;
	}
	
	public void setPointValue(int points) {pointValue = points;}

	// getters
	
	public String getSuit() {return suit;}
	
	public String getRank() {return rank;}
	
	public int getFace() {return face;}
	
	public int getPointValue() {return pointValue;}
	
	/**
	 * Checks if a card has the same values as this one
	 * @param check the card to check
	 * @return whether the card matches in all instance variables
	 */
	public boolean matches(Card check) {
		return check.getSuit().equals(suit) &&
				check.getFace() == face &&
				check.getRank().equals(rank) &&
				check.getPointValue() == pointValue;
	}

	/**
	 * Creates a String representation of the card
	 */
	public String toString() {
		// initialize return variable
		String ret = "";
		
		// if there is a rank
		if (rank != null) {
			// use it
			ret += rank + " ";
			// if there is also a face, add that in
			if (face != NOT_SPECIFIED) ret += "(" + face + ") ";
			// add in an "of" before the suit
			ret += "of ";
		}
		// if there isn't a rank, use the face
		else ret += face + " of ";
		
		// add in the face
		ret += suit + " ";
		// if there is a point value, add that in
		if (pointValue != NOT_SPECIFIED) ret += " (point value=" + pointValue + ")";
		
		return ret;
	}
}