package pong;

//(c) A+ Computer Science
//www.apluscompsci.com
//Name - Faith Okamoto

// for graphics
import java.awt.Color;

/**
 * Basic tester for Ball's constructors, toString, and equals methods
 * @author faith
 */
class BallTestOne {
	/**
	 * Creates some Balls for testing purposes
	 * @param args not used
	 */
	public static void main(String args[]) {
		// make a bunch of Balls and print them
		
		Ball one = new Ball();
		System.out.println(one);

		Ball two = new Ball(100, 90);
		System.out.println(two);

		Ball three = new Ball(100, 100, 30);
		System.out.println(three);

		Ball four = new Ball(100, 100, 30, Color.BLUE);
		System.out.println(four);

		Ball five = new Ball(100, 100, 30, Color.BLUE, 5, 6);
		System.out.println(five);

		Ball six = new Ball(100, 100, 30, Color.blue, 5, 6);
		System.out.println(six);

		// compare Balls to each other
		
		System.out.println(five.equals(four));

		System.out.println(five.equals(five));
	}
}