package starfighter;

//(c) A+ Computer Science
//www.apluscompsci.com
//Name - Faith Okamoto

/**
 * Basic tester for the Ship class
 * @author faith
 */
public class Shiptest {
	/**
	 * Runs some Ship code
	 * @param args not used
	 */
	public static void main(String args[]) {
		// instantiate some Ships and call methods on them
		MovingThing test = new Ship();
		System.out.println("Ship 1 " + test);

		Ship test2 = new Ship(50, 75);
		System.out.println("Ship 2 " + test2);

		Ship test3 = new Ship(7, 7, 6, 5, 1);
		test3.setX(3);
		test3.setY(5);
		System.out.println("Ship 3 " + test3);
	}
}