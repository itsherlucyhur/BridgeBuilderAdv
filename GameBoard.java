package BridgeBuilderAdv;

/**
 * The GameBoard class represents the game board for the BridgeBuilder game, where a Player and an Engineer play against each other. 
 * Tokens are placed using the placeToken() method, checkForWinDirection() checks for wins by iterating over rows and columns. 
 * The class also includes methods to display the board and to check if a position is empty or not. 
 * 
 * The approach for designing the game started with creating a constructor to initialize the board with a 2D char array, and initially presenting the empty positions with '.''s. 
 * The placeToken() method allows tokens to be placed at certain positions on the board. The checkForWinDirection() method checks for winning conditions by iterating 
 * over rows and columns to compare the number of tokens to the size of the board. The Player class represented a player in the game and had methods to place tokens and 
 * manage the score. The Engineer class was implemented to represent different modes for making moves on the board. The implementation of the game involved initializing the board, 
 * allowing each player and engineer to place their tokens, checking for wins in different directions, and verifying ties. 
 * 
 * One challenge was programming the hard mode, specifically determining the next empty position after the player's last position and finding the topmost empty position in 
 * a column if none were available. I had to overcome this by resetting the column index if it becomes greater than the board size, then iterating in reverse to find the next 
 * topmost empty position in the column. 
 * 
 * To test the solution, different scenarios were considered, such as by placing tokens in different positions, varying board sizes,
 * checking for wins in different directions (left-to-right, bottom-to-top bridge, and diagonal bridge), as well as verifying ties
 * between the Player and the Engineer. 
 * 
 * @author chaejinhur
 * 
 */

public class GameBoard {
	// private variables 
	private char[][] board; 	
	private int size; 
	
	/**
	 * Constructor for the GameBoard class 
	 * Initializes the game board with a specified size and initialize all positions as empty 
	 * @param size Size of the game board 
	 */
	public GameBoard(int size) {
		this.size = size; 
		board = new char[size][size]; 	// initialize 2d char array for board 
		
		// set all board positions as empty with '.'
		for (int row = 0; row < size; row++) {
			for (int col = 0; col < size; col++) {
				board[row][col] = '.'; 
			}
		}
	}
	
	
	public void placeToken(int row, int col, char token) {
		if (row >= 0 && row < size && col >= 0 && col < size) {
			board[row][col] = token;		// place the token at the specified position 
		} 
	}
	
	
	public boolean isPositionEmpty (int row, int col) {
		// check if the positions of row and column are smaller than the board size 
		if (row >= 0 && row < size && col >= 0 && col < size) {		
			// check if the position is an empty position ('.')
			if (board[row][col] == '.') {
				return true; 		// empty position 
			}
		} else {
			return false; 	// position out of bounds 
		}
		return false; 	// not empty 
	}
	
	
	public int getSize() {
		return size; 		// return size of board 
		
	}
	
	public void displayBoard() {
		System.out.print("  "); 	// indent before column headers for the board format  
		// loop over the columns to print the column headers 
	    char[] columnLabels = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
		for (int col = 0; col < size; col++) {
			char label = columnLabels[col]; 
			System.out.print(label + " "); 
		} 
		System.out.println(); 
		
		for (int row = 0; row < size; row++) {
			System.out.print(row + " ");		// print row number 
			
			for (int col = 0; col < size; col++) {
				System.out.print(board[row][col] + " "); 		// displays contents of each cell in row 
			}
			System.out.println(); 
		} 
	}
	
	public int checkForWinDirection(Player player) {		
		// left-to-right win: 
		for (int row = 0; row < size; row++) {
			int countRow = 0; 					// counter for rows 
			int countCol = 0; 					// counter for columns 
			
			for (int col = 0; col < size; col++) {
				if (board[row][col] == player.getToken()) {
					countRow++; 				// increment for rows 
				}
				if (board[row][col] == player.getToken()) {
					countCol++; 				// increment for columns
				}
			} 
			
			if (countRow == size || countCol == size) {		// check if either rows or columns are equal to the size 
				return 1; 
			} 	
		}
		
		// bottom-to-top win:  
		for (int col = 0; col < size; col++) {
			int count = 0; 
			for (int row = 0; row < size; row++) {
				if (board[row][col] == player.getToken()) {
					count++; 
				}
				if (count == size) {	// player wins when count of tokens placed in the same column is equal to the board size 
					return 2; 		
				}
			}
		}
			
		// top-left to bottom-right diagonal win: 
		int countDiagonal =0; 
		for (int i = 0; i < size; i++) {
			if (board[i][i] == player.getToken()) {
				countDiagonal++; 
			}
		} 
		if (countDiagonal == size) {
			if (size > 3) {
				return 10 + size; 	// diagonal win with bonus points based on size 
			} 
			return 10; 	// regular diagonal win 
		}
		
		// no win: 
		return 0; 
	}
	
	
	public boolean checkForTie() {
		for (int row = 0; row < size; row++) {
			for (int col = 0; col < size; col++) {
				if (board[row][col] == '.') {
					return false; 	// not all positions are filled, so not a tie 
				}
			}
		}
		return true; 	// all positions are filled, so it's a tie 
		
	}

} 