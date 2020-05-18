package starfighter;

import java.util.ArrayList;

/**
 * An Alien which can explode into 4 smaller aliens
 * @author faith
 *
 */
public class BigAlien extends Alien {
	/**
	 * Uses default values for size and initial position and speed
	 */
	public BigAlien() {
		this(DEFAULT_POS, DEFAULT_POS, DEFAULT_SIZE, DEFAULT_SIZE, DEFAULT_SPEED);
	}
	
	/**
	 * Uses default values for size and initial position, but allows initial speed specification
	 * @param s the Alien's initial speed, in coordinates per move
	 */
	public BigAlien(int s) {
		this(DEFAULT_POS, DEFAULT_POS, DEFAULT_SIZE, DEFAULT_SIZE, s);
	}

	/**
	 * Uses default values for size and initial speed, but allows initial position specification
	 * @param x the Alien's initial x-coordinate
	 * @param y the Alien's initial y-coordinate
	 */
	public BigAlien(int x, int y) {
		this(x, y, DEFAULT_SIZE, DEFAULT_SIZE, DEFAULT_SPEED);
	}

	/**
	 * Uses default values for size, but allows initial position and speed specification
	 * @param x the Alien's initial x-coordinate
	 * @param y the Alien's initial y-coordinate
	 * @param s the Alien's initial speed, in coordinates per move
	 */
	public BigAlien(int x, int y, int s) {
		this(x, y, DEFAULT_SIZE, DEFAULT_SIZE, s);
	}

	/**
	 * Uses default values for initial speed, but allows size and initial position specification
	 * @param x the Alien's initial x-coordinate
	 * @param y the Alien's initial y-coordinate
	 * @param w the Alien's width, in coordinates
	 * @param h the Alien's height, in coordinates
	 */
	public BigAlien(int x, int y, int w, int h) {
		this(x, y, w, h, DEFAULT_SPEED);
	}
	
	/**
	 * Allows specification of size and initial position and speed.
	 * Called by all other constructors, and tries to load the Alien image
	 * @param x the Alien's initial x-coordinate
	 * @param y the Alien's initial y-coordinate
	 * @param w the Alien's width, in coordinates
	 * @param h the Alien's height, in coordinates
	 * @param s the Alien's initial speed, in coordinates per move
	 */
	public BigAlien(int x, int y, int w, int h, int s) {
		super(x, y, w, h, s);
		setLives(2);
	}
	
	/**
	 * Has a lower chance of speeding up
	 */
	public void speedUp() {if (Math.random() < AlienHorde.SPEED_UP_CHANCE) super.speedUp();}
	
	/**
	 * Explodes into 4 smaller aliens
	 */
	public ArrayList<Alien> explode() {
		// initialize return variable
		ArrayList<Alien> smalls = new ArrayList<Alien>(4);
		// save size in shorter variable name
		int size = getWidth() / 2;
		// add each of the 4 smaller Aliens to the list
		for (int row = 0; row < 2; ++row) for (int col = 0; col < 2; ++col)
			smalls.add(new Alien(getX() + row * size, getY() + col * size, size, size, 1));
			
		return smalls;
	}
}