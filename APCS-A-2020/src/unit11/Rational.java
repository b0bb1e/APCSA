package unit11;
//(c) A+ Computer Science
//www.apluscompsci.com
//Name - Faith Okamoto

class Rational implements Comparable<Rational>
{
	// store values in the fraction
	private int numer, denom;
	
	// default constructor: fraction is 1/1
	public Rational() {
		this(1, 1);
	}
	
	// constructor: fraction is n/d
	public Rational(int n, int d) {
		setRational(n, d);
	}

	// sets the numerator and denominator
	public void setRational(int n, int d) {
		numer = n;
		denom = d;
		
		// reduce values if necessary
		reduce();
	}

	// set the numerator
	public void setNumerator(int n) {
		numer = n;
		
		// reduce values if necessary
		reduce();
	}
	
	// set the denominator
	public void setDenominator(int d) {
		denom = d;
		
		// reduce values if necessary
		reduce();
	}
	
	// add two Rationals together
	public void add(Rational other)
	{
		// calculate the new numerator (cross-multiplying)
		numer = (numer * other.getDenominator())
				+ (other.getNumerator() * denom);
		// calculate the new denominator (multiplying)
		denom = denom * other.getDenominator();
		
		// reduce values if necessary
		reduce();
	}

	// reduce values
	private void reduce()
	{
		// calculate the gcd of the numerator and denominator
		int gcd = gcd(numer, denom);
		
		// divide both by the gcd
		numer /= gcd;
		denom /= gcd;
	}

	// calculate the gcd of two numbers
	private int gcd(int a, int b)
	{
		// find the min of the two
		int min = Math.min(a, b);
		
		// loop from the min to 2
		for (int i = min; i > 1; i--) {
			// if both values divide i, return it
			if (a % i == 0 && b % i == 0) return i;
		}
		
		// otherwise, gcd = 1
		return 1;
	}

	// create a new Rational with the same attributes
	public Object clone ()
	{
		return new Rational(numer, denom);
	}

	// getters
	
	public int getNumerator() {return numer;}
	
	public int getDenominator() {return denom;}
	
	// check if an object is equal to this
	public boolean equals(Object compare)
	{
		// check numerator & denominator, cast to Rational
		return numer == ((Rational) compare).getNumerator()
				&& denom == ((Rational) compare).getDenominator();
	}

	// check if another Rational is bigger/smaller than this
	public int compareTo(Rational compare)
	{
		// check for equality first
		if (this.equals(compare)) return 0;
		
		// change both numerators for lcd purposes
		int myNumer = numer * compare.getDenominator();
		int compareNumer = compare.getNumerator() * denom;
		
		// compare the numerators
		if (myNumer > compareNumer) return 1;
		return -1;
	}
	
	// print out values as a fraction
	public String toString() {
		return numer + "/" + denom;
	}
}