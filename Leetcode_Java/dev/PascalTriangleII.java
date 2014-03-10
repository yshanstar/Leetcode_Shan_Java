package hack.leetcode.dev;

import java.util.ArrayList;

/*
 * Given an index k, return the kth row of the Pascal's triangle.
 * For example, given k = 3,
 * Return [1,3,3,1]. 
 */
public class PascalTriangleII {
	public ArrayList<Integer> getRow(int rowIndex) {
		// Start typing your Java solution below
		// DO NOT write main() function
		ArrayList<Integer> res = new ArrayList<Integer>();
		int[] tmp = new int[rowIndex + 1];
		for (int i = 1; i <= rowIndex + 1; i++) {
			if (i == 1) {
				res.add(1);
				continue;
			} else {
				res.add(1);
				tmp[0]=1;
				tmp[tmp.length-1]=1;
				for (int j = 1; j < i - 1; j++) {
					tmp[j] = res.get(j);
				}
				for (int k = 1; k < i - 1; k++) {
					res.set(k, tmp[k-1] + tmp[k]);
				}
			}
		}
		return res;
	}

	public static void main(String[] agrs) {
		PascalTriangleII pascalTriangleII = new PascalTriangleII();
		pascalTriangleII.getRow(4);
	}
}
