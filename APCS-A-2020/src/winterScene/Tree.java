package winterScene;

// for graphics
import java.awt.Color;
import java.awt.Graphics;

/**
 * Represents an immovable pine tree
 * @author faith
 */
public class Tree extends AbstractShape {
	/**
	 * the color of the trunk
	 */
	private static final Color BROWN = new Color(115, 79, 17);
	
	/**
	 * Constructor
	 * <br>
	 * Allows location and size specification
	 * @param x the x-coordinate of the Tree
	 * @param y the y-coordinate of the Tree
	 * @param w the width of the Tree
	 * @param h the height of the Tree
	 */
	public Tree(int x, int y, int w, int h) {
		super(x, y, w, h);
	}
	
	@Override
	public void draw(Graphics window) {
		// save x, y, w, and h in shorter variable names
		int x = getX();
		int y = getY();
		int w = getWidth();
		int h = getHeight();
		
		// the leaf-area of the Tree is green
		window.setColor(Color.green);
		
		// the points of the first triangle of Tree (1/4 between points and edges)
		int[][] triPoints = {{x + w / 2, x + 3 * w / 4, x + w / 4},  {y, y + h / 3, y + h / 3}};
		// fill this triangle
		window.fillPolygon(triPoints[0], triPoints[1], 3);
		
		// move all points h / 4 down
		for (int i = 0; i < triPoints[1].length; ++i) triPoints[1][i] += h / 4;
		// shift bottom points out so now only 1/5 is between points and edges
		triPoints[0][1] = x + 4 * w / 5;
		triPoints[0][2] = x + w / 5;
		// fill new triangle
		window.fillPolygon(triPoints[0], triPoints[1], 3);
		
		// move all points h / 4 down again
		for (int i = 0; i < triPoints[1].length; ++i) triPoints[1][i] += h / 4;
		// shift bottom points out so now they touch the edges
		triPoints[0][2] = x + w;
		triPoints[0][1] = x;
		// fill new triangle
		window.fillPolygon(triPoints[0], triPoints[1], 3);
		
		// draw trunk rectangle
		window.setColor(BROWN);
		window.fillRect(x + 3 * w / 8, y + 3 * h / 4, w / 4, h / 4);
	}

	/**
	 * Since the Tree cannot move, this method simply calls draw(window)
	 */
	@Override
	public void moveAndDraw(Graphics window) {
		draw(window);
	}
}