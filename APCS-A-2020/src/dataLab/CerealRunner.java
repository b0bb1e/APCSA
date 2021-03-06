package dataLab;

public class CerealRunner {
	public static void main(String[] args) {
		// the data from the table in parallel arrays
		String[] names = new String[] {"100% Bran", "100% Natural Bran",
				"All-Bran", "All-Bran with Extra Fiber", "Almond Delight",
				"Apple Cinnamon Cheerios", "Apple Jacks", "Basic 4",
				"Bran Chex", "Bran Flakes", "Cap'n Crunch", "Cheerios",
				"Cinnamon Toast Crunch", "Clusters", "Cocoa Puffs",
				"Corn Chex", "Corn Flakes", "Corn Pops", "Count Chocola",
				"Cracklin' Oat Bran", "Cream of Wheat (Quick)"};
		int[] carbs = new int[] {70, 120, 70, 50, 110, 110, 110, 130, 90,
				90, 120, 110, 120, 110, 110, 110, 100, 110, 110, 110, 100};
		int[] protein = new int[] {4, 3, 4, 4, 2, 2, 2, 3, 2, 3, 1, 6, 1,
				3, 1, 2, 2, 1, 1, 3, 3};
		
		// initialize an array of Cereals, and populate it using the data
		Cereal[] cereals = new Cereal[names.length];
		for (int i = 0; i < names.length; i++)
			cereals[i] = new Cereal(names[i], carbs[i], protein[i]);
		
		// the maximum score so far
		int max = 0;
		// the best cereal so far
		Cereal bestCereal = null;
		// loop over all cereals
		for (Cereal c : cereals) {
			// save this cereal's score
			int score = c.score();
			// if it's the best ever
			if (score > max) {
				// set the max score and best cereal to this one
				max = score;
				bestCereal = c;
			}
		}
		
		// print out the best cereal
		System.out.println(bestCereal + ",\nand is the best cereal for a low-carb, high-protein diet");
	}
}
