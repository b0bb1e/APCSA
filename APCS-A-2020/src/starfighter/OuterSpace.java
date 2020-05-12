package starfighter;

//(c) A+ Computer Science
//www.apluscompsci.com
//Name - Faith Okamoto

// for graphics
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Canvas;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * A game of Starfighter
 * @author faith
 */
@SuppressWarnings("serial")
public class OuterSpace extends Canvas implements KeyListener, Runnable {
	/**
	 * the player's spaceship
	 */
	private Ship ship;
	/**
	 * the Ammos in play
	 */
	private Bullets shots;
	/**
	 * the Aliens in play
	 */
	private AlienHorde horde;
	/**
	 * the bottom of the play-field
	 */
	private Wall bottom;
	
	/**
	 * the time of the last shot
	 */
	private long lastShot;
	/**
	 * the minimum time between shots, in ns
	 */
	private static final long SHOT_COOL_DOWN = 500000000;

	/**
	 * the keys currently pressed
	 */
	private boolean[] keys;
	
	/**
	 * the current score
	 */
	private int score;
	/**
	 * the label which displays the score
	 */
	private JLabel scoreMsg;
	/**
	 * the saved graphics
	 */
	private BufferedImage back;

	/**
	 * Initializes the game
	 * @param frame the frame the game will be on
	 */
	public OuterSpace(JFrame frame) {
		// black for outer space!
		setBackground(Color.black);
		// tracking 5 keys
		keys = new boolean[5];
		
		// the ship starts at the middle bottom
		ship = new Ship(frame.getWidth() / 2 - 10, frame.getHeight() - 100, 25, 25, 5);
		// initialize the shots
		shots = new Bullets();
		// initialize a 3-row Horde
		horde = new AlienHorde(3, frame.getWidth());
		// initialize a Wall for the bottom
		bottom = new Wall(0, frame.getHeight() - 10, frame.getWidth(), 10);
		// a shot hasn't been taken yet
		lastShot = Long.MIN_VALUE;
		
		// score starts at 0
		score = 0;
		// set up the score message
		scoreMsg = new JLabel("Score: " + score);
		// set up where this message will be
		scoreMsg.setBounds(frame.getWidth() - 100, 10, 90, 20);
		// set black background, green text, and opacity
		scoreMsg.setBackground(Color.black);
		scoreMsg.setForeground(Color.green);
		scoreMsg.setOpaque(true);
		// add to frame
		frame.add(scoreMsg);
		
		// set everything runnning
		this.addKeyListener(this);
		new Thread(this).start();
		setVisible(true);
	}

	/**
	 * Called when the game ends
	 */
	public void signalEnd() {
		// clear the horde and shots, and center the score
		horde.clear();
		shots.clear();
		scoreMsg.setBounds(getWidth() / 2 - 50, getHeight() / 2 - 10, 100, 20);
	}
	
	public void update(Graphics window) {
		paint(window);
	}

	public void paint(Graphics window) {
		// set up the double buffering to make the game animation nice and smooth
		Graphics2D twoDGraph = (Graphics2D) window;

		// take a snap shop of the current screen and same it as an image
		// that is the exact same width and height as the current screen
		if (back == null)
			back = (BufferedImage) (createImage(getWidth(), getHeight()));

		// create a graphics reference to the back ground image
		// we will draw all changes on the background image
		Graphics graphToBack = back.createGraphics();

		// draw background
		graphToBack.setColor(Color.BLUE);
		graphToBack.drawString("StarFighter ", 25, 50);
		graphToBack.setColor(Color.BLACK);
		graphToBack.fillRect(0, 0, 800, 600);

		// move ship if key is pressed
		if (keys[0]) ship.move(MovingThing.LEFT);
		if (keys[1]) ship.move(MovingThing.RIGHT);
		if (keys[2]) ship.move(MovingThing.UP);
		if (keys[3]) ship.move(MovingThing.DOWN);
		// if space is pressed and enough time has passed since last shot
		if (keys[4] && System.nanoTime() > lastShot + SHOT_COOL_DOWN) {
			// send out another shot, and reset lastShot
			shots.shoot(ship);
			lastShot = System.nanoTime();
		}
		
		// move bullets and aliens
		shots.moveEmAll();
		horde.moveEmAll(getWidth());
		
		// note dead aliens, and re-write score
		score += horde.removeDeadOnes(shots.getList());
		scoreMsg.setText("Score: " + score);
		
		// draw everything
		ship.draw(graphToBack);
		horde.drawEmAll(graphToBack);
		shots.drawEmAll(graphToBack);
		// if dead or won, signal an end
		if (horde.checkCollision(ship) || horde.checkCollision(bottom) || !horde.aliensLeft()) signalEnd();
		
		// draw image
		twoDGraph.drawImage(back, null, 0, 0);
	}

	public void keyPressed(KeyEvent e) {
		// if any interesting key was pressed, record it
		if (e.getKeyCode() == KeyEvent.VK_LEFT) keys[0] = true;
		else if (e.getKeyCode() == KeyEvent.VK_RIGHT) keys[1] = true;
		else if (e.getKeyCode() == KeyEvent.VK_UP) keys[2] = true;
		else if (e.getKeyCode() == KeyEvent.VK_DOWN) keys[3] = true;
		else if (e.getKeyCode() == KeyEvent.VK_SPACE) keys[4] = true;
		
		// repaint scene with new key pressed
		repaint();
	}

	public void keyReleased(KeyEvent e) {
		// if any interesting key was released, record it
		if (e.getKeyCode() == KeyEvent.VK_LEFT) keys[0] = false;
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) keys[1] = false;
		if (e.getKeyCode() == KeyEvent.VK_UP) keys[2] = false;
		if (e.getKeyCode() == KeyEvent.VK_DOWN) keys[3] = false;
		if (e.getKeyCode() == KeyEvent.VK_SPACE) keys[4] = false;
		
		// repaint scene with new key released
		repaint();
	}

	/**
	 * Ignore keyTyped events
	 */
	public void keyTyped(KeyEvent e) {}

	public void run() {
		try {
			while (true) {
				// wait 5 seconds between frames
				Thread.sleep(5);
				repaint();
			}
		} catch (Exception e) {}
	}
}