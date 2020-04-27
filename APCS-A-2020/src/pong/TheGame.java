package pong;

//(c) A+ Computer Science
//www.apluscompsci.com
//Name - Faith Okamoto
// for graphics
import javax.swing.JFrame;
import java.awt.Component;

/**
 * Runs Pong
 * @author faith
 */
@SuppressWarnings("serial")
public class TheGame extends JFrame {
	/**
	 * width of the Pong board
	 */
	private static final int WIDTH = 800;
	/**
	 * height of the Pong board
	 */
	private static final int HEIGHT = 600;

	/**
	 * Constructor
	 * <br>
	 * Initializes the Canvas, then adds a Pong game to it
	 */
	public TheGame() {
		// title should be PONG
		super("PONG");
		// initialize size
		setSize(WIDTH, HEIGHT);
		
		// initialize the Pong game
		Pong game = new Pong(this);
		((Component) game).setFocusable(true);
		getContentPane().add(game);

		// make everything visible and exitable
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	/**
	 * Initializes the game
	 * @param args not used
	 */
	public static void main(String args[]) {
		@SuppressWarnings("unused")
		TheGame run = new TheGame();
	}
}