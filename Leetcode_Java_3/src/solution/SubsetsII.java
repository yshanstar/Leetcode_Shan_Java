package solution;

import java.util.ArrayList;
import java.util.Arrays;

public class SubsetsII {
	public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		if (num == null || num.length == 0) {
			return res;
		}
		Arrays.sort(num);
		res.add(new ArrayList<Integer>());
		helper(res, num, 0, new ArrayList<Integer>());
		return res;
	}

	@SuppressWarnings("unchecked")
	private void helper(ArrayList<ArrayList<Integer>> res, int[] num,
			int start, ArrayList<Integer> tmp) {
		if (start == num.length) {
			return;
		}
		ArrayList<Integer> tmpRes = new ArrayList<Integer>(tmp);
		for (int i = start; i < num.length; i++) {
			tmpRes.add(num[i]);
			res.add((ArrayList<Integer>) tmpRes.clone());
			helper(res, num, i + 1, tmpRes);
			while (i < num.length - 1 && num[i] == num[i+1]) {
				i++;
			}
			tmpRes.remove(tmpRes.size() - 1);
		}
	}
}
