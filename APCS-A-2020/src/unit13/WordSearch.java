package unit13;
//(c) A+ Computer Science
//www.apluscompsci.com
//Name - Faith Okamoto

public class WordSearch
{
	/*
	 * The word search matrix of letters (which I think should be chars)
	 */
    private String[][] m;

    /**
     * Constructor: builds the matrix from a string
     * @param size the side length of the matrix
     * @param str all the letters of the matrix concatenated
     */
    public WordSearch(int size, String str) {
    	// initialize the matrix to the proper size
    	m = new String[size][size];
    	// loop over all letters required, putting into proper slot in matrix
    	for (int i = 0; i < size * size; i++) m[i / size][i % size] = str.charAt(i) + "";
    }
    
    /**
     * Reverses a string
     * @param s the string to reverse
     * @return a string with <code>s</code>'s chars in reverse order
     */
    private String reverse(String s) {
    	// return variable (r for reverse, r for return :-])
    	String r = "";
    	// looping over all chars, add to front
    	for (char c : s.toCharArray()) r = c + r;
    	
    	return r;
    }

    /**
     * Checks if a word is in the word search matrix
     * @param word the word to look for
     * @return whether to word (in any orientation, reversed or not) is in the matrix
     */
    public boolean isFound(String word) {
    	// check all directions
    	return checkAcross(word) || checkVertical(word) || checkDiagRight(word) || checkDiagLeft(word);
    }

    /**
     * Checks if a word is in one of the word search matrix's rows
     * @param w the word to look for
     * @return whether the word appears across the matrix
     */
	public boolean checkAcross(String w) {
		// loop over all rows in the matrix
		for (String[] row : m) {
			// save the current across-string being considered
			String across = "";
			
			// loop over all letters in this row
			for (int col = 0; col < row.length; col++) {
				// add the current letter
				across += row[col];
				// if the string is too long, truncate it
				if (across.length() > w.length()) across = across.substring(1);
				// if the string is the word (even if reversed), the word has been found
				if (across.equals(w) || across.equals(reverse(w))) return true;
			}
		}
		
		// if the word was not found in any row, it cannot be found across
		return false;
	}

	/**
	 * Checks if a word is in one of the word search matrix's columns
	 * @param w the word to look for
	 * @return whether the word appears vertically in the matrix
	 */
	public boolean checkVertical(String w) {
		// loop over all columns in the matrix
		for (int col = 0; col < m[0].length; col++) {
			// save the current vertical-string
			String vert = "";
			
			// loop over all letters in the column
			for (int row = 0; row < m.length; row++) {
				// add the current letter
				vert += m[row][col];
				// if the string is too long, truncate it
				if (vert.length() > w.length()) vert = vert.substring(1);
				// if the string is the word (even if reversed), the word has been found
				if (vert.equals(w) || vert.equals(reverse(w))) return true;
			}
		}
		
		// if the word was not found in any column, it cannot be found vertically
		return false;
	}

	/**
	 * Checks if a word is in one of the word search matrix's down-right diagonals
	 * @param w the word to look for
	 * @return whether the word appears down-right diagonally in the matrix
	 */
	public boolean checkDiagRight(String w) {
		// loop over all starting columns on the top
		for (int col = 0; col < m[0].length; col++) {
			// save the current diagonal-string
			String diag = "";
			
			// loop over all letters down diagonally
			for (int row = 0; row < m.length - col; row++) {
				// add the current letter 
				diag += m[row][col + row];
				// if the string is too long, truncate it
				if (diag.length() > w.length()) diag = diag.substring(1);
				// if the string is the word (even if reversed), the word has been found
				if (diag.equals(w) || diag.equals(reverse(w))) return true;
			}
		}
		
		// loop over all starting rows on the side
		for (int row = 1; row < m.length; row++) {
			// save the current diagonal-string
			String diag = "";
			
			// loop over all letters down diagonally
			for (int col = 0; col < m[0].length - row; col++) {
				// add the current letter
				diag += m[row + col][col];
				// if the string is too long, truncate it
				if (diag.length() > w.length()) diag = diag.substring(1);
				// if the string is the word (even if reversed), the word has been found
				if (diag.equals(w) || diag.equals(reverse(w))) return true;
			}
		}
		
		// if the word was not found in any of the down-right diagonals, then it is not there
		return false;
	}

	/**
	 * Checks if a word is in one of the word search matrix's down-left diagonals
	 * @param w the word to look for
	 * @return whether the word appears down-left diagonally in the matrix
	 */
	public boolean checkDiagLeft(String w) {
		// loop over all starting columns
		for (int col = 0; col < m[0].length; col++) {
			// save the current diagonal-string
			String diag = "";
			
			// loop over all letters down diagonally
			for (int row = 0; row <= m.length - (m[0].length - col); row++) {
				// add the current letter
				diag += m[row][col - row];
				// if the string is too long, truncate it
				if (diag.length() > w.length()) diag = diag.substring(1);
				// if the string is the word (even if reversed), the word has been found
				if (diag.equals(w) || diag.equals(reverse(w))) return true;
			}
		}
		
		// loop over all starting rows on the side
		for (int row = 1; row < m.length; row++) {
			// save the current diagonal-string
			String diag = "";
			
			// loop over all letters down diagonally
			for (int col = 0; col < m[0].length - row; col++) {
				// add the current letter
				diag += m[row + col][m[0].length - col - 1];
				// if the string is too long, truncate it
				if (diag.length() > w.length()) diag = diag.substring(1);
				// if the string is the word (even if reversed), the word has been found
				if (diag.equals(w) || diag.equals(reverse(w))) return true;
			}
		}
		
		// if none of the down-left diagonals checked had the word, it is not there
		return false;
	}

	/**
	 * Gives the word search matrix, properly formatted
	 */
	@Override
    public String toString() {
		// initialize the output to the empty string
    	String output = "";
    	// loop over all rows in the matrix
    	for (String[] row : m) {
    		// loop over all letters in the row, print out with space
    		for (String let : row) output += let + " ";
    		// newline for next row
    		output += "\n";
    	}
    	
 		return output;
    }
}
