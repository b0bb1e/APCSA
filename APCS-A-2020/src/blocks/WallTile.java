package blocks;

// for drawing
import java.awt.Graphics;

/**
 * A Tile marking a wall in a Blocks game
 * @author faith
 */
public class WallTile extends Tile {
	/**
	 * Use default initialization
	 */
	public WallTile() {super();}
	
	/**
	 * Blocks cannot be set into this Tile
	 */
	public void setBlock() {}
	
	/**
	 * Never can be moved in to - it's a wall!
	 */
	public boolean canMoveInto() {return false;}
	
	public void draw(Graphics window, int row, int col) {
		// walls are darker than background
		draw(window, BACKGROUND_COLOR.darker().darker(), row, col);
	}
	
	public String toString() {
		// append class identifier
		return "Wall" + super.toString();
	}
}