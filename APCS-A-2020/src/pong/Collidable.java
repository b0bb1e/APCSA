package pong;

//© A+ Computer Science  -  www.apluscompsci.com
//Name - Faith Okamoto

/**
 * Allows an object to check if it has collided with other objects
 * @author faith
 */
public interface Collidable {
	/**
	 * Check for a collision with an object to the left-hand side
	 * @param obj the object to check for a collision with
	 * @return whether the object has collided so
	 */
	public boolean didCollideLeft(Object obj);
	
	/**
	 * Check for a collision with an object to the right-hand side
	 * @param obj the object to check for a collision with
	 * @return whether the object has collided so
	 */
	public boolean didCollideRight(Object obj);
	
	/**
	 * Check for a collision with an object to the top side
	 * @param obj the object to check for a collision with
	 * @return whether the object has collided so
	 */
	public boolean didCollideTop(Object obj);
	
	/**
	 * Check for a collision with an object to the bottom side
	 * @param obj the object to check for a collision with
	 * @return whether the object has collided so
	 */
	public boolean didCollideBottom(Object obj);
}