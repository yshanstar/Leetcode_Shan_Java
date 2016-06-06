package hack.leetcode.dev;

/*
 * You are playing the following Bulls and Cows game with your friend: You write a 4-digit secret number and ask your friend to guess it, each time your friend guesses a number, you give a hint, the hint tells your friend how many digits are in the correct positions (called "bulls") and how many digits are in the wrong positions (called "cows"), your friend will use those hints to find out the secret number.

 For example:

 Secret number:  1807
 Friend's guess: 7810
 Hint: 1 bull and 3 cows. (The bull is 8, the cows are 0, 1 and 7.)
 According to Wikipedia: "Bulls and Cows (also known as Cows and Bulls or Pigs and Bulls or Bulls and Cleots) is an old code-breaking mind or paper and pencil game for two or more players, predating the similar commercially marketed board game Mastermind. The numerical version of the game is usually played with 4 digits, but can also be played with 3 or any other number of digits."

 Write a function to return a hint according to the secret number and friend's guess, use A to indicate the bulls and B to indicate the cows, in the above example, your function should return 1A3B.

 You may assume that the secret number and your friend's guess only contain digits, and their lengths are always equal.
 */
public class BullsandCows {
	public String getHint(String secret, String guess) {
		int bCount = 0;
		int cCount = 0;

		int[] secrets = new int[10];
		int[] guesses = new int[10];

		if (secret.length() != guess.length() || secret.isEmpty()) {
			return "0A0B";
		}

		for (int i = 0; i < secret.length(); i++) {
			char c1 = secret.charAt(i);
			char c2 = guess.charAt(i);
			if (c1 == c2) {
				++bCount;
			} else {
				++secrets[c1 - '0'];
				++guesses[c2 - '0'];
			}
		}

		for (int i = 0; i < secrets.length; i++) {
			cCount += Math.min(secrets[i], guesses[i]);
		}

		return bCount + "A" + cCount + "B";
	}

	public static void main(String[] args){
		BullsandCows test = new BullsandCows();
		test.getHint("1", "0");
	}
}
