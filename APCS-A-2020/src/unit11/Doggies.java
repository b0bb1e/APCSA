package unit11;
//(c) A+ Computer Science
//www.apluscompsci.com
//Name - Faith Okamoto

import java.util.Arrays;

public class Doggies
{
	// store the dogs
	private Dog[] pups;

	// constructor: initialize pups to array of proper # of Dogs
	public Doggies(int size)
	{
		pups = new Dog[size];
	}
	
	// as long as a valid spot is input, make a dog with
	// passed-in attributes at spot in pups
	public void set(int spot, int age, String name)
	{
		// check if the spot is in pups
		if (spot >= 0 && spot < pups.length) {
			// create a new Dog in spot to specifications
			pups[spot] = new Dog(age, name);
		}
	}

	// finds the name of the oldest Dog in pups
	public String getNameOfOldest()
	{
		// for tracking the oldest dog found
		int oldestAge = 0;
		String oldestName = "";
		
		// look through pups
		for (Dog d : pups) {
			// if this dog is the oldest recorded
			if (d.getAge() > oldestAge) {
				// save it as the oldest recorded
				oldestAge = d.getAge();
				oldestName = d.getName();
			}
		}
		
		return oldestName;
	}

	// finds the name of the youngestDog in pups
	public String getNameOfYoungest()
	{
		// for tracking the youngest dog found
		int youngestAge = Integer.MAX_VALUE;
		String youngestName = "";
		
		// look through pups
		for (Dog d : pups) {
			// if this dog is the youngest recorded
			if (d.getAge() < youngestAge) {
				// save it as the youngest recorded
				youngestAge = d.getAge();
				youngestName = d.getName();
			}
		}
		
		return youngestName;
	}

	// print out all the Dogs in pups
	public String toString()
	{
		return "" + Arrays.toString(pups);
	}
}