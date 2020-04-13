package practiceFRQs.practice_1_1;

public class Main {
	public static int[] getCubeTosses(NumberCube cube, int numTosses) {
		int[] tosses = new int[numTosses];
		for (int i = 0; i < numTosses; i++) tosses[i] = cube.toss();
		return tosses;
	}
	
	public static int getLongestRun(int[] values) {
		int start = 0;
		int maxLen = 1;
		int curRun = values[0];
		for (int i = 1; i < values.length; i++) {
			if (values[i] != curRun) {
				if (i - start > maxLen) maxLen = i - start;
				curRun = values[i];
				start = i;
			}
		}
		if (maxLen == 1) return -1;
		return start;
	}
}