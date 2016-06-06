package hack.leetcode.dev;

import java.util.ArrayList;
import java.util.Arrays;

/*
 * Given a set of distinct integers, S, return all possible subsets.
 * Note:
 * Elements in a subset must be in non-descending order.
 * The solution set must not contain duplicate subsets.
 * For example,
 * If S = [1,2,3], a solution is:
	 [
		 [3],
		 [1],
		 [2],
		 [1,2,3],
		 [1,3],
		 [2,3],
		 [1,2],
		 []
	 ]
 */
public class Subsets2 {
	public ArrayList<ArrayList<Integer>> subsets(int[] S) {
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		res.add(new ArrayList<Integer>());
		Arrays.sort(S);
		return helper(S,0,res);
	}
	
	private ArrayList<ArrayList<Integer>> helper(int[] S, int idx, ArrayList<ArrayList<Integer>> res){
		if (idx == S.length) {
			return res;
		}
		ArrayList<ArrayList<Integer>> newRes = new ArrayList<ArrayList<Integer>>(res);
		for (ArrayList<Integer> set : res) {
			ArrayList<Integer> tmp = new ArrayList<Integer>(set);
			tmp.add(S[idx]);
			newRes.add(tmp);
		}
		return helper(S, idx + 1, newRes);
	}
	
	public static void main(String[] args){
		Subsets2 test = new Subsets2();
		int[] S = { 0 };
		ArrayList<ArrayList<Integer>> res = test.subsets(S);
		System.out.println(res.size());
	}
}
