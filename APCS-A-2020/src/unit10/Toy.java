package unit10;
//(c) A+ Computer Science
//www.apluscompsci.com
//Name - Faith Okamoto

public class Toy
{
	// save information about the toy
	private String name;
	private int count;

	// default constructor: create a default toy
	public Toy()
	{
		// you want it, do you not?
		this("baby yoda");
	}

	// constructor: set the name, initialize count to 1
	public Toy(String n)
	{
		name = n;
		count = 1;
	}
	
	// getters
	
	public int getCount() {return count;}
	
	public String getName() {return name;}
	
	// setters
	
	public void setCount(int c) {count = c;}
	
	public void setName(String n) {name = n;}

	// give information about the toy
	public String toString()
	{
	   return name + " " + count;
	}
}