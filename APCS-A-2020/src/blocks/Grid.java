package blocks;

// for arrays that can change size
import java.util.ArrayList;

// for drawing
import java.awt.Graphics;
import java.awt.Color;

/**
 * A Grid that can play Blocks. Can move the player around and check for win.
 * @author faith
 */
public class Grid {
	/**
	 * the 2-D array tile grid
	 */
	private Tile[][] tiles;
	/**
	 * an array of all TargetTiles, for win checking
	 */
	private TargetTile[] targets;
	/**
	 * the location [row, col] of the player
	 */
	private int[] player;
	/**
	 * a record of all moves made by the player
	 */
	private ArrayList<Byte> moves;
	
	/**
	 * a constant for the up (^) direction
	 */
	public static final byte UP = 1;
	/**
	 * a constant for the right (>) direction
	 */
	public static final byte RIGHT = 2;
	/**
	 * a constant for the down (\/) direction
	 */
	public static final byte DOWN = 3;
	/**
	 * a constant for the left (<) direction
	 */
	public static final byte LEFT = 4;
	
	/**
	 * the Color of the player
	 */
	public static final Color PLAYER_COLOR = new Color(132, 184, 11);
	
	/**
	 * Initialize a Grid based on a Level
	 * @param level the Level to use data from
	 */
	public Grid(Level level) {
		// call the Level's getters for all necessary information
		this(level.getTypes(), level.getBlocks(), level.getPlayer());
	}
	
	/**
	 * Initialize a Grid given positional information
	 * @param types a grid of Tile types (B=Blank, W=Wall, T=Target)
	 * @param blocks the initial locations [row, col] of all blocks
	 * @param player the initial location [row, col] of the player
	 */
	public Grid(char[][] types, int[][] blocks, int[] player) {
		// initialize tiles grid to proper size
		tiles = new Tile[types.length][types[0].length];
		
		// the index of targets to add to
		int numTargets = 0;
		
		// loop over all cells in the tile/types grid
		for (int row = 0; row < types.length; ++row)
			for (int col = 0; col < types[0].length; ++col) {
				// if the types grid has B, then put a BlankTIle here
				if (types[row][col] == 'B')
					tiles[row][col] = new BlankTile();
				// if the types grid has W, then put a WallTile here
				else if (types[row][col] == 'W')
					tiles[row][col] = new WallTile();
				// if the types grid has T
				else if (types[row][col] == 'T') {
					// add a new target to the target array (and increment index)
					++numTargets;
					// copy TargetTile into tiles grid
					tiles[row][col] = new TargetTile();
				}
				// if the types grid has another char here
				else throw new IllegalArgumentException(
						// something went wrong!
						"Tile type not recognized (B, W, T)");
			}
		
		// initialize target-array length to proper size
		targets = new TargetTile[numTargets];
		int targetIndex = 0;
		for (Tile[] row : tiles) for (Tile tile : row)
			if (tile.getClass().equals(TargetTile.class)) 
				targets[targetIndex++] = (TargetTile) tile;
		// loop over all block positions
		for (int[] block : blocks)
			// set the Tile here to have a block
			tiles[block[0]][block[1]].setBlock(true);
		
		// save the initial player position
		this.player = player;
		// initialize the ArrayList of moves
		moves = new ArrayList<Byte>();
	}

	/**
	 * Draw the game
	 * @param window the window to draw on
	 */
	public void draw(Graphics window) {
		// loop over all Tiles in grid
		for (int row = 0; row < tiles.length; ++row)
			for (int col = 0; col < tiles[0].length; ++col)
				// draw at correct location
				tiles[row][col].draw(window, row, col);
		
		// save tile size in shorter variable
		int ts = Tile.SIZE;
		// draw target as a dot with 1/3 diameter
		window.setColor(PLAYER_COLOR);
		window.fillOval(player[1] * ts + ts / 3, player[0] * ts + ts / 3, ts / 3, ts / 3);
	}

	/**
	 * @param direction a direction to move in
	 * @return the value of the opposite direction
	 */
	private byte opDirection(byte direction) {
		// up <-> down, left <-> right
		if (direction == UP) return DOWN;
		else if (direction == DOWN) return UP;
		else if (direction == RIGHT) return LEFT;
		else if (direction == LEFT) return RIGHT;
		// if direction not recognized, throw an error
		throw new IllegalArgumentException("Invalid direction");
	}
	
	/**
	 * Get the location from a start in a direction
	 * @param pos the position [row, col] to start at
	 * @param direction the direction to move
	 * @return the new location [row, col]
	 */
	private int[] nextTile(int[] pos, byte direction) {
		// check for each direction, returning new array with modification
		if (direction == UP) return new int[] {pos[0] - 1, pos[1]};
		else if (direction == DOWN) return new int[] {pos[0] + 1, pos[1]};
		else if (direction == LEFT) return new int[] {pos[0], pos[1] - 1};
		else if (direction == RIGHT) return new int[] {pos[0], pos[1] + 1};
		// if direction not recognized, throw an error
		throw new IllegalArgumentException("Invalid direction");
	}

