package unit4;

//Name - Faith Okamoto
//Date - 2/10
//Class -
//Lab  -

public class Discount
{
	// method to discount a bill
	public static double getDiscountedBill(double bill)
	{
		// only discount if bill > $2000
		if (bill > 2000) return bill * 0.85;
		return bill;
	}
}