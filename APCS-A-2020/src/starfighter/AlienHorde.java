package starfighter;

//(c) A+ Computer Science
//www.apluscompsci.com
//Name - Faith Okamoto

// for drawing on things
import java.awt.Graphics;
// for arrays that can change size
import java.util.ArrayList;

/**
 * A group of Aliens which move together
 * @author faith
 */
public class AlienHorde {
	/**
	 * a matrix of Aliens, sorted into distinct rows
	 */
	private ArrayList<ArrayList<Alien>> aliens;
	/**
	 * saves whether each row of Aliens is moving left or right
	 */
	private ArrayList<Boolean> movingLeft;
	
	/**
	 * the x-coordinate spacing between adjacent Aliens
	 */
	public static final int X_SPACING = 50;
	/**
	 * the y-coordinate spacing between adjacent rows of Aliens
	 */
	public static final int Y_SPACING = 50;
	/**
	 * the chance that when moving down the screen a row of Aliens will speed up 1
	 */
	public static final double SPEED_UP_CHANCE = 0.4;

	/**
	 * Initializes the matrix of Aliens
	 * @param rows the number of rows of Aliens
	 * @param width the width of the screen to display on
	 */
	public AlienHorde(int rows, int width) {
		// initialize matrix
		aliens = new ArrayList<ArrayList<Alien>>(rows);
		// initialize left-moving list
		movingLeft = new ArrayList<Boolean>(rows);
		
		// loop for each row needed
		for (int row = 0; row < rows; ++row) {
			// add a row to the aliens matrix
			aliens.add(new ArrayList<Alien>());
			// note that this row is not moving left
			movingLeft.add(false);
			
			// assume that this row is starting at x=10
			int x = 10;
			// if this is an odd row, shift starting x forward to stagger
			if (row % 2 == 1) x += X_SPACING / 2;
			// loop over x-values, spaced by X_SPACING, until half the screen is gone
			for (; x < width / 2; x += X_SPACING)
				// add an alien in this position
				add(new Alien(x, row * Y_SPACING + 10, 25, 25, 1), row);
			
		}
	}

	/**
	 * Adds an Alien to the specified row in the matrix
	 * @param alien the alien to add
	 * @param row the row in the matrix to add it to
	 */
	public void add(Alien alien, int row) { aliens.get(row).add(alien); }

	/**
	 * Draws all of the Aliens
	 * @param window the window to draw on
	 */
	public void drawEmAll(Graphics window) {
		// loop over all rows of the matrix
		for (ArrayList<Alien> row : aliens)
			// loop over all aliens in the row, and draw them
			for (Alien alien : row) alien.draw(window);
	}

	/**
	 * Moves all Aliens
	 * @param width the width of the screen
	 */
	public void moveEmAll(int width) {
		// loop over all rows of the matrix
		for (int row = 0; row < aliens.size(); ++row) {
			// if this row is moving left
			if (movingLeft.get(row)) {
				// its end-Alien is the first one
				Alien end = aliens.get(row).get(0);
				
				// if the end-Alien would go off-screen with a move
				if (end.getX() - end.getSpeed() < 0) {
					// change this row's direction
					movingLeft.set(row, false);
					
					// loop over all Aliens in the row
					for (Alien alien : aliens.get(row)) {
						// move this Alien down
						alien.move(MovingThing.DOWN);
						// if speed < 5 and it is a random speed-up
						if (alien.getSpeed() < 5 && Math.random() < SPEED_UP_CHANCE) 
							// speed up this Alien
							alien.setSpeed(alien.getSpeed() + 1);
					}
				}
				// otherwise, loop over all Aliens and move them left
				else for (Alien alien : aliens.get(row)) alien.move(MovingThing.LEFT);
			}
			
			// or if this row is moving right
			else {
				// its end-Alien is the last one
				Alien end = aliens.get(row).get(aliens.get(row).size() - 1);
				
				// if the end-Alien would go off-screen with a move
				if (end.getX() + end.getWidth() + end.getSpeed() > width) {
					// change this row's direction
					movingLeft.set(row, true);
					
					// loop over all Aliens in the row
					for (Alien alien : aliens.get(row)) {
						// move this Alien down
						alien.move(MovingThing.DOWN);
						// if speed < 5 and it is a random speed-up
						if (alien.getSpeed() < 5 && Math.random() < SPEED_UP_CHANCE) 
							// speed up this Alien
							alien.setSpeed(alien.getSpeed() + 1);
					}
				}
				// otherwise, loop over all Aliens and move them right
				else for (Alien alien : aliens.get(row)) alien.move(MovingThing.RIGHT);
			}
		}
	}

	/**
	 * Removes Aliens hit my shots
	 * @param shots all shots currently fired
	 * @return the number of Aliens removed
	 */
	public int removeDeadOnes(ArrayList<Ammo> shots) {
		// initialize return variable
		int removed = 0;
		
		// loop over all rows of the matrix
		for (int row = aliens.size() - 1; row >= 0; --row) {
			// loop over all Aliens in this row
			for (int alien = aliens.get(row).size() - 1; alien >= 0; --alien)
				// loop over all Ammos being shot
				for (int shot = shots.size() - 1; shot >= 0; --shot)
					// if this Alien has collided with this Ammo
					if (aliens.get(row).get(alien).checkCollision(shots.get(shot))) {
						// remove the Alien and the shot, incrementing the removed-count
						aliens.get(row).remove(alien);
						shots.remove(shot);
						++removed;
						// no more shots need to be checked for this Alien
						break;
					}
			
			// if all Aliens in this row died
			if (aliens.get(row).isEmpty()) {
				// removed the row and its moving-left noter
				aliens.remove(row);
				movingLeft.remove(row);
			}
		}

		return removed;
	}

	/**
	 * Check for a collision by any Alien in the matrix
	 * @param obj the object with a possible collision
	 * @return whether any Alien collided with obj
	 */
	public boolean checkCollision(Locatable obj) {
		// loop over all rows in the matrix, and all Aliens in the row
		for (ArrayList<Alien> row : aliens) for (Alien alien : row)
			// if this Alien collided with the object, return so
			if (alien.checkCollision(obj)) return true;
		
		// if nothing triggered, return so
		return false;
	}
	
	/**
	 * Checks if any Aliens are left
	 * @return !aliens.isEmpty()
	 */
	public boolean aliensLeft() {return !aliens.isEmpty(); }
	
	/**
	 * Clears all Aliens
	 */
	public void clear() {aliens.clear();}

	public String toString() {
		// note the class at the beginning
		String ret = "Alien Horde\n";
		
		// loop over all rows in the matrix
		for (int row = 0; row < aliens.size(); ++row) {
			// add each Alien in this row to the toString
			for (Alien a : aliens.get(row)) ret += "Alien (" + a.toString() + ") ";
			// note whether this row is currently moving left
			ret += "moving left = " + movingLeft.get(row) + "\n";
		}
		return ret;
	}
}
