package dataLab;
/*
 * Arrays of objects
 */
 
import core.data.*;
import java.util.ArrayList;
import java.util.HashMap;

public class EmergencyManagerRunner {
	public static void main(String[] args) {
		// get emergency manager data
		DataSource ds = DataSource.connect("https://data.ny.gov/api/views/jwkb-x5v6/rows.xml").load();
		ArrayList<EmergencyManager> managers = ds.fetchList(EmergencyManager.class,
												"row/row/address", "row/row/zip_code");

		// initialize count map
		HashMap<Integer, Integer> zipCodeCount = new HashMap<Integer, Integer>();

		// used as placeholders in the loop
		int zipCode, count;
		// tracks information about max zip codes
		ArrayList<Integer> maxCodes = new ArrayList<Integer>();
		int maxCount = 0;
		
		// for each manager
		for (EmergencyManager em : managers) {
			// save their zipcode
			zipCode = em.getZipCode();
			
			// if this key isn't in the count map yet, put it in
			if (!zipCodeCount.containsKey(zipCode))
				zipCodeCount.put(zipCode, 0);
			// current count is one higher than reflected in the count map
			count = zipCodeCount.get(zipCode) + 1;
			// update the count map
			zipCodeCount.put(zipCode, count);
			
			// if this count is the highest ever
			if (count > maxCount) {
				// reset maxCount
				maxCount = count;
				// clear maxCodes and add this em's info
				maxCodes.clear();
				maxCodes.add(zipCode);
			}
			// if this count is equal to the highest so far, add zip code to maxCodes
			else if (count == maxCount) maxCodes.add(zipCode);
		}
		
		// number of managers in max zip codes is number of max zip codes * number of offices
		EmergencyManager[] maxManagers = new EmergencyManager[maxCodes.size() * maxCount];
		
		// adding to index 0
		int index = 0;
		// loop over all managers again
		for (EmergencyManager em : managers) {
			// if this manager's zip code is in the list of max zip codes
			if (maxCodes.indexOf(em.getZipCode()) != -1) {
				// add this manager to the array
				maxManagers[index] = em;
				// move index one forward
				index++;
			}
		}

		// print out information
		System.out.println("Total Emergency Management Offices in NYS: "
						+ managers.size());
		
		System.out.println("Number of zip codes those offices are in: "
						+ zipCodeCount.keySet().size());
		
		System.out.println("The maximum number of EMOs "
						+ "within a single zip code in NYS: " + maxCount);
		
		System.out.println("There are number of zip code(s) with this many offices: "
						+ maxCodes.size());
		
		System.out.println("These office(s) are:");
		
		for (EmergencyManager em : maxManagers)
			System.out.println(em.getAddress() + " (" + em.getZipCode() + ")");
	}
}