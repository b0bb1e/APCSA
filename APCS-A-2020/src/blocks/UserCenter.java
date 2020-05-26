package blocks;

// for arrays that can change size
import java.util.ArrayList;

// for reading from files
import java.util.Scanner;
import java.io.File;

// for writing to files
import java.io.BufferedWriter;
import java.io.FileWriter;

/**
 * A central database of Users, can load & save
 * @author faith
 */
public final class UserCenter {
	/**
	 * all Users currently known
	 */
	private static ArrayList<User> USERS = readUsers();
	
	/**
	 * Load User data from users.dat
	 * @return the completed ArrayList of Users
	 */
	private static ArrayList<User> readUsers() {
		// initialize return variable
		ArrayList<User> users = new ArrayList<User>();
		
		// point a Scanner at users.dat
		try (Scanner reader = new Scanner(new File("src/blocks/gameData/users.dat"))){
			// while there are more Users to read
			while (reader.hasNext())  {
				// read this User's name
				String name = reader.next();
				
				// if there are scores to read
				if (reader.hasNextInt()) {
					// initialize an ArrayList to hold them
					ArrayList<Integer> scores = new ArrayList<Integer>();
					// while there are scores to read, read into scores
					while (reader.hasNextInt()) scores.add(reader.nextInt());
					
					// initialize array of level scores
					int[] minLevelScores = new int[LevelCenter.numLevels];
					// copy scores into the array
					for (int i = 0; i < scores.size() && i < minLevelScores[i]; ++i) 
						minLevelScores[i] = scores.get(i);
					
					// if there is an overall score (all levels + 1)
					if (scores.size() == LevelCenter.numLevels + 1) {
						// read it
						int minScore = scores.remove(scores.size() - 1);
						// add a User with the read-in data
						users.add(new User(name, minLevelScores, minScore));
					}
					// if there is not an overall score
					else {
						// for each level without a score, set to NO_SCORE
						for (int i = scores.size(); i < minLevelScores.length; ++i)
							minLevelScores[i] = User.NO_SCORE;
						// add a User with the read-in data
						users.add(new User(name, minLevelScores));
					}
				}
				// or if there are no scores to read, add a User with just the name
				else users.add(new User(name));
			}
		}
		// if anything goes wrong
		catch (Exception e) {
			// note that there is a problem (but the game can go on)
			System.out.println("Unable to load previous users");
			// print out the problem
			e.printStackTrace();
			// get rid of any Users, since their data may be corrupted
			users.clear();
		}
		
		return users;
	}
	
	/**
	 * Save User data to users.dat
	 */
	public static void saveUsers() {
		// point a writer at users.dat
		try (BufferedWriter writer = new BufferedWriter(
				new FileWriter("src/blocks/gameData/users.dat"))) {
			// loop over all Users to save
			for (User user : USERS) {
				// write this User's name
				writer.write(user.getName());
				
				// if there are some level score to save, move to a new line
				if (user.lastCompletedLevel() > 0) writer.newLine();
				// loop over all level scores to save
				for (int level = 1; level <= user.lastCompletedLevel(); ++level)
					// write level scores, separated by a space
					writer.write(user.getMinLevelScore(level) + " ");
				
				// newline for the overall score
				writer.newLine();
				// if there is an overall score, write it and then newline
				if (user.getMinScore() != User.NO_SCORE) {
					writer.write(user.getMinScore() + " ");
					writer.newLine();
				}
				// space before next User
				writer.newLine();
			}
		}
		// If something goes wrong
		catch (Exception e) {
			// not that there is a problem
			System.out.println("Unable to save current users");
			// print out the problem
			e.printStackTrace();
		}
	}
	
	/**
	 * Get a User by name
	 * @param name the name of the User to get
	 * @return an existing User with that name, or null if none exists
	 */
	public static User getUser(String name) {
		// loop over all Users, and if name matches then return
		for (User user : USERS) if (user.getName().equals(name)) return user;
		// if no User is found, return null
		return null;
	}
	
	/**
	 * Add a User with a specified name
	 * @param name the name of the User to add
	 * @return the User added
	 */
	public static User addUser(String name) {
		// check that this will not be a duplicate name
		if (getUser(name) != null)
			// if so, complain
			throw new IllegalArgumentException("A user with that name already exists");
		// create the User
		User add = new User(name);
		// add to USERSS and return
		USERS.add(add);
		return add;
	}
	
	/**
	 * Get a sorted User leaderboard (earlier = higher)
	 * @return the 10 Users with the lowest overall scores
	 */
	public static ArrayList<User> getLeaderboard() {
		// initialize return variable
		ArrayList<User> leaderboard = new ArrayList<User>();
		
		// loop over all Users
		for (User user : USERS) {
			// save this User's overall score
			int score = user.getMinScore();
			// if this User has an overall score
			if (score != User.NO_SCORE) {
				// simple insertion sort into leaderboard, with lowest scores first
				int add = leaderboard.size();
				while (add > 0 && 
						leaderboard.get(add - 1).getMinScore() > score) --add;
				leaderboard.add(add, user);
			}
		}
		
		// if there are too many Users
		if (leaderboard.size() > 10) 
			// trim all over 10
			for (int user = leaderboard.size() - 1; user > 10; -- user) 
				leaderboard.remove(user);
		
		return leaderboard;
	}
	
	public String toString() {
		// class identifier
		String ret = "UserCenter";
		// add each user on a new line
		for (User user : USERS) ret += "\n" + user;
	
		return ret;
	}
}