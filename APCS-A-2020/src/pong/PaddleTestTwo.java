package pong;

//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

// for graphics
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Canvas;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import static java.lang.Character.*;

/**
 * Basic tester for Paddle's movement methods
 * @author faith
 */
@SuppressWarnings("serial")
public class PaddleTestTwo extends Canvas implements KeyListener, Runnable {
	/**
	 * a Ball to bounce around
	 */
	private Ball ball;
	/**
	 * a Paddle on the left
	 */
	private Paddle leftPaddle;
	/**
	 * a Paddle on the right
	 */
	private Paddle rightPaddle;
	/**
	 * the keys currently pressed
	 */
	private boolean[] keys;

	/**
	 * Constructor
	 * <br>
	 * Initializes everything
	 */
	public PaddleTestTwo() {
		ball = new Ball();
		leftPaddle = new Paddle(10, 50);
		rightPaddle = new Paddle(100, 50);
		keys = new boolean[5];

		setBackground(Color.WHITE);
		setVisible(true);

		this.addKeyListener(this);
		new Thread(this).start();
	}

	public void update(Graphics window) {
		paint(window);
	}

	public void paint(Graphics window) {
		// draw the Paddles
		ball.moveAndDraw(window);
		leftPaddle.draw(window);
		rightPaddle.draw(window);

		// check for bouncing off the side walls
		if (ball.getX() < 10 || ball.getX() > 550)
			// if so, flip the x-speed
			ball.flipXSpeed();
		
		// check for bouncing off the floor and ceiling
		if (ball.getY() < 10 || ball.getY() > 450)
			// if so, flip the y-speed
			ball.flipYSpeed();
		
		// move paddles as determined by keys
		
		if (keys[0] == true)
			leftPaddle.moveUpAndDraw(window);
		else if (keys[1] == true)
			leftPaddle.moveDownAndDraw(window);
		
		if (keys[2] == true)
			rightPaddle.moveUpAndDraw(window);
		else if (keys[3] == true)
			rightPaddle.moveDownAndDraw(window);
		
	}

	public void keyPressed(KeyEvent e) {
		// get the key pressed
		switch (toUpperCase(e.getKeyChar())) {
		// set the proper spot in the array
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
		// get the key pressed
		switch (toUpperCase(e.getKeyChar())) {
		// set the proper spot in the array
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

	public void keyTyped(KeyEvent e) {}

	public void run() {
		try {
			while (true) {
				// keep waiting, then painting
				Thread.sleep(8);
				repaint();
			}
		}
		catch (Exception e) {}
	}
}