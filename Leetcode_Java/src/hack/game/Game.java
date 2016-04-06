package hack.game;

public interface Game {
	/**
	 * This method will initialize the game. At the end of this method, the
	 * board has been set up and the game can be started
	 * 
	 * @param p1
	 *            Player 1
	 * @param p2
	 *            Player 2
	 */
	void initialize(Player p1, Player p2);

	/**
	 * This is the start point of playing the game. The game will alternate
	 * between the players letting them take shots at the other team.
	 * 
	 * @return Player who won
	 */
	Player playGame();
}
