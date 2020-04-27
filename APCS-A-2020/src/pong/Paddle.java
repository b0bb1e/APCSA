package pong;

//(c) A+ Computer Science
//www.apluscompsci.com
//Name - Faith Okamoto

// for graphics
import java.awt.Color;
import java.awt.Graphics;

/**
 * A paddle with particular movement patterns for games which need it
 * @author faith
 */
public class Paddle extends Block {
	/**
	 * the speed (in coordinates) of the Paddle
	 */
	private final int speed;
	
	/**
	 * the default speed value
	 */
	public static final int DEFAULT_SPEED = 5;

	/**
	 * Default Constructor
	 * <br>
	 * Uses default values for size, speed and initial location and color
	 */
	public Paddle() {
		this(Block.DEFAULT_X, Block.DEFAULT_Y, Block.DEFAULT_WIDTH,
				Block.DEFAULT_HEIGHT, Block.DEFAULT_COLOR, DEFAULT_SPEED);
	}
	
	/**
	 * Color Constructor
	 * <br>
	 * Uses default values for size and speed and initial location, but allows initial color specification
	 * @param c the initial color of the Paddle
	 */
	public Paddle(Color c) {
		this(Block.DEFAULT_X, Block.DEFAULT_Y, Block.DEFAULT_WIDTH,
				Block.DEFAULT_HEIGHT, c, DEFAULT_SPEED);
	}
	
	/**
	 * Speed Constructor
	 * <br>
	 * Uses default values for size and initial location and color, but allows speed specification
	 * @param s the speed (in coordinates) of the Paddle
	 */
	public Paddle(int s) {
		this(Block.DEFAULT_X, Block.DEFAULT_Y, Block.DEFAULT_WIDTH,
				Block.DEFAULT_HEIGHT, Block.DEFAULT_COLOR, s);
	}
	
	/**
	 * Size and Color Constructor
	 * <br>
	 * Uses default values for size and initial location, but allows speed and initial color specification
	 * @param s
	 * @param c
	 */
	public Paddle(int s, Color c) {
		this(Block.DEFAULT_X, Block.DEFAULT_Y, Block.DEFAULT_WIDTH,
				Block.DEFAULT_HEIGHT, c, s);
	}
	
	/**
	 * Location Constructor
	 * <br>
	 * Uses default values for size and speed and initial color, but allows initial location specification
	 * @param x the initial x-coordinate of the Paddle
	 * @param y the initial y-coordinate of the Paddle
	 */
	public Paddle(int x, int y) {
		this(x, y, Block.DEFAULT_WIDTH, Block.DEFAULT_HEIGHT, Block.DEFAULT_COLOR, DEFAULT_SPEED);
	}
	
	/**
	 * Location and Color Constructor
	 * <br>
	 * Uses default values for size and speed, but allows initial location and color specification
	 * @param x the initial x-coordinate of the Paddle
	 * @param y the initial y-coordinate of the Paddle
	 * @param c the initial color of the Paddle
	 */
	public Paddle(int x, int y, Color c) {
		this(x, y, Block.DEFAULT_WIDTH, Block.DEFAULT_HEIGHT, c, DEFAULT_SPEED);
	}
	
	/**
	 * Location and Speed Constructor
	 * <br>
	 * Uses default values for size and initial color, but allows speed and initial location specification
	 * @param x the initial x-coordinate of the Paddle
	 * @param y the initial y-coordinate of the Paddle
	 * @param s the speed (in coordinates) of the Paddle
	 */
	public Paddle(int x, int y, int s) {
		this(x, y, Block.DEFAULT_WIDTH, Block.DEFAULT_HEIGHT, Block.DEFAULT_COLOR, s);
	}
	
