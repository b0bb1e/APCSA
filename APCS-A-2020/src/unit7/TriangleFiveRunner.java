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
		TriangleFive tri = new TriangleFive();
		char[] chars = new char[] {'C', 'A', 'B', 'X', 'Z'};
		int[] amts = new int[] {4, 5, 7, 6, 8};
		tri.setLetAmt(chars[0], amts[0]);
		System.out.println(tri);
	}
}