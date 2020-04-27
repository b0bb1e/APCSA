package pong;

//(c) A+ Computer Science
//www.apluscompsci.com
//Name - Faith Okamoto

// for graphics
import javax.swing.JFrame;
import java.awt.Component;

/**
 * Basic tester for Block, Ball, and Paddle GUIs
 * @author faith
 */
@SuppressWarnings("serial")
public class Tester extends JFrame {
	/**
	 * width of the test frame
	 */
	private static final int WIDTH = 800;
	/**
	 * height of the test frame
	 */
	private static final int HEIGHT = 600;

	/**
	 * Constructor
	 * <br>
	 * Initializes everything
	 */
	public Tester() {
		super("PONG TESTER");
		setSize(WIDTH,HEIGHT);

		getContentPane().add(new BlockTestTwo());
		getContentPane().add(new BallTestTwo());

		PaddleTestTwo padTest = new PaddleTestTwo();
		((Component)padTest).setFocusable(true);
		getContentPane().add(padTest);

		setVisible(true);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	/**
	 * Runs the tester
	 * @param args not used
	 */
	public static void main(String args[]) {
		@SuppressWarnings("unused")
		Tester run = new Tester();
	}
}