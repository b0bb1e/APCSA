package pong;

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
import static java.lang.Character.*;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * A Runnable game of Pong
 * <br>
 * Controls: W & Z (left) and I & M (right)
 * @author faith
 */
@SuppressWarnings("serial")
public class Pong extends Canvas implements KeyListener, Runnable {
	/**
	 * the Ball being used in the game
	 */
	private final Ball ball;
	/**
	 * the Paddle used by the left-side player
	 */
	private final Paddle leftPaddle;
	/**
	 * the Paddle used by the right-side player
	 */
	private final Paddle rightPaddle;
	/**
	 * the Walls of the playing field
	 */
	private final Wall[] borders;
	
	/**
	 * the keys that are currently pressed
	 */
	private final boolean[] keys;
	/**
	 * the points scored by the left-side player
	 */
	private byte leftScore;
	/**
	 * the points score by the right-side player
	 */
	private byte rightScore;
	/**
	 * the message showing the scores
	 */
	private final JLabel scoreMessage;
	/**
	 * the saved copy of the playing field to create smooth animation
	 */
	private BufferedImage back;

	/**
	 * Constructor
	 * <br>
	 * Initializes all game variables as set-up
	 * @param frame the JFrame that this Pong will run in
	 */
	public Pong(JFrame frame) {
		// the ball starts in the middle of the screen
		ball = new InvisibleBall(frame.getWidth() / 2 - 5, frame.getHeight() / 2 - 5, 10);
		// the paddles start in the middle on opposite sides
		leftPaddle = new Paddle(10, frame.getHeight() / 2 - 50, 10, 100);
		rightPaddle = new Paddle(frame.getWidth() - 40, frame.getHeight() / 2, 10, 100);
		
		// get borders
		borders = Wall.getBorders(frame.getWidth(), frame.getHeight());
		// all 4 keys that we care about start not pressed
		keys = new boolean[4];
		// both players start with no points
		leftScore = 0;
		rightScore = 0;
		
		// initialize the score message
		scoreMessage = new JLabel("<html>rightScore: 0<br>leftScore: 0</html>");
		scoreMessage.setBounds(frame.getWidth() / 2 - 50, (frame.getHeight() * 3) / 4, 100, 100);
		scoreMessage.setAlignmentX(CENTER_ALIGNMENT);
		scoreMessage.setVisible(true);
		frame.add(scoreMessage);
		
		// make the game visible
		setBackground(Color.WHITE);
		setVisible(true);
		
		// start the game's thread, it should listen for keys being pressed
		new Thread(this).start();
		addKeyListener(this);
	}

	/**
	 * Any updates should just paint
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

		// draw ball, paddles, and walls
		ball.moveAndDraw(graphToBack);
		leftPaddle.draw(graphToBack);
		rightPaddle.draw(graphToBack);
		for (Wall wall : borders) wall.draw(graphToBack);
		
		// check for any collisions
		checkCollisions(graphToBack);
		
		// see if the paddles need to be moved
		if (keys[0]) leftPaddle.moveUpAndDraw(graphToBack);
		else if (keys[1]) leftPaddle.moveDownAndDraw(graphToBack);
		
		if (keys[2]) rightPaddle.moveUpAndDraw(graphToBack);
		else if (keys[3]) rightPaddle.moveDownAndDraw(graphToBack);
		
		// draw the screen again
		twoDGraph.drawImage(back, null, 0, 0);
	}
	
	/**
	 * Resets the ball's location to the middle
	 * @param window the window to draw the ball in
	 */
	private void resetBall(Graphics window) {
		ball.teleport(getWidth() / 2 - 5, getHeight() / 2 - 5, window);
	}
	
	/**
	 * Checks for any important collisions
	 * @param window the window that should be drawn in
	 */
	private void checkCollisions(Graphics window) {
		// if the ball collided with the left wall
		if (ball.didCollideLeft(borders[0])) {
			// update the right-side player's score
			rightScore++;
			scoreMessage.setText("<html>rightScore: " + rightScore + "<br>leftScore: " + leftScore + "</html>");
			
			// reset the ball's location
			resetBall(window);
		}
		
		// if the ball collided with the right wall
		if (ball.didCollideRight(borders[2])) {
			// update the left-side player's score
			leftScore++;
			scoreMessage.setText("<html>rightScore: " + rightScore + "<br>leftScore: " + leftScore + "</html>");
			
			// reset the ball's location
			resetBall(window);
		}
		
		// if the ball collided with the floor or ceiling
		if (ball.didCollideTop(borders[1]) || ball.didCollideBottom(borders[3]))
			// flip the sign of its y-speed
			ball.flipYSpeed();
		
		// if the ball collided with the top or bottom of either paddle
		if (ball.didCollideBottom(leftPaddle) || ball.didCollideTop(leftPaddle) || 
				ball.didCollideBottom(rightPaddle) || ball.didCollideTop(rightPaddle))
			// flip the sign of its y-speed
			ball.flipYSpeed();
		
		// if the ball collided with the side of either paddle
		if (ball.didCollideLeft(leftPaddle) || ball.didCollideRight(rightPaddle))
			// flip the sign of its x-speed
			ball.flipXSpeed();
	}
	
	public void keyPressed(KeyEvent e) {
		// check the upper-case form of the pressed key
		switch (toUpperCase(e.getKeyChar())) {
		// set the proper spot in the keys array to true
		// since that key is currently pressed
		case 'W':
			keys[0] = true;
			break;
		case 'Z':
			keys[1] = true;
			break;
		case 'I':
			keys[2] = true;
			break;
		case 'M':
			keys[3] = true;
			break;
		}
	}

	public void keyReleased(KeyEvent e) {
		// check the upper-case from of the released key
		switch (toUpperCase(e.getKeyChar())) {
		// set the proper spot in the keys array to false
		// since that key is not currently pressed
		case 'W':
			keys[0] = false;
			break;
		case 'Z':
			keys[1] = false;
			break;
		case 'I':
			keys[2] = false;
			break;
		case 'M':
			keys[3] = false;
			break;
		}
	}

	/**
	 * Ignore keyTyped events
	 */
	public void keyTyped(KeyEvent e) {}

	public void run() {
		try {
			while (true) {
				// wait 8 ms between frames
				Thread.sleep(8);
				repaint();
			}
		}
		catch (Exception e) {}
	}
}