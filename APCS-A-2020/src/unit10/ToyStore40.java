package unit10;
//(c) A+ Computer Science
//www.apluscompsci.com
//Name - Faith Okamoto

import java.util.ArrayList;

public class ToyStore40
{
	// store the toys in the store
	private ArrayList<Toy> toyList;

	// constructor initializes the toyList
	public ToyStore40()
	{
		toyList = new ArrayList<Toy>();
	}

	// adds toys from a space-separated string to the toyList
	public void loadToys(String toys)
	{
		// initialize an array of names
		ArrayList<String> names = new ArrayList<String>();
		
		// for each of those names in the string
		for (String name : toys.split(" ")) {
			// if it's a new name
			if (!names.contains(name)) {
				// add a Toy with this name to the toyList
				toyList.add(new Toy(name));
				// add this name to names
				names.add(name);
			}
			
			// else (toy with this name already created)
			else {
				// increment that toy's count by 1
				Toy t = getThatToy(name);
				t.setCount(t.getCount() + 1);
			}
		}
	}
  
	// return a toy from the toyList by name
  	public Toy getThatToy(String name)
  	{
  		// check through each toy
  		for (Toy t : toyList) {
  			// if it has the proper name, return it
  			if (t.getName().equals(name)) return t;
  		}
  		
  		// if no toy with name was found, return null
  		return null;
  	}
  	
  	// give my name
  	public String myName() {
  		return "Faith Okamoto";
  	}
  	
  	// find the name of the most frequent toy
  	public String getMostFrequentToy()
  	{
  		// used to track information about
  		// the most frequent toy so far
  		int mostTimes = 0;
  		String mostName = "";
  		
  		// check through each toy
  		for (Toy t : toyList) {
  			// if it is more frequent than
  			// current most frequent toy
  			if (t.getCount() > mostTimes) {
  				// save it as the most frequent toy
  				mostTimes = t.getCount();
  				mostName = t.getName();
  			}
  		}
  		
  		// return most frequent toy's name
  		return mostName;
  	}  
  
  	// insertion sort of the toyList by count 
  	public void sortToysByCount()
  	{
  		// used as placeholders in the loop
  		int check;
  		Toy temp;
  		
  		// loop over all unsorted elements
  		for (int i = 1; i < toyList.size(); i++) {
  			// save the current spot being checked
  			check = i - 1;
  			// while check is the beginning of toyList
  			// and the left element has larger count
  			while (check >= 0 &&
  					toyList.get(i).getCount() < 
  					toyList.get(check).getCount()) {
  				// move checking index over
  				check--;
  			}
  			
  			// move this element to its sorted spot
  			temp = toyList.remove(i);
  			toyList.add(check + 1, temp);
  		}
  	}  
  	
  	// give information about all toys
	public String toString()
	{
		return "" + toyList.toString();
	}
}