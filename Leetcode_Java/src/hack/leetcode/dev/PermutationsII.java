package hack.leetcode.dev;

import java.util.ArrayList;
import java.util.Arrays;

/*
 * Given a collection of numbers that might contain duplicates, return all possible unique permutations.
 * For example,
 * [1,1,2] have the following unique permutations:
 * [1,1,2], [1,2,1], and [2,1,1].
 */
public class PermutationsII {
	public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		Arrays.sort(num);

		ArrayList<Integer> tmp = new ArrayList<Integer>();
		int n = num.length;
		boolean[] visited = new boolean[n];
		helper(num, visited, 0, res, tmp);
		return res;
	}

	private void helper(int[] num, boolean[] visited, int idx, ArrayList<ArrayList<Integer>> res, ArrayList<Integer> tmp) {
		if (tmp.size() == num.length) {
			res.add(new ArrayList<Integer>(tmp));
			return;
		}
		for (int i = 0; i < num.length; i++) {
			if (!visited[i]) {
				tmp.add(num[i]);
				visited[i] = true;
				helper(num, visited, idx + 1, res, tmp);
				visited[i] = false;
				tmp.remove(tmp.size() - 1);
				while (i + 1 < num.length && num[i + 1] == num[i])
					i++;
			}
		}
	}
}
