package blocks;

// for the game itself
import javax.swing.JFrame;

// for handling window closes
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

@SuppressWarnings("serial")
public class BlocksRunner extends JFrame {
	/**
	 * Initializes a Blocks game
	 */
	public BlocksRunner() {
		// set up the Frame
		super("Blocks");
		setSize(500, 500);
		
		// create a BlocksPanel, focus, and add to Frame
		BlocksPanel game = new BlocksPanel();
		game.setFocusable(true);
		getContentPane().add(game);

		// make it visible
		setVisible(true);
		
		// set up close to save current Users before exiting
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				UserCenter.saveUsers();
				System.exit(0);
			}
		});
	}
	
	/**
	 * Instantiates a LinesRunner
	 * @param args not used
	 */
	public static void main(String[] args) {
		@SuppressWarnings("unused")
		BlocksRunner run = new BlocksRunner();
	}
}