package pong;

//(c) A+ Computer Science
//www.apluscompsci.com
//Name - Faith Okamoto

// for graphics
import java.awt.Color;

/**
 * Basic tester for Block's constructors, toString, and equals methods
 * @author faith
 *
 */
class BlockTestOne {
	/**
	 * Creates some Blocks for testing purposes
	 * @param args not used
	 */
	public static void main(String args[]) {
		// make a bunch of Blocks and print them
		
		Block one = new Block();
		System.out.println(one);

		Block two = new Block(50, 50, 30, 30);
		System.out.println(two);

		Block three = new Block(350, 350, 15, 15, Color.RED);
		System.out.println(three);

		Block four = new Block(450, 50, 20, 60, Color.GREEN);
		System.out.println(four);

		// compare Blocks to each other
		
		System.out.println(one.equals(two));
		System.out.println(one.equals(one));
	}
}