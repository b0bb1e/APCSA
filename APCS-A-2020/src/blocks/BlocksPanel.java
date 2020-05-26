package blocks;

// for the GUI
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.TextField;
import java.awt.Component;
import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JRadioButton;

// for handling events (button clicks & key presses)
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * A fully-functional GUI for playing Blocks
 * @author faith
 */
@SuppressWarnings("serial")
public class BlocksPanel extends JPanel implements ActionListener {
	/**
	 * the User playing the game
	 */
	private User user;
	/**
	 * the current game-board
	 */
	private Grid game;
	/**
	 * the number of the current level (1-indexed)
	 */
	private int curLevel;
	/**
	 * the player's cumulative score
	 */
	private int score;
	/**
	 * the player's score for this level
	 */
	private int levelScore;
	
	/**
	 * the current screen being displayed
	 */
	private char screen;
	
	/**
	 * a constant for the introduction screen
	 */
	private static final char INTRO = 'I';
	/**
	 * a constant for the instructions screen
	 */
	private static final char INSTRUCTIONS = 'S';
	/**
	 * a constant for the credits screen
	 */
	private static final char CREDITS = 'C';
	/**
	 * a constant for the user-choice screen
	 */
	private static final char USER_CHOICE = 'U';
	/**
	 * a constant for the level-choice screen
	 */
	private static final char LEVEL_CHOICE = 'L';
	/**
	 * a constant for the game screen
	 */
	private static final char GAME = 'G';
	/**
	 * a constant for the ending screen
	 */
	private static final char END = 'E';
	
	/**
	 * a multi-use label, providing any necessary information
	 */
	private JLabel infoMessage;
	/**
	 * the button indicating a desire to transition to the next screen
	 */
	private JButton nextButton;
	
	/**
	 * the intro-screen button for entering the instructions screen
	 */
	private JButton instructionsButton;
	/**
	 * a JPanel which displays instructions
	 */
	private BlocksInstructions instructionsPanel;
	/**
	 * the intro-screen button for entering the credits screen
	 */
	private JButton creditsButton;
	
	/**
	 * the entry field for a username
	 */
	private TextField userNameEntry;
	/**
	 * the group of buttons determining user or guest
	 */
	private ButtonGroup userChoice;
	/**
	 * the guest user button
	 */
	private JRadioButton guest;
	/**
	 * the non-guest user button
	 */
	private JRadioButton nonGuest;
	
	/**
	 * the group of buttons determining starting level
	 */
	private ButtonGroup levelChoice;
	/**
	 * an array of all buttons for starting level choosing
	 */
	private JRadioButton[] levelButtons;
	
	/**
	 * the game-screen button for undoing a move
	 */
	private JButton undoButton;
	/**
	 * the game-screen button for reseting a level
	 */
	private JButton resetButton;
	
	/**
	 * a list of all Components on the JPanel for easy iteration
	 */
	private Component[] allComponents;	
	
	/**
	 * all of the lines of credits, in order
	 */
	private static final String[] CREDITS_LINES = {
			"Idea: Puzzlerama (mobile app)",
			"Code: Faith Okamoto",
			"Graphics: Faith Okamoto + javax.swing",
			"Made for: APCSA final project",
			"Much credit to: Stack Overflow, Oracle docs",
			"Used as a break: Stack Exchange, various books",
			"Tester: Lori Okamoto (however unwillingly)"
	};
	/**
	 * the index of the current line in CREDIST_LINES
	 */
	private int creditsIndex;
	
	/**
	 * Set up a Blocks game
	 */
	public BlocksPanel() {
		// initialize the GUI elements
		initDisplay();
		// assume that the game starts at level 1
		curLevel = 1;
		
		// start listening to mouse clicks
		addKeyListener(new MyKeyListener());
		// make self visible
		setVisible(true);
		
		// display the introduction screen
		displayIntroScreen();
	}
	
