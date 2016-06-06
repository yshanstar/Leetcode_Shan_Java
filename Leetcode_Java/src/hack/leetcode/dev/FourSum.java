package hack.leetcode.dev;

import java.util.ArrayList;
import java.util.Arrays;

/*
 * Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target? 
 * Find all unique quadruplets in the array which gives the sum of target.
 * Note:
 * â€¢Elements in a quadruplet (a,b,c,d) must be in non-descending order. (ie, a â‰? b â‰? c â‰? d)
 * â€¢The solution set must not contain duplicate quadruplets.
 * For example, given array S = {1 0 -1 0 -2 2}, and target = 0.
 * A solution set is:
 * (-1,  0, 0, 1)
 * (-2, -1, 1, 2)
 * (-2,  0, 0, 2)
 */
public class FourSum {
	public ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		Arrays.sort(num);
		if (num == null || num.length == 0) {
			return res;
		}

		for (int i = 0; i <= num.length - 4; i++) {
			if (i != 0 && num[i] == num[i - 1]) {
				continue;
			}
			for (int j = i + 1; j <= num.length - 3; j++) {
				if (j != i + 1 && num[j] == num[j - 1]) {
					continue;
				}
				getRestCandidates(num, i, j, j + 1, num.length - 1, target, res);
			}
		}

		return res;
	}

	private void getRestCandidates(int[] num, int i, int j, int p, int q, int target, ArrayList<ArrayList<Integer>> res) {
		while (p < q) {
			int sum = num[i] + num[j] + num[p] + num[q];
			if (sum < target) {
				p++;
			} else if (sum > target) {
				q--;
			} else {
				ArrayList<Integer> tmp = new ArrayList<Integer>();
				tmp.add(num[i]);
				tmp.add(num[j]);
				tmp.add(num[p]);
				tmp.add(num[q]);
				res.add(tmp);
				p++;
				q--;
				while (p < q && num[p] == num[p - 1]) {
					p++;
				}
				while (p < q && num[q] == num[q + 1]) {
					q--;
				}
			}
		}
	}
}
