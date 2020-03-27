package q3_project;

// used to read strings
import java.util.Scanner;

/**
 * Represents a product/item for sale.
 * Maintains a reference to all sales made in the past.
 * @author faith
 */
public class Product {
	/**
	 * the name of this {@code Product} (for easy recognition)
	 */
	private String name;
	/**
	 * the amount it costs to make this {@code Product}
	 */
	private double costToMake;
	/**
	 * a {@code SaleHistory} with all the prices that this {@code Product} has sold for
	 */
	private SaleHistory sales;

	/**
	 * Default constructor
	 * <br>
	 * Initializes {@code name}, {@code costToMake}, and {@code sales} to empty values.
	 */
	public Product() {
		name = "";
		costToMake = 0;
		sales = new SaleHistory();
	}
	
	/**
	 * Regular constructor
	 * <br>
	 * Initializes {@code name}, {@code costToMake}, and {@code sales}
	 * to the values given in info, provided proper formatting.
	 * @param info properly formatted product information
	 */
	public Product(String info) {
		// open a Scanner on the information string
		Scanner reader = new Scanner(info);
		
		// initialize name to blank
		name = "";
		// while prices have not yet been reached, keep adding on the name
		while (!reader.hasNextDouble()) name += " " + reader.next();
		// get rid of the first space in name
		name = name.substring(1);
		
		// read the cost to make this Product
		costToMake = reader.nextDouble();
		// initialize the SaleHistory from the prices given
		sales = new SaleHistory(reader.nextLine().substring(1));
		// clean up
		reader.close();
	}
	
	/**
	 * Adds a new sale price for this {@code Product}
	 * @param price the new price this {@code Product} went for
	 */
	public void addSale(double price) {
		sales.addSale(price);
	}

	/**
	 * Calculates the total profit from this {@code Product}
	 * <br>
	 * Gets revenue (from {@code sales.totalRev()}) and subtracts the cost to make all sold.
	 * @return the total profit made off selling this {@code Product}
	 */
	public double totalProfit() {
		return sales.totalRev() - (costToMake * sales.getNumSales());
	}

	/**
	 * Calculates the average profit from this {@code Product}
	 * <br>
	 * Gets total profit (from {@code getTotalProfit()}) and divides by the number of sales.
	 * @return the total profit made off selling this {@code Product}
	 */
	public double aveProfit() {
		return totalProfit() / sales.getNumSales();
	}
	
	/**
	 * Getter for the average price from this {@code Product}
	 * <br>
	 * Calls the {@code SaleHistory}'s {@code avePrice()} method
	 * @return the total profit made off selling this {@code Product}
	 */
	public double avePrice() {
		return sales.avePrice();
	}
	
	/**
	 * Getter for the maximum price this {@code Product} has sold for
	 * <br>
	 * Calls the {@code SaleHistory}'s {@code getMaxPrice()} method.
	 * @return the maximum price this {@code Product} has sold for
	 */
	public double maxPrice() {return this.sales.maxPrice();}

	/**
	 * Getter for {@code this.name}
	 * @return the {@code name} of this {@code Product}
	 */
	public String getName() {return this.name;}
	
	/**
	 * Getter for {@code this.costToMake}
	 * @return the {@code costToMake} of this {@code Product}
	 */
	public double getCostToMake() {return this.costToMake;}
	
	/**
	 * Overridden toString
	 * <br>
	 * Gives the {@code name} and {@code costToMake} of this {@code Product},
	 * along with context about the sale history.
	 */
	@Override
	public String toString() {
		return getName() + ": costs " + getCostToMake() + " to make, and "
				+ sales.getNumSales() + " have made $" + String.format("%.2f", totalProfit());
	}
}