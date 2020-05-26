package blocks;

// for drawing
import java.awt.Graphics;
import java.awt.Color;

/**
 * A Grid which can simulate an example game
 * @author faith
 */
public class ExampleGrid extends Grid {
	/**
	 * an ordered array of moves the player should take
	 */
	private byte[] moves;
	/**
	 * the index of the player's current move
	 */
	private int moveNum;
	/**
	 * the simulated player's score
	 */
	private int score;
	
	/**
	 * Initialize an ExampleGrid based on an ExampleLevel
	 * @param level the ExampleLevel to use
	 */
	public ExampleGrid(ExampleLevel level) {
		this(level.getTypes(), level.getBlocks(), level.getPlayer(), level.getMoves());
	}
	
	/**
	 * Initialize an ExampleGrid given positional information
	 * @param types a grid of Tile types (B=Blank, W=Wall, T=Target)
	 * @param blocks the initial locations [row, col] of all blocks
	 * @param player the initial location [row, col] of the player
	 * @param moves the byte values of simulated moves to be made
	 */
	public ExampleGrid(char[][] types, int[][] blocks, int[] player, byte[] moves) {
		// initialize the underlying Grid
		super(types, blocks, player);
		// save moves, start on the first one, set lastMove to now
		this.moves = moves;
	}
	
	/**
	 * Adds a string describing the moves by the simulated player
	 */
	public void draw(Graphics window) {
		// draw the underlying Grid
		super.draw(window);
		// set display string
		String display = "";
		// if there was a move made, write out what it was
		if (moveNum > 0) 
			display = "Moved " + dirToString(moves[moveNum - 1]) + "          ";
		// add in current score
		display += "Score = " + score;
		// draw the string
		window.setColor(Color.BLACK);
		window.drawString(display, (getCols() + 1) * Tile.SIZE, 50);
	}
	
	/**
	 * Simulates the next move
	 */
	public void nextMove() {
		// if there are more moves to go
		if (moveNum < moves.length) {
			// add on to score if the next move moves the player
			if (movePlayer(moves[moveNum++])) ++score;
		}
		// otherwise
		else {
			// undo everthing
			while (undo()) {}
			moveNum = 0;
			score = 0;
		}
	}
}