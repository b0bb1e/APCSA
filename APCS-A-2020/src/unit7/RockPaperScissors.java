package unit7;
//(c) A+ Computer Science
// www.apluscompsci.com
//Name -  Faith Okamoto

public class RockPaperScissors
{
	// attributes to track the players' positions
	private String playChoice;
	private String compChoice;

	// default constructor: player has first option and computer has random
	public RockPaperScissors()
	{
		setPlayers("R");
		compChoice = randomChoice();
	}

	// constructor: set player's choice and computer has random
	public RockPaperScissors(String player)
	{
		setPlayers(player);
		compChoice = randomChoice();
	}

	// method to set the player's choice and randomize the computer's
	public void setPlayers(String player)
	{
		playChoice = player;
		compChoice = randomChoice();
	}
	
	// method to randomize the computer's choice
	public String randomChoice() {
		// get a random number between 0 and 2 inclusive
		int rand = (int) (Math.random() * 3);
		
		// set computer to proper choice based on the random number
		if (rand == 0) return "R";
		else if (rand == 1) return "P";
		else return "S";
	}

	// method to determine the winner and return an explanation
	public String determineWinner()
	{
		if (!playChoice.equals("R") && !playChoice.equals("P") && !playChoice.equals("S")) return "Computer wins <<Invalid Player Choice>>";
		else if (playChoice.equals("R") && compChoice.equals("S")) return "Player wins <<Rock Breaks Scissors>>";
		else if (playChoice.equals("S") && compChoice.equals("P")) return "Player wins <<Scissors Cuts Paper>>";
		else if (playChoice.equals("P") && compChoice.equals("R")) return "Player wins <<Paper Covers Rock>>";
		else if (compChoice.equals("R") && playChoice.equals("S")) return "Computer wins <<Rock Breaks Scissors>>";
		else if (compChoice.equals("S") && playChoice.equals("P")) return "Computer wins <<Scissors Cuts Paper>>";
		else if (compChoice.equals("P") && playChoice.equals("R")) return "Computer wins <<Paper Covers Rock>>";
		return "Draw Game";
	}

	// method to print out the choices and winner
	public String toString()
	{
		return "player had " + playChoice + "\ncomputer had " + compChoice + "\n!" + determineWinner() + "!";
	}
}