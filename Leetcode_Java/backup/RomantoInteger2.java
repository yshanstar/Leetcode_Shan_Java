package hack.leetcode.dev;

/*
 * Given a roman numeral, convert it to an integer.
 * Input is guaranteed to be within the range from 1 to 3999.
 */
public class RomantoInteger2 {
	public int romanToInt(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}
		int sum = 0;
		int pre = getDigit(s.charAt(s.length() - 1));
		sum += pre;
		for (int i = s.length() - 2; i >= 0; i--) {
			int d = getDigit(s.charAt(i));
			if (d < pre) {
				sum -= d;
			} else {
				sum += d;
			}
			pre = d;
		}
		return sum;
	}

	private int getDigit(char c) {
		switch (c) {
		case 'I':
			return 1;
		case 'V':
			return 5;
		case 'X':
			return 10;
		case 'L':
			return 50;
		case 'C':
			return 100;
		case 'D':
			return 500;
		case 'M':
			return 1000;
		default:
			return 0;
		}
	}
}
