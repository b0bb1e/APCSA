package practiceFRQs.practice_1_3;

import java.util.ArrayList;

public class TileGame {
	private ArrayList<NumberTile> board;
	
	public TileGame() {board = new ArrayList<NumberTile>();}
	
	private int getIndexForFit(NumberTile tile) {
		if (board.size() == 0) return 0;
		if (tile.getRight() == board.get(0).getLeft())
			return 0;
		else if (tile.getLeft() == board.get(board.size() - 1).getRight())
			return board.size();
		
		for (int right = 1; right < board.size(); right++) {
			if (tile.getLeft() == board.get(right - 1).getRight() &&
					tile.getRight() == board.get(right).getLeft())
				return right;
		}
		return -1;
	}
	
	public boolean insertTile(NumberTile tile) {
		if (board.size() == 0) {
			board.add(tile);
			return true;
		}
		for (int i = 0; i < 4; i++) {
			int fitIndex = getIndexForFit(tile);
			if (fitIndex != -1) {
				board.add(fitIndex, tile);
				return true;
			}
			tile.rotate();
		}
		return false;
	}
}