package unit6;
//(c) A+ Computer Science
//www.apluscompsci.com
//Name - Faith Okamoto

public class Perfect
{
	// number attribute
	private int number;

	// default constructor: first sample number
	public Perfect() {
		setNum(496);
	}
	
	// constructor: set number attribute
	public Perfect(int num) {
		setNum(num);
	}

	// method to set number attribute
	public void setNum(int num) {
		number = num;
	}
	
	// method to determine if a number is perfect
	public boolean isPerfect()
	{
		// initialize a divisors-sum variable
		int divSum = 0;
		
		// for all numbers less than half the number plus one (high numbers cannot work)
		for (int i = 1; i < (number / 2) + 1; i++) {
			// if this number is a divisor, add it to the divisors-sum
			if (number % i == 0) divSum += i;
		}
		return divSum == number;
	}
	
	// method to print out the number within the context of perfection
	public String toString() {
		if(isPerfect()) return number + " is perfect.";
		return number + " is not perfect.";
	}
}