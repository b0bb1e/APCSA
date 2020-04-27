package pong;

//(c) A+ Computer Science
//www.apluscompsci.com
//Name - Faith Okamoto

/**
 * Allows an object to have location in x-y coordinates
 * @author faith
 */
public interface Locatable {
	// Setters
	
	/**
	 * Setter for the x-coordinate
	 * @param x the new x-coordinate
	 */
    public void setX(int x);
    /**
     * Setter for the y-coordinate
     * @param y the new y-coordinate
     */
    public void setY(int y);
    /**
     * Setter for the overall position
     * @param x the new x-coordinate
     * @param y the new y-coordinate
     */
    public void setPos(int x, int y);

    // Getters
    
    /**
     * Getter for the x-coordinate
     * @return the x-coordinate's value
     */
    public int getX();
    /**
     * Getter for the y-coordinate
     * @return the y-coordinate's value
     */
    public int getY();
}