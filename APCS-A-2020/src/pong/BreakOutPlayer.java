package pong;

//(c) A+ Computer Science
//www.apluscompsci.com
//Name - Faith Okamoto
// for graphics
import javax.swing.JFrame;
import java.awt.Component;

/**
 * Runs BreakOut
 * @author faith
 */
@SuppressWarnings("serial")
public class BreakOutPlayer extends JFrame {
	/**
	 * the size of the BreakOut board
	 */
	private static final int WIDTH = 500;
	/**
	 * the height of the BreakOut board
	 */
	private static final int HEIGHT = 700;

	/**
	 * Constructor
	 * <br>
	 * Initializes the Canvas, then adds a BreakOut game to it
	 */
	public BreakOutPlayer() {
		// title should be BreakOut
		super("BreakOut");
		// initialize size
		setSize(WIDTH, HEIGHT);

		// initialize the game
		BreakOut game = new BreakOut(this, 4);
		((Component) game).setFocusable(true);
		getContentPane().add(game);

		// make it visible and closable
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	/**
	 * Initialize the game
	 * @param args not used
	 */
	public static void main(String args[]) {
		@SuppressWarnings("unused")
		BreakOutPlayer run = new BreakOutPlayer();
	}
}