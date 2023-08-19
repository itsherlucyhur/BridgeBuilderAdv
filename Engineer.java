package BridgeBuilderAdv;

/**
 * The Engineer class represents an engineer player in the BridgeBuilder game. 
 * The Engineer makes different moves based on which mode is selected: hard or easy. 
 * @author chaejinhur
 *
 */

public class Engineer {
	private char token; 		// token for engineer's moves 
	private boolean hardMode; 	

	/**
	 * Constructor initializes the engineer's token and mode of the game
	 * @param hardMode True if hard mode is selected, false if easy mode is selected
	 */
	public Engineer(boolean hardMode) {
		this.hardMode = hardMode; 
		token = '0'; 
	}
	
	
	public void makeMove(GameBoard board, int playerLastRow, int playerLastCol) {
		// hard mode: make a move on the board determined by Engineer's strategy 
		if (hardMode == true) {
			int nextCol = playerLastCol + 1; 
			
			// select the next empty position after the player's last position 
			if (nextCol >= board.getSize()) {	// if next column exceeds the size: 
				nextCol = 0; 	// reset it to 0
			} 
				
			// select the topmost empty position in the column 
			for (int row = board.getSize() - 1; row >= 0; row--) {
				if (board.isPositionEmpty(row, nextCol) == true) {		// if a next topmost empty position in the column is found: 
					board.placeToken(row, nextCol, token);		// place the token 
					return; 
				}
			}
			
			// if there's no empty position found: resort to random space
			for (int row = 0; row < board.getSize(); row++) {
				for (int col = 0; col < board.getSize(); col++) {
					if (board.isPositionEmpty(row, nextCol) == true) {
						board.placeToken(row, col, token);
						return; 
					}		
				}
			} 
		}
			
		// EASY MODE: select a random empty position 
		while (hardMode == false) {
			int randomRow = (int) (Math.random() * board.getSize()); 
			int randomCol = (int) (Math.random() * board.getSize()); 
					
			if (board.isPositionEmpty(randomRow, randomCol)) {
				board.placeToken(randomRow, randomCol, token);	// place the token in random empty position 
				break; 
			} 
		}		
	}
			
	public char getToken() {
		return token; 	// return the engineer's token 
	}
	
	
	
} 
