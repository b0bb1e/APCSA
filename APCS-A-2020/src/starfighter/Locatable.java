package starfighter;

//© A+ Computer Science  -  www.apluscompsci.com
//Name - Faith Okamoto

/**
 * Methods for an object with location and size
 * @author faith
 */
public interface Locatable {
	/**
	 * Get x-coordinate
	 * @return the x-coordinate
	 */
	public int getX();

	/**
	 * Get y-coordinate
	 * @return the y-coordinate
	 */
	public int getY();
	
	/**
	 * Get width
	 * @return the width in coordinates
	 */
	public int getWidth();
	
	/**
	 * Get height
	 * @return the height in coordinates
	 */
	public int getHeight();
}