	/**
	 * Initialize all GUI elements
	 */
	private void initDisplay() {
		// initialize the user-choice buttons
		userChoice = new ButtonGroup();
		// set up the guest-button
		guest = new JRadioButton("Play as guest", true);
		addButton(guest, userChoice);
		// set up the non-guest-button
		nonGuest = new JRadioButton("Play as user:", false);
		addButton(nonGuest, userChoice);

		// set up the username entry field
		userNameEntry = new TextField(20);
		add(userNameEntry);
		
		// initialize the level-choice button group
		levelChoice = new ButtonGroup();
		// initialize the array of level buttons to the proper size
		levelButtons = new JRadioButton[LevelCenter.numLevels];
		// for each level button that needs to be set up
		for (int level = 1; level <= LevelCenter.numLevels; ++level) {
			// set up the level button
			levelButtons[level - 1] = new JRadioButton("Level " + level, false);
			// level buttons need an action command, which is just their level
			levelButtons[level - 1].setActionCommand("" + level);
			levelButtons[level - 1].setOpaque(false);
			addButton(levelButtons[level - 1], levelChoice);
		}
		
		// set up the information message
		infoMessage = new JLabel();
		add(infoMessage);
		
		// set up the next-screen button
		nextButton = new JButton("Next");
		addButton(nextButton, null);
		
		// set up the undo button
		undoButton = new JButton("Undo");
		addButton(undoButton, null);
		
		// set up the reset button
		resetButton = new JButton("Reset");
		addButton(resetButton, null);
		
		// set up the instructions button
		instructionsButton = new JButton("Instructions");
		addButton(instructionsButton, null);
		
		// set up the credits button
		creditsButton = new JButton("Credits");
		addButton(creditsButton, null);
		
		// set up inner instructions panel
		instructionsPanel = new BlocksInstructions();
		// listen for its back button
		instructionsPanel.getBackButton().addActionListener(this);
		add(instructionsPanel);
		
		// add all Components into an array, in no particular order
		allComponents = new Component[levelButtons.length + 10];
		allComponents[0] = creditsButton;
		allComponents[1] = resetButton;
		allComponents[2] = instructionsButton;
		allComponents[3] = undoButton;
		allComponents[4] = guest;
		allComponents[5] = nonGuest;
		allComponents[6] = userNameEntry;
		allComponents[7] = infoMessage;
		allComponents[8] = nextButton;
		allComponents[9] = instructionsPanel;
		for (int i = 0; i < levelButtons.length; ++i)
			allComponents[i + 10] = levelButtons[i];
	}
	
	/**
	 * Do generalized button set-up
	 * @param button the button to set up
	 * @param group the group to add to (if applicable)
	 */
	private void addButton(AbstractButton button, ButtonGroup group) {
		// the button should send actions but not take focus
		button.addActionListener(this);
		button.setFocusable(false);
		// add button to self & group (if applicable)
		if (group != null) group.add(button);
		// if no group, then decrease margins
		else button.setMargin(new Insets(5, 5, 5, 5));
		add(button);
	}
	
	/**
	 * Display the introductory screen
	 */
	private void displayIntroScreen() {
		// save current screen
		screen = INTRO;
		// no layout on start screen
		setLayout(null);
		
		// set up game title and buttons
		infoMessage.setText("A game of BLOCKS for the blockheads out there");
		infoMessage.setBounds(100, 100, 300, 50);
		creditsButton.setBounds(100, 200, 125, 50);
		nextButton.setBounds(175, 300, 125, 50);
		instructionsButton.setBounds(250, 200, 125, 50);
		// make sure only title and buttons are visible
		setOnlyVisible(new Component[] {infoMessage, creditsButton, instructionsButton, nextButton});
	}
	
	/**
	 * Display the user-choice screen
	 */
	private void displayUserChoiceScreen() {
		// note the screen
		screen = USER_CHOICE;
		setLayout(new FlowLayout());
		// make user-choice stuff visible
		setOnlyVisible(new Component[] {guest, nonGuest, userNameEntry, nextButton});
	}

	/**
	 * Display the level-choice screen
	 */
	private void displayLevelChoiceScreen() {
		// save current screen
		screen = LEVEL_CHOICE;
		
		//save the name entered in userNameEntry
		String name = userNameEntry.getText();
		// if a username wasn't given
		if (name.isBlank()) {
			// set user to null (guest user)
			user = null;
			// don't mention user in level-choice message
			infoMessage.setText("Choose level!");
		}
		// if a username was given
		else {
			// attempt to get the user by this name
			user = UserCenter.getUser(name);
			// if there was no user, make a new one
			if (user == null) user = UserCenter.addUser(name);
			// mention user in level-choice message
			infoMessage.setText(name + ", choose level!");
		}
		
		// make level-choice stuff visible
		setOnlyVisible(new Component[] {infoMessage, nextButton});
		// set up level buttons specially
		for (JRadioButton button : levelButtons) {
			button.setVisible(true);
			// enable all levels for a guest user, or 
			// enable levels one past previously completed
			button.setEnabled(user == null || 
					Integer.parseInt(button.getActionCommand()) <= 
					user.lastCompletedLevel() + 1);
		}
		// select level 1
		levelButtons[0].setSelected(true);
	}

