package starfighter;

/**
 * A stationary wall
 * @author faith
 */
public class Wall implements Locatable {
	/**
	 * the Wall's x-coordinate
	 */
	private int x;
	/**
	 * the Wall's y-coordinate
	 */
	private int y;
	/**
	 * the Wall's width in coordinates
	 */
	private int width;
	/**
	 * the Wall's height in coordinates
	 */
	private int height;
	
	/**
	 * Initializes position and size
	 * @param x the Wall's x-coordinate
	 * @param y the Wall's y-coordinate
	 * @param w the Wall's width in coordinates
	 * @param h the Wall's height in coordinates
	 */
	public Wall(int x, int y, int w, int h) {
		this.x = x;
		this.y = y;
		width = w;
		height = h;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}
	
	public String toString() {
		return x + " " + y + " " + width + " " + height;
	}
}