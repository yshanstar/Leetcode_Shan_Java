package solution;

import java.util.ArrayList;

public class Combinations {
	public ArrayList<ArrayList<Integer>> combine(int n, int k) {
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
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
			for (ArrayList<Integer> tmp : combine(i - 1, k - 1)) {
				tmp.add(i);
				res.add(tmp);
			}
		}
		return res;
	}
}
