package blocks;

// for drawing
import java.awt.Graphics;

/**
 * A blank (non-target) Tile in a Blocks game
 * @author faith
 */
public class BlankTile extends Tile {
	/**
	 * Use default initialization
	 */
	public BlankTile() {super();}
	/**
	 * Can only move in if there is no block
	 */
	public boolean canMoveInto() {return !hasBlock();}
	
	public void draw(Graphics window, int row, int col) {
		// always just use background color
		draw(window, BACKGROUND_COLOR, row, col);
	}

	public String toString() {
		return "Blank" + super.toString();
	}
}