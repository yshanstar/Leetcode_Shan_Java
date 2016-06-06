package hack.leetcode.dev;

import java.util.ArrayList;
import java.util.List;

/*
 * Write a program to find the n-th ugly number.
 * Ugly numbers are positive numbers whose prime factors only include 2, 3, 5. For example, 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10 ugly numbers.
 * Note that 1 is typically treated as an ugly number.
 */
public class UglyNumberII {
	public int nthUglyNumber(int n) {
		List<Integer> tmp = new ArrayList<Integer>();
		tmp.add(1);

		if (n <= 0) {
			return 0;
		}

		if (n == 1) {
			return tmp.get(n - 1);
		}

		int i2 = 0;
		int i3 = 0;
		int i5 = 0;

		while (tmp.size() < n) {
			int m2 = tmp.get(i2) * 2;
			int m3 = tmp.get(i3) * 3;
			int m5 = tmp.get(i5) * 5;

			int m = Math.min(Math.min(m2, m3), m5);

			if (m == m2) {
				i2++;
			}

			if (m == m3) {
				i3++;
			}

			if (m == m5) {
				i5++;
			}

			tmp.add(m);
		}
		
		return tmp.get(n - 1);
	}
}
