package blocks;

/**
 * Immutable information about a level of Blocks
 * @author faith
 */
public class Level {
	/**
	 * the types-of-tiles grid
	 */
	private final char[][] types;
	/**
	 * the starting coordinates of the blocks
	 */
	private final int[][] blocks;
	/**
	 * the starting coordinates of the player
	 */
	private final int[] player;
	
	/**
	 * Initialize all instance variables
	 * @param types the types-of-tiles grid
	 * @param blocks the starting coordinates of the blocks
	 * @param player the starting coordinates of the player
	 */
	public Level(char[][] types, int[][] blocks, int[] player) {
		this.types = types;
		this.blocks = blocks;
		this.player = player;
	}
	
	/**
	 * @return the types-of-tiles grid
	 */
	public char[][] getTypes() {return types;}
	
	/**
	 * @return the starting coordinates of the blocks
	 */
	public int[][] getBlocks() {return blocks;}
	
	/**
	 * @return the starting coordinates of the player
	 */
	public int[] getPlayer() {return player;}

	public String toString() {
		// class identifier
		String ret = "Level\n";
		// add in types grid, space/newline separated
		for (char[] row : types) {
			for (char type : row) ret += type + " ";
			ret += '\n';
		}
		
		// add in each block, space-separated
		ret += "Blocks at:";
		for (int[] block : blocks) ret += " (" + block[0] + ", " + block[1] + ")";
		// return with player location tacked on
		return ret + "\nPlayer at: (" + player[0] + ", " + player[1] + ")";
	}
}