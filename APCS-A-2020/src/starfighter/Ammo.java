package starfighter;

//(c) A+ Computer Science
//www.apluscompsci.com
//Name - Faith Okamoto

// for graphics
import java.awt.Color;
import java.awt.Graphics;

/**
 * A bullet, drawn as a cyan circle
 * @author faith
 */
public class Ammo extends MovingThing {
	/**
	 * Uses default values for size and initial position and speed
	 */
	public Ammo() {
		super();
	}
	
	/**
	 * Uses default values for size and initial position, but allows initial speed specification
	 * @param s the Ammo's initial speed, in coordinates per move
	 */
	public Ammo(int s) {
		super(s);
	}

	/**
	 * Uses default values for size and initial speed, but allows initial position specification
	 * @param x the Ammo's initial x-coordinate
	 * @param y the Ammo's initial y-coordinate
	 */
	public Ammo(int x, int y) {
		super(x, y);
	}

	/**
	 * Uses default values for size, but allows initial position and speed specification
	 * @param x the Ammo's initial x-coordinate
	 * @param y the Ammo's initial y-coordinate
	 * @param s the Ammo's initial speed, in coordinates per move
	 */
	public Ammo(int x, int y, int s) {
		super(x, y, s);
	}
	
	/**
	 * Uses default values for initial speed, but allows size and initial position specification
	 * @param x the Ammo's initial x-coordinate
	 * @param y the Ammo's initial y-coordinate
	 * @param w the Ammo's width, in coordinates
	 * @param h the Ammo's height, in coordinates
	 * @param s the Ammo's initial speed, in coordinates per move
	 */
	public Ammo(int x, int y, int w, int h) {
		super(x, y, w, h);
	}

	/**
	 * Allows specification of size and initial position and speed.
	 * Called by all other constructors, and tries to load the Ammo image
	 * @param x the Ammo's initial x-coordinate
	 * @param y the Ammo's initial y-coordinate
	 * @param w the Ammo's width, in coordinates
	 * @param h the Ammo's height, in coordinates
	 * @param s the Ammo's initial speed, in coordinates per move
	 */
	public Ammo(int x, int y, int w, int h, int s) {
		super(x, y, w, h, s);
	}
	
	public void draw(Graphics window) {
		// draw the Ammo's circle in cyan
		window.setColor(Color.cyan);
		window.fillOval(getX(), getY(), getWidth(), getHeight());
	}

	public void move(char direction) {
		// moves UP every time
		setY(getY() - getSpeed());
	}
}