package pong;

// for graphics
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;

/**
 * A Runnable game of BreakOut
 * <br>
 * Controls: left and right arrows
 * @author faith
 */
@SuppressWarnings("serial")
public class BreakOut extends Canvas implements KeyListener, ActionListener, Runnable {
	/**
	 * the Ball being used in the game
	 */
	private final Ball ball;
	/**
	 * the player's Paddle
	 */
	private final Paddle paddle;
	/**
	 * the currently-visible Blocks
	 */
	private final ArrayList<Block> blocks;
	/**
	 * the Walls of the playing field
	 */
	private final Wall[] borders;
	
	/**
	* dimensions of the Block field used for resetting
	*/
	private final int width, height, rows;
	/**
	 * the number of lives the player has left
	 */
	private int lives;
	/**
	 * the keys that are currently pressed
	 */
	private final boolean[] keys;
	/**
	 * the button to restart the game
	 */
	private final JButton restartButton;
	/**
	 * the saved copy of the playing field to create smooth animation
	 */
	private BufferedImage back;
	
	/**
	 * the width and height of the Blocks
	 */
	public static final int BLOCK_SIZE = 25;
	
	/**
	 * Constructor
	 * <br>
	 * Initializes all game variables as set-up
	 * @param frame the JFrame that this game will run in
	 * @param r the number of rows of Blocks to use
	 */
	public BreakOut(JFrame frame, int r) {
		// save dimensions for the Block field
		width = frame.getWidth();
		height = frame.getHeight();
		rows = r;
		
		// the ball starts right above the paddle
		ball = new Ball(width / 2, height  - 75, 10);
		// the paddle starts in the middle bottom
		paddle = new Paddle(width / 2 - 50, height - 60, 100, 10);
		// initialize the blocks ArrayList
		blocks = new ArrayList<Block>();
		// set up the Blocks
		resetBlocks();
		// get the borders for the playing field
		borders = Wall.getBorders(width, height);
		
		// both keys that we care about are not pressed
		keys = new boolean[2];
		// the player starts with 3 lives
		lives = 3;
		
		// set up the restart button
		restartButton = new JButton("Restart");
		restartButton.setBounds(width / 2 - 50, height / 2 + 50, 100, 30);
		restartButton.setVisible(false);
		restartButton.addActionListener(this);
		frame.add(restartButton);
		
		// make the game visible
		setBackground(Color.WHITE);
		setVisible(true);
		
		// start the game's thread, it should listen for keys being pressed
		new Thread(this).start();
		addKeyListener(this);
	}
	
	/**
	 * Any update should just paint
	 */
	public void update(Graphics window) {
		paint(window);
	}
	
	/**
	 * Paints a frame of the game
	 */
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

		// draw ball, paddle, walls, and blocks
		ball.moveAndDraw(graphToBack);
		paddle.draw(graphToBack);
		for (Wall b : borders) b.draw(graphToBack);
		for (Block b : blocks) b.draw(graphToBack);
		
		// check for any collisions
		checkCollisions(graphToBack);
		
		// see if the paddles need to be moved
		if (keys[0]) paddle.moveRightAndDraw(graphToBack);
		else if (keys[1]) paddle.moveLeftAndDraw(graphToBack);
		
		// if there are no blocks left, then the player has won
		if (blocks.isEmpty()) signalWin();
		
