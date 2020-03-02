package unit10;
//(c) A+ Computer Science
//www.apluscompsci.com
//Name - Faith Okamoto

// import for getting inputs
import java.util.Scanner;

public class TriangleWordRunner
{
	public static void main(String args[])
	{
		// initialize scanner
		Scanner keyboard = new Scanner(System.in);
		// used to track in the loop
		String word, choice;
		
		// do-while : run once, then check if the user wants to go on
		do {
			// get a word
			// ENTER: a, it, box, toad, fishy, dog
			System.out.print("Enter a word :: ");
			word = keyboard.next();
			
			// print out that word's triangle
			TriangleWord.printTriangle(word);
			
			// check if user wants to go on
			// ENTER: y, y, y, y, y, n
			System.out.print("\nDo you want to enter more sample input? ");
			choice = keyboard.next();
			
			// space before next loop
			System.out.println();
		}
		// only go on if user indicate with a y or yes
		while(choice.toLowerCase().charAt(0) == 'y');
		
		// clean up keyboard
		keyboard.close();
	}
}