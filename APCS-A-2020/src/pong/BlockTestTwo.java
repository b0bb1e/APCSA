package pong;

//(c) A+ Computer Science
//www.apluscompsci.com
//Name - Faith Okamoto

// for graphics
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Canvas;

/**
 * Basic tester for Block's drawing methods
 * @author faith
 */
@SuppressWarnings("serial")
public class BlockTestTwo extends Canvas {
	/**
	 * Constructor
	 * <br>
	 * Initializes the Canvas
	 */
	public BlockTestTwo() {
		setBackground(Color.WHITE);
	}

	public void paint(Graphics window) {
		// make a bunch of blocks and draw them
		
		Block one = new Block();
		one.draw(window);

		Block two = new Block(50, 50, 30, 30);
		two.draw(window);

		Block three = new Block(350, 350, 15, 15, Color.RED);
		three.draw(window);

		two.draw(window, Color.white);

		Block four = new Block(450, 50, 20, 60, Color.GREEN);
		four.draw(window);
	}
}