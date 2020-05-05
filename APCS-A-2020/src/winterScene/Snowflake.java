package winterScene;

//(c) A+ Computer Science
//www.apluscompsci.com
//Name - Faith Okamoto

// for graphics
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;

/**
 * Represents a snowflake which can fall down the screen
 * @author faith
 */
public class Snowflake extends AbstractShape {
	/**
	 * the snowflake drawing
	 */
	private Polygon flake;
	
	/**
	 * Constructor
	 * <br>
	 * Initializes size, fall speed, and initial position, as well as the flake drawing
	 * @param x the initial x-coordinate of the Snowflake
	 * @param y the initial y-coordinate of the Snowflake
	 * @param r the radius of the Snowflake
	 * @param s the y-speed (fall speed), in coordinates per move, of the Snowflake
	 */
	public Snowflake(int x, int y, int r, int s) {
		super(x, y, r * 2, r * 2, Color.black, 0, s);
		setUpFlake(x, y);
	}
	
	/**
	 * Initializes the snowflake Polygon
	 * @param x the x-coordinate of the Snowflake
	 * @param y the y-coordinate of the Snowflake
	 */
	private void setUpFlake(int x, int y) {
		// save some checkpoint coordinates (width = height, since flake has radius)
		
		// one-forth the way from the origin
		int of = getWidth() / 4;
		// one-half the way from the origin
		int oh = getWidth() / 2;
		// three-forths the way from the origin
		int tf = 3 * getWidth() / 4;
		// all the way to the other side from the origin
		int s = getWidth();
		
		// initialize the lists of coordinates
		int[] xCoords = {x + oh, x + of, x + oh, x + tf, x + oh, x + s,
				x + s, x + oh, x + tf, x + oh, x + of, x+ oh, x, x};
		int[] yCoords = {y + oh, y + of, y, y + of, y + oh, y + of, y+ tf,
				y + oh, y + tf, y + s, y + tf, y + oh, y + tf, y + of};
		
		// initialize the flake
		flake = new Polygon(xCoords, yCoords, xCoords.length);
	}

	@Override
	public void draw(Graphics window) {
		// using the proper color, draw the flake (not fill)
		window.setColor(getColor());
		window.drawPolygon(flake);
	}

	@Override
	public void moveAndDraw(Graphics window) {
		// move flake
		flake.translate(getXSpeed(), getYSpeed());
		// adjust inner coordinates
		setX(getX() + getXSpeed());
		setY(getY() + getYSpeed());
		// redraw in new position
		draw(window);
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
	 * Generates a random Snowflake
	 * @param xMin the minimum x-coordinate to allow
	 * @param xMax the maximum x-coordinate to allow
	 * @param yMin the minimum y-coordinate to allow
	 * @param yMax the maximum y-coordinate to allow
	 * @param rMin the minimum radius to allow
	 * @param rMax the maximum radius to allow
	 * @param sMin the minimum fall-speed to allow
	 * @param sMax the maximum fall-speed to allow
	 * @return a randomly generated Snowflake
	 */
	public static Snowflake randomFlake(int xMin, int xMax, int yMin,
			int yMax, int rMin, int rMax, int sMin, int sMax) {
		return new Snowflake(randRange(xMin, xMax), randRange(yMin, yMax),
				randRange(rMin, rMax), randRange(sMin, sMax));
	}
}