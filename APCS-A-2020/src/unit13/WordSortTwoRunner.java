package unit13;
//(c) A+ Computer Science
//www.apluscompsci.com
//Name - Faith Okamoto

// for reading from the file
import java.util.Scanner;
import java.io.File;
import java.io.IOException;

public class WordSortTwoRunner {
	public static void main(String args[]) throws IOException {
		// get a Scanner for the file
		Scanner file = new Scanner(new File("src/unit13/wordsorttwo.dat"));
		// read how many sentences are in this file
		int size = file.nextInt();
		// moving on to the sentences
		file.nextLine();
		
		// loop over each sentence
		for(int i = 0; i < size; i++) {
			// read in the sentence into a new WordSort
			WordSortTwo run = new WordSortTwo(file.nextLine());
			// sort the words in this sentence
			run.sort();
			// print out the sentence
			System.out.println(run);
		}
		
		// clean up
		file.close();
	}
}