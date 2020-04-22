package practiceFRQs.practice_2_3;

import java.util.ArrayList;

public class Stats {
	private ArrayList<ScoreInfo> scoreList;
	
	public boolean record(int score) {
		for (int i = 0; i < scoreList.size(); i++) {
			if (scoreList.get(i).getScore() == score) {
				scoreList.get(i).increment();
				return false;
			}
			else if (scoreList.get(i).getScore() > score) {
				scoreList.add(i, new ScoreInfo(score));
				return true;
			}
		}
		scoreList.add(new ScoreInfo(score));
		return true;
	}
	
	public void recordScores(int[] stuScores) {
		for (int score : stuScores) record(score);
	}
}