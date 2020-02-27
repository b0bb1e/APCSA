package elevensLab;
//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

public class Card
{
	public static final String FACES[] = {"ACE", "TWO", "THREE", "FOUR",
			"FIVE", "SIX", "SEVEN", "EIGHT", "NINE", "TEN", "JACK", "QUEEN", "KING"};

	private String suit;
	private int face, pointValue;

	public Card(String s, int value) {
		suit = s;
		face = value;
		pointValue = 0;
	}
	
	public Card(String s, int value, int points) {
		suit = s;
		face = value;
		pointValue = points;
	}

	public void setSuit(String s) {suit = s;}
	
	public void setFace(int value) {face = value;}
	
	public void setPointValue(int points) {pointValue = points;}

	public String getSuit() {return suit;}
	
	public int getFace() {return face;}
	
	public int getPointValue() {return pointValue;}
	
	public boolean isEqual(Card check) {
		return check.getSuit() == suit && check.getFace() == face;
	}

	public String toString() {
		if (pointValue == 0) return FACES[face - 1] + " of " + suit + " (point value = " + face + ")";
		return FACES[face - 1] + " of " + suit + " (point value = " + pointValue + ")";
	}
}