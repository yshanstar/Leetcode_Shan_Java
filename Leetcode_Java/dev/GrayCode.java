package hack.leetcode.dev;

import java.util.ArrayList;

/*
 * The gray code is a binary numeral system where two successive values differ in only one bit.
 * Given a non-negative integer n representing the total number of bits in the code, print the sequence of gray code. A gray code sequence must begin with 0.
 * For example, given n = 2, return [0,1,3,2]. Its gray code sequence is:
 * 00 - 0
 * 01 - 1
 * 11 - 3
 * 10 - 2
 */
public class GrayCode {
	public static ArrayList<Integer> grayCode(int n) {
		ArrayList<Integer> res = new ArrayList<Integer>();
		if (n == 0) {
			res.add(0);
			return res;
		}
		res.add(0);
		res.add(1);

		for (int i = 1; i < n; i++) {
			ArrayList<Integer> tmp = new ArrayList<Integer>(res);
			Integer a = 1 << i;
			for (int j = res.size() - 1; j >= 0; j--) {
				tmp.add(res.get(j) + a);
			}
			res = tmp;
		}

		return res;
	}

	public static void main(String[] args) {
		grayCode(2);
	}
}
