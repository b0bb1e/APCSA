package blocks;

// for reading from files
import java.util.Scanner;
import java.io.File;

/**
 * A central database of Levels, can load
 * @author faith
 */
public final class LevelCenter {
	/**
	 * all Levels loaded
	 */
	private static Level[] LEVELS = readLevels();
	/**
	 * the number of Levels available
	 */
	public static final int numLevels = LEVELS.length;
	
	private static ExampleLevel[] EXAMPLES = readExamples();
	
	/**
	 * Load Level data from levels.dat
	 * @return the completed array of Levels
	 */
	private static Level[] readLevels() {
		// point a Scanner at levels.dat
		try (Scanner reader = new Scanner(
				new File("src/blocks/gameData/levels.dat"))) {
			// initialize Levels array to proper size
			Level[] levels = new Level[reader.nextInt()];
			// loop over all Levels to load
			for (int level = 0; level < levels.length; ++level) {
				// initialize types matrix to proper size
				char[][] types = new char[reader.nextInt()][reader.nextInt()];
				// loop over all cells in types matrix
				for (int row = 0; row < types.length; ++row)
					for (int col = 0; col < types[0].length; ++col)
						// read in char for type
						types[row][col] = reader.next().charAt(0);
				
				// initialize block coordinate array to proper size
				int[][] blocks = new int[reader.nextInt()][2];
				// loop over all coordinates to read, reading into array
				for (int block = 0; block < blocks.length; ++block)
					blocks[block] = new int[] {reader.nextInt(), reader.nextInt()};
				
				// read player coordinates
				int[] player = {reader.nextInt(), reader.nextInt()};
				// add new Level to levels array
				levels[level] = new Level(types, blocks, player);
			}
			
			return levels;
		}
		// if anything goes wrong
		catch (Exception e) {
			// print it out
			e.printStackTrace();
			// Levels are needed, this is unrecoverable
			throw new RuntimeException("Unable to load levels");
		}
	}
	
	/**
	 * Load Level data from levels.dat
	 * @return the completed array of Levels
	 */
	private static ExampleLevel[] readExamples() {
		// point a Scanner at levels.dat
		try (Scanner reader = new Scanner(
				new File("src/blocks/gameData/examples.dat"))) {
			// initialize Levels array to proper size
			ExampleLevel[] examples = new ExampleLevel[reader.nextInt()];
			// loop over all Levels to load
			for (int example = 0; example < examples.length; ++example) {
				// initialize types matrix to proper size
				char[][] types = new char[reader.nextInt()][reader.nextInt()];
				// loop over all cells in types matrix
				for (int row = 0; row < types.length; ++row)
					for (int col = 0; col < types[0].length; ++col)
						// read in char for type
						types[row][col] = reader.next().charAt(0);
				
				// initialize block coordinate array to proper size
				int[][] blocks = new int[reader.nextInt()][2];
				// loop over all coordinates to read, reading into array
				for (int block = 0; block < blocks.length; ++block)
					blocks[block] = new int[] {reader.nextInt(), reader.nextInt()};
				
				// read player coordinates
				int[] player = {reader.nextInt(), reader.nextInt()};
				
				byte[] moves = new byte[reader.nextInt()];
				for (int move = 0; move < moves.length; ++move) 
					moves[move] = Grid.stringToDir(reader.next());
				// add new Level to levels array
				examples[example] = new ExampleLevel(types, blocks, player, moves);
			}
			
			return examples;
		}
		// if anything goes wrong
		catch (Exception e) {
			// print it out
			e.printStackTrace();
			// Levels are needed, this is unrecoverable
			throw new RuntimeException("Unable to load examples");
		}
	}
	
	/**
	 * Get a Level by its 1-indexed number
	 * @param level the 1-indexed number of 
	 * @return the Level with that number
	 */
	public static Level getLevel(int level) {return LEVELS[level - 1];}

	public static ExampleLevel getExample(int example) {return EXAMPLES[example];}
	
	public String toString() {
		// declare class
		String ret = "LevelCenter";
		// add each Level on a new line
		for (Level level : LEVELS) ret += "\n" + level;
		
		return ret;
	}
}