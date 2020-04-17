package elevensLab;
//(c) A+ Computer Science
//www.apluscompsci.com
//Name - Faith Okamoto

public class DeckRunner
{
	public static void main( String args[] )
	{
		// create a new Deck
		Deck test = new Deck();
		
		// print out initial permutation of cards
		System.out.println( "All cards in order." );
		for( int j = 1; j <= 52; j++ ) System.out.println(test.dealCard());
		
		// shuffled cards
		test.shuffle();	
		
		// print out shuffled permutation of cards
		System.out.println( "\n\nAll cards after shuffling." );
		for( int j = 1; j <= 52; j++ ) System.out.println( test.dealCard() );
	}
}