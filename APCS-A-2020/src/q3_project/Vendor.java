package q3_project;

// used as a resizable data structure
import java.util.ArrayList;

/**
 * Represents a store or other kind of seller.
 * Maintains an {@code ArrayList} of {@code Product}s that are sold by this {@code Vendor}.
 * @author faith
 */
public class Vendor {
	/**
	 *  the name of this {@code Vendor} (for easy recognition)
	 */
	private String name;
	/**
	 *  the {@code Products} that this {@code Vendor} has for sale
	 */
	private ArrayList<Product> products;
	private String sorted;
	
	/**
	 * Default constructor
	 * <br>
	 * Initializes {@code name} and {@code products} to empty.
	 */
	public Vendor() {
		this.name = "";
		this.products = new ArrayList<Product>();
		this.sorted = "none";
	}
	
	/**
	 * Regular constructor
	 * <br>
	 * Initializes {@code name} to a specified value and {@code products} to empty.
	 * @param name the name of this {@code Vendor}
	 */
	public Vendor(String name) {
		this.name = name;
		this.products = new ArrayList<Product>();
		this.sorted = "none";
	}
	
	/**
	 * Adds a new {@code Product} to {@code products} with the specified information
	 * @param productInfo properly formatted information about a {@code Product}
	 */
	public void addProduct(String productInfo) {
		products.add(new Product(productInfo));
		sorted = "none";
	}
	
	/**
	 * Adds a new sale price to one of the {@code Product}s in {@code products}
	 * Loops through {@code products}, checking for the name given and
	 * using the {@code addSale()} method once found.
	 * @param name the name of the {@code Product} that had another sale
	 * @param price the price the new sale was for
	 */
	public void addSale(String name, double price) {
		// loop over all products
		for (Product item : products) {
			// check if the name equals
			if (item.getName().equals(name)) {
				// if so, add the sale and leave
				item.addSale(price);
				break;
			}
		}
		sorted = "none";
	}

	/**
	 * Finds the {@code Product} in {@code products} which sold for the most
	 * <br>
	 * Loops through each {@code Product} in {@code products}, setting it as
	 * the most expensive if better than the current best.
	 * @return the {@code Product} which maximizes {@code getMaxPrice()},
	 * or {@code null} if {@code products} is empty
	 */
	public Product mostExpensiveItem() {
		// check for emptiness
		if (getNumProducts() == 0) return null;
		
		// initialize best Product to the first one
		Product best = products.get(0);
		// loop over all other Products
		for (int i = 1; i < getNumProducts(); i++) 
			// check if this Product went for more than the current best
			if (best.maxPrice() < products.get(i).maxPrice())
				// if so, set it as the best
				best = products.get(i);
		
		return best;
	}
	
	/**
	 * Calculates the total profit of this {@code Vendor}
	 * <br>
	 * Loops through each {@code Product} in {@code products}, adding up {@code totalProfit()}.
	 * @return the total profit of all {@code Product}s of this {@code Vendor}
	 */
	public double totalProfit() {
		// initialize return variable
		double total = 0;
		// add each Product's total to the overall total
		for (Product item : products) total += item.totalProfit();
		
		return total;
	}
	
	/**
	 * Insertion sort of {@code products} based on total profit
	 * <br>
	 * Loops through all {@code Product}s in {@code products}, moving each forward
	 * until an index with total profit of more than the current {@code Product}.
	 */
	public void sortProductsTotalProfit() {
		// loop through unsorted portion of ArrayList
		for (int i = 1; i < products.size(); i++) {
			// the Product being sorted, must be removed first
			Product temp = products.remove(i);
			
			// the index of the Product that should come right before this one
			int beforeIndex = i - 1;
			// while the Product at that index does not fulfill the aforementioned criteria
			while (beforeIndex >= 0 && products.get(beforeIndex).totalProfit() < temp.totalProfit())
				// move the index forward to check another
				beforeIndex--;
			
			// finally add the Product back in at the now-sorted index
			products.add(beforeIndex + 1, temp);
		}
		sorted = "total";
	}
	
	
	/**
	 * Insertion sort of {@code products} based on total profit
	 * <br>
	 * Loops through all {@code Product}s in {@code products}, moving each forward
	 * until an index with average profit of more than the current {@code Product}.
	 */
	public void sortProductsAveProfit() {
		// loop through unsorted portion of ArrayList
		for (int i = 1; i < products.size(); i++) {
			// the Product being sorted, must be removed first
			Product temp = products.remove(i);
			
			// the index of the Product that should come right before this one
			int beforeIndex = i - 1;
			// while the Product at that index does not fulfill the aforementioned criteria
			while (beforeIndex >= 0 && products.get(beforeIndex).aveProfit() < temp.aveProfit())
				// move the index forward to check another
				beforeIndex--;
			
			// finally add the Product back in at the now-sorted index
			products.add(beforeIndex + 1, temp);
		}
		sorted = "average";
	}
	
	/**
	 * Calculates the average price of this {@code Vendor}
	 * <br>
	 * Loops through each {@code Product} in {@code products}, adding up {@code avePrice()},
	 * and dividing by the number of {@code Product}s in the end.
	 * @return the average price of all {@code Product}s of this {@code Vendor}
	 */
	public double avePrice() {
		// initialize return variable
		double total = 0;
		// add each Product's total to the overall total
		for (Product item : products) total += item.avePrice();
		
		return total / getNumProducts();
	}
	
