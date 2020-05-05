package winterScene;

//(c) A+ Computer Science
//www.apluscompsci.com
//Name - Faith Okamoto

// for graphics
import java.awt.Color;
import java.awt.Graphics;

/**
 * Represents a Shape with position, size, and the ability to move. All
 * subclasses must be able to draw themselves, as well as move.
 * @author faith
 */
public abstract class AbstractShape {
	/**
	 * the x-coordinate of the Shape
	 */
	private int x;
	/**
	 * the y-coordinate of the Shape
	 */
	private int y;
	/**
	 * the width of the Shape
	 */
	private final int width;
	/**
	 * the height of the Shape
	 */
	private final int height;
	/**
	 * the color of the Shape
	 */
	private Color color;
	/**
	 * the x-speed, in coordinates per move, of the shape
	 */
	private int xSpeed;
	/**
	 * the y-speed, in coordinates per move, of the shape
	 */
	private int ySpeed;
	
	/**
	 * the default color, if none is specified
	 */
	public static final Color DEFAULT_COLOR = Color.WHITE;
	/**
	 * the default speed, if none is specified
	 */
	public static final int DEFAULT_SPEED = 0;

	// Constructors
	
	/**
	 * Default Constructor
	 * <br>
	 * Uses default values for initial color and speeds, but allows size and initial position specification
	 * @param xP the initial x-coordinate of the Shape
	 * @param yP the initial y-coordinate of the Shape
	 * @param w the width of the Shape
	 * @param h the height of the Shape
	 */
	public AbstractShape(int xP, int yP, int w, int h) {
		this(xP, yP, w, h, DEFAULT_COLOR, DEFAULT_SPEED, DEFAULT_SPEED);
	}

	/**
	 * Color Constructor
	 * <br>
	 * Uses default values for initial speeds, but allows size, and initial position and color specification
	 * @param xP the initial x-coordinate of the Shape
	 * @param yP the initial y-coordinate of the Shape
	 * @param w the width of the Shape
	 * @param h the height of the Shape
	 * @param c the initial color of the Shape
	 */
	public AbstractShape(int xP, int yP, int w, int h, Color c) {
		this(xP, yP, w, h, c, DEFAULT_SPEED, DEFAULT_SPEED);
	}

	/**
	 * Complete Constructor
	 * <br>
	 * Allows size, and initial position, color, and speeds specification
	 * @param xP the initial x-coordinate of the Shape
	 * @param yP the initial y-coordinate of the Shape
	 * @param w the width of the Shape
	 * @param h the height of the Shape
	 * @param c the initial color of the Shape
	 * @param xS the initial x-speed, in coordinates per move, of the Shape
	 * @param yS the initial y-speed, in coordinates per move, of the Shape
	 */
	public AbstractShape(int xP, int yP, int w, int h, Color c, int xS, int yS) {
		x = xP;
		y = yP;
		width = w;
		height = h;
		color = c;
		xSpeed = xS;
		ySpeed = yS;
	}

	// Abstract Draw Methods
	
	/**
	 * Draws the Shape
	 * @param window the window to draw on
	 */
	public abstract void draw(Graphics window);
	
	/**
	 * Moves the Shape, then draws it
	 * @param window the window to draw on
	 */
	public abstract void moveAndDraw(Graphics window);
	
	// Setters
	
	/**
	 * Setter for x
	 * @param xP the new x value
	 */
	public void setX(int xP) {x = xP;}

	/**
	 * Setter for y
	 * @param yP the new y value
	 */
	public void setY(int yP) {y = yP;}
	
	/**
	 * Setter for color
	 * @param c the new color value
	 */
	public void setColor(Color c) {color = c;}

	/**
	 * Setter for x-speed
	 * @param xS the new x-speed value
	 */
	public void setXSpeed(int xS) {xSpeed = xS;}

	/**
	 * Setter for y-speed
	 * @param yS the new y-speed value
	 */
	public void setYSpeed(int yS) {ySpeed = yS;}

	// Getters
	
	/**
	 * Getter for x
	 * @return the x value
	 */
	public int getX() {return x;}
	
	/**
	 * Getter for y
	 * @return the y value
	 */
	public int getY() {return y;}

	/**
	 * Getter for width
	 * @return the width value
	 */
	public int getWidth() {return width;}

	/**
	 * Getter for height
	 * @return the height value
	 */
	public int getHeight() {return height;}
	
	/**
	 * Getter for color
	 * @return the color value
	 */
	public Color getColor() {return color;}
	
	/**
	 * Getter for x-speed
	 * @return the x-speed value
	 */
	public int getXSpeed() {return xSpeed;}
	
	/**
	 * Getter for y-speed
	 * @return the y-speed value
	 */
	public int getYSpeed() {return ySpeed;}

	// Utility Method
	
	public String toString() {
		return x + " " + y + " " + width + " " + height + " " + color + " " + xSpeed + " " + ySpeed;
	}
}