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
 * An alien in the Starfighter game
 * @author faith
 */
public class Alien extends MovingThing {
	/**
	 * the Alien's graphics image
	 */
	private Image image;

	/**
	 * Uses default values for size and initial position and speed
	 */
	public Alien() {
		this(DEFAULT_POS, DEFAULT_POS, DEFAULT_SIZE, DEFAULT_SIZE, DEFAULT_SPEED);
	}
	
	/**
	 * Uses default values for size and initial position, but allows initial speed specification
	 * @param s the Alien's initial speed, in coordinates per move
	 */
	public Alien(int s) {
		this(DEFAULT_POS, DEFAULT_POS, DEFAULT_SIZE, DEFAULT_SIZE, s);
	}

	/**
	 * Uses default values for size and initial speed, but allows initial position specification
	 * @param x the Alien's initial x-coordinate
	 * @param y the Alien's initial y-coordinate
	 */
	public Alien(int x, int y) {
		this(x, y, DEFAULT_SIZE, DEFAULT_SIZE, DEFAULT_SPEED);
	}

	/**
	 * Uses default values for size, but allows initial position and speed specification
	 * @param x the Alien's initial x-coordinate
	 * @param y the Alien's initial y-coordinate
	 * @param s the Alien's initial speed, in coordinates per move
	 */
	public Alien(int x, int y, int s) {
		this(x, y, DEFAULT_SIZE, DEFAULT_SIZE, s);
	}

	/**
	 * Uses default values for initial speed, but allows size and initial position specification
	 * @param x the Alien's initial x-coordinate
	 * @param y the Alien's initial y-coordinate
	 * @param w the Alien's width, in coordinates
	 * @param h the Alien's height, in coordinates
	 */
	public Alien(int x, int y, int w, int h) {
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
	public Alien(int x, int y, int w, int h, int s) {
		super(x, y, w, h, s);
		
		try {
			// attempt to load alien image
			URL url = getClass().getResource("images/alien.jpg");
			image = ImageIO.read(url);
		} catch (Exception e) {
			// if that didn't work, complain
			throw new RuntimeException("Couldn't load the alien image");
		}
	}

	public void move(char direction) {
		// only recognizes DOWN, LEFT, and RIGHT; not UP
		if (direction == DOWN) setY(getY() + getHeight());
		else if (direction == LEFT) setX(getX() - getSpeed());
		else if (direction == RIGHT) setX(getX() + getSpeed());
	}

	public void draw(Graphics window) {
		window.drawImage(image, getX(), getY(), getWidth(), getHeight(), null);
	}
	
	/**
	 * Checks if this Alien has collided with a Locatable
	 * @param obj an object which has possibly collided with the Alien
	 * @return whether the Alien and Locatable have indeed collided
	 */
	public boolean checkCollision(Locatable obj) {
		// if other object is too far to the left to touch, return false
		if (getX() > obj.getX() && getX() > obj.getX() + obj.getWidth()) return false;
		// if other object is too far to the right to touch, return false
		if (getX() < obj.getX() && getX() + getWidth() < obj.getX()) return false;
		// if other object is too far below to touch, return false
		if (getY() > obj.getY() && getY() > obj.getY() + obj.getHeight()) return false;
		// if other object is too far above to touch, return false
		if (getY() < obj.getY() && getY() + getHeight() < obj.getY()) return false;
		
		// if none of that, return true
		return true;
	}
}