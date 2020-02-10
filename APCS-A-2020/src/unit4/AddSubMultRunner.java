package unit4;

// import for printing outputs
import static java.lang.System.*;

public class AddSubMultRunner
{
	public static void main(String args[])
	{
		// run all the test cases
		System.out.println(AddSubMult.check(10, 20));
		System.out.println(AddSubMult.check(20, 10));
		System.out.println(AddSubMult.check(20, 20));
		System.out.println(AddSubMult.check(10, 10));
		System.out.println(AddSubMult.check(0, 1));
		System.out.println(AddSubMult.check(1, 0));
		System.out.println(AddSubMult.check(3.1, 5.7));
		System.out.println(AddSubMult.check(5.2, 3.8));
		System.out.println(AddSubMult.check(5342, 323));
	}
}