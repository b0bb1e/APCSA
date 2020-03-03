package unit10;
//(c) A+ Computer Science
//www.apluscompsci.com
//Name - Faith Okamoto

public class ToyRunner
{
	public static void main(String[] args)
	{
		// create some Toys, run methods to test
		Toy game = new Toy("sorry");
		game.setCount(1);
		System.out.println(game);
		
		Toy action = new Toy("gi joe");
		action.setCount(5);
		System.out.println(action);
	}
}