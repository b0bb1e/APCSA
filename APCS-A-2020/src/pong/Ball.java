package pong;

//(c) A+ Computer Science
//www.apluscompsci.com
//Name - Faith Okamoto

// for graphics
import java.awt.Color;
import java.awt.Graphics;

/**
 * A ball, for use in games that require bouncing off objects
 * @author faith
 */
public class Ball extends Block implements Collidable {
	/**
	 * the number of x-coordinates the Ball moves each time
	 */
	private int xSpeed;
	/**
	 * the number of y-coordinates the Ball moves each time
	 */
	private int ySpeed;
	
	/**
	 * the default x-speed value
	 */
	public static final int DEFAULT_X_SPEED = 3;
	/**
	 * the default y-speed value
	 */
	public static final int DEFAULT_Y_SPEED = 1;
	/**
	 * the default diameter value
	 */
	public static final int DEFAULT_DIAMETER = 10;
	
	/**
	 * the number of leeway coordinates for collision purposes
	 */
	public static final byte TOUCH_THRESHOLD = 1;

	// Constructors
	
	/**
	 * Blank Constructor
	 * <br>
	 * Uses default values for size and initial x, y, color, and speeds
	 */
	public Ball() {
		this(Block.DEFAULT_X, Block.DEFAULT_Y, DEFAULT_DIAMETER, 
				Block.DEFAULT_COLOR, DEFAULT_X_SPEED, DEFAULT_Y_SPEED);
	}
	
	/**
	 * Size Constructor
	 * <br>
	 * Uses default values for initial x, y, color, and speeds but allows size specification
	 * @param d the diameter (in coordinates) of this Ball
	 */
	public Ball(int d) {
		this(Block.DEFAULT_X, Block.DEFAULT_Y, d, 
				Block.DEFAULT_COLOR, DEFAULT_X_SPEED, DEFAULT_Y_SPEED);
	}
	
	/**
	 * Color Constructor
	 * <br>
	 * Uses default values for size and initial x, y, and speeds but allows initial color specification
	 * @param c the initial color of this Ball
	 */
	public Ball(Color c) {
		this(Block.DEFAULT_X, Block.DEFAULT_Y, DEFAULT_DIAMETER, 
				c, DEFAULT_X_SPEED, DEFAULT_Y_SPEED);
	}
	
	/**
	 * Size and Color Constructor
	 * <br>
	 * Uses default values for initial x, y, and speeds but allows size and initial color specification
	 * @param d the diameter (in coordinates) of the Ball
	 * @param c the initial color of the Ball
	 */
	public Ball(int d, Color c) {
		this(Block.DEFAULT_X, Block.DEFAULT_Y, d, c, DEFAULT_X_SPEED, DEFAULT_Y_SPEED);
	}

	/**
	 * Location Constructor
	 * <br>
	 * Uses default values for diameter and initial color and speeds, but allows initial location specification
	 * @param x the initial x-coordinate of the Ball
	 * @param y the initial y-coordinate of the Ball
	 */
	public Ball(int x, int y) {
		this(x, y, DEFAULT_DIAMETER, Block.DEFAULT_COLOR, DEFAULT_X_SPEED, DEFAULT_Y_SPEED);
	}
	
	/**
	 * Location and Color Constructor
	 * <br>
	 * Uses default values for diameter and initial speeds, but allows initial location and color specification
	 * @param x the initial x-coordinate of the Ball
	 * @param y the initial y-coordinate of the Ball
	 * @param c the initial color of the Ball
	 */
	public Ball(int x, int y, Color c) {
		this(x, y, DEFAULT_DIAMETER, c, DEFAULT_X_SPEED, DEFAULT_Y_SPEED);
	}
	
	/**
	 * Location and Size Constructor
	 * <br>
	 * Uses default values for initial color and speeds, but allows size and initial location specification
	 * @param x the initial x-coordinate of the Ball
	 * @param y the initial y-coordinate of the Ball
	 * @param d the diameter (in coordinates) of the Ball
	 */
	public Ball(int x, int y, int d) {
		this(x, y, d, Block.DEFAULT_COLOR, DEFAULT_X_SPEED, DEFAULT_Y_SPEED);
	}
	
	/**
	 * Location, Size, and Color Constructor
	 * <br>
	 * Uses default values for initial speeds, but allows size and initial location and color specification
	 * @param x the initial x-coordinate of the Ball
	 * @param y the initial y-coordinate of the Ball
	 * @param d the diameter (in coordinates) of the Ball
	 * @param c the initial color of the Ball
	 */
	public Ball(int x, int y, int d, Color c) {
		this(x, y, d, c, DEFAULT_X_SPEED, DEFAULT_Y_SPEED);
	}
	
	/**
	 * Location, Size, and Speeds Constructor
	 * <br>
	 * Uses a default value for initial color, but allows size and initial location and speeds specification
	 * @param x the initial x-coordinate of the Ball
	 * @param y the initial y-coordinate of the Ball
	 * @param d the diameter (in coordinates) of the Ball
	 * @param xS the initial x-speed (in coordinates) of the Ball
	 * @param yS the initial y-speed (in coordinates) of the Ball
	 */
	public Ball(int x, int y, int d, int xS, int yS) {
		this(x, y, d, Block.DEFAULT_COLOR, xS, yS);
	}
	
	/**
	 * Complete Constructor
	 * <br>
	 * Allows specification of size and initial location, color, and speeds
	 * @param x the initial x-coordinate of the Ball
	 * @param y the initial y-coordinate of the Ball
	 * @param d the diameter (in coordinates) of the Ball
	 * @param c the initial color of the Ball
	 * @param xS the initial x-speed (in coordinates) of the Ball
	 * @param yS the initial y-speed (in coordinates) of the Ball
	 */
	public Ball(int x, int y, int d, Color c, int xS, int yS) {
		super(x, y, d, d, c);
		xSpeed = xS;
		ySpeed = yS;
	}

