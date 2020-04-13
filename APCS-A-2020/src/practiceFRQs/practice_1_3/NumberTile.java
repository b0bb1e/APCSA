package practiceFRQs.practice_1_3;

public class NumberTile {
	private int[] sides;
	
	public void rotate() {
		int temp = sides[3];
		for (int i = 3; i > 0; i--) {
			sides[i] = sides[i - 1];
		}
		sides[0] = temp;
	}
	
	public int getLeft() {return sides[3];}
	
	public int getRight() {return sides[1];}
}