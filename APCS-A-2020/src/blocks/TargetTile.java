package blocks;

// for drawing
import java.awt.Graphics;
import java.awt.Color;

/**
 * A Tile that is a block target in a Blocks game
 * @author faith
 */
public class TargetTile extends Tile {
	/**
	 * the Color of the target dot
	 */
	public static final Color TARGET_COLOR = new Color(144, 232, 232);
	
	/**
	 * Use default initialization
	 */
	public TargetTile() {super();}
	
	/**
	 * Can only move in if there is no block
	 */
	public boolean canMoveInto() {return !hasBlock();}
	
	public void draw(Graphics window, int row, int col) {
		// if there is a block, color whole Tile with the target color
		if (hasBlock()) draw(window, TARGET_COLOR, row, col);
		// otherwise
		else {
			// draw with default color
			draw(window, BACKGROUND_COLOR, row, col);
			// draw centered target circle with half diameter
			window.setColor(TARGET_COLOR);
			window.fillOval(col * SIZE + SIZE / 4, row * SIZE + SIZE / 4, SIZE / 2, SIZE / 2);
		}
	}

	public String toString() {
		// append class identifier
		return "Target" + super.toString();
	}
}