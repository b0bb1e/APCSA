package pong;

//(c) A+ Computer Science
//www.apluscompsci.com
//Name - Faith Okamoto

// for graphics
import java.awt.Color;

class SpeedUpBall extends Ball {
	/**
	 * Blank Constructor
	 * <br>
	 * Uses default values for size and initial x, y, color, and speeds
	 */
	public SpeedUpBall() {
		super();
	}
	
	/**
	 * Size Constructor
	 * <br>
	 * Uses default values for initial x, y, color, and speeds but allows size specification
	 * @param d the diameter (in coordinates) of this Ball
	 */
	public SpeedUpBall(int d) {
		super(d);
	}
	
	/**
	 * Color Constructor
	 * <br>
	 * Uses default values for size and initial x, y, and speeds but allows initial color specification
	 * @param c the initial color of this Ball
	 */
	public SpeedUpBall(Color c) {
		super(c);
	}
	
	/**
	 * Size and Color Constructor
	 * <br>
	 * Uses default values for initial x, y, and speeds but allows size and initial color specification
	 * @param d the diameter (in coordinates) of the Ball
	 * @param c the initial color of the Ball
	 */
	public SpeedUpBall(int d, Color c) {
		super(d, c);
	}

	/**
	 * Location Constructor
	 * <br>
	 * Uses default values for diameter, initial color and speeds, but allows initial location specification
	 * @param x the initial x-coordinate of the Ball
	 * @param y the initial y-coordinate of the Ball
	 */
	public SpeedUpBall(int x, int y) {
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
	public SpeedUpBall(int x, int y, Color c) {
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
	public SpeedUpBall(int x, int y, int d) {
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
	public SpeedUpBall(int x, int y, int d, Color c) {
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
	public SpeedUpBall(int x, int y, int d, int xS, int yS) {
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
	public SpeedUpBall(int x, int y, int d, Color c, int xS, int yS) {
		super(x, y, d, c, xS, yS);
	}

	/**
	 * Modifies setXSpeed to always set the absolute value one higher than asked
	 */
	public void setXSpeed(int xS) {
		// if asked to set a positive speed, set 1 higher
		if (xS >= 0) super.setXSpeed(xS + 1);
		// otherwise (asked to set a negative speed) set 1 lower
		else super.setXSpeed(xS - 1);
	}

	/**
	 * Modifies setYSpeed to always set the absolute value one higher than asked
	 */
	public void setYSpeed(int yS) {
		// if asked to set a positive speed, set 1 higher
		if (yS >= 0) super.setYSpeed(yS + 1);
		// otherwise (asked to set a negative speed) set 1 lower
		else super.setYSpeed(yS - 1);
	}
}