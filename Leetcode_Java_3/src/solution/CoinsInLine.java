package solution;

/*
 * There are n coins in a line. Two players take turns to take one or two coins from right side until there are no more coins left. The player who take the last coin wins.
Could you please decide the first play will win or lose?
 */
public class CoinsInLine {
	public boolean firstWillWin(int n) {
		return n % 3 != 0;
	}
}