	/**
	 * Compares two {@code Vendor}s to find the more profitable one
	 * <br>
	 * Compares {@code this.getTotalProfit()} to {@code other.getTotalProfit()}.
	 * @param other another {@code Vendor}
	 * @return whichever {@code Vendor} is more profitable overall, or {@code null} if they make the same
	 */
	public Vendor compareProfit(Vendor other) {
		// handles the case where this Vendor is more profitable than other
		if (this.totalProfit() > other.totalProfit()) return this;
		// handles the opposite case
		else if (other.totalProfit() > this.totalProfit()) return other;
		// if both make the same, return null
		else return null;
	}
	
	/**
	 * Compares two {@code Vendor}s to find the one with more {@code Product}s
	 * <br>
	 * Compares {@code this.getNumProducts()} to {@code other.getNumProducts()}.
	 * @param other another {@code Vendor}
	 * @return whichever {@code Vendor} has more {@code Product}s, or {@code null} if they have the same
	 */
	public Vendor compareNumProducts(Vendor other) {
		// handles the case where this Vendor has more Products than other
		if (this.getNumProducts() > other.getNumProducts()) return this;
		// handles the opposite case
		else if (other.getNumProducts() > this.getNumProducts()) return other;
		// if they both have the same number, return null
		else return null;
	}
	
	/**
	 * Compares two {@code Vendor}s to find the one with a higher average price
	 * <br>
	 * Compares {@code this.avePrice()} to {@code other.avePrice()}.
	 * @param other another {@code Vendor}
	 * @return whichever {@code Vendor} has a higher average price, or {@code null} if they have the same
	 */
	public Vendor compareAvePrice(Vendor other) {
		// handles the case where this Vendor has a higher average price than the other
		if (this.avePrice() > other.avePrice()) return this;
		// handles the opposite case
		else if (other.avePrice() > this.avePrice()) return other;
		// if they both have the same, return null
		else return null;
	}
	
	/**
	 * Finds a {@code Product} in {@code products} by its total profit
	 * <br>
	 * Uses binary search, moves the left and right bounds each iteration
	 * by comparison to the profit of the middle product, narrowing search.
	 * @param totalProfit the total profit of the desired {@code Product}
	 * @return a {@code Product] with that profit, or null if none exists
	 */
	public Product binarySearchTotalProfit(double totalProfit) {
		// sort by total profit if not already
		if (!sorted.equals("total")) sortProductsTotalProfit();
		
		// initialize right and left to the edges
		int right = 0;
		int left = getNumProducts() - 1;
		
		// while there are some Products still being searched
		while (right < left) {
			// calculate the middle index of the interval being searched
			int middle = (right + left) / 2;
			// get the profit of the middle Product
			double midProfit = products.get(middle).totalProfit();
			
			// if the profits match, return the middle Product
			if (Math.abs(totalProfit - midProfit) <= 0.01) return products.get(middle);
			// or if not, shift the bounds appropriately
			else if (totalProfit < midProfit) right = middle;
			else if (totalProfit > midProfit) left = middle;
		}
		
		// if a Product with the desired price was not found, return null
		return null;
	}
	
	/**
	 * Finds a {@code Product} in {@code products} by its average profit
	 * <br>
	 * Uses binary search, moves the left and right bounds each iteration
	 * by comparison to the profit of the middle product, narrowing search.
	 * @param aveProfit the average profit of the desired {@code Product}
	 * @return a {@code Product] with that profit, or null if none exists
	 */
	public Product binarySearchAveProfit(double aveProfit) {
		// sort by total profit if not already
		if (!sorted.equals("average")) sortProductsAveProfit();
		
		// initialize right and left to the edges
		int right = 0;
		int left = getNumProducts() - 1;
		
		// while there are some Products still being searched
		while (right < left) {
			// calculate the middle index of the interval being searched
			int middle = (right + left) / 2;
			// get the profit of the middle Product
			double midProfit = products.get(middle).aveProfit();
			
			// if the profits match, return the middle Product
			if (Math.abs(aveProfit - midProfit) <= 0.01) return products.get(middle);
			// or if not, shift the bounds appropriately
			else if (aveProfit < midProfit) right = middle;
			else if (aveProfit > midProfit) left = middle;
		}
		
		// if a Product with the desired price was not found, return null
		return null;
	}
	
	/**
	 * Getter for {@code this.name}
	 * @return the {@code name} of this {@code Vendor}
	 */
	public String getName() {return this.name;}
	
	/**
	 * Getter for size of this {@code Vendor}'s {@code products}
	 * @return the number of {@code Product}s in {@code this.products}
	 */
	public int getNumProducts() {return this.products.size();}
	
	/**
	 * Overridden toString
	 * <br>
	 * Gives the {@code name} of this {@code Vendor}
	 * and its {@code Product}s with context.
	 */
	@Override
	public String toString() {
		// initialize return variable to name and starter text
		String output = getName() + "\n\nA selection of fine wares:\n";
		// add each Product's information, tabbed nicely
		for (Product item : products) output += "\t" + item + "\n";
		
		return output;
	}
}