package dataLab;

public class Cereal {
	private String name;
	private int carbs, protein;
	
	public Cereal() {
		name = "My Cereal";
		carbs = 0;
		protein = 0;
	}
	
	public Cereal(String n, int c, int p) {
		name = n;
		carbs = c;
		protein = p;
	}
	
	public int score() {
		return (protein * 100 - carbs) / carbs;
	}

	public int getCarbs() {return carbs;}

	public int getProtein() {return protein;}
	
	public String getName() {return name;}

	public void setCarbs(int c) {carbs = c;}

	public void setProtein(int p) {protein = p;}
	
	public void setName(String n) {name = n;}
	
	public String toString() {
		return name + " has " + carbs + " carbs and " + protein + " protein";
	}
}
