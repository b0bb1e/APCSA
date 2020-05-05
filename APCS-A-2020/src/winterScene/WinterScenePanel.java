package winterScene;

//(c) A+ Computer Science
//www.apluscompsci.com
//Name - Faith Okamoto

// for graphics
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.Font;

import javax.swing.JPanel;
import java.util.ArrayList;

/**
 * A Panel which displays a winter scene
 * <br>
 * Poorly hidden Easter (Chirstmas?) Eggs (Presents?):
 * <ul>
 * 	<li>Typing "SANTA" (not case sensitive) will add a random, bouncing present</li>
 * 	<li>Typing "GRINCH" (not case sensitive) will remove (steal) a present</li>
 * 	<li>Clicking on any present will change its color randomly</li>
 * </ul>
 * @author faith
 */
@SuppressWarnings("serial")
public class WinterScenePanel extends JPanel implements KeyListener, Runnable {
	/**
	 * the Snowflakes currently falling
	 */
	private final ArrayList<Snowflake> flakes;
	/**
	 * the Presents currently bouncing around
	 */
	private final ArrayList<Present> presents;
	/**
	 * the Snowman being displayed
	 */
	private final Snowman sman;
	/**
	 * the Tree being displayed
	 */
	private final Tree tree;
	
	/**
	 * the keys which were last pressed
	 */
	private final char[] lastPressed;
	/**
	 * the letters requried to spell out/activate "SANTA"
	 */
	private static final char[] SANTA = {'S', 'A', 'N', 'T', 'A'};
	/**
	 * the letters required to spell out/activate the "GRINCH"
	 */
	private static final char[] GRINCH = {'G', 'R', 'I', 'N', 'C', 'H'};

	/**
	 * Constructor
	 * <br>
	 * Initializes all instance variables; sets up panel
	 * @param width the width of the Frame this Panel will be on
	 * @param height the height of the Frame this Panel will be on
	 */
	public WinterScenePanel(int width, int height) {
		// initialize flakes to have 50 random Snowflakes
		flakes = new ArrayList<Snowflake>();
		for (int i = 0; i < 50; ++i)
			flakes.add(Snowflake.randomFlake(0, width - 15, 0, height - 15, 5, 15, 2, 10));
		// initialize presents to empty
		presents = new ArrayList<Present>();
		
		// initialize the Snowman and Tree
		sman = new Snowman(width / 2, height - 200, 100, 150);
		tree = new Tree(width / 4, height / 2, 100, height / 2 - 50);
		lastPressed = new char[6];

		// make sure we're listening for keys!
		addKeyListener(this);
		// make everything visible
		setVisible(true);
		// start
		new Thread(this).start();
	}

	/**
	 * Updates should just paint
	 */
	public void update(Graphics window) {
		paint(window);
	}

	public void paint(Graphics window) {
		// cover up the background in blue
		window.setColor(Color.BLUE);
		window.fillRect(0, 0, getWidth(), getHeight());
		// write out the instructions
		window.setFont(new Font("TAHOMA", Font.BOLD, 18));
		window.drawString("MAKE A WINTER SCENE!", 40, 40);
		
		// draw the Snowman and Tree
		sman.draw(window);
		tree.draw(window);
		
		// loop over all flakes
		for (int i = 0; i < flakes.size(); ++i) {
			// move this flake down
			flakes.get(i).moveAndDraw(window);
			
			// if this flake has reached the bottom
			if (flakes.get(i).getY() + flakes.get(i).getHeight() >= getHeight())
				// set this spot to a new, randomly-generated flake
				flakes.set(i, Snowflake.randomFlake(0, getWidth() - 15, 0, 20, 5, 15, 2, 10));
		}
		
		// loop over all presents
		for (Present present : presents) {
			// move this present
			present.moveAndDraw(window);
			
			// if this present has bumped into a side wall
			if (present.getX() + present.getWidth() >= getWidth() || present.getX() <= 0)
				// reverse its x-speed
				present.setXSpeed(-present.getXSpeed());
			// if this present has bumped into the floor or ceiling
			if (present.getY() + present.getHeight() >= getHeight() || present.getY() <= 0)
				// reverse its y-speed
				present.setYSpeed(-present.getYSpeed());
		}
	}

	public void run() {
		try {
			while (true) {
				// wait 35 ms between frames
				Thread.sleep(35);
				repaint();
			}
		}
		catch (Exception e) {}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// shift all saved keys down an index
		for (int i = 0; i < lastPressed.length - 1; ++i)
			lastPressed[i] = lastPressed[i + 1];
		// set last index to the upper-case version of the typed key
		lastPressed[lastPressed.length - 1] = Character.toUpperCase(e.getKeyChar());
		
		// if the first character indicates a chance of GRINCH, and there are presents to steal
		if (lastPressed[0] == GRINCH[0] && !presents.isEmpty()) {
			// assume that the rest of the keys are good
			boolean good = true;
			// loop over all other keys to check
			for (int i = 1; i < GRINCH.length; ++i)
				// if this key doesn't match the required one
				if (lastPressed[i] != GRINCH[i]) {
					// note that this is not good and exit
					good = false;
					break;
				}
			
			// if all keys passed, remove one present
			if (good) presents.remove(presents.size() - 1);
		}
		
		// if the second character indicates a chance of SANTA
		if (lastPressed[1] == SANTA[0]) {
			// assume that the rest of the keys are good
			boolean good = true;
			// loop over all other keys to check
			for (int i = 1; i < SANTA.length; ++i)
				// if this key doesn't match the required one
				if (lastPressed[i + 1] != SANTA[i]) {
					// not that this is not good and exit
					good = false;
					break;
				}
			
			// if all keys passed
			if (good) {
				// add a randomly generated present
				presents.add(Present.randomPresent(0, getWidth() - 100, 0, getHeight() - 100, 20, 50));
				// add it as something intrested in mouse events
				addMouseListener(presents.get(presents.size() - 1));
			}
		}
	}

	/**
	 * Ignore keyPressed events
	 */
	@Override
	public void keyPressed(KeyEvent e) {}

	/**
	 * Ignore keyReleased events
	 */
	@Override
	public void keyReleased(KeyEvent e) {}
}