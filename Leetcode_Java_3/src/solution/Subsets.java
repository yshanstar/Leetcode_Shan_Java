package solution;

import java.util.ArrayList;
import java.util.Arrays;

public class Subsets {
	public ArrayList<ArrayList<Integer>> subsets(int[] S) {
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		if (S == null || S.length == 0) {
			return res;
		}
		Arrays.sort(S);
		res.add(new ArrayList<Integer>());
		helper(res, S, 0, new ArrayList<Integer>());
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
			tmpRes.remove(tmpRes.size() - 1);
		}
	}

	public static void main(String[] args) {
		Subsets test = new Subsets();
		int[] nums = { 1, 2, 3, 4, 5, 6, 7, 8, 10, 0 };
		System.out.println(test.subsets(nums));
	}
}