	/**
	 * Display the introductory screen
	 */
	private void displayInstructionsScreen() {
		// save current screen
		screen = INSTRUCTIONS;
		
		// flow-layout to get inner panel to display
		setLayout(new FlowLayout());
		
		// make everything invisible
		setOnlyVisible(new Component[] {});
		// display instructions
		instructionsPanel.display();
	}
	
	/**
	 * Display the credits screen
	 */
	private void displayCreditsScreen() {
		// save current screen
		screen = CREDITS;
		
		// set up text to display first line of credits
		infoMessage.setText(CREDITS_LINES[0]);
		creditsIndex = 0;
		infoMessage.setBounds(50, 50, 400, 50);
		// set up next-button
		nextButton.setBounds(50, 200, 100, 50);
		// display only text and next-button
		setOnlyVisible(new Component[] {infoMessage, nextButton});
	}
	
	/**
	 * Display the game screen
	 */
	private void displayGameScreen() {
		// save current screen
		screen = GAME;
		
		// no layout for the game (just drawing shapes, really)
		setLayout(null);
		// set up the game with the correct level
		game = new Grid(LevelCenter.getLevel(curLevel));
		// cumulative score is 0 if this is the first level OR a guest user
		if (curLevel == 1 || user == null) score = 0;
		// or use the best score up to the level before
		else score = user.getMinScoreUpTo(curLevel - 1);
		// level score always begins at 0
		levelScore = 0;
		
		// only info, undo, and reset are visible
		setOnlyVisible(new Component[] {infoMessage, undoButton, resetButton});
		
		// set up the level-info for the info message
		infoMessage.setText("Level " + curLevel + ": Level Score = 0, "
				+ "Cumalative score = " + score);
		// position info, undo, and reset
		infoMessage.setBounds(10, (game.getRows() + 2) * Tile.SIZE, 300, 25);
		undoButton.setBounds((game.getCols() + 2) * Tile.SIZE, 10, 50, 50);
		resetButton.setBounds((game.getCols() + 2) * Tile.SIZE + 75, 10, 50, 50);
		
		repaint();
	}

	/**
	 * Display the end screen
	 */
	private void displayEndScreen() {
		// save current screen
		screen = END;
		
		// if this is a named user, save their over-all score
		if (user != null) user.setMinScore(score);
		// initialize the leaderboard string
		String leaderboard = "<html>Leaderboard<br>";
		// for each user on the leaderboard
		for (User leader : UserCenter.getLeaderboard()) {
			// add this user's name
			leaderboard += leader.getName();
			// add enough dots to extend name to 25 chars
			for (int dot = 0; dot < 25 - leader.getName().length(); ++dot) 
				leaderboard += ".";
			// add their score and a line break
			leaderboard += leader.getMinScore() + "<br>";
		}
		// cap off leaderboard string
		leaderboard += "</html>";
		
		// only info-message with leaderboard should be visible
		setOnlyVisible(new Component[] {infoMessage});
		// set info-message to show leaderboard, and position
		infoMessage.setText(leaderboard);
		infoMessage.setBounds(getWidth() / 2 - 50, 10, 200, 400);
		
		// repaint new display
		repaint();
	}
	
	/**
	 * Set only selected Components on Panel to be visible
	 * @param visibles the Components that should be visible
	 */
	private void setOnlyVisible(Component[] visibles) {
		// first, set everything to invisible
		for (Component comp : allComponents) comp.setVisible(false);
		// then make visible visible
		for (Component comp : visibles) comp.setVisible(true);
	}
	
	public void paintComponent(Graphics window) {
		// draw a the background
		window.setColor(Tile.BACKGROUND_COLOR.darker());
		window.fillRect(0, 0, getWidth(), getHeight());

		// if the game is going on, draw it
		if (screen == GAME) game.draw(window);
	}
	
