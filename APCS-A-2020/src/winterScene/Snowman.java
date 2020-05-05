package winterScene;

//(c) A+ Computer Science
//www.apluscompsci.com
//Name - Faith Okamoto

// for graphics
import java.awt.Graphics;

/**
 * Represents an immovable snowman
 * @author faith
 */
public class Snowman extends AbstractShape {
	/**
	 * Constructor
	 * <br>
	 * Allows location and size specification
	 * @param x the x-coordinate of the Snowman
	 * @param y the y-coordinate of the Snowman
	 * @param w the width of the Snowman
	 * @param h the height of the Snowman
	 */
	public Snowman(int x, int y, int w, int h) {
		super(x, y, w, h);
	}

	public void draw(Graphics window) {
		// save x, y, w, and h in shorter names
		int x = getX();
		int y = getY();
		int w = getWidth();
		int h = getHeight();
		
		// color the Snowman, and draw its 3 sections
		window.setColor(getColor());
		window.fillOval(x, y + (h / 2), w, h / 2);
		window.fillOval(x + (w / 4), y + (h / 4), w / 2, h / 3);
		window.fillOval(x + (w / 3), y, w / 3, h / 3);
	}

	/**
	 * The Snowman does not move, so this method simply calls draw(window)
	 */
	public void moveAndDraw(Graphics window) {
		draw(window);
	}
}