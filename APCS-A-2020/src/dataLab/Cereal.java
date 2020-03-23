package dataLab;

public class Cereal {
	// name of the cereal
	private String name;
	// nutrition information
	private int carbs, protein;
	
	// default constructor
	public Cereal() {
		this("My Cereal", 0, 0);
	}
	
	// basic constructor: sets name, carbs, protein
	public Cereal(String n, int c, int p) {
		name = n;
		carbs = c;
		protein = p;
	}
	
	// calculates the score
	public int score() {
		return (protein * 100 - carbs) / carbs;
	}

	// print out information about the cereal
	public String toString() {
		return name + " has " + carbs + " carbs and " + protein + " protein";
	}
}
