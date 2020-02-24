package elevensLab;
//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

public class Card
{
	public static final String FACES[] = {"ACE", "TWO", "THREE", "FOUR",
			"FIVE", "SIX", "SEVEN", "EIGHT", "NINE", "TEN", "JACK", "QUEEN", "KING"};

	private String suit;
	private int face;

  	//constructors
	public Card(String s, int value) {
		suit = s;
		face = value;
	}

	public void setSuit(String s) {suit = s;}
	
	public void setFace(int value) {face = value;}

	public String getSuit() {return suit;}
	
	public int getFace() {return face;}
	
	public boolean isEqual(Card check) {
		return check.getSuit() == suit && check.getFace() == face;
	}

	public String toString() {
		return FACES[face - 1] + " of " + suit + " (point value = " + face + ")";
	}
}