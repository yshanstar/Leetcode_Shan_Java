package solution;

import java.util.ArrayList;

public class Permutations {
	public ArrayList<ArrayList<Integer>> permute(int[] num) {
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		if (num.length == 0) {
			return res;
		}
		int[] used = new int[num.length];
		helper(res, 0, num, new ArrayList<Integer>(), used);
		return res;
	}

	private void helper(ArrayList<ArrayList<Integer>> res, int idx, int[] num,
			ArrayList<Integer> tmp, int[] used) {
		if (idx == num.length) {
			res.add(new ArrayList<Integer>(tmp));
			return;
		}

		for (int i = 0; i < num.length; i++) {
			if (used[i] == 0) {
				used[i] = 1;
				tmp.add(num[i]);
				helper(res, idx + 1, num, tmp, used);
				used[i] = 0;
				tmp.remove(tmp.size() - 1);
			}
		}
	}
}
