package Unit0;
//(c) A+ Computer Science
//www.apluscompsci.com

//Name -
//Date -
//Class -
//Lab  -



public class AsciiBox
{
	static void box(int repeats) {
		if (repeats > 0) {
			System.out.println("+++++++++++++++++++++++++");
			System.out.println("+++++++++++++++++++++++++");
			System.out.println("+++++++++++++++++++++++++");
			if (repeats > 1) {
				System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAA");
				System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAA");
			}
			box(repeats - 1);
		}
	}
	
	public static void main(String[] args)
	{
		System.out.println("Faith \t  1/29/2020 \n\n" );
		box(4);
	}
}