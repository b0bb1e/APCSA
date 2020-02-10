package unit4;

public class AddSubMult
{
	// method to manipulate two doubles as requested
	public static double check(double a, double b)
	{
		double asm;
		if (a > b) asm = a - b;
		else if (b > a) asm = b - a;
		else asm = a * b;
		return (double) ((int) (asm * 10)) / 10;
	}
}