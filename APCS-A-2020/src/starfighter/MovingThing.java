package starfighter;

//(c) A+ Computer Science
//www.apluscompsci.com
//Name - Faith Okamoto

// for drawing on things
import java.awt.Graphics;

/**
 * An object that can move and draw itself
 * @author faith
 */
public abstract class MovingThing implements Moveable {
	/**
	 * the MovingThing's x-coordinate
	 */
	private int x;
	/**
	 * the MovingThing's y-coordinate
	 */
	private int y;
	/**
	 * the MovingThing's width in coordinates
	 */
	private int width;
	/**
	 * the MovingThing's height in coordinates
	 */
	private int height;
	/**
	 * the MovingThing's speed in coordinates per move
	 */
	private int speed;
	
	/**
	 * default value for initial X and Y coordinates
	 */
	public static final int DEFAULT_POS = 10;
	/**
	 * default value for width and height
	 */
	public static final int DEFAULT_SIZE = 10;
	/**
	 * default value for speed, in coordinates per move
	 */
	public static final int DEFAULT_SPEED = 0;
	
	/**
	 * should be passed to the move(char) method to indicate a move up
	 */
	public static final char UP = 'U';
	/**
	 * should be passed to the move(char) method to indicate a move down
	 */
	public static final char DOWN = 'D';
	/**
	 * should be passed to the move(char) method to indicate a move right
	 */
	public static final char RIGHT = 'R';
	/**
	 * should be passed to the move(char) method to indicate a move left
	 */
	public static final char LEFT = 'L';

	/**
	 * Uses default values for size and initial position and speed
	 */
	public MovingThing() {
		this(DEFAULT_POS, DEFAULT_POS, DEFAULT_SIZE, DEFAULT_SIZE, DEFAULT_SPEED);
	}
	
	/**
	 * Uses default values for size and initial position, but allows initial speed specification
	 * @param s the MovingThing's initial speed, in coordinates per move
	 */
	public MovingThing(int s) {
		this(DEFAULT_POS, DEFAULT_POS, DEFAULT_SIZE, DEFAULT_SIZE, s);
	}

	/**
	 * Uses default values for size and initial speed, but allows initial position specification
	 * @param x the MovingThing's initial x-coordinate
	 * @param y the MovingThing's initial y-coordinate
	 */
	public MovingThing(int x, int y) {
		this(x, y, DEFAULT_SIZE, DEFAULT_SIZE, DEFAULT_SPEED);
	}

	/**
	 * Uses default values for size, but allows initial position and speed specification
	 * @param x the MovingThing's initial x-coordinate
	 * @param y the MovingThing's initial y-coordinate
	 * @param s the MovingThing's initial speed, in coordinates per move
	 */
	public MovingThing(int x, int y, int s) {
		this(x, y, DEFAULT_SIZE, DEFAULT_SIZE, s);
	}
	
	/**
	 * Uses default values for initial speed, but allows size and initial position specification
	 * @param x the MovingThing's initial x-coordinate
	 * @param y the MovingThing's initial y-coordinate
	 * @param w the MovingThing's width, in coordinates
	 * @param h the MovingThing's height, in coordinates
	 * @param s the MovingThing's initial speed, in coordinates per move
	 */
	public MovingThing(int x, int y, int w, int h) {
		this(x, y, w, h, DEFAULT_SPEED);
	}

	/**
	 * Allows specification of size and initial position and speed.
	 * Called by all other constructors, and tries to load the MovingThing image
	 * @param x the MovingThing's initial x-coordinate
	 * @param y the MovingThing's initial y-coordinate
	 * @param w the MovingThing's width, in coordinates
	 * @param h the MovingThing's height, in coordinates
	 * @param s the MovingThing's initial speed, in coordinates per move
	 */
	public MovingThing(int x, int y, int w, int h, int s) {
		this.x = x;
		this.y = y;
		width = w;
		height = h;
		speed = s;
	}

	// Setters
	
	public void setPos(int x, int y) {setX(x); setY(y);
	}

	public void setX(int x) {this.x = x;}

	public void setY(int y) {this.y = y;}
	
	public void setSpeed(int s) {speed = s;}

	// Getters
	
	public int getX() {return x;}

	public int getY() {return y;}

	public int getWidth() {return width;}

	public int getHeight() {return height;}
	
	public int getSpeed() {return speed;}

	// Abstract methods
	
	/**
	 * Moves the MovingThing in a specified direction (UP, DOWN, LEFT, RIGHT)
	 * @param direction the direction to move
	 */
	public abstract void move(char direction);

	/**
	 * Draws the MovingThing on a window
	 * @param window the window to draw on
	 */
	public abstract void draw(Graphics window);

	// toString
	
	public String toString() {return x + " " + y + " " + width + " " + height + " " + speed;}
}