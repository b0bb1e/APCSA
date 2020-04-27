package pong;

//(c) A+ Computer Science
//www.apluscompsci.com
//Name - Faith Okamoto

// for graphics
import java.awt.Color;

/**
 * Simple tester for Paddle's constructors, toString, and equals methods
 * @author faith
 */
class PaddleTestOne {
	/**
	 * Creates some Paddles for testing purposes
	 * @param args not used
	 */
	public static void main(String args[]) {
		// make a bunch of Paddles and print them
		
		Paddle one = new Paddle();
		System.out.println(one);

		Paddle two = new Paddle(100, 90);
		System.out.println(two);

		Paddle three = new Paddle(100, 100, 30);
		System.out.println(three);

		Paddle four = new Paddle(100, 100, 30, 50, 8);
		System.out.println(four);

		Paddle five = new Paddle(100, 100, 30, 20, Color.GREEN, 6);
		System.out.println(five);

		// compare paddles to each other
		
		System.out.println(five.equals(four));
		System.out.println(five.equals(five));
	}
}