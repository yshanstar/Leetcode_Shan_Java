package hack.leetcode.dev;

import java.util.ArrayList;
import java.util.Arrays;

/*
 * Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? 
 * Find all unique triplets in the array which gives the sum of zero.
 * Note:
 * Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c)
 * The solution set must not contain duplicate triplets.
 * For example, given array S = {-1 0 1 2 -1 -4},
 * A solution set is:
 * (-1, 0, 1)
 * (-1, -1, 2)
 */
public class ThreeSum2 {
	public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		if (num.length < 3) {
			return res;
		}
		Arrays.sort(num);
		for (int i = 0; i < num.length; i++) {
			if (i != 0 && num[i] == num[i - 1]) {
				continue;
			}
			int j = i + 1;
			int k = num.length - 1;
			while (j < k) {
				int sum_two = num[j] + num[k];
				if (sum_two + num[i] > 0) {
					k--;
				} else if (sum_two + num[i] < 0) {
					j++;
				} else {
					ArrayList<Integer> list = new ArrayList<Integer>();
					list.add(num[i]);
					list.add(num[j]);
					list.add(num[k]);
					res.add(list);

					k--;
					j++;
					while (j < k && num[j] == num[j - 1]) {
						j++;
					}
					while (j < k && num[k] == num[k + 1]) {
						k--;
					}
				}
			}
		}
		return res;
	}
}