	public void actionPerformed(ActionEvent e) {
		// if the guest-button is clicked
		if (e.getSource().equals(guest)) {
			// clear, and disable, the username entry field
			userNameEntry.setText("");
			userNameEntry.setEnabled(false);
		}
		
		// if the non-guest button is clicked
		else if (e.getSource().equals(nonGuest))
			// enable the username entry field
			userNameEntry.setEnabled(true);
		
		// if the next-button is clicked
		else if (e.getSource().equals(nextButton)) {
			// go from intro screen to user-choice screen
			if (screen == INTRO) displayUserChoiceScreen();
			// on credits screen, go to next line of credits or, if out, back to intro
			else if (screen == CREDITS) {
				if (creditsIndex == CREDITS_LINES.length - 1) displayIntroScreen();
				else infoMessage.setText(CREDITS_LINES[++creditsIndex]);
			}
			// go from user-choice screen to level-choice screen
			else if (screen == USER_CHOICE) displayLevelChoiceScreen();
			// go from level-choice screen to game screen
			else if (screen == LEVEL_CHOICE) displayGameScreen();
		}
		
		// if the undo-button is clicked
		else if (e.getSource().equals(undoButton)) {
			// if undoing works
			if (game.undo()) {
				// decrease move-count scores and display
				infoMessage.setText("Level " + curLevel + ": Level score = " + 
						(--levelScore) + ", Cumalative score = " + (--score));
				// repaint new game
				repaint();
			}
		}
			
		// if the reset-button is clicked
		else if (e.getSource().equals(resetButton)) {
			// get rid of the score for this level
			score -= levelScore;
			levelScore = 0;
			// set the new info-message
			infoMessage.setText("Level " + curLevel + ": Level score = 0, "
					+ "Cumalative score = " + score);
			// reset the game to the current level's grid
			game = new Grid(LevelCenter.getLevel(curLevel));
			// repaint new display
			repaint();
		}
		
		// if the instructions-button is clicked, display instructions
		else if (e.getSource().equals(instructionsButton))
			displayInstructionsScreen();

		// if the credits-button is clicked, display credits
		else if (e.getSource().equals(creditsButton)) {
			displayCreditsScreen();
		}
		
		// if the instructions back-button is clicked, display intro
		else if (e.getSource().equals(instructionsPanel.getBackButton()))
			displayIntroScreen();
		
		// if one of the level buttons was clicked
		else if (e.getActionCommand() != null)
			// set the current level to its command
			curLevel = Integer.parseInt(e.getActionCommand());
	}
	
	/**
	 * Move to the next level
	 */
	private void nextLevel() {
		// if there is a user, save their score for this level
		if (user != null) user.setMinLevelScore(curLevel, levelScore);
		// reset the level score
		levelScore = 0;
		
		// if this is the last level, show the win-message
		if (curLevel == LevelCenter.numLevels) displayEndScreen();
		// otherwise, move to next level
		else {
			// generate the grid for the next level
			game = new Grid(LevelCenter.getLevel(++curLevel));
			// reset info message
			infoMessage.setText("Level " + curLevel + ": Level score = 0, "
					+ "Cumalative score = " + score);
			// re-calculate positions for info & buttons
			infoMessage.setBounds(10, (game.getRows() + 2) * Tile.SIZE, 300, 25);
			undoButton.setBounds((game.getCols() + 2) * Tile.SIZE, 10, 50, 50);
			resetButton.setBounds((game.getCols() + 2) * Tile.SIZE + 75, 10, 50, 50);
			// repaint the new display
			repaint();
		}
	}
	
	/**
	 * A key listener for the Blocks game
	 * @author faith
	 */
	private class MyKeyListener implements KeyListener {
		/**
		 * Ignore keyTyped events
		 */
		public void keyTyped(KeyEvent e) {}

		public void keyPressed(KeyEvent e) {
			// if currently playing
			if (screen == GAME) {
				// if the game is won move to the next level
				if (game.checkWin()) nextLevel();
				// otherwise attempt to process move
				else {
					// save the key pressed
					int key = e.getKeyCode();
					// set direction to move to an invalid one
					byte dir = Byte.MIN_VALUE;
					
					// W & up arrow set direction to UP
					if (key == KeyEvent.VK_W || key == KeyEvent.VK_UP)
						dir = Grid.UP;
					// D & right arrow set direction to RIGHT
					else if (key == KeyEvent.VK_D || key == KeyEvent.VK_RIGHT)
						dir = Grid.RIGHT;
					// S & down arrow set direction to DOWN
					else if (key == KeyEvent.VK_S || key == KeyEvent.VK_DOWN)
						dir = Grid.DOWN;
					// A & left arrow set direction to LEFT
					else if (key == KeyEvent.VK_A || key == KeyEvent.VK_LEFT)
						dir = Grid.LEFT;
					
					// if the move was successful
					if (dir != Byte.MIN_VALUE && game.movePlayer(dir)) {
						// update/display move-score counters
						infoMessage.setText("Level " + curLevel + ": Level score = " + 
								(++levelScore) + ", Cumalative score = " + (++score));
						// repaint new display
						repaint();
					}
				}
			}
		}

		/**
		 * Ignore keyReleased events
		 */
		public void keyReleased(KeyEvent e) {}
	}
}