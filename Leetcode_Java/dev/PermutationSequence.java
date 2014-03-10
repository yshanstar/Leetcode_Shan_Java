package hack.leetcode.dev;

import java.util.ArrayList;

/*
 * The set [1,2,3,…,n] contains a total of n! unique permutations.
 * By listing and labeling all of the permutations in order,
 * We get the following sequence (ie, for n = 3):
 "123"
 "132"
 "213"
 "231"
 "312"
 "321"
 * Given n and k, return the kth permutation sequence.
 * Note: Given n will be between 1 and 9 inclusive.
 */
public class PermutationSequence {
	public static String getPermutation(int n, int k) {
		if (k <= 0 || n == 0) {
			return "";
		}

		ArrayList<Integer> nums = new ArrayList<Integer>();
		for (int i = 1; i <= n; i++) {
			nums.add(i);
		}

		StringBuilder sb = new StringBuilder();

		int[] res = new int[n];
		res[0] = 1;
		for (int i = 1; i <= n - 1; i++) {
			res[i] = res[i - 1] * i;
		}
		for (int i = n - 1; i >= 0; i--) {
			int s = 1;
			while (k > res[i]) {
				k -= res[i];
				s++;
			}
			int idx = (s != 0) ? s - 1 : nums.size() - 1;
			sb.insert(n - i - 1, nums.get(idx));
			nums.remove(idx);
		}

		return sb.toString();
	}

	public static String getPermutation2(int n, int k) {
		// Start typing your Java solution below
		// DO NOT write main() function
		boolean[] output = new boolean[n];
		StringBuilder buf = new StringBuilder("");
		int[] res = new int[n];
		res[0] = 1;
		for (int i = 1; i < n; i++)
			res[i] = res[i - 1] * i;

		for (int i = n - 1; i >= 0; i--) {
			int s = 1;
			while (k > res[i]) {
				s++;
				k -= res[i];
			}
			for (int j = 0; j < n; j++) {
				if (j + 1 <= s && output[j]) {
					s++;
				}
			}
			output[s - 1] = true;
			buf.append(Integer.toString(s));
		}
		return buf.toString();
	}

	public static void main(String[] args) {
		System.out.println(getPermutation(4, 7));
	}
}