	/**
	 * Grab a Tile given a position
	 * @param pos the position of the Tile [row, col]
	 * @return the Tile at pos
	 * @throws ArrayIndexOutOfBoundsException the pos is off the board
	 */
	private Tile getTile(int[] pos) throws ArrayIndexOutOfBoundsException {
		return tiles[pos[0]][pos[1]];
	}
	
	/**
	 * Undo 1 move
	 * @return whether the undo was successful
	 */
	public boolean undo() {
		// if there are no moves to undo, undo is unsuccessful
		if (moves.isEmpty()) return false;
		// grab the last move made
		byte move = moves.remove(moves.size() - 1);
		// if it is negative (indicates a block was pushed)
		if (move < 0) {
			// make it positive
			move *= -1;
			// move block back to player spot
			getTile(player).setBlock(true);
			// delete block from next spot
			getTile(nextTile(player, move)).setBlock(false);
		}
		// move player backwards
		player = nextTile(player, opDirection(move));
		// return a successful undo
		return true;
	}
	
	/**
	 * Move the player
	 * @param direction the direction to move in
	 * @return whether a move occurred
	 */
	public boolean movePlayer(byte direction) {
		// try to move
		try {
			// get the position of a move in direction
			int[] next = nextTile(player, direction);
			// save the Tile in this position
			Tile nextT = getTile(next);
			
			// if this Tile has a block
			if (nextT.hasBlock()) {
				// get the position of one more move in the same direction
				int[] farther = nextTile(next, direction);
				Tile fartherT = getTile(farther);
				
				// if the block can be pushed here
				if (fartherT.canMoveInto()) {
					// move the block-setting from next to farther
					nextT.setBlock(false);
					fartherT.setBlock(true);
					// move player
					player = next;
					// save move as negative, to indicate block-push
					moves.add((byte) -direction);
					
					// note a successful move
					return true;
				}
				// if the block cannot be pushed here, note a failed mvoe
				else return false;
			}
			// or if the next Tile can be moved in to
			else if (nextT.canMoveInto()) {
				// move player and save move
				player = next;
				moves.add(direction);
				// note a successful move
				return true;
			}
			// otherwise, move is unsuccessful
			else return false;
		}
		// if something would go off-board, return a failure
		catch (ArrayIndexOutOfBoundsException e) {return false;}
	}
	
	/**
	 * @return whether the game has been won
	 */
	public boolean checkWin() {
		// loop over all targets, if any does not have a block the game is not won
		for (TargetTile target : targets) if (!target.hasBlock()) return false;
		// if all have a block, the game is won
		return true;
	}
	
	/**
	 * @return the # of rows of Tiles in the tiles grid
	 */
	public int getRows() {return tiles.length;}
	
	/**
	 * @return the # of columns of Tiles in the tiles grid
	 */
	public int getCols() {return tiles[0].length;}
	
	/**
	 * Converts a string to a direction (up, down, right, left)
	 * @param str the string to convert (case insensitive)
	 * @return the byte value of the direction
	 */
	public static byte stringToDir(String str) {
		// convert to lower case
		str = str.toLowerCase();
		// check each direction name, return value if so
		if (str.equals("up")) return UP;
		else if (str.equals("down")) return DOWN;
		else if (str.equals("right")) return RIGHT;
		else if (str.equals("left")) return LEFT;
		// if no direction matches, this is invalid
		throw new IllegalArgumentException("Invalid direction");
	}
	
	/**
	 * Converts a direction to its String form
	 * @param dir the direction to convert, one of the static bytes UP, DOWN, RIGHT, LEFT
	 * @return the String value of the direction
	 */
	public static String dirToString(byte dir) {
		// check each direction value, return string if so
		if (dir == UP) return "up";
		else if (dir == DOWN) return "down";
		else if (dir == RIGHT) return "right";
		else if (dir == LEFT) return "left";
		// if no value matches, this is invalid
		throw new IllegalArgumentException("Invalid direction");
	}
	
	public String toString() {
		// initialize grid-string
		String grid = "";
		// initialize blocks-string
		String blocks = "Blocks at:";
		
		// loop over all positions in the tiles grid
		for (int row = 0; row < tiles.length; ++row) {
			for (int col = 0; col < tiles[0].length; ++col) {
				// add the first letter of the class name, space-separated
				grid += tiles[row][col].getClass().
						getSimpleName().charAt(0) + " ";
				// if this Tile has a bock, add a note to the blocks-string
				if (tiles[row][col].hasBlock()) 
					blocks += " (" + row + ", " + col + ")";
			}
			grid += '\n';
		}
		
		// return a built-up string with class identifier & player position as well
		return "Grid\n" + grid + blocks + 
				"\nPlayer at: (" + player[0] + ", " + player[1] + ")";
	}
}