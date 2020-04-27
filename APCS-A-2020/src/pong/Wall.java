package pong;

/**
 * Can generate Block Walls given dimensions of a field
 * @author faith
 */
public class Wall extends Block {
	/**
	 * the thickness of the walls
	 */
	public static final int THICKNESS = 5;
	
	/**
	 * Vertical Constructor
	 * <br>
	 * Creates a vertical Wall with size THICKNESS x h
	 * @param x the x-coordinate of the Wall
	 * @param h the height of the Wall
	 */
	private Wall(int x, int h) {
		super(x, 0, THICKNESS, h);
	}
	
	/**
	 * Horizontal Constructor
	 * <br>
	 * Creates a horizontal wall with size w x THICKNESS
	 * @param y the y-coordinate of the Wall
	 * @param w the height of the Wall
	 * @param horiz included to differentiate this constructor with the Vertical one
	 */
	private Wall(int y, int w, boolean horiz) {
		super(0, y, w, THICKNESS);
	}
	
	/**
	 * Generates Wall borders given dimensions
	 * @param width the width of the place being bordered
	 * @param height the height of the place being bordered
	 * @return the created Walls
	 */
	public static Wall[] getBorders(int width, int height) {
		// initialize return variable
		Wall[] borders = new Wall[4];
		// left wall
		borders[0] = new Wall(0, height);
		// top wall
		borders[1] = new Wall(0, width, true);
		// right wall
		borders[2] = new Wall(width - 19, height);
		// bottom wall
		borders[3] = new Wall(height - 41, width, true);
		
		return borders;
	}
}