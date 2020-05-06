package practiceFRQs.practice_4_2;

import java.util.ArrayList;

public class OnlinePurchaseManager {
	// purchases stores Gizmos
	private ArrayList<Gizmo> purchases;

	// point purchases at a new ArrayList
	public OnlinePurchaseManager() {
		purchases = new ArrayList<Gizmo>();
	}

	// NOT part of the sample question
	// needed in order to type up and
	// test student code
	public void add(String m, boolean e) {
		purchases.add(new Gizmo(m, e));
	}

	// Part A
	// count the number of Gizmos made by maker
	// that are also electronic
	// must call getMaker and isElectronic
	// return the count or 0 if no matches
	public int countElectronicsByMaker(String maker) {
		int count = 0;
		for (Gizmo g : purchases)
			if (g.getMaker().equals(maker) && g.isElectronic()) ++count;
		
		return count;
	}

	// Part B
	// loop thought the list and check for matching adjacent pairs
	// return true of any adjacent [ side by side ] pairs are the same
	// to be the same the pairs must have the same maker and
	// be either electronic or non-electronic
	// you really really should use the equals method from Gizmo
	public boolean hasAdjacentEqualPair() {
		for (int i = 0; i < purchases.size() - 1; ++i)
			if (purchases.get(i).equals(purchases.get(i + 1)))
				return true;
		return false;
	}

	// NOT part of the sample question
	// needed in order to type up and
	// test student code
	public String toString() {
		return "" + purchases;
	}
}

/*
 * Part C
 * 
 * OPEN-ENDED SECTION
 * 
 * A programmer would like to add a method getCheapestGizmoByMaker, which
 * returns the least expensive Gizmo purchased by an individual from a given
 * maker.
 * 
 * Write a description of how you would change the Gizmo and
 * OnlinePurchaseManager classes in order to support this modification.
 * 
 * Make sure to include the following in your response.
 * 
 * • Write the method header for the getCheapestGizmoByMaker method. DO write
 * code for this part.
 * 
 * • Identify any new or modified variables, constants, constructors, or methods
 * aside from the getCheapestGizmoByMaker method. DO NOT write code for this
 * part.
 * 
 * • Describe, for each new or revised variable, constant, constructor, or
 * method, how it would change or be implemented, including visibility and type.
 * You do not need to describe the getCheapestGizmoByMaker method. DO NOT write
 * code for this part.
 * 
 * 
 * public Gizmo getCheapestGizmoByMaker(String maker) {
 * 		Gizmo cheap = null;
 * 		for (Gizmo g : purchases) 
 * 			if (g.getMaker().equals(maker) &&
 * 				(cheap == null || g.getPrice() < cheap.getPrice())
 * 				cheap = g;
 * 		return cheap;
 * }
 * 
 * I would add a private int instance variable to Gizmo called price. The Gizmo constructor would change to
 * have an addition int argument called p, and in the constructor price would be set to p. I would add a get
 * method for price, getPrice(), which would return the value of price. Gizmo's equals method would add
 * "&& price == g.getPrice()" to the return statement, and Gizmo's toString method would add '" $" + price'
 * to the return statement. The OnlinePurchaseManager's add method would add an additional int argument
 * called p, which would be passed to the added Gizmo's constructor. Additionally, the above 
 * getCheapestGizmoByMaker method would be added.
 */
