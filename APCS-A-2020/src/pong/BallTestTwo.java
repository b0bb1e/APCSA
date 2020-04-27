package pong;

//(c) A+ Computer Science
//www.apluscompsci.com
//Name - Faith Okamoto

// for graphcis
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Canvas;

/**
 * Basic tester for Ball's movement methods
 * @author faith
 */
@SuppressWarnings("serial")
class BallTestTwo extends Canvas implements Runnable {
	/**
	 * the Ball being tested
	 */
	private Ball ball;

	/**
	 * Constructor
	 * <br>
	 * Initializes the Canvas and Ball
	 */
	public BallTestTwo() {
		setBackground(Color.WHITE);
		setVisible(true);

		ball = new Ball();

		new Thread(this).start();
	}

	public void update(Graphics window) {
		paint(window);
	}

	public void paint(Graphics window) {
		// move the Ball
		ball.moveAndDraw(window);

		// check for hitting the side walls
		if (ball.getX() < 10 || ball.getX() > 550)
			// flip x-speed if so
			ball.flipXSpeed();
		

		// check for hitting the floor and ceiling
		if (ball.getY() < 10 || ball.getY() > 450)
			// flip y-speed if so
			ball.flipYSpeed();
		
	}

	public void run() {
		try {
			while (true) {
				// keep waiting, then repainting
				Thread.sleep(19);
				repaint();
			}
		}
		catch (Exception e) {}
	}
}