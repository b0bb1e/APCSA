package blocks;

/**
 * A User which knows its name and scores
 * @author faith
 */
public class User {
	/**
	 * an identifying name of the User
	 */
	private final String name;
	/**
	 * the minimum (best) scores achieved for each Level
	 */
	private int[] minLevelScores;
	/**
	 * the minimum (best) overall score
	 */
	private int minScore;
	
	/**
	 * a constant indicating a lack of score
	 */
	public static final int NO_SCORE = -1;
	
	/**
	 * Assumes a User has no scores
	 * @param name the name of the User
	 */
	public User(String name) {
		// save name
		this.name = name;
		
		// fill minLevelScores array with NO_SCORE
		minLevelScores = new int[LevelCenter.numLevels];
		for (int i = 0; i < minLevelScores.length; ++i)
			minLevelScores[i] = NO_SCORE;
		// note a lack of an overall score
		minScore = NO_SCORE;
	}
	
	/**
	 * Assumes a User has some level scores but no overall score
	 * @param name the name of the User
	 * @param minLevelScores the minimum (best) scores achieved for each Level
	 */
	public User(String name, int[] minLevelScores) {
		// save name and minimum level scores
		this.name = name;
		this.minLevelScores = minLevelScores;
		// note the lack of an overall score
		minScore = NO_SCORE;
	}
	
	/**
	 * Assumes a User has level scores and an overall score
	 * @param name the name of the User
	 * @param minLevelScores the minimum (best) scores achieved for each Level
	 * @param minScore the minimum (best) overal score
	 */
	public User(String name, int[] minLevelScores, int minScore) {
		// save all
		this.name = name;
		this.minLevelScores = minLevelScores;
		this.minScore = minScore;
	}

	/**
	 * @return the name of this User
	 */
	public String getName() {return name;}
	
	/**
	 * @param level the 1-indexed level number to get the score of
	 * @return the minimum score achieved for that level
	 */
	public int getMinLevelScore(int level) {return minLevelScores[level - 1];}
	
	/**
	 * Calculate the minimum score up to and including a level
	 * @param level a (1-indexed) level
	 * @return the sum of all minimum level scores up to and including the given level
	 */
	public int getMinScoreUpTo(int level) {
		// if not all levels before have been completed
		if (lastCompletedLevel() < level) 
			// throw an exception
			throw new IllegalArgumentException("No score for that level yet");
		
		// add up all necessary scores
		int score = 0;
		for (int i = 0; i < level; ++i) score += minLevelScores[i];
		
		return score;
	}

	/**
	 * Determines the last level completed
	 * @return the 1-indexed number of the last level with a score
	 */
	public int lastCompletedLevel() {
		// loop over all saved level scores
		for (int i = 0; i < minLevelScores.length; ++i)
			// if this 0-index score does not exist, return it
			// as the 1-indexed level completed before it
			if (minLevelScores[i] == NO_SCORE) return i;
		
		// if all levels have scores, return the last one
		return LevelCenter.numLevels;
	}

	/**
	 * @return the minimum overall score
	 */
	public int getMinScore() {return minScore;}
	
	/**
	 * Sets a minimum level score if it beats the previous one
	 * @param level the level to set the score of
	 * @param score the score to set
	 */
	public void setMinLevelScore(int level, int score) {
		// if this level has no score or a higher score
		if (minLevelScores[level - 1] == NO_SCORE || 
				minLevelScores[level - 1] > score)
			// set the new score
			minLevelScores[level - 1] = score;
	}
	
	/**
	 * Sets a minimum overall score if its beats the previous one
	 * @param score the score to set
	 */
	public void setMinScore(int score) {
		// if there is no score or a higher score
		if (minScore == NO_SCORE || minScore > score)
			// set the new score
			minScore = score;
	}
	
	public String toString() {
		// start with class identifier and name
		String ret = "User\n" + name;
		// if there is a cumulative score, add it in
		if (minScore != NO_SCORE) ret += " cumulative score = " + minScore;
		// newline
		ret += "\n";
		// for each level score
		for (int i = 0; i < minLevelScores.length; ++i) {
			// if it doesn't exist, add level # & N/A
			if (minLevelScores[i] == NO_SCORE) ret += " level " + (i + 1) + " score = N/A";
			// if it does, add level # & score
			else ret += " level " + (i + 1) + " score = " + minLevelScores[i];
		}
		
		return ret;
	}
}