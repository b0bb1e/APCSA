package blocks;

// for the GUI
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.image.BufferedImage;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

// for handling button clicks
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * An animated instructions screen for Blocks
 * @author faith
 */
@SuppressWarnings("serial")
public class BlocksInstructions extends JPanel implements Runnable, ActionListener {
	/**
	 * Game instructions, in order
	 */
	private static final String[] GAME_I = {
		"You control the green dot with WASD or arrow keys",
		"You can push blocks around",
		"You can only push one block at a time",
		"There are several blue targets on the board",
		"Your goal is to cover all targets with blocks",
		"Neither the dot nor the blocks can move through walls",
		"<html>You score is the number of moves to complete a level<br>"
		+ "The less moves, the better. Press any key to move to the next level</html>"
	};
	
	/**
	 * User instructions, in order
	 */
	private static final String[] USER_I = {
		"You can play as a guest or a named user",
		"<html>Guest users have access to all levels,<br>"
		+ "but cannot get a score on the leaderboard</html>",
		"Named users start only able to access level 1",
		"<html>Once a named user completes a level,<br>"
		+ "they can skip it whenever they want</html>",
		"<html>Named users have their best scores saved<br>"
		+ "(for each level and overall)</html>",
		"<html>If a named user skips a level, their best score for it<br>"
		+ "is pre-added to their overall score</html>",
		"<html>Once a named user completes all built-in levels,<br>"
		+ "then their best overall score appears on the leaderboard</html>"
	};
	
	/**
	 * the current step in the instructions
	 */
	private int step;
	
	/**
	 * multi-use label for any sort of text that needs displaying
	 */
	private JLabel text;
	/**
	 * a button to move to the game-instructions-screen
	 */
	private JButton gameButton;
	/**
	 * a button to move to the user-instructions-screen
	 */
	private JButton userButton;
	/**
	 * a button to exit the instructions screen
	 */
	private JButton backButton;
	/**
	 * a button to move to the next instruction
	 */
	private JButton nextButton;
	/**
	 * the current simulated level
	 */
	private ExampleGrid example;
	/**
	 * an image of the animated simulated game
	 */
	private BufferedImage game;
	
	/**
	 * the value of the current screen displayer
	 */
	public char screen;
	
	/**
	 * a constant for the main instructions screen
	 */
	private static final char MAIN = 'M';
	/**
	 * a constant for the game-instructions-screen
	 */
	private static final char GAME = 'G';
	/**
	 * a constant for the user-instructions-screen
	 */
	private static final char USER = 'U';
	
	/**
	 * the time of the last move in the simulated game
	 */
	private long lastMove;
	/**
	 * the time to wait in-between moves in the simulated game
	 */
	private static final long MOVE_WAIT = 2000000000L;
	
	/**
	 * Set up the instructions screen
	 */
	public BlocksInstructions() {
		// initialize GUI
		initDisplay();
		// hide at first
		setVisible(false);
		
		// start running
		new Thread(this).start();
	}
	
	/**
	 * Initialize all GUI elements
	 */
	private void initDisplay() {
		// set up the general text
		text = new JLabel();
		add(text);
		
		// set up the game button
		gameButton = new JButton("Game");
		addButton(gameButton);
		
		// set up the user button
		userButton = new JButton("Users");
		addButton(userButton);
		
		// set up the back button
		backButton = new JButton("Back");
		addButton(backButton);
		
		// set up the next button
		nextButton = new JButton("Next");
		addButton(nextButton);
	}
	
	/**
	 * Do generalized button set-up
	 * @param button the button to set up
	 */
	private void addButton(JButton button) {
		// the button should send actions but not take focus
		button.addActionListener(this);
		button.setFocusable(false);
		// the button should have a small margin and hide at first
		button.setMargin(new Insets(5, 5, 5, 5));
		button.setVisible(false);
		// add button to self
		add(button);
	}
	
	/**
	 * Displays the instructions screen, start at the main
	 */
	public void display() {displayMainScreen();}
	
	/**
	 * Display the main screen
	 */
	private void displayMainScreen() {
		// save current screen
		screen = MAIN;
		// show self
		setVisible(true);
		// set text to show instructions
		text.setText("What kind of instructions do you want?");
		// display everything but next button
		text.setVisible(true);
		gameButton.setVisible(true);
		userButton.setVisible(true);
		backButton.setVisible(true);
		nextButton.setVisible(false);
	}
	
	/**
	 * Display the game instructions screen
	 */
	private void displayGameScreen() {
		// save current screen
		screen = GAME;
		
		// set up the first game instructions (plus example level!)
		example = new ExampleGrid(LevelCenter.getExample(0));
		step = 0;
		text.setText(GAME_I[0]);
		
		// only text and next button are visible
		text.setVisible(true);
		gameButton.setVisible(false);
		userButton.setVisible(false);
		backButton.setVisible(false);
		nextButton.setVisible(true);
		// save RIGHT NOW as the last move
		lastMove = System.nanoTime();
		// repaint new screen
		repaint();
	}
	
	/**
	 * Display the user instructions screen
	 */
	private void displayUserScreen() {
		// save current screen
		screen = USER;
		
		// set text to show the first user instruction
		step = 0;
		text.setText(USER_I[0]);
		// only text and next-button are visible
		text.setVisible(true);
		gameButton.setVisible(false);
		userButton.setVisible(false);
		backButton.setVisible(false);
		nextButton.setVisible(true);
	}
	
	/**
	 * @return the back button of this Panel, in case someone wants to listen to it
	 */
	public JButton getBackButton() {return backButton;}
	
	public void paintComponent(Graphics window) {
		// draw a the background
		window.setColor(Tile.BACKGROUND_COLOR.darker());
		window.fillRect(0, 0, getWidth(), getHeight());
		
		// if this is the game
		if (screen == GAME) {
			// set up an image to draw the example game on
			game = new BufferedImage(example.getCols() * Tile.SIZE + 200, 
					example.getRows() * Tile.SIZE, BufferedImage.TYPE_INT_ARGB);
			// draw example game onto image
			example.draw(game.createGraphics());
			// draw image onto screen
			((Graphics2D) window).drawImage(game, null, 0, 50);
			// make sure the JPanel is big enough for the image
			setSize(getWidth(), game.getHeight() + 50);
		}
	}

	public void actionPerformed(ActionEvent e) {
		// if the next button was clicked
		if (e.getSource().equals(nextButton)) {
			// for game or use screen, move to next instructions
			if (screen == GAME) {
				if (step == GAME_I.length - 1) displayMainScreen();
				else {
					// game must also move to next example game, and repaint
					example = new ExampleGrid(LevelCenter.getExample(step));
					text.setText(GAME_I[++step]);
				}
				repaint();
			}
			else if (screen == USER) {
				if (step == USER_I.length - 1) displayMainScreen();
				else text.setText(USER_I[++step]);
			}
		}
		// game and user buttons go to respective screens
		else if (e.getSource().equals(gameButton)) displayGameScreen();
		else if (e.getSource().equals(userButton)) displayUserScreen();
	}
	
	public void run() {
		// loop forever
		while (true)
			// this is on the outside to discourage complier optimization
			// if the last move was long enough ago
			if (System.nanoTime() - lastMove > MOVE_WAIT) {
				// reset last move time
				lastMove = System.nanoTime();
				// if this is the game screen
				if (screen == GAME) {
					// do next move and re-display
					example.nextMove();
					repaint();
				}
			}
	}
}