	/**
	 * Location, Speed, and Color Constructor
	 * <br>
	 * Uses default values for size, but allows speed and initial location and color specification
	 * @param x the initial x-coordinate of the Paddle
	 * @param y the initial y-coordinate of the Paddle
	 * @param c the initial color of the Paddle
	 * @param s the speed (in coordinates) of the Paddle
	 */
	public Paddle(int x, int y, Color c, int s) {
		this(x, y, Block.DEFAULT_WIDTH, Block.DEFAULT_HEIGHT, c, s);
	}
	
	/**
	 * Location and Size Constructor
	 * <br>
	 * Uses default values for speed and initial color, but allows size and initial location specification
	 * @param x the initial x-coordinate of the Paddle
	 * @param y the initial y-coordinate of the Paddle
	 * @param w the width (in coordinates) of the Paddle
	 * @param h the height (in coordinates) of the Paddle
	 */
	public Paddle(int x, int y, int w, int h) {
		this(x, y, w, h, Block.DEFAULT_COLOR, DEFAULT_SPEED);
	}
	
	/**
	 * Location, Size, and Color Constructor
	 * <br>
	 * Uses a default value for speed, but allows size and initial location and color specification
	 * @param x the initial x-coordinate of the Paddle
	 * @param y the initial y-coordinate of the Paddle
	 * @param w the width (in coordinates) of the Paddle
	 * @param h the height (in coordinates) of the Paddle
	 * @param c the initial color of the Paddle
	 */
	public Paddle(int x, int y, int w, int h, Color c) {
		this(x, y, w, h, c, DEFAULT_SPEED);
	}
	
	/**
	 * Location, Size, and Speed Constructor
	 * <br>
	 * Uses a default value for initial color, but allows size, speed, and initial location specification
	 * @param x the initial x-coordinate of the Paddle
	 * @param y the initial y-coordinate of the Paddle
	 * @param w the width (in coordinates) of the Paddle
	 * @param h the height (in coordinates) of the Paddle
	 * @param s the speed (in coordinates) of the Paddle
	 */
	public Paddle(int x, int y, int w, int h, int s) {
		this(x, y, w, h, Block.DEFAULT_COLOR, s);
	}
	
	/**
	 * Complete Constructor
	 * <br>
	 * Allows size, speed, and initial location and color specification
	 * @param x the initial x-coordinate of the Paddle
	 * @param y the initial y-coordinate of the Paddle
	 * @param w the width (in coordinates) of the Paddle
	 * @param h the height (in coordinates) of the Paddle
	 * @param c the initial color of the Paddle
	 * @param s the speed (in coordinates) of the Paddle
	 */
	public Paddle(int x, int y, int w, int h, Color c, int s) {
		super(x, y, w, h, c);
		speed = s;
	}

	// GUI Methods
	
	/**
	 * Moves the Paddle up at a rate of speed, drawing it
	 * @param window the window to move the Paddle in
	 */
	public void moveUpAndDraw(Graphics window) {
		teleport(getX(), getY() - speed, window);
	}

	/**
	 * Moves the Paddle down at a rate of speed, drawing it
	 * @param window the window to move the Paddle in
	 */
	public void moveDownAndDraw(Graphics window) {
		teleport(getX(), getY() + speed, window);
	}
	
	/**
	 * Moves the Paddle left at a rate of speed, drawing it
	 * @param window the window to move the Paddle in
	 */
	public void moveLeftAndDraw(Graphics window) {
		teleport(getX() - speed, getY(), window);
	}

	/**
	 * Moves the Paddle right at a rate of speed, drawing it
	 * @param window the window to move the Paddle in
	 */
	public void moveRightAndDraw(Graphics window) {
		teleport(getX() + speed, getY(), window);
	}
	
	// Getter

	/**
	 * Getter for speed
	 * @return the x-coordinate's value
	 */
	public int getSpeed() {return speed;}

	// Utility Methods
	
	public String toString() {
		return super.toString() + " " + speed;
	}
	
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (!(obj instanceof Paddle)) return false;
		
		Paddle other = (Paddle) obj;
		return super.equals(other) && speed == other.getSpeed();
	}
}