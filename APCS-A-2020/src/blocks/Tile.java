package blocks;

// for drawing
import java.awt.Graphics;
import java.awt.Color;

/**
 * A tile for playing Blocks over. Can have a block on it and draw itself.
 * @author faith
 */
public abstract class Tile {
	/**
	 * whether a block is on this Tile
	 */
	private boolean hasBlock;
	/**
	 * the default background color for Tiles
	 */
	public static final Color BACKGROUND_COLOR = new Color(242, 159, 107);
	/**
	 * the side length of Tiles in coordinates
	 */
	public static final int SIZE = 24;
	
	/**
	 * Tiles start without a block on them
	 */
	public Tile() {
		hasBlock = false;
	}
	
	/**
	 * @return whether a block on this Tile
	 */
	public boolean hasBlock() {return hasBlock;}
	
	/**
	 * @param hasBlock whether a block is on this Tile
	 */
	public void setBlock(boolean hasBlock) {this.hasBlock = hasBlock;}
	
	/**
	 * @return if this Tile can be freely moved in to
	 */
	public abstract boolean canMoveInto();
	
	/**
	 * Draw this Tile at a specified location
	 * @param window the window to draw on
	 * @param row the row to draw at
	 * @param col the column to draw at
	 */
	public abstract void draw(Graphics window, int row, int col);
	
	/**
	 * Draw a Tile with the specified color and location
	 * @param window the window to draw on
	 * @param color the Color to draw with
	 * @param row the row to draw at
	 * @param col the column to draw at
	 */
	protected void draw(Graphics window, Color color, int row, int col) {
		// draw the background with color + location specified
		window.setColor(color);
		window.fillRect(col * SIZE, row * SIZE, SIZE, SIZE);
		
		// if there is a block
		if (hasBlock()) {
			// using a slightly darker color, draw block centered with half the side length
			window.setColor(color.darker());
			window.fillRect(col * SIZE + SIZE / 4, row * SIZE + SIZE / 4, SIZE / 2, SIZE / 2);
		}
		
		// outline in black
		window.setColor(Color.BLACK);
		window.drawRect(col * SIZE, row * SIZE, SIZE, SIZE);
	}
	
	public String toString() {
		// check if there is a block or not
		if (hasBlock) return "Tile with a block";
		else return "Tile without a block";
	}
}