package hack.leetcode.dev;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Comparator;

/*
 * Given a list of non negative integers, arrange them such that they form the largest number.
 * For example, given [3, 30, 34, 5, 9], the largest formed number is 9534330.
 * Note: The result may be very large, so you need to return a string instead of an integer.
 */
public class LargestNumber {
	public String largestNumber(int[] num) {
		String[] numArray = new String[num.length];

		for (int i = 0; i < num.length; i++) {
			numArray[i] = String.valueOf(num[i]);
		}

		Arrays.sort(numArray, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				String leftRight = o1.concat(o2);
				String rightLeft = o2.concat(o1);
				return rightLeft.compareTo(leftRight);
			}
		});

		StringBuilder sb = new StringBuilder();
		for (String s : numArray) {
			sb.append(s);
		}

		BigInteger result = new BigInteger(sb.toString());

		return result.toString();
	}
}
