package solution;

import java.util.ArrayList;
import java.util.List;

public class Combinations {
	public List<List<Integer>> combine(int n, int k) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if (k > n) {
			return res;
		}
		if (k == 1) {
			for (int i = 1; i <= n; i++) {
				ArrayList<Integer> tmp = new ArrayList<Integer>();
				tmp.add(i);
				res.add(tmp);
			}
			return res;
		}
		for (int i = 1; i <= n; i++) {
			for (List<Integer> tmp : combine(i - 1, k - 1)) {
				tmp.add(i);
				res.add(tmp);
			}
		}
		return res;
	}

	public List<List<Integer>> combineDFS(int n, int k) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if (k <= 0 || k > n) {
			return res;
		}

		helper(res, new ArrayList<Integer>(), n, k, 1);
		return res;
	}

	private void helper(List<List<Integer>> res, List<Integer> tmp, int n, int k, int start) {
		if (k == 0) {
			res.add(new ArrayList<Integer>(tmp));
			return;
		}

		for (int i = start; i <= n && k > 0; i++) {
			tmp.add(i);
			helper(res, tmp, n, k - 1, i + 1);
			tmp.remove(tmp.size() - 1);
		}
	}

	public static void main(String[] args) {
		Combinations test = new Combinations();
		test.combine(4, 2);
	}
}
