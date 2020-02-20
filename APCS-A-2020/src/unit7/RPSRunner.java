package unit7;
//(c) A+ Computer Science
// www.apluscompsci.com
//Name -  Faith Okamoto

// import for printing outputs and accepting inputs
import java.util.Scanner;
import static java.lang.System.*;

public class RPSRunner
{
	public static void main(String args[])
	{
		// declare objects & variables
		Scanner keyboard = new Scanner(System.in);
		RockPaperScissors game = new RockPaperScissors();	
		String response;
		boolean again = false;
		
		// play the game at least once
		do {
			// prompt the player for a choice and save the first (uppercased) char
			System.out.print("Rock-Paper-Scissors - pick your weapon[R,P,S] :: ");
			response = keyboard.next().toUpperCase().substring(0, 1);
			
			// input choice into game object
			game.setPlayers(response);
			
			// print out the result of the game and prompt to play again
			System.out.println(game);
			System.out.print("\nDo you want to play again? ");
			
			// if the first (lowercased) char indicates they want to play again, note it in the loop variable
			if (keyboard.next().toLowerCase().charAt(0) == 'y') {
				again = true;
				System.out.println();
			}
			// else note in the loop variable
			else again = false;
		}
		// only play another game if the player wanted to
		while(again);
		
		// clean up the Scanner object
		keyboard.close();
	}
}



