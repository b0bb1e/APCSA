package winterScene;

// for graphics
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Represents a striped present box
 * @author faith
 */
public class Present extends AbstractShape implements MouseListener{
	/**
	 * Constructor
	 * <br>
	 * Allows size, color, and initial position and speeds specification
	 * @param x the initial x-coordinate of the Present
	 * @param y the initial y-coordinate of the Present
	 * @param s the side length of the Present
	 * @param c the color of the Present
	 * @param xS the initial x-speed, in coordinates per move, of the Present
	 * @param yS the initial y-speed, in coordinates per move, of the Present
	 */
	public Present(int x, int y, int s, Color c, int xS, int yS) {
		super(x, y, s, s, c, xS, yS);
	}

	@Override
	public void draw(Graphics window) {
		// draw the main box in this Present's color
		window.setColor(getColor());
		window.fillRect(getX(), getY(), getWidth(), getHeight());
		
		// draw 2 black stripes, a fifth wide and a fifth apart
		window.setColor(Color.black);
		for (int i = 1; i <= 3; i += 2)
			window.fillRect(getX() + (i * getWidth() / 5), getY(), getWidth() / 5, getHeight());
		
	}

	@Override
	public void moveAndDraw(Graphics window) {
		// update internal coordinates
		setX(getX() + getXSpeed());
		setY(getY() + getYSpeed());
		// draw in new position
		draw(window);
	}
	
	/**
	 * Generates a random color
	 * @return a random RGB color
	 */
	public static Color randColor() {
		return new Color(randRange(0, 255), randRange(0, 255), randRange(0, 255));
	}
	
	/**
	 * Generates a random number within a certain range
	 * @param min the minimum number, inclusive
	 * @param max the maximum number, inclusive
	 * @return a random integer within the given range
	 */
	public static int randRange(int min, int max) {
		return (int) (Math.random() * (max - min + 1)) + min;
	}

	/**
	 * Generates a random Present
	 * @param xMin the minimum x-coordinate to allow
	 * @param xMax the maximum x-coordinate to allow
	 * @param yMin the minimum y-coordinate to allow
	 * @param yMax the maximum y-coordinate to allow
	 * @param sMin the minimum side length to allow
	 * @param sMax the maximum side length to allow
	 * @return a randomly generated Present
	 */
	public static Present randomPresent(int xMin, int xMax, int yMin, int yMax, int sMin, int sMax) {
		return new Present(randRange(xMin, xMax), randRange(yMin, yMax), randRange(sMin, sMax),
				randColor(), randRange(-5, 5), randRange(-5, 5));
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// if the click was on the Present
		if (e.getX() >= getX() && e.getX() <= getX() + getWidth() &&
				e.getY() >= getY() && e.getY() <= getY() + getHeight())
			// change to a random color
			setColor(randColor());
	}

	/**
	 * Ignore mousePressed events
	 */
	@Override
	public void mousePressed(MouseEvent e) {}

	/**
	 * Ignore mouseReleased events
	 */
	@Override
	public void mouseReleased(MouseEvent e) {}

	/**
	 * Ignore mouseEntered events
	 */
	@Override
	public void mouseEntered(MouseEvent e) {}

	/**
	 * Ignore mouseExited events
	 */
	@Override
	public void mouseExited(MouseEvent e) {}
}