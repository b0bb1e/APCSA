package q3_project;

// used as a resizable data structure
import java.util.ArrayList;

/**
 * Represents all previous prices that an item has sold for.
 * Maintains an {@code ArrayList} of these prices.
 * @author faith
 */
public class SaleHistory {
	/**
	 * the previous sale prices
	 */
	private ArrayList<Double> sales;
	
	/**
	 * Default constructor
	 * <br>
	 * Initializes {@code sales} to empty.
	 */
	public SaleHistory() {
		sales = new ArrayList<Double>();
	}

	/**
	 * Regular constructor
	 * <br>
	 * Initializes {@code sales} to values given in history, provided proper formatting
	 * @param history proper formatted prices
	 */
	public SaleHistory(String history) {
		sales = new ArrayList<Double>();
		// prices should be separated by spaces
		String[] prices = history.split(" ");
		// read each price into sales as a double
		for (String price : prices) addSale(Double.parseDouble(price));
	}
	
	/**
	 * Adds a sale price to {@code sales}
	 * @param price the new sale price
	 */
	public void addSale(double price) {
		sales.add(price);
	}

	/**
	 * Calculates the total revenue from the sale prices
	 * <br>
	 * Loops over {@code sales}, adding each element to a total.
	 * @return the total of all prices sold for
	 */
	public double totalRev() {
		// initialize return variable
		double total = 0;
		// add each price in sales to the total
		for (Double sale : sales) total += sale;
		
		return total;
	}

	/**
	 * Calculates the average price sold for
	 * <br>
	 * Divides the total revenue by the number of items sold.
	 * @return the average price in the record
	 */
	public double avePrice() {
		return totalRev() / getNumSales();
	}
	
	/**
	 * Finds the maximum price in the record
	 * <br>
	 * Loops through each price in {@code sales}, setting it as
	 * the most maximum if more than the current maximum.
	 * @return the maximum price in {@code sales},
	 * or {@code 0.0} if {@code sales} is empty
	 */
	public double maxPrice() {
		// check for emptiness
		if (getNumSales() == 0) return 0.0;
		
		// initialize best price to the first one
		double max = sales.get(0);
		// loop over all other prices
		for (int i = 1; i < sales.size(); i++)
			// check if this price is more than the current maximum
			if (max < sales.get(i))
				// if so, set it as the maximum
				max = sales.get(i);
		
		return max;
	}

	/**
	 * Getter for the number of sale prices recorded
	 * @return the size of {@code sales}
	 */
	public int getNumSales() {
		return sales.size();
	}
	
	/**
	 * Overridden toString
	 * <br>
	 * Give information about the number of sales and the total amount earned with context.
	 */
	@Override
	public String toString() {
		return getNumSales() + " have made $" + String.format("%.2f", totalRev());
	}
}