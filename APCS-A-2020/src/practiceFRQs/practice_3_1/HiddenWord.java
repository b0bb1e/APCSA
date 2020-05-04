package practiceFRQs.practice_3_1;

public class HiddenWord {
	private String word;
	
	public HiddenWord(String word) {
		this.word = word;
	}
	
	public String getHint(String guess) {
		char[] hint = new char[word.length()];
		for (int i = 0; i < guess.length(); ++i) {
			if (word.charAt(i) == guess.charAt(i)) hint[i] = guess.charAt(i);
			else {
				boolean appears = false;
				for (int j = 0; j < word.length(); ++j) {
					if (word.charAt(j) == guess.charAt(i)) {
						appears = true;
						break;
					}
				}
				if (appears) hint[i] = '+';
				else hint[i] = '*';
			}
		}
		return new String(hint);
	}
}