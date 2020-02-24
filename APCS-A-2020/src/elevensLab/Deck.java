package elevensLab;
//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

//make a Deck class
public class Deck {
	public static final int NUMCARDS = 52;
	public static String[] SUITS = "CLUBS HEARTS DIAMONDS SPADES".split(" ");
	
	private List<Card> cards;
	private int top;

   //make a Deck constructor
	public Deck() {
		this(Card.FACES, SUITS, new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13});
	}
	
	public Deck(String[] ranks, String[] suits, int[] values) {
		cards = new ArrayList<Card>();
		top = values.length * suits.length - 1;
		
		for (String suit : suits) {
			for (int face: values) {
				cards.add(new Card(suit, face));
			}
		}
	}
	
	public boolean isEmpty() {return top == 0;}
	
	public int size() {return top + 1;}
	
	public Card dealCard() {
		if (top == 0) return null;
		top--;
		return cards.get(top + 1);
	}
   
   public void shuffle() {
	   Collections.shuffle(cards);
	   top = cards.size() - 1;
   }
}