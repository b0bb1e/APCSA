package blocks;

/**
 * Saves a simulated game level
 * @author faith
 */
public class ExampleLevel extends Level {
	/**
	 * the sequence of moves (direction byte values) the simulated player should do
	 */
	private byte[] moves;
	
	/**
	 * Initialize all instance variables
	 * @param types the types-of-tiles grid
	 * @param blocks the starting coordinates of the blocks
	 * @param player the starting coordinates of the player
	 * @param moves the sequence of simulated moves
	 */
	public ExampleLevel(char[][] types, int[][] blocks, int[] player, byte[] moves) {
		super(types, blocks, player);
		this.moves = moves;
	}
	
	/**
	 * @return the sequence of simulated moves
	 */
	public byte[] getMoves() {return moves;}
}