package hack.leetcode.dev;

import java.util.ArrayList;
import java.util.Arrays;

/*
 *  Given a collection of integers that might contain duplicates, S, return all possible subsets.
 *	Note:
 *	Elements in a subset must be in non-descending order.
 *	The solution set must not contain duplicate subsets.
 *	For example,
 *	If S = [1,2,2], a solution is:
 *	[
 *		[2],
 *		[1],
 *		[1,2,2],
 *		[2,2],
 *		[1,2],
 *		[]
 *	]
 */
public class SubsetsII {
	public static ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (num.length < 0) {
			return null;
		}
		Arrays.sort(num);
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		res.add(new ArrayList<Integer>());
		generateSubSet(num, 0, res, new ArrayList<Integer>());
		return res;
	}

	@SuppressWarnings("unchecked")
	private static void generateSubSet(int[] num, int idx, ArrayList<ArrayList<Integer>> res, ArrayList<Integer> subSet) {
		ArrayList<Integer> tmpSubSet = new ArrayList<Integer>(subSet);
		if (idx > num.length - 1) {
			return;
		}
		for (int i = idx; i < num.length; i++) {
			tmpSubSet.add(num[i]);
			res.add((ArrayList<Integer>) tmpSubSet.clone());
			generateSubSet(num, i + 1, res, tmpSubSet);
			while (i < num.length - 1 && num[i] == num[i + 1]) {
				i++;
			}
			tmpSubSet.remove(tmpSubSet.size() - 1);
		}
	}
}
