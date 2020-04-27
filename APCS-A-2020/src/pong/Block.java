package pong;

//(c) A+ Computer Science
//www.apluscompsci.com
//Name - Faith Okamoto

// for graphics
import java.awt.Color;
import java.awt.Graphics;

/**
 * A generalize block with location, size, and color which can draw and move
 * @author faith
 */
public class Block implements Locatable {
	/**
	 * the x-coordinate of the Block
	 */
	private int xPos;
	/**
	 * the y-coordinate of the Block
	 */
	private int yPos;
	/**
	 * the width (in coordinates) of the Block
	 */
	private final int width;
	/**
	 * the height (in coordinates) of the Block
	 */
	private final int height;
	/**
	 * the color of the Block
	 */
	private Color color;
	
	/**
	 * the default x-coordinate value
	 */
	public static final int DEFAULT_X = 100;
	/**
	 * the default y-coordinate value
	 */
	public static final int DEFAULT_Y = 150;
	/**
	 * the default width value
	 */
	public static final int DEFAULT_WIDTH = 10;
	/**
	 * the default height value
	 */
	public static final int DEFAULT_HEIGHT = 10;
	/**
	 * the default color
	 */
	public static final Color DEFAULT_COLOR = Color.black;

	/**
	 * Default Constructor
	 * <br>
	 * Uses default values for size and initial location and color
	 */
	public Block() {
		this(DEFAULT_X, DEFAULT_Y, DEFAULT_WIDTH, DEFAULT_HEIGHT, DEFAULT_COLOR);
	}
	
	/**
	 * Color Constructor
	 * <br>
	 * Uses default values for size and initial location, but allows color specification
	 * @param c
	 */
	public Block(Color c) {
		this(DEFAULT_X, DEFAULT_Y, DEFAULT_WIDTH, DEFAULT_HEIGHT, c);
	}
	
	/**
	 * Location Constructor
	 * <br>
	 * Uses default values for size and initial color, but allows initial location specification
	 * @param x the initial x-coordinate of the Block
	 * @param y the initial y-coordinate of the Block
	 */
	public Block(int x, int y) {
		this(x, y, DEFAULT_WIDTH, DEFAULT_HEIGHT, DEFAULT_COLOR);
	}
	
	/**
	 * Location and Color Constructor
	 * <br>
	 * Uses default values for size, but allows initial location and color specification
	 * @param x the initial x-coordinate of the Block
	 * @param y the initial y-coordinate of the Block
	 * @param c the initial color of the Block
	 */
	public Block(int x, int y, Color c) {
		this(x, y, DEFAULT_WIDTH, DEFAULT_HEIGHT, c);
	}
	
	/**
	 * Location and Size Constructor
	 * <br>
	 * Uses a default value for initial color, but allows size and initial location specification
	 * @param x the initial x-coordinate of the Block
	 * @param y the initial y-coordinate of the Block
	 * @param w the width of the Block
	 * @param h the height of the Block
	 */
	public Block(int x, int y, int w, int h) {
		this(x, y, w, h, DEFAULT_COLOR);
	}
	
	/**
	 * Complete Constructor
	 * <br>
	 * Allows specification of size and initial location and color
	 * @param x the initial x-coordinate of the Block
	 * @param y the initial y-coordinate of the Block
	 * @param w the width of the Block
	 * @param h the height of the Block
	 * @param c the initial color of the Block
	 */
	public Block(int x, int y, int w, int h, Color c) {
		xPos = x;
		yPos = y;
		width = w;
		height = h;
		color = c;
	}

	// GUI Methods
	
	/**
	 * Draws the Block as a rectangle with its color
	 * @param window the window to draw in
	 */
	public void draw(Graphics window) {
		window.setColor(color);
		window.fillRect(getX(), getY(), getWidth(), getHeight());
	}
	
	/**
	 * Draws the Block as a rectangle with the specified color
	 * @param window the window to draw in
	 */
	public void draw(Graphics window, Color c) {
		window.setColor(c);
		window.fillRect(getX(), getY(), getWidth(), getHeight());
	}
	
	/**
	 * Erase the Block by drawing over with white
	 * @param window the window to erase from
	 */
	public void erase(Graphics window) {
		draw(window, Color.white);
	}
	
	/**
	 * Teleports the Block to a specified location
	 * @param x the x-coordinate to move the Block to
	 * @param y the y-coordinate to move the Block to
	 * @param window the window to draw the Block in
	 */
	public void teleport(int x, int y, Graphics window) {
		// erase the old drawing
		erase(window);
		// move to new location
		setPos(x, y);
		// draw in new location
		draw(window);
	}
	
	// Setters

	public void setX(int x) {xPos = x;}

	public void setY(int y) {yPos = y;}
	
	public void setPos(int x, int y) {
		xPos = x;
		yPos = y;
	}
	
	/**
	 * Setter for the color
	 * @param c the new Color
	 */
	public void setColor(Color c) {
		color = c;
	}
	
	// Getters
	
	public int getX() {return xPos;}
	
	public int getY() {return yPos;}
	
	/**
	 * Getter for the width
	 * @return the width's value
	 */
	public int getWidth() {return width;}
	
	/**
	 * Getter for the height
	 * @return the height's value
	 */
	public int getHeight() {return height;}
	
	/**
	 * Getter for the color
	 * @return the color's value
	 */
	public Color getColor() {return color;}

	// Utility Methods
	
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (!(obj instanceof Block)) return false;
		
		Block other = (Block) obj;
		return xPos == other.getX() && yPos == other.getY() && 
				width == other.getWidth() && height == other.getHeight() && 
				color.equals(other.getColor());
	}

	public String toString() {
		return xPos + " " + yPos + " " + width + " " + height + " " + color;
	}
}