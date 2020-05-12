package starfighter;

//(c) A+ Computer Science
//www.apluscompsci.com
//Name - Faith Okamoto

/**
 * Methods for an object with location, size, and movement
 * @author faith
 */
public interface Moveable extends Locatable {
	/**
	 * Set x and y coordinates
	 * @param x the new x-coordinate
	 * @param y the new y-coordinate
	 */
	public void setPos(int x, int y);

	/**
	 * Set x-coordinate
	 * @param x the new x-coordinate
	 */
	public void setX(int x);
	
	/**
	 * Set y-coordinate
	 * @param y the new y-coordinate
	 */
	public void setY(int y);
	
	/**
	 * Set speed
	 * @param s the new speed in coordinates
	 */
	public void setSpeed(int s);

	/**
	 * Get speed
	 * @return the speed in coordinates
	 */
	public int getSpeed();
}