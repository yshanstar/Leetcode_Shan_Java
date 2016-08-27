package hack.leetcode.dev;

import java.util.ArrayList;
import java.util.List;

/*
 * Given an integer n, return 1 - n in lexicographical order.
 * For example, given 13, return: [1,10,11,12,13,2,3,4,5,6,7,8,9].
 * Please optimize your algorithm to use less time and space. The input size may be as large as 5,000,000
 */
public class LexicographicalNumbers {
	public List<Integer> lexicalOrder(int n) {
		if (n <= 0) {
			return new ArrayList<Integer>();
		}

		List<Integer> res = new ArrayList<Integer>();
		res.add(1);

		for (int i = 1, prev = 1; i < n; ++i) {
			if (prev * 10 <= n) {
				prev *= 10;
			} else {
				while (prev % 10 == 9 || prev == n) {
					prev /= 10;
				}
				prev++;
			}

			res.add(prev);
		}

		return res;
	}
}
