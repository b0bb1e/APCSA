package celebrity;

public class FamousNumber extends Celebrity {

	String name;
	double[] clues;
	
	public FamousNumber(String name, String clues) {
		super(name, clues);
		processClues();
		this.name = name;
	}
	
	public void processClues() {
		String[] wordClues = super.getClue().split(",");
		clues = new double[wordClues.length];
		for (int i = 0; i < clues.length; i++) {
			clues[i] = Double.parseDouble(wordClues[i]);
		}
	}
	
	public String getClue() {
		return clues[(int) (Math.random() * clues.length)] + "";
	}
	
	public String toString() {
		String ret = "This is the famous number " + name + ", and it has the number clues ";
		for (double c : clues) ret += c + ", ";
		return ret.substring(ret.length() - 2) + ". Any questions?";
	}
}
