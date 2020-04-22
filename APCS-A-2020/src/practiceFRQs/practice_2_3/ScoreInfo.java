package practiceFRQs.practice_2_3;

public class ScoreInfo {
	private int score;
	private int numStudents;
	
	public ScoreInfo(int aScore) {
		score = aScore;
		numStudents = 1;
	}
	
	public void increment() {numStudents++;}
	
	public int getScore() {return score;}
	
	public int getFrequency() {return numStudents;}
}