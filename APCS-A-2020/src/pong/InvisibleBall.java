package pong;

//(c) A+ Computer Science
//www.apluscompsci.com
//Name - Faith Okamoto

// for graphics
import java.awt.Color;
import java.awt.Graphics;

/**
 * A special Ball that goes invisible randomly
 * @author faith
 */
class InvisibleBall extends Ball {
	/**
	 * whether the Ball is currently visible
	 */
	private boolean visible;
	
	/**
	 * the probability that any one draw will have the Ball change visibility
	 */
	public static final double CHANGE_VISIBILITY_CHANCE = 0.02;
	
	/**
	 * Blank Constructor
	 * <br>
	 * Uses default values for size and initial x, y, color, and speeds
	 */
	public InvisibleBall() {
		super();
	}
	
	/**
	 * Size Constructor
	 * <br>
	 * Uses default values for initial x, y, color, and speeds but allows size specification
	 * @param d the diameter (in coordinates) of this Ball
	 */
	public InvisibleBall(int d) {
		super(d);
	}
	
	/**
	 * Color Constructor
	 * <br>
	 * Uses default values for size and initial x, y, and speeds but allows initial color specification
	 * @param c the initial color of this Ball
	 */
	public InvisibleBall(Color c) {
		super(c);
	}
	
	/**
	 * Size and Color Constructor
	 * <br>
	 * Uses default values for initial x, y, and speeds but allows size and initial color specification
	 * @param d the diameter (in coordinates) of the Ball
	 * @param c the initial color of the Ball
	 */
	public InvisibleBall(int d, Color c) {
		super(d, c);
	}

	/**
	 * Location Constructor
	 * <br>
	 * Uses default values for diameter, initial color and speeds, but allows initial location specification
	 * @param x the initial x-coordinate of the Ball
	 * @param y the initial y-coordinate of the Ball
	 */
	public InvisibleBall(int x, int y) {
		super(x, y);
	}
	
	/**
	 * Location and Color Constructor
	 * <br>
	 * Uses default values for diameter and initial speeds, but allows initial location and color specification
	 * @param x the initial x-coordinate of the Ball
	 * @param y the initial y-coordinate of the Ball
	 * @param c the initial color of the Ball
	 */
	public InvisibleBall(int x, int y, Color c) {
		super(x, y, c);
	}

	/**
	 * Location and Size Constructor
	 * <br>
	 * Uses default values for initial color and speeds, but allows size and initial location specification
	 * @param x the initial x-coordinate of the Ball
	 * @param y the initial y-coordinate of the Ball
	 * @param d the diameter (in coordinates) of the Ball
	 */
	public InvisibleBall(int x, int y, int d) {
		super(x, y, d);
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
	public InvisibleBall(int x, int y, int d, Color c) {
		super(x, y, d, c);
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
	public InvisibleBall(int x, int y, int d, int xS, int yS) {
		super(x, y, d, xS, yS);
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
	public InvisibleBall(int x, int y, int d, Color c, int xS, int yS) {
		super(x, y, d, c, xS, yS);
	}

	/**
	 * Randomly changes visibility
	 * @return whether after randomization the Ball is visible
	 */
	private boolean getVisible() {
		// change visibility if the random number is below a threshold
		if (Math.random() < CHANGE_VISIBILITY_CHANCE) visible = !visible;
		
		return visible;
	}
	
	/**
	 * Modifies the moveAndDraw method to only draw if visible is randomly true
	 */
	public void moveAndDraw(Graphics window) {
		// erase old drawing if it was there!
		if (visible) erase(window);
		// move to new position
		setPos(getX() + getXSpeed(), getY() + getYSpeed());
		
		// if visible is still/becomes randomly true, draw the Ball
		if (getVisible()) draw(window);
	}
}