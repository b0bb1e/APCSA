package winterScene;

//(c) A+ Computer Science
//www.apluscompsci.com
//Name - Faith Okamoto

// for graphics
import java.awt.Component;
import javax.swing.JFrame;

/**
 * Basic runner for the graphics of the WinterScenePanel
 * @author faith
 */
@SuppressWarnings("serial")
public class GraphicsRunner extends JFrame {
	/**
	 * the width of the frame
	 */
	private static final int WIDTH = 800;
	/**
	 * the height of the frame
	 */
	private static final int HEIGHT = 600;

	/**
	 * Constructor
	 * <br>
	 * Initializes/runs the WinterScenePanel
	 */
	public GraphicsRunner() {
		// set up the Frame
		super("THE WINTER SCENE PROJECT");
		setSize(WIDTH, HEIGHT);

		// set up the Panel and add to Frame
		WinterScenePanel scene = new WinterScenePanel(WIDTH, HEIGHT);
		((Component) scene).setFocusable(true);
		getContentPane().add(scene);

		// make Frame visible and exitable
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	/**
	 * Creates a new GraphcisRunner, which runs the WinterScenePanel
	 * @param args
	 */
	public static void main(String args[]) {
		@SuppressWarnings("unused")
		GraphicsRunner run = new GraphicsRunner();
	}
}