package BridgeBuilderAdv;

/**
 * The Player class represents a player in the BridgeBuilder game. 
 * A player has a token that shows where they've made their moves. 
 * At the end of the game, the scores will be returned to show the Player's total points. 
 * @author chaejinhur
 *
 */
public class Player {	
	private char token; 	
	private int score; 

	// constructor for Player 
	public Player() {
		this.token = '+'; 	// token for marking player's moves 
		this.score = 0; 	// player's score initialized 
	}
	
	// places the player's token on the game board at specified row 
	public void makeMove(GameBoard board, int row, int col) {
		board.placeToken(row, col, token); 	// place the player's token on the board to make a move 
	}
	
	/**
	 * Returns the plaeyr's token 
	 * @return the player's token 
	 */
	public char getToken() {
		return token; 	
	}
	
	/**
	 * Returns the player's score 
	 * @return the player's current score 
	 */
		public int getScore() {
			return score; 	
	}
		
	
	/**
	 * Adds the specified increment to the score 
	 * @param increment the score increment 
	 */
	public void addScore (int increment) {
		score += increment; 	
	}
	
	
}
