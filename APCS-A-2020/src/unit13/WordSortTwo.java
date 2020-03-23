package unit13;
//(c) A+ Computer Science
//www.apluscompsci.com
//Name - Faith Okamoto

public class WordSortTwo {
	/**
	 * the words in the sentence
	 */
	private String[] wordRay;

	/**
	 * Constructor: initialize <code>wordRay</h1>
	 * @param sentence the sentence to pull words from
	 */
	public WordSortTwo(String sentence) {
		// the sentence should be split by spaces
		wordRay = sentence.split(" ");
	}

	/**
	 * Sort <code>wordRay</code> by dictionary order
	 */
	public void sort()
	{
		// loop over all words but first (already sorted)
		for (int i = 1; i < wordRay.length; i++) {
			// save the index being checked (starts as the one right before this)
			int beforeIndex = i - 1;
			// while the element in index being checked should go after the current one
			while (beforeIndex > - 1 && wordRay[i].compareTo(wordRay[beforeIndex]) < 0)
				// move the index being checked forward
				beforeIndex--;
			
			// save the element that is currently being sorted
			String temp = wordRay[i];
			// looping over all elements that have to be shifted back, shift back
			for (int j = i - 1; j > beforeIndex; j--) wordRay[j + 1] = wordRay[j];
			// put the current element in its proper index
			wordRay[beforeIndex + 1] = temp;
		}
	}

	/**
	 * Gives information about the <code>wordRay</code>
	 */
	public String toString()
	{
		// initialize the output
		String output = "";
		// add each word on its own line
		for (String word : wordRay) output += word + "\n";
		// extra newlines for spacing
		return output + "\n\n";
	}
}