package starfighter;

//(c) A+ Computer Science
//www.apluscompsci.com
//Name - Faith Okamoto

// for loading images
import java.net.URL;
import java.awt.Graphics;
import java.awt.Image;
import javax.imageio.ImageIO;

/**
 * A moving spaceship
 * @author faith
 */
public class Ship extends MovingThing {
	/**
	 * the image of the Ship
	 */
	private Image image;

	/**
	 * Uses default values for size and initial position and speed
	 */
	public Ship() {
		this(DEFAULT_POS, DEFAULT_POS, DEFAULT_SIZE, DEFAULT_SIZE, DEFAULT_SPEED);
	}
	
	/**
	 * Uses default values for size and initial position, but allows initial speed specification
	 * @param s the Ship's initial speed, in coordinates per move
	 */
	public Ship(int s) {
		this(DEFAULT_POS, DEFAULT_POS, DEFAULT_SIZE, DEFAULT_SIZE, s);
	}

	/**
	 * Uses default values for size and initial speed, but allows initial position specification
	 * @param x the Ship's initial x-coordinate
	 * @param y the Ship's initial y-coordinate
	 */
	public Ship(int x, int y) {
		this(x, y, DEFAULT_SIZE, DEFAULT_SIZE, DEFAULT_SPEED);
	}

	/**
	 * Uses default values for size, but allows initial position and speed specification
	 * @param x the Ship's initial x-coordinate
	 * @param y the Ship's initial y-coordinate
	 * @param s the Ship's initial speed, in coordinates per move
	 */
	public Ship(int x, int y, int s) {
		this(x, y, DEFAULT_SIZE, DEFAULT_SIZE, s);
	}

	/**
	 * Uses default values for initial speed, but allows size and initial position specification
	 * @param x the Ship's initial x-coordinate
	 * @param y the Ship's initial y-coordinate
	 * @param w the Ship's width, in coordinates
	 * @param h the Ship's height, in coordinates
	 */
	public Ship(int x, int y, int w, int h) {
		this(x, y, w, h, DEFAULT_SPEED);
	}
	
	/**
	 * Allows specification of size and initial position and speed.
	 * Called by all other constructors, and tries to load the Ship image
	 * @param x the Ship's initial x-coordinate
	 * @param y the Ship's initial y-coordinate
	 * @param w the Ship's width, in coordinates
	 * @param h the Ship's height, in coordinates
	 * @param s the Ship's initial speed, in coordinates per move
	 */
	public Ship(int x, int y, int w, int h, int s) {
		super(x, y, w, h, s);
		
		try {
			// attempt to load Ship image
			URL url = getClass().getResource("images/ship.jpg");
			image = ImageIO.read(url);
		} catch (Exception e) {
			// if that didn't work, complain
			throw new RuntimeException("Couldn't load the Ship image");
		}
	}
	
	public void move(char direction) {
		// move in the specified direction
		if (direction == MovingThing.UP) setY(getY() - getSpeed());
		else if (direction == MovingThing.DOWN) setY(getY() + getSpeed());
		else if (direction == MovingThing.LEFT) setX(getX() - getSpeed());
		else if (direction == MovingThing.RIGHT) setX(getX() + getSpeed());
	}

	public void draw(Graphics window) {
		// draws the ship image
		window.drawImage(image, getX(), getY(), getWidth(), getHeight(), null);
	}
}