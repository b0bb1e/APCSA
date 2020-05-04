package practiceFRQs.practice_3_2;

public class Range implements NumberGroup {
	private int min;
	private int max;
	
	public Range(int min, int max) {
		this.min = min;
		this.max = max;
	}
	
	public boolean contains(int num) {
		return num >= min && num <= max;
	}
}