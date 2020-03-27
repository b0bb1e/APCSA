package q3_project;

// for reading from the data file
import java.util.Scanner;
import java.io.File;
import java.io.IOException;

public class VendorRunner {
	public static void main(String[] args) throws IOException {
		// open a reader on the file
		Scanner reader = new Scanner(new File("src/q3_project/product_info.dat"));
		
		// the first line is the name of the Vendor
		Vendor feed = new Vendor(reader.nextLine());
		// the next line has the number of items listed
		int items = reader.nextInt();
		// move reader down to items
		reader.nextLine();
		// loop over all items listed, adding to the Vendor
		for (int i = 0; i < items; i++) feed.addProduct(reader.nextLine());
		
		// moving on to the next Vendor
		reader.nextLine();
		
		// the first line is the name of the Vendor
		Vendor cheat = new Vendor(reader.nextLine());
		// the next line has the number of items listed
		items = reader.nextInt();
		// move reader down to items
		reader.nextLine();
		// loop over all items listed, adding to the Vendor
		for (int i = 0; i < items; i++) cheat.addProduct(reader.nextLine());
		
		// this reader is done with, clean up
		reader.close();
		
		// print out the initial states of the Vendors
		System.out.println(feed + "\n\n" + cheat + "\n----------");
		
		// add some sales
		feed.addSale("blue milk (1 bottle)", 10);
		cheat.addSale("5-paragraph essay (1 day, high quality)", 300);
		cheat.addSale("5-paragraph essay (1 day, high quality)", 300);
		// print out the new state
		System.out.println("After selling another blue milk for $10"
				+ " and two more 1-day rush, good quality essays for $300:\n");
		System.out.println(feed + "\n\n" + cheat + "\n----------");
		
		// sort items by total profit
		feed.sortProductsTotalProfit();
		cheat.sortProductsTotalProfit();
		// print out the new state
		System.out.println("After sorting for total profit:\n");
		System.out.println(feed + "\n\n" + cheat + "\n----------");
		
		// sort items by average profit
		feed.sortProductsAveProfit();
		cheat.sortProductsAveProfit();
		// print out the new state
		System.out.println("After sorting for average profit:\n");
		System.out.println(feed + "\n\n" + cheat + "\n----------");
		
		// compare the Vendors using various metrics, print out the result
		System.out.println("The more profitable vendor is " +
							feed.compareProfit(cheat).getName());
		System.out.println("The vendor with a wider range of products is " +
							feed.compareNumProducts(cheat).getName());
		System.out.println("The higher-end vendor is " + 
							feed.compareAvePrice(cheat).getName());
		System.out.println("\n");
		
		// find the most expensive products from the vendors
		System.out.println("The product that sold for the most from " +
							feed.getName() + " is: " + feed.mostExpensiveItem().getName());
		System.out.println("The product that sold for the most from " +
							cheat.getName() + " is: " + cheat.mostExpensiveItem().getName());
		System.out.println("\n");
		
		// find products with certain values
		System.out.println("Using binary search on " + feed.getName() +
							"\nto find a product with total profit of $60.35 yields: "
							+ feed.binarySearchTotalProfit(60.35).getName());
		System.out.println("Using binary search on " + cheat.getName() +
							"\nto find a product with average profit of $71.29 yields: "
							+ cheat.binarySearchAveProfit(71.29).getName());
	}
}