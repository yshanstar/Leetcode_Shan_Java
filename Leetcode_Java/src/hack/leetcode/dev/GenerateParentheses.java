package hack.leetcode.dev;

import java.util.ArrayList;

/*
 *  Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 * 	For example, given n = 3, a solution set is:
 * 	"((()))", "(()())", "(())()", "()(())", "()()()"
 */
public class GenerateParentheses {
	public static ArrayList<String> generateParenthesis(int n) {
		if (n <= 0) {
			return new ArrayList<String>();
		}

		ArrayList<String> res = new ArrayList<String>();

		Helper(res, 0, 0, n, "");
		return res;
	}

	private static void Helper(ArrayList<String> res, int l, int r, int n, String s) {
		if (l > n || r > n) {
			return;
		}
		if (r == n) {
			res.add(s);
		}
		if (n == 1) {
			res.add("()");
			return;
		}
		Helper(res, l + 1, r, n, s + "(");
		if (l > r) {
			Helper(res, l, r + 1, n, s + ")");
		}
	}

	public static void main(String[] args) {
		ArrayList<String> a = generateParenthesis(3);
		System.out.println(a);
	}
}
