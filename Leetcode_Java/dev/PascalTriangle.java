package hack.leetcode.dev;

import java.util.ArrayList;

/*
 * Given numRows, generate the first numRows of Pascal's triangle.
 * For example, given numRows = 5,
 * Return
 [
 [1],
 [1,1],
 [1,2,1],
 [1,3,3,1],
 [1,4,6,4,1]
 ]
 *
 */
public class PascalTriangle {
	public ArrayList<ArrayList<Integer>> generate(int numRows) {
		// Start typing your Java solution below
		// DO NOT write main() function
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		for (int i = 1; i <= numRows; i++) {
			ArrayList<Integer> tmp;
			if (i == 1) {
				ArrayList<Integer> tmpRes = new ArrayList<Integer>();
				tmpRes.add(1);
				res.add(tmpRes);
				continue;
			} else {
				tmp = res.get(i - 2);
				ArrayList<Integer> tmpRes = new ArrayList<Integer>();
				for (int j = 0; j <= tmp.size(); j++) {
					if (j == 0) {
						tmpRes.add(1);
					} else if (j == tmp.size()) {
						tmpRes.add(1);
					} else {
						tmpRes.add(tmp.get(j - 1) + tmp.get(j));
					}
				}
				res.add(tmpRes);
			}
		}
		return res;
	}

	public static void main(String[] args) {
		PascalTriangle pascalTriangle = new PascalTriangle();
		pascalTriangle.generate(3);
	}
}
