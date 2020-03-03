package unit11;
//(c) A+ Computer Science
//www.apluscompsci.com
//Name - Faith Okamoto

// import for getting inputs
import java.util.Scanner;

public class WordPrinterRunner {
	public static void main(String args[]) {
		// initialize scanner
		Scanner keyboard = new Scanner(System.in);
		// used to track situation in loop
		String choice, word;
		int times;
		
		// do-while : run code, then continually ask to continue
		do {
			// get a word
			// ENTER: hello, funny, chicken, dog
			System.out.print("Enter the word to display :: ");
			word = keyboard.next();

			// get a number
			// ENTER: 9, 6, 4, 1
			System.out.print("Enter the times to display :: ");
			times = keyboard.nextInt();

			// call the printWord method
			WordPrinter.printWord(word, times);
			
			// check if this should go on
			// ENTER: y, y, y, n
			System.out.print("\nDo you want to enter more sample input? ");
			choice = keyboard.next();
			
			// space before next loop
			System.out.println();
		}
		// continue if yes or y
		while (choice.toLowerCase().charAt(0) == 'y');
		
		keyboard.close();
	}
}