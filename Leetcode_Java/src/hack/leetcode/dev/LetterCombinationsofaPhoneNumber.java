package hack.leetcode.dev;

import java.util.ArrayList;

/*
 * Given a digit string, return all possible letter combinations that the number could represent.
 * A mapping of digit to letters (just like on the telephone buttons) is given below.
 */
public class LetterCombinationsofaPhoneNumber {
	public ArrayList<String> letterCombinations(String digits) {
		char[][] map = new char[][] { { 'a', 'b', 'c' }, { 'd', 'e', 'f' }, { 'g', 'h', 'i' }, { 'j', 'k', 'l' }, { 'm', 'n', 'o' },
				{ 'p', 'q', 'r', 's' }, { 't', 'u', 'v' }, { 'w', 'x', 'y', 'z' } };

		ArrayList<String> ret = new ArrayList<String>();
		StringBuilder sb = new StringBuilder();
		helper(ret, sb, map, 0, digits);
		return ret;
	}

	private void helper(ArrayList<String> ret, StringBuilder sb, char[][] map, int idx, String digits) {
		if (idx >= digits.length()) {
			ret.add(sb.toString());
			return;
		} else {
			int index = digits.charAt(idx) - '1' - 1;
			int size = map[index].length;
			for (int i = 0; i < size; i++) {
				sb.append(map[index][i]);
				helper(ret, sb, map, idx + 1, digits);
				sb.deleteCharAt(sb.length() - 1);
			}
		}
	}
}