		// draw the screen again
		twoDGraph.drawImage(back, null, 0, 0);
	}
	
	/**
	 * Resets the ball and paddle
	 */
	private void resetBallAndPaddle() {
		// set the paddle up in the bottom middle
		paddle.teleport(width / 2 - 50, height - 60, back.createGraphics());
		
		// the ball goes right above the paddle in the bottom middle
		ball.teleport(width / 2, height - 75, back.createGraphics());
		// randomize the ball's speed and direction
		ball.setSpeed((int) (Math.random() * 3) + 1, (int) -(Math.random() * 3) - 1);
		// randomly negate the ball's x-speed
		if (Math.random() > 0.5) ball.flipXSpeed();
	}
	
	/**
	 * Resets the Blocks
	 */
	private void resetBlocks() {
		// clear all current blocks
		blocks.clear();
		// loop over all open x-coordinates from one wall to the other
		for (int x = Wall.THICKNESS; x < width - Wall.THICKNESS - BLOCK_SIZE; x += BLOCK_SIZE)
			// loop over all y-coordinates required by row #
			for (int y = 2 * BLOCK_SIZE; y < (2 + rows) * BLOCK_SIZE; y += BLOCK_SIZE)
				// add a ball in this position with a random color
				blocks.add(new Block(x, y, BLOCK_SIZE, BLOCK_SIZE, BlinkyBall.randomColor()));
	}

	/**
	 * Signals a win
	 */
	private void signalWin() {
		System.out.println("win");
		// set up the restart button
		restartButton.setVisible(true);
	}
	
	/**
	 * Signals a loss
	 */
	private void signalLoss() {
		System.out.println("loss");
		// set up a restart button
		restartButton.setVisible(true);
		// set up the ball bouncing around as a wait screen
		ball.teleport(width / 2 - 5, height / 2 - 5, back.createGraphics());
	}
	
	/**
	 * Checks for any important collisions
	 * @param window the window to draw everything
	 */
	private void checkCollisions(Graphics window) {
		// if the ball collided with a side wall
		if (ball.didCollideLeft(borders[0]) || ball.didCollideRight(borders[2]))
			// negate its x-speed
			ball.flipXSpeed();
		
		// if the ball collided with the top wall
		if (ball.didCollideTop(borders[1])) 
			// negate its y-speed
			ball.flipYSpeed();
		
		// if the ball collided with the bottom wall
		if (ball.didCollideBottom(borders[3])) {
			// if the restart button is visible, just negate y-speed
			if (restartButton.isVisible()) ball.flipYSpeed();
			// otherwise (the game is still going)
			else {
				// the player loses a life
				lives--;
				// if they ran out of lives, they lose
				if (lives == 0) signalLoss();
				// otherwise the ball and paddle reset
				else resetBallAndPaddle();
			}
		}
	
		// if the ball collided with the paddle top
		if (ball.didCollideBottom(paddle))
			// negate its y-speed
			ball.flipYSpeed();
			
		// if the ball collided with the paddle's sides
		if (ball.didCollideLeft(paddle) || ball.didCollideRight(paddle))
			// negate its x-speed
			ball.flipXSpeed();
		
		// loop over all blocks from back for easy removal
		for (int i = blocks.size() - 1; i >= 0; i--) {
			// if a collision from top or bottom occurred
			if (ball.didCollideTop(blocks.get(i)) || ball.didCollideBottom(blocks.get(i))) {
				// negate the ball's y-speed
				ball.flipYSpeed();
				
				// erase and remove the block if the game is active (restart button is invisible)
				if (!restartButton.isVisible()) {
					blocks.get(i).erase(window);
					blocks.remove(i);
				}
			}
			
			// or if a collision from a side occurred
			else if (ball.didCollideLeft(blocks.get(i)) || ball.didCollideRight(blocks.get(i))) {
				// negate the ball's x-speed
				ball.flipXSpeed();
				
				// erase and remove the block if the game is active (restart button is invisible)
				if (!restartButton.isVisible()) {
					blocks.get(i).erase(window);
					blocks.remove(i);
				}
			}
		}
	}
	
	public void run() {
		try {
			while (true) {
				// continuously sleep and repaint
				Thread.sleep(8);
				repaint();
			}
		} 
		catch (Exception e) {}
	}
	
	public void keyPressed(KeyEvent e) {
		// get the keyCode
		switch (e.getKeyCode()) {
		// if it was an important key, set the proper
		// spot in the keys array to true
		// since the key is now pressed
		case KeyEvent.VK_RIGHT:
			keys[0] = true;
			break;
		case KeyEvent.VK_LEFT:
			keys[1] = true;
			break;
		}
	}

	public void keyReleased(KeyEvent e) {
		// get the keyCode
		switch (e.getKeyCode()) {
		// if it was an important key, set the proper
		// spot in the keys array to false
		// since the key is now not pressed
		case KeyEvent.VK_RIGHT:
			keys[0] = false;
			break;
		case KeyEvent.VK_LEFT:
			keys[1] = false;
			break;
		}
	}

	/**
	 * Ignore keyTyped events
	 */
	public void keyTyped(KeyEvent e) {}

	/**
	 * Listen for the restart button
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// if the restart button is clicked
		if (e.getSource().equals(restartButton)) {
			// reset everything
			resetBallAndPaddle();
			resetBlocks();
			// hide the restart button
			restartButton.setVisible(false);
		}
	}
}