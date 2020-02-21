package unit7;
//(c) A+ Computer Science
//www.apluscompsci.com
//Name - Faith Okamoto

// import for printing outputs
import static java.lang.System.*;

public class TriangleFiveRunner
{
	public static void main(String args[])
	{
		// declare objects & variables
		TriangleFive tri = new TriangleFive();
		// all the sample data sets
		char[] chars = new char[] {'C', 'A', 'B', 'X', 'Z'};
		int[] amts = new int[] {4, 5, 7, 6, 8};
		
		for (byte i = 0; i < chars.length; i++) {
			// get new situation
			tri.setLetAmt(chars[i], amts[i]);
			
			// print out char triangle
			System.out.println(tri);
		}
	}
}