package hack.leetcode.dev;

import java.util.ArrayList;

/*
 * Given an index k, return the kth row of the Pascal's triangle.
 * For example, given k = 3,
 * Return [1,3,3,1].
 * Note:
 * Could you optimize your algorithm to use only O(k) extra space?
 */
public class PascalsTriangleII {
	public static ArrayList<Integer> getRow(int rowIndex) {
		ArrayList<Integer> res = new ArrayList<Integer>();
		int tmp[] = new int[rowIndex + 1];
		for (int i = 0; i <= rowIndex; i++) {
			if (i == 0) {
				res.add(1);
				continue;
			}
			res.add(1);
			tmp[0] = 1;
			tmp[i] = 1;
			for (int j = 1; j < i; j++) {
				tmp[j] = res.get(j);
			}
			for (int j = 1; j < i; j++) {
				res.set(j, tmp[j - 1] + tmp[j]);
			}
		}
		return res;
	}

	public static void main(String[] args) {
		getRow(0);
	}
}
