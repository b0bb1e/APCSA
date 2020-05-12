package starfighter;

//(c) A+ Computer Science
//www.apluscompsci.com
//Name - Faith Okamoto

// for graphics
import javax.swing.JFrame;
import java.awt.Component;

/**
 * Runs the StarFighter game
 * @author faith
 */
@SuppressWarnings("serial")
public class StarFighter extends JFrame {
	/**
	 * the width of the game's frame
	 */
	private static final int WIDTH = 800;
	/**
	 * the height of the game's frame
	 */
	private static final int HEIGHT = 600;

	/**
	 * Sets up the game
	 */
	public StarFighter() {
		super("STARFIGHTER");
		setSize(WIDTH, HEIGHT);
		
		// initialize and add an OuterSpace
		OuterSpace theGame = new OuterSpace(this);
		((Component) theGame).setFocusable(true);
		getContentPane().add(theGame);

		// set visible and closable
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	/**
	 * Runs a StarFighter game
	 * @param args not used
	 */
	public static void main(String args[]) {
		@SuppressWarnings("unused")
		StarFighter run = new StarFighter();
	}
}