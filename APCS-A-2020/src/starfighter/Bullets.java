package starfighter;

//(c) A+ Computer Science
//www.apluscompsci.com
//Name - Faith Okamoto

// for drawing things
import java.awt.Graphics;
// for arrays that can change size
import java.util.ArrayList;

/**
 * A group of Ammo that move together
 * @author faith
 */
public class Bullets {
	/**
	 * the Ammos
	 */
	private ArrayList<Ammo> ammo;

	/**
	 * Initializes the list of Ammos
	 */
	public Bullets() {
		ammo = new ArrayList<Ammo>();
	}

	/**
	 * Shoots from a Locatable
	 * @param shooter the object that should appear to shoot an Ammo
	 */
	public void shoot(Locatable shooter) {
		// add an Ammo from the top middle of the Locatable
		ammo.add(new Ammo(shooter.getX() + shooter.getWidth() / 2, shooter.getY(), 5));
	}

	/**
	 * Draws all the Ammos
	 * @param window the window to draw on
	 */
	public void drawEmAll(Graphics window) {
		// loop over all Ammos, drawing each one
		for (Ammo a : ammo) a.draw(window);
	}

	/**
	 * Moves all Ammos up
	 */
	public void moveEmAll() {
		// loop over all Ammos
		for (int bullet = ammo.size() - 1; bullet >= 0; --bullet) {
			// move this Ammo up
			ammo.get(bullet).move(MovingThing.UP);
			// if it is off the screen, remove it from the list
			if (ammo.get(bullet).getY() + ammo.get(bullet).getHeight() < 0) 
				ammo.remove(bullet);
		}
	}

	/**
	 * Clear all Ammos
	 */
	public void clear() {
		ammo.clear();
	}

	/**
	 * Get the List of Ammos
	 * @return this.ammo
	 */
	public ArrayList<Ammo> getList() {
		return ammo;
	}

	public String toString() {
		return ammo.toString();
	}
}