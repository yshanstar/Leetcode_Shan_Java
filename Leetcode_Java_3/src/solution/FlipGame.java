package solution;

import java.util.ArrayList;
import java.util.List;

/*
 * ou are playing the following Flip Game with your friend: Given a string that contains only these two characters: + and -, you and your friend take turns to flip two consecutive "++" into "--". The game ends when a person can no longer make a move and therefore the other person will be the winner.

 Write a function to compute all possible states of the string after one valid move.

 For example, given s = "++++", after one move, it may become one of the following states:

 [
 "--++",
 "+--+",
 "++--"
 ]
 If there is no valid move, return an empty list [].
 */
public class FlipGame {
	public List<String> generatePossibleNextMoves(String s) {
		List<String> res = new ArrayList<String>();

		if (s.length() < 2) {
			return res;
		}

		for (int i = 0; i < s.length() - 1; i++) {
			if (s.charAt(i) != '+') {
				continue;
			}

			if (s.charAt(i) != s.charAt(i + 1)) {
				continue;
			}

			StringBuilder sb = new StringBuilder();
			char c = s.charAt(i);
			switch (c) {
			case '+':
				sb.append(s.substring(0, i));
				sb.append("--");
				sb.append(s.substring(i + 2));
				break;
			default:
				break;
			}
			res.add(sb.toString());
		}

		return res;
	}
}