	// GUI Methods
	
	/**
	 * Draws the Ball as a circle instead
	 */
	public void draw(Graphics window) {
		window.setColor(getColor());
		window.fillOval(getX(), getY(), getWidth(), getHeight());
	}
	
	/**
	 * Draws the Ball as a circle instead
	 */
	public void draw(Graphics window, Color c) {
		window.setColor(c);
		window.fillOval(getX(), getY(), getWidth(), getHeight());
	}
	
	/**
	 * Moves the Ball at its speed to a new location
	 * @param window the window to move the Ball in
	 */
	public void moveAndDraw(Graphics window) {
		teleport(getX() + xSpeed, getY() + ySpeed, window);
	}
	
	// Collision Methods
	
	/**
	 * Checks if another Block is within the X-range of the Ball
	 * @param other the other Block to check
	 * @return whether the x-coordinate/size of the Block indicate it being in the Ball's column
	 */
	private boolean withinX(Block other) {
		return (getX() >= other.getX() && getX() - other.getX() <= other.getWidth()) ||
				(other.getX() >= getX() && other.getX() - getX() <= getWidth());
	}
	
	/**
	 * Checks if another Block is within the Y-range of the Ball
	 * @param other the other Block to check
	 * @return whether the y-coordinate/size of the Block indicate it being in the Ball's column
	 */
	private boolean withinY(Block other) {
		return (getY() >= other.getY() && getY() - other.getY() <= other.getHeight()) ||
				(other.getY() >= getY() && other.getY() - getY() <= getHeight());
	}
	
	/**
	 * Checks if another Block is touching the Ball from the left-hand side
	 * @param other the Block to check for touching
	 * @return whether the Block is touching this Ball so
	 */
	private boolean touchLeft(Block other) {
		return getX() >= other.getX() && 
				Math.abs(other.getWidth() - (getX() - other.getX())) <= TOUCH_THRESHOLD;
	}
	
	/**
	 * Checks if another Block is touching the Ball from the right-hand side
	 * @param other the Block to check for touching
	 * @return whether the Block is touching this Ball so
	 */
	private boolean touchRight(Block other) {
		return other.getX() > getX() && 
				Math.abs(getWidth() - (other.getX() - getX())) <= TOUCH_THRESHOLD;
	}
	
	/**
	 * Checks if another Block is touching the Ball from the top side
	 * @param other the Block to check for touching
	 * @return whether the Block is touching this Ball so
	 */
	private boolean touchTop(Block other) {
		return getY() > other.getY() && 
				Math.abs(other.getHeight() - (getY() - other.getY())) <= TOUCH_THRESHOLD;
	}
	
	/**
	 * Checks if another Block is touching the Ball from the bottom side
	 * @param other the Block to check for touching
	 * @return whether the Block is touching this Ball so
	 */
	private boolean touchBottom(Block other) {
		return other.getY() > getY() && 
				Math.abs(getHeight() - (other.getY() - getY())) <= TOUCH_THRESHOLD;
	}
	
	public boolean didCollideLeft(Object obj) {
		if (!(obj instanceof Block))
			throw new IllegalArgumentException("Can only collide with Blocks");
		
		Block other = (Block) obj;
		return touchLeft(other) && withinY(other);
	}
	
	public boolean didCollideRight(Object obj) {
		if (!(obj instanceof Block))
			throw new IllegalArgumentException("Can only collide with Blocks");
		
		Block other = (Block) obj;
		return touchRight(other) && withinY(other);
	}
		
	public boolean didCollideTop(Object obj) {
		if (!(obj instanceof Block))
			throw new IllegalArgumentException("Can only collide with Blocks");
		
		Block other = (Block) obj;
		return touchTop(other) && withinX(other);
	}
	
	public boolean didCollideBottom(Object obj) {
		if (!(obj instanceof Block))
			throw new IllegalArgumentException("Can only collide with Blocks");
		
		Block other = (Block) obj;
		return touchBottom(other) && withinX(other);
	}
	
	// Setters
	
	/**
	 * Setter for the x-speed
	 * @param xS the new x-speed
	 */
	public void setXSpeed(int xS) {xSpeed = xS;}
	
	/**
	 * Setter for the y-speed
	 * @param yS the new y-speed
	 */
	public void setYSpeed(int yS) {ySpeed = yS;}
	
	/**
	 * Flips the sign for x-speed
	 */
	public void flipXSpeed() {setXSpeed(-xSpeed);}
	
	/**
	 * Flips the sign for y-speed
	 */
	public void flipYSpeed() {setYSpeed(-ySpeed);}
	
	/**
	 * Setter for both speeds
	 * @param xS the new x-speed
	 * @param yS the new y-speed
	 */
	public void setSpeed(int xS, int yS) {
		setXSpeed(xS);
		setYSpeed(yS);
	}

	// Getters
	
	/**
	 * Getter for the x-speed
	 * @return the x-speed's value
	 */
	public int getXSpeed() {return xSpeed;}
	
	/**
	 * Getter for the y-speed
	 * @return the y-speed's value
	 */
	public int getYSpeed() {return ySpeed;}
	
	// Utility Methods
	
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (!(obj instanceof Ball)) return false;
		
		Ball other = (Ball) obj;
		return super.equals(other) && xSpeed == other.getXSpeed() && ySpeed == other.getYSpeed();
	}

	public String toString() {
		return super.toString() + " " + xSpeed + " " + ySpeed;
	}
}