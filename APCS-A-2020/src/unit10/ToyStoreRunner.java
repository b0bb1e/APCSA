package unit10;
//(c) A+ Computer Science
//www.apluscompsci.com
//Name - Faith Okamoto

public class ToyStoreRunner
{
	public static void main(String args[])
	{
		// create a ToyStore and run some methods to test it
		ToyStore store = new ToyStore();
		System.out.println(store); 
		
		String toys = "sorry bat sorry sorry sorry train train teddy teddy ball ball";
		store.loadToys(toys);
		System.out.println(store);
		
		System.out.println(store.getMostFrequentToy());
	}
}