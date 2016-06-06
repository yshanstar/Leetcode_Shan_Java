package hack.leetcode.dev;

import java.util.HashSet;
import java.util.Set;

/*
 *Write an algorithm to determine if a number is "happy".
 A happy number is a number defined by the following process: Starting with any positive integer, replace the number by the sum of the squares of its digits, and repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1. Those numbers for which this process ends in 1 are happy numbers.

 Example: 19 is a happy number

 12 + 92 = 82
 82 + 22 = 68
 62 + 82 = 100
 12 + 02 + 02 = 1
 * 
 */

public class HappyNumber {
	public boolean isHappy(int n) {
		Set<Integer> nums = new HashSet<Integer>();

		while (!nums.contains(n)) {
			nums.add(n);

			n = getSum(getDigits(n));

			if (n == 1) {
				return true;
			}
		}

		return false;
	}

	private int getSum(int[] nums) {
		int sum = 0;
		for (int i : nums) {
			sum += i * i;
		}
		return sum;
	}

	private int[] getDigits(int n) {
		String s = String.valueOf(n);

		int[] res = new int[s.length()];
		int i = 0;

		while (n > 0) {
			int m = n % 10;
			res[i++] = m;
			n = n / 10;
		}

		return res;
	}
}
